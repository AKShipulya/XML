package com.epam.xml.entity.type;

public enum GemTag {
    GEMS("gems"),
    ID("id"),
    NAME("name"),
    PRECIOUSNESS("preciousness"),
    GEMPRODUCTIONPLACE("geproductionpalce"),
    GEMDEPOSIT("gemdeposit"),
    SYNTHETICGEM("syntheticgem"),
    NATURALGEM("naturalgem");

    private String value;
    private GemTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GemTag{");
        sb.append('}');
        return sb.toString();
    }
}
