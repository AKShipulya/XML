package com.epam.xml.parser.impl;

import com.epam.xml.entity.Gem;
import com.epam.xml.exception.ParserCustomException;
import com.epam.xml.handler.GemErrorHandler;
import com.epam.xml.handler.GemHandler;
import com.epam.xml.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxParserImpl implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<Gem> parse(String filePath) throws ParserCustomException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            GemHandler handler = new GemHandler();
            reader.setContentHandler(handler);
            reader.setErrorHandler(new GemErrorHandler());
            reader.parse(filePath);
            LOGGER.info("XML has been parsed successfully!");
            return handler.getGems();
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            throw new ParserCustomException(String.format("File %s can't ber read or parsed", filePath), exception);
        }
    }
}
