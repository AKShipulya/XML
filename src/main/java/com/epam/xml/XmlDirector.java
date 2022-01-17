package com.epam.xml;

import com.epam.xml.entity.Gem;
import com.epam.xml.exception.ParserCustomException;
import com.epam.xml.parser.Parser;
import com.epam.xml.parser.ParserFactory;
import com.epam.xml.parser.ParserType;
import com.epam.xml.validator.XmlValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XmlDirector {
    private static final Logger LOGGER = LogManager.getLogger();

    private final XmlValidator validator;
    private final ParserType parserType;

    public XmlDirector(XmlValidator validator, ParserType parserType) {
        this.validator = validator;
        this.parserType = parserType;
    }

    public List<Gem> parseXml(String xmlFilePath, String xsdFilePath) throws ParserCustomException {
        List<Gem> gems = new ArrayList<>();
        if (validator.isValid(xmlFilePath, xsdFilePath)) {
            try {
                Parser parser = ParserFactory.create(parserType);
                gems = parser.parse(xmlFilePath);
                LOGGER.info("Gems were created successfully!");
            } catch (ParserCustomException | JAXBException | FileNotFoundException exception) {
                LOGGER.warn("File can't be parsed! Cause: {}", exception.getMessage());
            }
        } else {
            throw new ParserCustomException("XML file is invalid!");
        }
        return gems;
    }
}