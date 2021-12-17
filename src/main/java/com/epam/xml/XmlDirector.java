package com.epam.xml;

import com.epam.xml.entity.Gem;
import com.epam.xml.exception.ParserCustomException;
import com.epam.xml.parser.Parser;
import com.epam.xml.parser.impl.SaxParserImpl;
import com.epam.xml.validator.XmlValidator;

import java.util.List;

public class XmlDirector {
    private static final String XML_FILE_PATH = "src/test/resources/gems.xml";
    private static final String XSD_FILE_PATH = "src/test/resources/gems.xsd";

    public static void main(String[] args) throws ParserCustomException {
        List<Gem> test;
        XmlValidator validator = new XmlValidator();
        Parser parser = new SaxParserImpl();
        if (validator.isValid(XML_FILE_PATH, XSD_FILE_PATH)) {
            test = parser.parse(XML_FILE_PATH);
        } else
            throw new ParserCustomException("XML file is invalid!");
        // FIXME: 17.12.2021 Statrt main and check! IT DOESN'T WORKS!!!
        System.out.println(test);
    }

}
