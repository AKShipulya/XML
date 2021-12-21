package com.epam.xml.entity;

import com.epam.xml.entity.type.Preciousness;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "SyntheticGem")
public class SyntheticGem extends Gem {
    private String gemProductionPlace;

    public SyntheticGem() {
    }

    public SyntheticGem(String id, String name, Preciousness preciousness, String gemProductionPlace) {
        super(id, name, preciousness);
        this.gemProductionPlace = gemProductionPlace;
    }

    @XmlElement(name = "gem-production-place", namespace = "http://www.epam.com/gems")
    public String getGemProductionPlace() {
        return gemProductionPlace;
    }

    public void setGemProductionPlace(String gemProductionPlace) {
        this.gemProductionPlace = gemProductionPlace;
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

        return gemProductionPlace != null ? gemProductionPlace.equals(that.gemProductionPlace) : that.gemProductionPlace == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (gemProductionPlace != null ? gemProductionPlace.hashCode() : 0);
        return result;
    }

    @Override
    public String
    toString() {
        final StringBuilder stringBuilder = new StringBuilder("SyntheticGem{");
        stringBuilder.append("id='").append(super.getId()).append('\'');
        stringBuilder.append(", name='").append(super.getName()).append('\'');
        stringBuilder.append(", preciousness='").append(preciousness);
        stringBuilder.append(", GemProductionPlace='").append(gemProductionPlace).append('\'');
        stringBuilder.append('}').append("\n");
        return stringBuilder.toString();
    }
}
