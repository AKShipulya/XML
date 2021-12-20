package com.epam.xml.parser.impl;

import com.epam.xml.entity.Gem;
import com.epam.xml.entity.Gems;
import com.epam.xml.entity.NaturalGem;
import com.epam.xml.entity.SyntheticGem;
import com.epam.xml.parser.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JaxbParserImpl implements Parser {
    @Override
    public List<Gem> parse(String filePath) throws JAXBException {
        List<Gem> gemsList;
        JAXBContext jaxbContext = JAXBContext.newInstance(Gems.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Gems gems = (Gems) unmarshaller.unmarshal(new File("src/test/resources/gems.xml"));
        gemsList = gems.getGems();

        return gemsList;

    }
}
