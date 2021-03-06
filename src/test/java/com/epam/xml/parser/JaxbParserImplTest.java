package com.epam.xml.parser;

import com.epam.xml.entity.Gem;
import com.epam.xml.entity.NaturalGem;
import com.epam.xml.entity.SyntheticGem;
import com.epam.xml.entity.type.Preciousness;
import com.epam.xml.exception.ParserCustomException;
import com.epam.xml.parser.impl.JaxbParserImpl;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class JaxbParserImplTest {
    private static final String XML_FILE_PATH = "src/test/resources/test_gems.xml";

    @Test
    public void testParseShouldReturnListOfGemsWhenXmlIsValid() throws JAXBException, FileNotFoundException, ParserCustomException {
        //given
        SyntheticGem syntheticGem = new SyntheticGem("id1", "Synthetic Diamond", Preciousness.PRECIOUS, "USA by USA-Diamond Factory Inc.");
        NaturalGem naturalGem = new NaturalGem("id2", "Diamond", Preciousness.PRECIOUS, "South Africa by South Africa-Diamonds Africa LLC");
        List<Gem> expected = Arrays.asList(syntheticGem, naturalGem);
        Parser parser = new JaxbParserImpl();
        //when
        List<Gem> actual = parser.parse(XML_FILE_PATH);
        //then
        Assert.assertEquals(expected, actual);
    }
}