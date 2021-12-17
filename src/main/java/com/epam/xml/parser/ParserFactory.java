package com.epam.xml.parser;

import com.epam.xml.exception.ParserCustomException;
import com.epam.xml.parser.impl.DomParserImpl;
import com.epam.xml.parser.impl.JaxbParserImpl;
import com.epam.xml.parser.impl.SaxParserImpl;

public class ParserFactory {

    Parser create(ParserType parserType) throws ParserCustomException {
        switch (parserType) {
            case DOM_PARSER:
                return new DomParserImpl();
            case SAX_PARSER:
                return new SaxParserImpl();
            case JAXB_PARSER:
                return new JaxbParserImpl();
            default:
                throw new ParserCustomException("Parser type not found");
        }
    }
}
