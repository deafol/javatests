package nl.vinyamar.xml;

import java.io.*;
import javax.xml.stream.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.*;

public class Stax2Dom {

	public static void main(String[] args) throws Exception {
		XMLInputFactory xif = XMLInputFactory.newInstance();
		xif.setProperty(XMLInputFactory.IS_COALESCING, true);
		XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader(new ClassPathResource("input.xml").getFile()));
		xsr.nextTag(); // Advance to statements element

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		while (xsr.nextTag() == XMLStreamConstants.START_ELEMENT) {
			DOMResult result = new DOMResult();
			t.transform(new StAXSource(xsr), result);
			Node tree = result.getNode();

			printTree(tree);
		}
	}

	private static void printTree(Node tree) throws IOException, TransformerException {
		StringBuilder content = new StringBuilder("");
		try (StringWriter stringWriter = new StringWriter()) {
			TransformerFactory.newInstance().newTransformer().transform(new DOMSource(tree), new StreamResult(stringWriter));
			content.append(stringWriter.toString());
		}
		System.out.println(content.toString());
	}

}
