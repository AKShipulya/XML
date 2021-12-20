package com.epam.xml.entity.type;

public enum GemTag {
    GEMS,
    ID,
    NAME,
    PRECIOUSNESS,
    GEMPRODUCTIONPLACE,
    GEMDEPOSIT,
    SYNTHETICGEM,
    NATURALGEM;

    @Override
    public String toString() {
        String result = this.name();
        result = result.toLowerCase();
        return result;
    }
}