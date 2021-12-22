package com.epam.xml.entity;

import com.epam.xml.entity.type.Preciousness;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "NaturalGem")
public class NaturalGem extends Gem {
    private String gemDepositPlace;

    public NaturalGem(String id, String name, Preciousness preciousness, String gemDepositPlace) {
        super(id, name, preciousness);
        this.gemDepositPlace = gemDepositPlace;
    }

    //public constructor required by JAXB parser
    public NaturalGem() {
    }

    @XmlElement(name = "gem-deposit-place", namespace = "http://www.epam.com/gems")
    public String getGemDepositPlace() {
        return gemDepositPlace;
    }

    public void setGemDepositPlace(String gemDepositPlace) {
        this.gemDepositPlace = gemDepositPlace;
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
        return gemDepositPlace != null ? gemDepositPlace.equals(that.gemDepositPlace) : that.gemDepositPlace == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (gemDepositPlace != null ? gemDepositPlace.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("NaturalGem{");
        stringBuilder.append("id='").append(super.getId()).append('\'');
        stringBuilder.append(", name='").append(super.getName()).append('\'');
        stringBuilder.append(", preciousness='").append(super.getPreciousness()).append('\'');
        stringBuilder.append(", GemDepositPlace='").append(gemDepositPlace).append('\'');
        stringBuilder.append('}').append("\n");
        return stringBuilder.toString();
    }
}