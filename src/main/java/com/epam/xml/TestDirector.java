package com.epam.xml;

import com.epam.xml.entity.Gem;
import com.epam.xml.exception.ParserCustomException;
import com.epam.xml.parser.Parser;
import com.epam.xml.parser.impl.SaxParserImpl;
import com.epam.xml.validator.XmlValidator;

import java.util.List;

public class TestDirector {
    public static void main(String[] args) throws ParserCustomException {
        String xmlFile = "src/test/resources/gems.xml";
        String xsdFile = "src/test/resources/gems.xsd";
        XmlValidator validator = new XmlValidator();
        Parser parser = new SaxParserImpl();

        XmlDirector director = new XmlDirector(validator, parser);
        List<Gem> result = director.parseXml(xmlFile, xsdFile);
        System.out.println(result);
    }
}
