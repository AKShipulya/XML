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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        SyntheticGem that = (SyntheticGem) o;

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
        final StringBuilder sb = new StringBuilder("SyntheticGem{");
        sb.append("preciousness=").append(preciousness);
        sb.append(", GemProductionPlace='").append(GemProductionPlace).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
