package io.github.erha134.easylib.util.compare;

import io.github.erha134.easylib.annotation.Immutable;
import io.github.erha134.easylib.collection.ListUtils;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 版本号比较工具类
 */
@Immutable
@Getter
public final class Version implements Comparable<Version> {
    private final List<String> splitVersion;

    public Version(String version) {
        this(version, "\\.");
    }

    public Version(String version, String regex) {
        this.splitVersion = ListUtils.of(version.split(regex));

        // 去除版本号列表中的0
        for (int i = this.splitVersion.size() - 1; i >= 0; i--) {
            int j = Integer.parseInt(this.splitVersion.get(i));

            if (j == 0) {
                this.splitVersion.remove(i);
            } else {
                break;
            }
        }
    }

    @Override
    public int compareTo(@NotNull Version o) {
        List<String> current = this.splitVersion;
        List<String> target = o.splitVersion;

        // 比较版本号列表中的每一项
        for (int i = 0; i < Math.min(current.size(), target.size()); i++) {
            int v1 = Integer.parseInt(current.get(i));
            int v2 = Integer.parseInt(target.get(i));

            if (v1 > v2) {
                return 1;
            }

            if (v1 < v2) {
                return -1;
            }
        }

        // 如果版本号列表长度不同，则较长的版本号较大
        return Integer.compare(current.size(), target.size());
    }
}
