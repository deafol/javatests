package nl.vinyamar.xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stax.StAXSource;
import java.io.StringReader;

public class Stax2Dom2 {

	public static void main(String[] args) throws TransformerException, XMLStreamException {

		String xml =
				"<?xml version=\"1.0\"?>" +
						"<document>" +
						"  <element xmlns=\"http://localhost\" />" +
						"</document>";

		StringReader reader = new StringReader(xml);
		XMLInputFactory xif = XMLInputFactory.newFactory();
		XMLStreamReader xsr = xif.createXMLStreamReader(reader);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();

		StAXSource source = new StAXSource(xsr);
		DOMResult result = new DOMResult();

		t.transform(source, result);
		System.out.println((result.getNode()));
	}
}
