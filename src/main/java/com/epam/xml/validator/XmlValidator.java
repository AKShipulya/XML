package com.epam.xml.validator;

import com.epam.xml.handler.GemErrorHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
    private static final Logger LOGGER = LogManager.getLogger();

    //xmlFile "src/test/resources/students_ext.xml"
    //xsdFile "src/test/resources/students.xsd"
    public boolean isValid(String xmlFile, String xsdFile) {
        boolean result = false;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        GemErrorHandler errorHandler = new GemErrorHandler();
        try {
            Schema schema = factory.newSchema(new File(xsdFile));
            Validator validator = schema.newValidator();
            validator.setErrorHandler(errorHandler);
            validator.validate(new StreamSource(xmlFile));

            LOGGER.info(xmlFile + " validation is ended");
            LOGGER.info(xmlFile + " is valid");
            result = true;
        } catch (SAXException | IOException e) {
            LOGGER.warn("File reading error or file {} is not available: ", xmlFile, e);
        }
        return result;
    }
}