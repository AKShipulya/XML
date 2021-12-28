package com.epam.xml.parser.impl;

import com.epam.xml.entity.Gem;
import com.epam.xml.entity.Gems;
import com.epam.xml.exception.ParserCustomException;
import com.epam.xml.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbParserImpl implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<Gem> parse(String filePath) {
        List<Gem> gemsList = new ArrayList<>();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Gems.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Gems gems = (Gems) unmarshaller.unmarshal(new File(filePath));
            gemsList = gems.getGems();
        } catch (JAXBException exception) {
            LOGGER.warn(String.format("File %s can't ber read or parsed", filePath), exception);
        }
        LOGGER.info("XML has been parsed successfully!");
        return gemsList;
    }
}