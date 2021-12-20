package com.epam.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "gems", namespace = "http://www.epam.com/gems")
public class Gems {
    @XmlElements({
            @XmlElement(name = "natural-gem", namespace = "http://www.epam.com/gems", type = NaturalGem.class),
            @XmlElement(name = "synthetic-gem", namespace = "http://www.epam.com/gems", type = SyntheticGem.class)
    })
    private List<Gem> gems = new ArrayList<>();

    public Gems() {
    }

    public void setGems(List<Gem> tariffs) {
        this.gems = tariffs;
    }

    public boolean add(Gem gem) {
        return gems.add(gem);
    }

    public List<Gem> getGems() {
        return gems;
    }
}
