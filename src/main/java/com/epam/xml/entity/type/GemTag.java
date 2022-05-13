package com.epam.xml.entity.type;

public enum GemTag {
    GEMS,
    ID,
    NAME,
    PRECIOUSNESS,
    GEM_PRODUCTION_PLACE,
    GEM_DEPOSIT_PLACE,
    SYNTHETIC_GEM,
    NATURAL_GEM;

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