package com.epam.xml.entity;

import com.epam.xml.entity.type.Preciousness;

public class NaturalGem extends Gem {
    private String GemDeposit;

    public NaturalGem() {
    }

    public NaturalGem(String id, String name, Preciousness preciousness, String gemDeposit) {
        super(id, name, preciousness);
        GemDeposit = gemDeposit;
    }

    public String getGemDeposit() {
        return GemDeposit;
    }

    public void setGemDeposit(String gemDeposit) {
        GemDeposit = gemDeposit;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }

        NaturalGem that = (NaturalGem) object;

        return GemDeposit != null ? GemDeposit.equals(that.GemDeposit) : that.GemDeposit == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (GemDeposit != null ? GemDeposit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("NaturalGem{");
        stringBuilder.append("preciousness=").append(preciousness);
        stringBuilder.append(", GemDeposit='").append(GemDeposit).append('\'');
        stringBuilder.append('}').append("\n");
        return stringBuilder.toString();
    }
}
