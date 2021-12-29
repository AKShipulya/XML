package com.epam.xml;

import com.epam.xml.entity.Gem;
import com.epam.xml.entity.NaturalGem;
import com.epam.xml.entity.SyntheticGem;
import com.epam.xml.entity.type.Preciousness;
import com.epam.xml.exception.ParserCustomException;
import com.epam.xml.parser.ParserType;
import com.epam.xml.validator.XmlValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class XmlDirectorTest {
    private static final String XML_FILE_PATH = "src/test/resources/test_gems.xml";
    private static final String XSD_FILE_PATH = "src/test/resources/gems.xsd";

    @Test
    public void testParseXmlShouldCreateWhenXmlIsValid() throws ParserCustomException {
        //given
        SyntheticGem testSyntheticGem = new SyntheticGem("id1", "Synthetic Diamond", Preciousness.PRECIOUS, "USA by USA-Diamond Factory Inc.");
        NaturalGem testNaturalGem = new NaturalGem("id2", "Diamond", Preciousness.PRECIOUS, "South Africa by South Africa-Diamonds Africa LLC");
        List<Gem> expected = Arrays.asList(testSyntheticGem, testNaturalGem);
        XmlValidator validator = new XmlValidator();
        XmlDirector directorSax = new XmlDirector(validator, ParserType.SAX_PARSER);
        XmlDirector directorDom = new XmlDirector(validator, ParserType.DOM_PARSER);
        XmlDirector directorJaxb = new XmlDirector(validator, ParserType.JAXB_PARSER);
        //when
        List<Gem> actualSax = directorSax.parseXml(XML_FILE_PATH, XSD_FILE_PATH);
        List<Gem> actualDom = directorDom.parseXml(XML_FILE_PATH, XSD_FILE_PATH);
        List<Gem> actualJaxb = directorJaxb.parseXml(XML_FILE_PATH, XSD_FILE_PATH);
        //then
        Assert.assertEquals(expected, actualSax);
        Assert.assertEquals(expected, actualDom);
        Assert.assertEquals(expected, actualJaxb);
    }
}