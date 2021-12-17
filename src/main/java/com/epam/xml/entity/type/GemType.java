package com.epam.xml.entity.type;

public enum GemType {
    NATURALGEM,
    SYNTHETICGEM;

    @Override
    public String toString() {
        String result = this.name();
        result = result.toLowerCase();
        return result;
    }
}
