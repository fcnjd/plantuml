package nonreg.svg;

import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import static java.nio.charset.StandardCharsets.UTF_8;
import static net.sourceforge.plantuml.FileFormat.SVG;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test that PlantUML SVG output includes the custom plantuml namespace
 * and uses it for semantic attributes.
 */
public class PlantUMLNamespaceTest {

	@Test
	void testPlantUMLNamespaceIsDefined() throws Exception {
		final String diagramText = "@startuml\n" +
				"Alice -> Bob: Hello\n" +
				"@enduml";
		
		final String svg = generateSVG(diagramText);
		final Document doc = parseXML(svg);
		final Element root = doc.getDocumentElement();
		
		// Check that the plantuml namespace is defined
		String plantumlNamespace = root.getAttribute("xmlns:plantuml");
		assertEquals("http://plantuml.com/xmlns", plantumlNamespace,
				"PlantUML namespace should be defined in SVG root");
	}

	@Test
	void testElementsHavePlantUMLTypeAttribute() throws Exception {
		final String diagramText = "@startuml\n" +
				"Alice -> Bob: Test Message\n" +
				"@enduml";
		
		final String svg = generateSVG(diagramText);
		final Document doc = parseXML(svg);
		
		// Check that rectangles have plantuml:type attribute
		NodeList rects = doc.getElementsByTagName("rect");
		assertTrue(rects.getLength() > 0, "Should have at least one rectangle");
		boolean foundTypeAttr = false;
		for (int i = 0; i < rects.getLength(); i++) {
			Element rect = (Element) rects.item(i);
			if (rect.hasAttribute("plantuml:type")) {
				foundTypeAttr = true;
				assertEquals("rectangle", rect.getAttribute("plantuml:type"));
			}
		}
		assertTrue(foundTypeAttr, "At least one rectangle should have plantuml:type attribute");
		
		// Check that lines have plantuml:type attribute
		NodeList lines = doc.getElementsByTagName("line");
		if (lines.getLength() > 0) {
			boolean foundLineType = false;
			for (int i = 0; i < lines.getLength(); i++) {
				Element line = (Element) lines.item(i);
				if (line.hasAttribute("plantuml:type")) {
					foundLineType = true;
					assertEquals("line", line.getAttribute("plantuml:type"));
				}
			}
			assertTrue(foundLineType, "At least one line should have plantuml:type attribute");
		}
		
		// Check that text elements have plantuml:type attribute
		NodeList texts = doc.getElementsByTagName("text");
		assertTrue(texts.getLength() > 0, "Should have at least one text element");
		boolean foundTextType = false;
		for (int i = 0; i < texts.getLength(); i++) {
			Element text = (Element) texts.item(i);
			if (text.hasAttribute("plantuml:type")) {
				foundTextType = true;
				assertEquals("text", text.getAttribute("plantuml:type"));
			}
		}
		assertTrue(foundTextType, "At least one text should have plantuml:type attribute");
	}

	@Test
	void testGroupsHavePlantUMLSemanticAttributes() throws Exception {
		final String diagramText = "@startuml\n" +
				"Alice -> Bob: Hello\n" +
				"@enduml";
		
		final String svg = generateSVG(diagramText);
		final Document doc = parseXML(svg);
		
		// Check that groups have plantuml namespace versions of semantic attributes
		NodeList groups = doc.getElementsByTagName("g");
		assertTrue(groups.getLength() > 0, "Should have at least one group");
		
		boolean foundPlantUMLClassAttr = false;
		boolean foundPlantUMLDataParticipantAttr = false;
		
		for (int i = 0; i < groups.getLength(); i++) {
			Element group = (Element) groups.item(i);
			
			// Check for plantuml:class attribute
			if (group.hasAttribute("plantuml:class")) {
				foundPlantUMLClassAttr = true;
				// Should match the non-namespaced class attribute
				if (group.hasAttribute("class")) {
					assertEquals(group.getAttribute("class"), group.getAttribute("plantuml:class"));
				}
			}
			
			// Check for plantuml:data-participant attribute
			if (group.hasAttribute("plantuml:data-participant")) {
				foundPlantUMLDataParticipantAttr = true;
				// Should match the non-namespaced data-participant attribute
				if (group.hasAttribute("data-participant")) {
					assertEquals(group.getAttribute("data-participant"), 
							group.getAttribute("plantuml:data-participant"));
				}
			}
		}
		
		assertTrue(foundPlantUMLClassAttr, "Should find at least one group with plantuml:class attribute");
		assertTrue(foundPlantUMLDataParticipantAttr, 
				"Should find at least one group with plantuml:data-participant attribute");
	}

	private String generateSVG(String diagramText) throws Exception {
		final SourceStringReader ssr = new SourceStringReader(diagramText, UTF_8);
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ssr.outputImage(baos, 0, new FileFormatOption(SVG, false));
		return new String(baos.toByteArray(), UTF_8);
	}

	private Document parseXML(String xml) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(new InputSource(new StringReader(xml)));
	}
}
