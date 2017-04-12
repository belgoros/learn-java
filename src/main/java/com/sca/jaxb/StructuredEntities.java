package com.sca.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by ZFTC0418 on 23/02/2015.
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class StructuredEntities {

    @XmlElement(name = "BatchStructuredLine")
    private List<BatchStructuredLine> entities;

    public List<BatchStructuredLine> getEntities() {
        return entities;
    }

    public void setEntities(final List<BatchStructuredLine> entities) {
        this.entities = entities;
    }
}
