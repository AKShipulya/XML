package com.epam.xml.entity;

import java.util.Objects;

public abstract class Gem {
    private int id;
    private String name;
    Preciousness preciousness;

    public Gem(int id, String name, Preciousness preciousness) {
        this.id = id;
        this.name = name;
        this.preciousness = preciousness;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Gem gem = (Gem) o;

        if (id != gem.id) {
            return false;
        }
        if (!Objects.equals(name, gem.name)) {
            return false;
        }
        return preciousness == gem.preciousness;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (preciousness != null ? preciousness.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Gem{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", preciousness=").append(preciousness);
        sb.append('}');
        return sb.toString();
    }
}
