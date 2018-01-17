package bt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EventTest {

	@Test
	final void testEvent() {
		Event e = new Event("1508405807560 1508405807504 vader HELLO");
	}
	
	@Test
	final void testEventNotHello() {
		Event e = new Event("1508405807378 1508405807387 luke LOST vader");
	}

	@Test
	final void testContacted_node() {
		Event e = new Event("1508405807560 1508405807504 vader HELLO");
		assertEquals("vader", e.contacted_node());
	} 

	@Test
	final void testToString() {
		Event e = new Event("1508405807560 1508405807504 vader HELLO");
		assertEquals("HELLO vader", e.toString());
	}

}
