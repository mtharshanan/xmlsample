package xmlsample;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlMainParser {

	public static void main(String[] args) throws IOException {

		Address address = new Address("1st Street", 10, "Dublin", "CA");
		Person person = new Person("person1", 12, address);

		pojoToXml(person);
		xmlToPojo();
	}

	private static void pojoToXml(Person person) throws JsonProcessingException {
		ObjectMapper xmlMapper = new XmlMapper();
		String xml = xmlMapper.writeValueAsString(person);
		System.out.format("Formatted XML is %s\n", xml);
	}

	private static void xmlToPojo() throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper xmlMapper = new XmlMapper();
		Person value = xmlMapper.readValue(
				"<Person><name>person2</name><age>22</age><address><street>2nd Street</street><number>20</number><city>Pleasanton</city><state>CA</state></address></Person>"
				, Person.class);
		System.out.format("Formatted POJO is %s\n", value);
	}

}
