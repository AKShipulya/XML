package com.epam.xml.validator;

import com.epam.xml.exception.ParserCustomException;
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

    public boolean isValid(String xmlFile, String xsdFile) throws ParserCustomException {
        if (xmlFile == null || xmlFile.isEmpty() || xsdFile == null || xsdFile.isEmpty()) {
            throw new ParserCustomException("XML or XSD file empty or the path invalid!");
        }
        boolean result = true;
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        GemErrorHandler errorHandler = new GemErrorHandler();
        try {
            Schema schema = factory.newSchema(new File(xsdFile));
            Validator validator = schema.newValidator();
            validator.setErrorHandler(errorHandler);
            validator.validate(new StreamSource(xmlFile));

            LOGGER.info(xmlFile + " validation is ended");
            if (errorHandler.isErrorOccurred()) {
                result = false;
                LOGGER.warn(xmlFile + " is invalid");
            } else {
                LOGGER.info(xmlFile + " is valid");
            }
        } catch (SAXException | IOException exception) {
            LOGGER.warn("File reading error or file {} is not available: ", xmlFile, exception);
        }
        return result;
    }
}