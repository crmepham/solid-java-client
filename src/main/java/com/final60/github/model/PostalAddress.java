package com.final60.github.model;

import com.taxonic.carml.rdf_mapper.annotations.RdfProperty;

public class PostalAddress {

    private String streetAddress;

    private String locality;

    private String postalCode;

    private String region;

    private String countryName;

    /**
     * Gets the streetAddress.
     *
     * @return streetAddress
     */
    public String getStreetAddress()
    {
        return streetAddress;
    }

    /**
     * Sets the streetAddress.
     *
     * @param streetAddress the streetAddress
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#street-address")
    public void setStreetAddress(String streetAddress)
    {
        this.streetAddress = streetAddress;
    }

    /**
     * Gets the locality.
     *
     * @return locality
     */
    public String getLocality()
    {
        return locality;
    }

    /**
     * Sets the locality.
     *
     * @param locality the locality
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#locality")
    public void setLocality(String locality)
    {
        this.locality = locality;
    }

    /**
     * Gets the postalCode.
     *
     * @return postalCode
     */
    public String getPostalCode()
    {
        return postalCode;
    }

    /**
     * Sets the postalCode.
     *
     * @param postalCode the postalCode
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#postal-code")
    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    /**
     * Gets the region.
     *
     * @return region
     */
    public String getRegion()
    {
        return region;
    }

    /**
     * Sets the region.
     *
     * @param region the region
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#region")
    public void setRegion(String region)
    {
        this.region = region;
    }

    /**
     * Gets the countryName.
     *
     * @return countryName
     */
    public String getCountryName()
    {
        return countryName;
    }

    /**
     * Sets the countryName.
     *
     * @param countryName the countryName
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#country-name")
    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }


}
