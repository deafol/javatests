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
 * <p>Java class for AccountInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PointsBalance" type="{http://www.ing.com/lchs}pointsBalance"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountInfo", propOrder = {
    "pointsBalance"
})
public class AccountInfo {

    @XmlElement(name = "PointsBalance", required = true)
    protected BigInteger pointsBalance;

    /**
     * Gets the value of the pointsBalance property.
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *
     */
    public BigInteger getPointsBalance() {
        return pointsBalance;
    }

    /**
     * Sets the value of the pointsBalance property.
     *
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *     
     */
    public void setPointsBalance(BigInteger value) {
        this.pointsBalance = value;
    }

}