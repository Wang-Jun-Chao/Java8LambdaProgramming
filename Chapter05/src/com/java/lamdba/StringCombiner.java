package com.java.lamdba;

/**
 * Author: 王俊超
 * Date: 2015-12-05 15:49
 * Declaration: All Rights Reserved !!!
 */
public class StringCombiner {
    // 分隔符
    private final String delim;
    // 前缀
    private final String prefix;
    // 后缀
    private final String suffix;
    private final StringBuilder builder;

    public StringCombiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
        builder = new StringBuilder();
    }

    public StringCombiner add(String element) {
        if (areAtStart()) {
            builder.append(prefix);
        } else {
            builder.append(delim);
        }
        builder.append(element);
        return this;
    }

    private boolean areAtStart() {
        return builder.length() == 0;
    }

    public StringCombiner merge(StringCombiner other) {
        if (other.builder.length() > 0) {
            if (areAtStart()) {
                builder.append(prefix);
            } else {
                builder.append(delim);
            }
            builder.append(other.builder, prefix.length(), other.builder.length());
        }
        return this;
    }

    @Override
    public String toString() {
        if (areAtStart()) {
            builder.append(prefix);
        }
        builder.append(suffix);
        return builder.toString();
    }
}
