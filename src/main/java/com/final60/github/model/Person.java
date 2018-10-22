package com.final60.github.model;

import com.taxonic.carml.rdf_mapper.annotations.RdfProperty;
import com.taxonic.carml.rdf_mapper.annotations.RdfType;

import java.util.Set;

public class Person {

    private String name;
    private Set<String> names;
    private Set<PostalAddress> addresses;
    private Set<Telephone> telephoneNumbers;
    private Set<Email> emails;
    private Set<Person> knows;
    private String note;
    private String role;
    private String organization;
    private String vcard;

    /**
     * Gets the names.
     *
     * @return names
     */
    public Set<String> getNames()
    {
        return names;
    }

    /**
     * Sets the names.
     *
     * @param names the names
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#fn")
    public void setNames(Set<String> names)
    {
        this.names = names;
    }

    /**
     * Gets the addresses.
     *
     * @return addresses
     */
    public Set<PostalAddress> getAddresses()
    {
        return addresses;
    }

    /**
     * Sets the addresses.
     *
     * @param addresses the addresses
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#hasAddress")
    public void setAddresses(Set<PostalAddress> addresses)
    {
        this.addresses = addresses;
    }

    /**
     * Gets the telephones.
     *
     * @return telephones
     */
    public Set<Telephone> getTelephoneNumbers()
    {
        return telephoneNumbers;
    }

    /**
     * Sets the telephones.
     *
     * @param telephoneNumbers the telephoneNumbers
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#hasTelephone")
    @RdfType(Telephone.class)
    public void setTelephoneNumbers(Set<Telephone> telephoneNumbers)
    {
        this.telephoneNumbers = telephoneNumbers;
    }

    /**
     * Gets the note.
     *
     * @return note
     */
    public String getNote()
    {
        return note;
    }

    /**
     * Sets the note.
     *
     * @param note the note
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#note")
    public void setNote(String note)
    {
        this.note = note;
    }

    /**
     * Gets the organization.
     *
     * @return organization
     */
    public String getOrganization()
    {
        return organization;
    }

    /**
     * Sets the organization.
     *
     * @param organization the organization
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#organization-name")
    public void setOrganization(String organization)
    {
        this.organization = organization;
    }

    /**
     * Gets the vcard.
     *
     * @return vcard
     */
    public String getVcard()
    {
        return vcard;
    }

    /**
     * Sets the vcard.
     *
     * @param vcard the vcard
     */
    @RdfProperty("http://xmlns.com/foaf/0.1/vcard")
    public void setVcard(String vcard)
    {
        this.vcard = vcard;
    }

    /**
     * Gets the role.
     *
     * @return role
     */
    public String getRole()
    {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role the role
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#role")
    public void setRole(String role)
    {
        this.role = role;
    }

    /**
     * Gets the name.
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name
     */
    @RdfProperty("http://xmlns.com/foaf/0.1/name")
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the emails.
     *
     * @return emails
     */
    public Set<Email> getEmails()
    {
        return emails;
    }

    /**
     * Sets the emails.
     *
     * @param emails the emails
     */
    @RdfProperty("http://www.w3.org/2006/vcard/ns#hasEmail")
    @RdfType(Email.class)
    public void setEmails(Set<Email> emails)
    {
        this.emails = emails;
    }

    /**
     * Gets the knows.
     *
     * @return knows
     */
    public Set<Person> getKnows()
    {
        return knows;
    }

    /**
     * Sets the knows.
     *
     * @param knows the knows
     */
    @RdfProperty("http://xmlns.com/foaf/0.1/knows")
    @RdfType(Person.class)
    public void setKnows(Set<Person> knows)
    {
        this.knows = knows;
    }
}
