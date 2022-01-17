package com.epam.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "gems", namespace = "http://www.epam.com/gems")
public class Gems {
    @XmlElements
            ({
                    @XmlElement(name = "synthetic-gem", type = SyntheticGem.class, required = true, namespace = "http://www.epam.com/gems"),
                    @XmlElement(name = "natural-gem", type = NaturalGem.class, required = true, namespace = "http://www.epam.com/gems")
            })
    private List<Gem> gemList = new ArrayList<>();

    public void setGemList(List<Gem> gemList) {
        this.gemList = gemList;
    }

    public boolean addGem(Gem gem) {
        return gemList.add(gem);
    }

    public List<Gem> getGems() {
        return new ArrayList<>(gemList);
    }
}