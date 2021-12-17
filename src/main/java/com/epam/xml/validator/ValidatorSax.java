package com.epam.xml.validator;

import com.epam.xml.handler.GemErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class ValidatorSax {
    private static final Logger LOGGER = LogManager.getLogger();

    //xmlFile "src/test/resources/students_ext.xml"
    //xsdFile "src/test/resources/students.xsd"
    public boolean isValid(String xmlFile, String xsdFile) {
        boolean result = false;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            Schema schema = factory.newSchema(new File(xsdFile));
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            saxParserFactory.setSchema(schema);
            SAXParser parser = saxParserFactory.newSAXParser();
            parser.parse(xmlFile, new GemErrorHandler());

            LOGGER.info(xmlFile + " is valid");
            result = true;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOGGER.warn(e.getMessage());
        }
        return result;
    }
}