package io.github.erha134.easylib.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.github.erha134.easylib.string.StringFormatter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 本地化语言类，类似 MC。
 */
public class Language {
    /**
     * {@link Gson} 实例。
     */
    private static final Gson GSON = new Gson();
    /**
     * 所有翻译。
     */
    private final Map<String, String> map;

    /**
     * 构造函数。
     * @param language 语言
     */
    public Language(String language) {
        this.map = new HashMap<>();

        load(language);
    }

    /**
     * 默认构造函数，使用系统语言。
     */
    public Language() {
        this(StringFormatter.format("{}_{}", Locale.getDefault().getLanguage(), Locale.getDefault().getCountry())
                .toLowerCase());
    }

    /**
     * 加载翻译。
     * @param language 语言
     */
    private void load(String language) {
        try (InputStream is = Language.class.getResourceAsStream("/lang/" + language + ".json")) {
            if (is != null) {
                JsonObject jsonObject = GSON.fromJson(new InputStreamReader(is), JsonObject.class);

                for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                    this.map.put(entry.getKey(), entry.getValue().getAsString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取翻译。
     * @param key 翻译键
     * @return 翻译
     */
    public String get(String key) {
        return this.get(key, key);
    }

    /**
     * 获取格式化后的翻译。
     * @param key 翻译键
     * @param args 格式化参数
     * @return 翻译
     */
    public String get(String key, Object... args) {
        return StringFormatter.format(this.get(key), args);
    }

    /**
     * 获取翻译。
     * @param key 翻译键
     * @param fallback 默认翻译
     * @return 翻译
     */
    public String get(String key, String fallback) {
        return this.map.getOrDefault(key, fallback);
    }

    /**
     * 获取格式化后的翻译。
     * @param key 翻译键
     * @param fallback 默认翻译
     * @param args 格式化参数
     * @return 翻译
     */
    public String get(String key, String fallback, Object... args) {
        return StringFormatter.format(this.get(key, fallback), args);
    }

    /**
     * 判断是否有翻译。
     * @param key 翻译键
     * @return 是否有翻译
     */
    public boolean hasTranslation(String key) {
        return this.map.containsKey(key);
    }
}
