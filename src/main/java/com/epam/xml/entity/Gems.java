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
                    @XmlElement(name = "synthetic-gem", type = SyntheticGem.class, required = false, namespace = "http://www.epam.com/gems"),
                    @XmlElement(name = "natural-gem", type = NaturalGem.class, required = false, namespace = "http://www.epam.com/gems")
            })
    private List<Gem> gemList = new ArrayList<>();

    public Gems() {
    }

    public void setGemList(List<Gem> tariffs) {
        this.gemList = tariffs;
    }

    public boolean add(Gem gem) {
        return gemList.add(gem);
    }

    public List<Gem> getGems() {
        return gemList;
    }
}