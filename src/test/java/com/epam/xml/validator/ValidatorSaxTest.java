package com.epam.xml.validator;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorSaxTest {
    private static final String XML_FILE_PATH = "src/test/resources/gems.xml";
    private static final String XSD_FILE_PATH = "src/test/resources/gems.xsd";

    @Test
    public void testIsValidShouldReturnTrueWhenFileIsValid() {
        //given
        ValidatorSax validatorSax = new ValidatorSax();
        //when
        boolean actual = validatorSax.isValid(XML_FILE_PATH, XSD_FILE_PATH);
        //then
        Assert.assertTrue(actual);
    }
}