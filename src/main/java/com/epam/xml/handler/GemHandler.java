package com.epam.xml.handler;

import com.epam.xml.entity.Gem;
import com.epam.xml.entity.NaturalGem;
import com.epam.xml.entity.SyntheticGem;
import com.epam.xml.entity.type.GemTag;
import com.epam.xml.entity.type.GemType;
import com.epam.xml.entity.type.Preciousness;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;

public class GemHandler extends DefaultHandler {
    private final List<Gem> gems;
    private Gem currentGem;
    private GemTag currentTag;
    private final EnumSet<GemTag> WITH_TEXT;

    public GemHandler() {
        gems = new ArrayList<>();
        WITH_TEXT = EnumSet.range(GemTag.ID, GemTag.GEMDEPOSIT);
    }


    public List<Gem> getGems() {
        return gems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        String name = qName.toUpperCase(Locale.ROOT);
        if (qName.equals(GemType.NATURALGEM.toString()) || qName.equals(GemType.SYNTHETICGEM.toString())) {
            GemType gemType = GemType.valueOf(name);
            switch (gemType) {
                case NATURALGEM:
                    currentGem = new NaturalGem();
                    break;
                case SYNTHETICGEM:
                    currentGem = new SyntheticGem();
                    break;
            }
            if (attributes.getLength() == 1) {
                currentGem.setId(attributes.getValue(0));
            } else {
                int idAttributeIndex = attributes.getLocalName(0).equals(GemTag.ID.toString()) ? 0 : 1;
                currentGem.setId(attributes.getValue(idAttributeIndex));
            }
        } else {
            GemTag temp = GemTag.valueOf(name.toUpperCase(Locale.ROOT));
            if (WITH_TEXT.contains(temp)) {
                currentTag = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals(GemType.NATURALGEM.toString()) || qName.equals(GemType.SYNTHETICGEM.toString())) {
            gems.add(currentGem);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).trim();
        if (currentTag != null) {
            switch (currentTag) {
                case NAME:
                    currentGem.setName(data);
                    break;
                case PRECIOUSNESS:
                    String precious = data.toUpperCase(Locale.ROOT);
                    currentGem.setPreciousness(Preciousness.valueOf(precious));
                    break;
                case GEMDEPOSIT:
                    NaturalGem tempNaturalGem = (NaturalGem) currentGem;
                    tempNaturalGem.setGemDeposit(data);
                    break;
                case GEMPRODUCTIONPLACE:
                    SyntheticGem tempSyntheticGem = (SyntheticGem) currentGem;
                    tempSyntheticGem.setGemProductionPlace(data);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentTag.getDeclaringClass(), currentTag.name());
            }
        }
        currentTag = null;
    }
}