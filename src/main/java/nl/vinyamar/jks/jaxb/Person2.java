//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/nl.vinyamar.jks.jaxb">http://java.sun.com/xml/nl.vinyamar.jks.jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.12 at 08:55:10 AM CET 
//


package nl.vinyamar.jks.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for Person2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Person2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonName" type="{http://www.ing.com/lchc}PersonName"/>
 *         &lt;element name="PersonDemographics" type="{http://www.ing.com/lchc}PersonDemographics"/>
 *         &lt;element name="PostalCode" type="{http://www.ing.com/lchs}postalCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person2", propOrder = {
    "personName",
    "personDemographics",
    "postalCode"
})
public class Person2 {

    @XmlElement(name = "PersonName", required = true)
    protected PersonName personName;
    @XmlElement(name = "PersonDemographics", required = true)
    protected PersonDemographics personDemographics;
    @XmlElement(name = "PostalCode")
    protected String postalCode;

    /**
     * Gets the value of the personName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonName }
     *     
     */
    public PersonName getPersonName() {
        return personName;
    }

    /**
     * Sets the value of the personName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonName }
     *     
     */
    public void setPersonName(PersonName value) {
        this.personName = value;
    }

    /**
     * Gets the value of the personDemographics property.
     * 
     * @return
     *     possible object is
     *     {@link PersonDemographics }
     *     
     */
    public PersonDemographics getPersonDemographics() {
        return personDemographics;
    }

    /**
     * Sets the value of the personDemographics property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonDemographics }
     *     
     */
    public void setPersonDemographics(PersonDemographics value) {
        this.personDemographics = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

}