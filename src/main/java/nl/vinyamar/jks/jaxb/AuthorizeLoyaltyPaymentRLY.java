//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/nl.vinyamar.jks.jaxb">http://java.sun.com/xml/nl.vinyamar.jks.jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.12 at 08:55:10 AM CET 
//


package nl.vinyamar.jks.jaxb;

import javax.xml.bind.annotation.*;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReturnCode" type="{http://www.ing.com/lchgs}returnCode"/>
 *         &lt;element name="Security" type="{http://www.ing.com/lchc}Security"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "returnCode",
    "security"
})
@XmlRootElement(name = "AuthorizeLoyaltyPaymentRLY", namespace = "http://www.ing.com/lch/alp")
public class AuthorizeLoyaltyPaymentRLY {

    @XmlElement(name = "ReturnCode", required = true)
    protected String returnCode;
    @XmlElement(name = "Security", required = true)
    protected Security security;

    /**
     * Gets the value of the returnCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * Sets the value of the returnCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnCode(String value) {
        this.returnCode = value;
    }

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link Security }
     *     
     */
    public Security getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link Security }
     *     
     */
    public void setSecurity(Security value) {
        this.security = value;
    }

}
