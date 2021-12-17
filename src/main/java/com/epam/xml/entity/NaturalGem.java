package com.epam.xml.entity;

public class NaturalGem extends Gem {
    private String GemDeposit;

    public NaturalGem(int id, String name, Preciousness preciousness, String gemDeposit) {
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

        NaturalGem that = (NaturalGem) o;

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
        final StringBuilder sb = new StringBuilder("NaturalGem{");
        sb.append("preciousness=").append(preciousness);
        sb.append(", GemDeposit='").append(GemDeposit).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
