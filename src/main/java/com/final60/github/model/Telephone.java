package com.final60.github.model;

import com.taxonic.carml.rdf_mapper.annotations.RdfProperty;
import org.eclipse.rdf4j.model.IRI;

public class Telephone
{

    private IRI type;

    private IRI value;

    /**
     * Gets the type.
     *
     * @return type
     */
    public IRI getType()
    {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the type
     */
    @RdfProperty("http://www.w3.org/1999/02/22-rdf-syntax-ns#type")
    public void setType(IRI type)
    {
        this.type = type;
    }


    /**
     * Gets the value.
     *
     * @return value
     */
    public IRI getValue()
    {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the value
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#value")
    public void setValue(IRI value)
    {
        this.value = value;
    }
}
