package com.epam.xml;

import com.epam.xml.entity.Gem;
import com.epam.xml.entity.NaturalGem;
import com.epam.xml.entity.SyntheticGem;
import com.epam.xml.entity.type.Preciousness;
import com.epam.xml.exception.ParserCustomException;
import com.epam.xml.parser.Parser;
import com.epam.xml.parser.ParserType;
import com.epam.xml.parser.impl.SaxParserImpl;
import com.epam.xml.validator.XmlValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;

public class XmlDirectorTest {
    private final static String FILE_PATH = "testPath";
    private final static Gem TEST_GEM_1 = Mockito.mock(NaturalGem.class);
    private final static Gem TEST_GEM_2 = Mockito.mock(SyntheticGem.class);
    private final static List<Gem> TEST_GEMS_LIST = Arrays.asList(TEST_GEM_1, TEST_GEM_2);

    // TODO: 21.12.2021 Create this test! 
    @Test
    public void testParseXmlShouldCreateWhenXmlIsValid() throws ParserCustomException, JAXBException, FileNotFoundException {
        //given
        XmlValidator validator = Mockito.mock(XmlValidator.class);
        when(validator.isValid(FILE_PATH,FILE_PATH)).thenReturn(true);
        Parser parser = Mockito.mock(SaxParserImpl.class);
        when(parser.parse(FILE_PATH)).thenReturn(TEST_GEMS_LIST);
        ParserType parserType = Mockito.mock(ParserType.class);
        when(parserType.ordinal()).thenReturn(1);
        XmlDirector director = new XmlDirector(validator, parserType);
        //when
        List<Gem> gems = director.parseXml(FILE_PATH, FILE_PATH);
        //then
        Assert.assertEquals(2, gems.size());

    }

}