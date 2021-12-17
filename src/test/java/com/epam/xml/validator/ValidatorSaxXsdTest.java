package com.epam.xml.validator;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorSaxXsdTest {
    private static final String XML_FILE_PATH = "src/test/resources/gems.xml";
    private static final String XSD_FILE_PATH = "src/test/resources/gems.xsd";

    @Test
    public void testIsValidShouldReturnTrueWhenValid() {
        //given
        ValidatorSaxXsd validatorSaxXsd = new ValidatorSaxXsd();
        //when
        boolean actual = validatorSaxXsd.isValid(XML_FILE_PATH, XSD_FILE_PATH);
        //then
        Assert.assertTrue(actual);

    }
}