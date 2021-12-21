package com.epam.xml.entity;

import com.epam.xml.entity.type.Preciousness;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "NaturalGem")
public class NaturalGem extends Gem {
    private String gemDeposit;

    public NaturalGem() {
    }

    public NaturalGem(String id, String name, Preciousness preciousness, String gemDeposit) {
        super(id, name, preciousness);
        this.gemDeposit = gemDeposit;
    }

    @XmlElement(name = "gem-deposit", namespace = "http://www.epam.com/gems")
    public String getGemDeposit() {
        return gemDeposit;
    }

    public void setGemDeposit(String gemDeposit) {
        this.gemDeposit = gemDeposit;
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

        return gemDeposit != null ? gemDeposit.equals(that.gemDeposit) : that.gemDeposit == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (gemDeposit != null ? gemDeposit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("NaturalGem{");
        stringBuilder.append("id='").append(super.getId()).append('\'');
        stringBuilder.append(", name='").append(super.getName()).append('\'');
        stringBuilder.append(", preciousness='").append(preciousness).append('\'');
        stringBuilder.append(", GemDeposit='").append(gemDeposit).append('\'');
        stringBuilder.append('}').append("\n");
        return stringBuilder.toString();
    }
}