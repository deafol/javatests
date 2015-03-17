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
import java.math.BigInteger;

/**
 * <p>Java class for PostalAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostalAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContactPointUsageTypeName" type="{http://www.ing.com/lchs}contactPointUsageTypeEnum" minOccurs="0"/>
 *         &lt;element name="PreferredLanguage" type="{http://www.ing.com/lchgs}languageEnum" minOccurs="0"/>
 *         &lt;element name="PostalAddressInformation" type="{http://www.ing.com/lchs}postalAddressInformation" minOccurs="0"/>
 *         &lt;element name="AddressLines" type="{http://www.ing.com/lchs}addressLines" minOccurs="0"/>
 *         &lt;element name="Street" type="{http://www.ing.com/lchs}street" minOccurs="0"/>
 *         &lt;element name="HouseNumber" type="{http://www.ing.com/lchs}houseNumber" minOccurs="0"/>
 *         &lt;element name="HouseNumberAddition" type="{http://www.ing.com/lchs}houseNumberAddition" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.ing.com/lchs}postalCode" minOccurs="0"/>
 *         &lt;element name="OnBoardType" type="{http://www.ing.com/lchs}onBoardTypeEnum" minOccurs="0"/>
 *         &lt;element name="AddressFormat" type="{http://www.ing.com/lchs}addressFormatEnum" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.ing.com/lchs}city" minOccurs="0"/>
 *         &lt;element name="Region" type="{http://www.ing.com/lchs}region" minOccurs="0"/>
 *         &lt;element name="POBox" type="{http://www.ing.com/lchs}pOBox" minOccurs="0"/>
 *         &lt;element name="CountryCode" type="{http://www.ing.com/lchs}countryCodeEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostalAddress", propOrder = {
    "contactPointUsageTypeName",
    "preferredLanguage",
    "postalAddressInformation",
    "addressLines",
    "street",
    "houseNumber",
    "houseNumberAddition",
    "postalCode",
    "onBoardType",
    "addressFormat",
    "city",
    "region",
    "poBox",
    "countryCode"
})
public class PostalAddress {

    @XmlElement(name = "ContactPointUsageTypeName")
    protected BigInteger contactPointUsageTypeName;
    @XmlElement(name = "PreferredLanguage")
    protected String preferredLanguage;
    @XmlElement(name = "PostalAddressInformation")
    protected String postalAddressInformation;
    @XmlElement(name = "AddressLines")
    protected String addressLines;
    @XmlElement(name = "Street")
    protected String street;
    @XmlElement(name = "HouseNumber")
    protected BigInteger houseNumber;
    @XmlElement(name = "HouseNumberAddition")
    protected String houseNumberAddition;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "OnBoardType")
    protected BigInteger onBoardType;
    @XmlElement(name = "AddressFormat")
    protected BigInteger addressFormat;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "Region")
    protected String region;
    @XmlElement(name = "POBox")
    protected BigInteger poBox;
    @XmlElement(name = "CountryCode")
    protected String countryCode;

    /**
     * Gets the value of the contactPointUsageTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *
     */
    public BigInteger getContactPointUsageTypeName() {
        return contactPointUsageTypeName;
    }

    /**
     * Sets the value of the contactPointUsageTypeName property.
     *
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *
     */
    public void setContactPointUsageTypeName(BigInteger value) {
        this.contactPointUsageTypeName = value;
    }

    /**
     * Gets the value of the preferredLanguage property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    /**
     * Sets the value of the preferredLanguage property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPreferredLanguage(String value) {
        this.preferredLanguage = value;
    }

    /**
     * Gets the value of the postalAddressInformation property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPostalAddressInformation() {
        return postalAddressInformation;
    }

    /**
     * Sets the value of the postalAddressInformation property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPostalAddressInformation(String value) {
        this.postalAddressInformation = value;
    }

    /**
     * Gets the value of the addressLines property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddressLines() {
        return addressLines;
    }

    /**
     * Sets the value of the addressLines property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddressLines(String value) {
        this.addressLines = value;
    }

    /**
     * Gets the value of the street property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Gets the value of the houseNumber property.
     *
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *
     */
    public BigInteger getHouseNumber() {
        return houseNumber;
    }

    /**
     * Sets the value of the houseNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *
     */
    public void setHouseNumber(BigInteger value) {
        this.houseNumber = value;
    }

    /**
     * Gets the value of the houseNumberAddition property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHouseNumberAddition() {
        return houseNumberAddition;
    }

    /**
     * Sets the value of the houseNumberAddition property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHouseNumberAddition(String value) {
        this.houseNumberAddition = value;
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

    /**
     * Gets the value of the onBoardType property.
     *
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *
     */
    public BigInteger getOnBoardType() {
        return onBoardType;
    }

    /**
     * Sets the value of the onBoardType property.
     *
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *
     */
    public void setOnBoardType(BigInteger value) {
        this.onBoardType = value;
    }

    /**
     * Gets the value of the addressFormat property.
     *
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *
     */
    public BigInteger getAddressFormat() {
        return addressFormat;
    }

    /**
     * Sets the value of the addressFormat property.
     *
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *
     */
    public void setAddressFormat(BigInteger value) {
        this.addressFormat = value;
    }

    /**
     * Gets the value of the city property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the region property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the poBox property.
     *
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *
     */
    public BigInteger getPOBox() {
        return poBox;
    }

    /**
     * Sets the value of the poBox property.
     *
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *     
     */
    public void setPOBox(BigInteger value) {
        this.poBox = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

}
