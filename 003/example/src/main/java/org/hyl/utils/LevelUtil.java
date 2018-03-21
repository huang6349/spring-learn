package org.hyl.utils;

import org.apache.commons.lang3.StringUtils;

public class LevelUtil {

    public final static String SEPARATOR = ".";

    public final static String ROOT = "0";

    public static String calculateLevel() {
        return ROOT;
    }

    public static String calculateLevel(String parentLevel, long parentId) {
        if (StringUtils.isBlank(parentLevel)) {
            return calculateLevel();
        }
        return StringUtils.join(parentLevel, SEPARATOR, parentId);
    }
}
