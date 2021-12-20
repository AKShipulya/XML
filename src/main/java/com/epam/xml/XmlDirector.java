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
    private final static Logger LOGGER = LogManager.getLogger();

    private final XmlValidator VALIDATOR;
    private final ParserType PARSER_TYPE;

    public XmlDirector(XmlValidator validator, ParserType parserType) {
        this.VALIDATOR = validator;
        this.PARSER_TYPE = parserType;
    }

    public List<Gem> parseXml(String xmlFilePath, String xsdFilePath) throws ParserCustomException {
        List<Gem> gems = new ArrayList<>();
        if (VALIDATOR.isValid(xmlFilePath, xsdFilePath)) {
            try {
                Parser parser = ParserFactory.create(PARSER_TYPE);
                gems = parser.parse(xmlFilePath);
                LOGGER.info("Gems were created successfully!");
            } catch (ParserCustomException | JAXBException | FileNotFoundException exception) {
                LOGGER.warn("File can't be parsed! Cause: {}", exception.getMessage());
            }
        } else
            throw new ParserCustomException("XML file is invalid!");
        return gems;
    }

}
