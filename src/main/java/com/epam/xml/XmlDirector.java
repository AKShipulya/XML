package com.epam.xml;

import com.epam.xml.entity.Gem;
import com.epam.xml.exception.ParserCustomException;
import com.epam.xml.parser.Parser;
import com.epam.xml.validator.XmlValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.XMLFormatter;

public class XmlDirector {
    private final static Logger LOGGER = LogManager.getLogger();

    private XmlValidator validator;
    private Parser parser;

    public XmlDirector(XmlValidator validator, Parser parser) {
        this.validator = validator;
        this.parser = parser;
    }

    public List<Gem> parseXml(String xmlFilePath, String xsdFilePath) throws ParserCustomException {
        List<Gem> gems = new ArrayList<>();
        if (validator.isValid(xmlFilePath, xsdFilePath)) {
            try {
                gems = parser.parse(xmlFilePath);
                LOGGER.info("Gems were created successfully!");
            } catch (ParserCustomException e) {
                e.printStackTrace();
            }
        } else
            throw new ParserCustomException("XML file is invalid!");
        // FIXME: 17.12.2021 Start main and check! IT DOESN'T WORKS!!!
        return gems;
    }

}
