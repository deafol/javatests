package nl.vinyamar.jks;

import nl.vinyamar.jks.jaxb.*;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.io.IOException;
import java.math.BigInteger;
import java.net.Authenticator;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class SoapTest {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        Properties properties = System.getProperties();
        properties.put("proxySet", true);
        properties.put("proxyHost", "proxynldcv.europe.intranet");
        properties.put("proxyPort", "8080");
        properties.put("javax.net.ssl.trustStore", "/home/vf65fn/Data/ing-certs/ing.jks");
        properties.put("javax.net.ssl.trustStorePassword", "ing123");
        Authenticator.setDefault(new SimpleAuthenticator("m00117j", "Dev15jan"));

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setDefaultUri("https://lar-t.ingservices.nl/loyalty/");
        webServiceTemplate.setMarshaller(marshaller());
        webServiceTemplate.setUnmarshaller((Unmarshaller) marshaller());

        AuthorizeLoyaltyPaymentREQ req = request();
        AuthorizeLoyaltyPaymentRLY res = (AuthorizeLoyaltyPaymentRLY) webServiceTemplate.marshalSendAndReceive(req);
        System.out.println("returns: " + res.getReturnCode());
    }

    private static AuthorizeLoyaltyPaymentREQ request() {
        AuthorizeLoyaltyPaymentREQ req = new AuthorizeLoyaltyPaymentREQ();
        req.setAuditTrailInfo("dummy");
        req.getParty().add(party());
        req.getParty().add(party());
        req.getAgreementFrom().add(agreement());
        req.getAgreementFrom().add(agreement());
        req.setAgreementTo(agreement());
        req.setPayment(payment());
        req.setSecurity(security());
        return req;
    }

    private static Security security() {
        Security security = new Security();
        security.setSignature("sig");
        return security;
    }

    private static Agreement agreement() {
        Agreement agreement = new Agreement();
        agreement.setAgreementType("type");
        agreement.setExternalAgreementId("12345678");
        agreement.setPartyAgreementRole(partyAgreementRole());
        return agreement;
    }

    private static PartyAgreementRole partyAgreementRole() {
        PartyAgreementRole partyAgreementRole = new PartyAgreementRole();
        partyAgreementRole.setTypeName("typename");
        Party3 party = new Party3();
        party.setId("12345678");
        partyAgreementRole.setParty(party);
        return partyAgreementRole;
    }

    private static Payment payment() {
        Payment payment = new Payment();
        payment.setAmount(BigInteger.ONE);
        payment.setCurrency("EUR");
        payment.setPoints(BigInteger.ONE);
        payment.setOrderId("orderId");
        return payment;
    }

    private static Party party() {
        Party party = new Party();
        party.setId("12345678");
        party.setTypeName("type");
        party.setPersonName(new PersonName());
        return party;
    }

    private static Marshaller marshaller() {
        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("nl.vinyamar.jks.jaxb");
        return marshaller;
    }
}
