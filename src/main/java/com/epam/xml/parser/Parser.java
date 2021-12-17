package com.epam.xml.parser;

import com.epam.xml.entity.Gem;
import com.epam.xml.exception.ParserCustomException;

import java.util.List;

public interface Parser {
    List<Gem> parse(String filePath) throws ParserCustomException;
}
