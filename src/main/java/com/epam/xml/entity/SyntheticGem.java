package com.epam.xml.entity;

import com.epam.xml.entity.type.Preciousness;

public class SyntheticGem extends Gem {
    private String GemProductionPlace;

    public SyntheticGem() {
    }

    public SyntheticGem(String id, String name, Preciousness preciousness, String gemProductionPlace) {
        super(id, name, preciousness);
        GemProductionPlace = gemProductionPlace;
    }

    public String getGemProductionPlace() {
        return GemProductionPlace;
    }

    public void setGemProductionPlace(String gemProductionPlace) {
        GemProductionPlace = gemProductionPlace;
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

        SyntheticGem that = (SyntheticGem) object;

        return GemProductionPlace != null ? GemProductionPlace.equals(that.GemProductionPlace) : that.GemProductionPlace == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (GemProductionPlace != null ? GemProductionPlace.hashCode() : 0);
        return result;
    }

    @Override
    public String
    toString() {
        final StringBuilder stringBuilder = new StringBuilder("SyntheticGem{");
        stringBuilder.append("preciousness=").append(preciousness);
        stringBuilder.append(", GemProductionPlace='").append(GemProductionPlace).append('\'');
        stringBuilder.append('}').append("\n");
        return stringBuilder.toString();
    }
}
