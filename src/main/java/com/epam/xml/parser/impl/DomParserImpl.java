package com.epam.xml.parser.impl;

import com.epam.xml.entity.Gem;
import com.epam.xml.entity.NaturalGem;
import com.epam.xml.entity.SyntheticGem;
import com.epam.xml.entity.type.GemTag;
import com.epam.xml.entity.type.GemType;
import com.epam.xml.entity.type.Preciousness;
import com.epam.xml.exception.ParserCustomException;
import com.epam.xml.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DomParserImpl implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();

    private final List<Gem> GEMS;
    private final DocumentBuilderFactory FACTORY = DocumentBuilderFactory.newInstance();

    public DomParserImpl() {
        this.GEMS = new ArrayList<>();
    }

    public List<Gem> getGems() {
        return GEMS;
    }

    @Override
    public List<Gem> parse(String filePath) {
        Document document;
        try {
            DocumentBuilder documentBuilder = FACTORY.newDocumentBuilder();
            document = documentBuilder.parse(filePath);
            Element root = document.getDocumentElement();
            createSpecifiedTypeGems(root, GemType.NATURALGEM);
            createSpecifiedTypeGems(root, GemType.SYNTHETICGEM);
            LOGGER.info("XML has been parsed successfully!");
        } catch (SAXException | IOException | ParserConfigurationException | ParserCustomException exception) {
            LOGGER.warn(String.format("File %s can't ber read or parsed", filePath), exception);
        }
        return getGems();
    }

    private void createSpecifiedTypeGems(Element root, GemType gemType) throws ParserCustomException {
        NodeList gemNodeList = root.getElementsByTagName(gemType.toString());
        for (int i = 0; i < gemNodeList.getLength(); i++) {
            Element gemElement = (Element) gemNodeList.item(i);
            Gem gem = buildGem(gemElement, gemType);
            GEMS.add(gem);
        }
    }

    private Gem buildGem(Element gemElement, GemType gemType) throws ParserCustomException {
        Gem gem;
        switch (gemType) {
            case NATURALGEM:
                gem = new NaturalGem();
                ((NaturalGem) gem).setGemDeposit(getElementTextContent(gemElement, GemTag.GEMDEPOSIT.toString()));
                break;
            case SYNTHETICGEM:
                gem = new SyntheticGem();
                ((SyntheticGem) gem).setGemProductionPlace(getElementTextContent(gemElement, GemTag.GEMPRODUCTIONPLACE.toString()));
                break;
            default:
                throw new ParserCustomException("Invalid gem type!");
        }
        gem.setId(gemElement.getAttribute(GemTag.ID.toString()));
        String name = getElementTextContent(gemElement, GemTag.NAME.toString());
        gem.setName(name);
        String preciousness = getElementTextContent(gemElement, GemTag.PRECIOUSNESS.toString());
        gem.setPreciousness(Preciousness.valueOf(preciousness.toUpperCase(Locale.ROOT)));
        return gem;
    }

    private static String getElementTextContent(Element gemElement, String tagName) {
        NodeList nodeList = gemElement.getElementsByTagName(tagName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}