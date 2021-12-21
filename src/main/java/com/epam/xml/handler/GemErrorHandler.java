package com.epam.xml.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class GemErrorHandler extends DefaultHandler {
    private final Logger LOGGER = LogManager.getLogger();
    private boolean isError = false;

    @Override
    public void warning(SAXParseException exception) {
        LOGGER.warn(getLineAddress(exception) + "-" + exception.getMessage());
        isError = true;
    }

    @Override
    public void error(SAXParseException exception) {
        LOGGER.error(getLineAddress(exception) + "-" + exception.getMessage());
        isError = true;
    }

    @Override
    public void fatalError(SAXParseException exception) {
        LOGGER.fatal(getLineAddress(exception) + "-" + exception.getMessage());
        isError = true;
    }

    private String getLineAddress(SAXParseException exception) {
        return exception.getLineNumber() + " : " + exception.getColumnNumber();
    }

    public boolean isErrorOccurred() {
        return isError;
    }
}