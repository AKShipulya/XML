package com.epam.xml.entity;

import com.epam.xml.entity.type.Preciousness;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gem", propOrder = {"name", "preciousness"})
@XmlSeeAlso({NaturalGem.class, SyntheticGem.class})
public abstract class Gem {
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String id;
    @XmlElement(namespace = "http://www.epam.com/gems", required = true)
    private String name;
    @XmlElement(namespace = "http://www.epam.com/gems", required = true)
    Preciousness preciousness;

    public Gem(String id, String name, Preciousness preciousness) {
        this.id = id;
        this.name = name;
        this.preciousness = preciousness;
    }

    public Gem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Preciousness getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(Preciousness preciousness) {
        this.preciousness = preciousness;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Gem gem = (Gem) object;

        if (id != null ? !id.equals(gem.id) : gem.id != null) {
            return false;
        }
        if (name != null ? !name.equals(gem.name) : gem.name != null) {
            return false;
        }
        return preciousness == gem.preciousness;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (preciousness != null ? preciousness.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Gem{");
        stringBuilder.append("id='").append(id).append('\'');
        stringBuilder.append(", name='").append(name).append('\'');
        stringBuilder.append(", preciousness=").append(preciousness);
        stringBuilder.append('}').append("\n");
        return stringBuilder.toString();
    }
}
