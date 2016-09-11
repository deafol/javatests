package nl.vinyamar.xml;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.StringWriter;


public class Sax2Dom {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		DomListener listener = new DomListener() {
			@Override
			public String getQname() {
				return "Item";
			}

			@Override
			public void processTree(Element tree) throws SAXException, IOException, TransformerException {
				tree.removeChild(tree.getFirstChild());

				StringBuilder content = new StringBuilder("");
				try (StringWriter stringWriter = new StringWriter()) {
					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					transformer.transform(new DOMSource(tree), new StreamResult(stringWriter));
					content.append(stringWriter.toString());
				}
				System.out.println(content.toString());
			}
		};
		Sax2DomHandler handler = new Sax2DomHandler(listener);
		parser.parse(new ClassPathResource("input.xml").getFile(),handler);
	}
}

// a kind of event handler
interface DomListener {
	public String getQname();

	public void processTree(Element tree) throws SAXException, IOException, TransformerException;
}

class Sax2DomHandler extends DefaultHandler {
	private Document factory;
	private Element current;
	private DomListener listener;

	public Sax2DomHandler(DomListener l) {
		listener = l;
	}

	public void startDocument()
			throws SAXException {
		// all this just to get an empty document;
		// we need one to use as a factory
		try {
			factory = DocumentBuilderFactory
					.newInstance()
					.newDocumentBuilder()
					.newDocument();
		} catch (Exception e) {
			throw new SAXException("can't get DOM factory", e);
		}
	}

	public void startElement(String uri, String local,
							 String qName, Attributes atts)
			throws SAXException {
		// start a new subtree, or ignore
		if (current == null) {
			if (!listener.getQname().equals(qName))
				return;
			current = createElement(uri, qName);

			// Add to current subtree, descend.
		} else {
			Element e = createElement(uri, qName);
			current.appendChild(e);
			current = e;
		}
		// NOTE:  this example discards all attributes!
		// They ought to be saved to the current element.
	}

	private Element createElement(String uri, String qName) {
		Element e;
		if ("".equals(uri))
			e = factory.createElement(qName);
		else
			e = factory.createElementNS(uri, qName);
		return e;
	}

	public void endElement(String uri, String local, String qName)
			throws SAXException {
		Node parent;

		// ignore?
		if (current == null)
			return;
		parent = current.getParentNode();

		// end subtree?
		if (parent == null) {
			current.normalize();
			try {
				listener.processTree(current);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
			current = null;

			// else climb up one level
		} else
			current = (Element) current.getParentNode();
	}

	// if saving, append and continue
	public void characters(char buf[], int offset, int length)
			throws SAXException {
		if (current != null)
			current.appendChild(factory.createTextNode(
					new String(buf, offset, length)));
	}
}
