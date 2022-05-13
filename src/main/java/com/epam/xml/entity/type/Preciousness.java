package com.epam.xml.entity.type;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "preciousness")
@XmlEnum
public enum Preciousness {
    @XmlEnumValue("precious")
    PRECIOUS,
    @XmlEnumValue("semiprecious")
    SEMIPRECIOUS
}