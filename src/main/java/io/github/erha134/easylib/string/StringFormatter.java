package io.github.erha134.easylib.string;

/**
 * 字符串格式化工具类
 */
public class StringFormatter extends StringUtils {
    /**
     * 像 SLF4J 类似的方式格式化字符串。
     * @param s 将要格式化的字符串
     * @param args 参数
     * @return 格式化后的字符串
     */
    public static String format(String s, Object... args) {
        for (int i = 0; i < args.length; i++) {
            String str = toString(args[i]);
            s = s.replaceFirst("\\{}", str)
                    .replaceAll("\\{" + i + "}", str);
        }

        return s;
    }
}
