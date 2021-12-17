package com.epam.xml.validator;

import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {
    private static final String XML_FILE_PATH = "src/test/resources/gems.xml";
    private static final String XSD_FILE_PATH = "src/test/resources/gems.xsd";

    @Test
    public void testIsValidShouldReturnTrueWhenValid() {
        //given
        XmlValidator xmlValidator = new XmlValidator();
        //when
        boolean actual = xmlValidator.isValid(XML_FILE_PATH, XSD_FILE_PATH);
        //then
        Assert.assertTrue(actual);

    }
}