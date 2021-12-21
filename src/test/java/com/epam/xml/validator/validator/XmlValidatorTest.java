package com.epam.xml.validator.validator;

import com.epam.xml.exception.ParserCustomException;
import com.epam.xml.validator.XmlValidator;
import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {
    private static final String XML_FILE_PATH = "src/test/resources/gems.xml";
    private static final String XSD_FILE_PATH = "src/test/resources/gems.xsd";
    private static final String INVALID_XML_FILE_PATH = "src/test/resources/invalid_gems.xml";
    private static final String EMPTY_FILE_PATH = "";

    @Test
    public void testIsValidShouldReturnTrueWhenValid() throws ParserCustomException {
        //given
        XmlValidator xmlValidator = new XmlValidator();
        //when
        boolean actual = xmlValidator.isValid(XML_FILE_PATH, XSD_FILE_PATH);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenInvalid() throws ParserCustomException {
        //given
        XmlValidator xmlValidator = new XmlValidator();
        //when
        boolean actual = xmlValidator.isValid(INVALID_XML_FILE_PATH, XSD_FILE_PATH);
        //then
        Assert.assertFalse(actual);
    }

    @Test(expected = ParserCustomException.class)
    public void testIsValidShouldThrowExceptionWhenPathIsEmpty() throws ParserCustomException {
        //given
        XmlValidator xmlValidator = new XmlValidator();
        //when
        boolean actual = xmlValidator.isValid(EMPTY_FILE_PATH, EMPTY_FILE_PATH);
        //then
        Assert.assertFalse(actual);
    }

    @Test(expected = ParserCustomException.class)
    public void testIsValidShouldThrowExceptionWhenPathIsNull() throws ParserCustomException {
        //given
        XmlValidator xmlValidator = new XmlValidator();
        //when
        boolean actual = xmlValidator.isValid(null, null);
        //then
        Assert.assertFalse(actual);
    }
}