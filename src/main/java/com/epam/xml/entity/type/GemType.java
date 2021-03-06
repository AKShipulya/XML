package com.epam.xml.entity.type;

public enum GemType {
    NATURAL_GEM,
    SYNTHETIC_GEM;

    private static final String UNDERSCORE = "_";
    private static final String HYPHEN = "-";

    @Override
    public String toString() {
        String result = this.name();
        result = result.toLowerCase();
        result = result.replace(UNDERSCORE, HYPHEN);
        return result;
    }
}