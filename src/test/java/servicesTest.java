import static org.junit.Assert.*;

import org.junit.Test;

import service.Servcises;

public class servicesTest {

	@Test
	public void test() {

		Servcises s = new Servcises();
		assertEquals(1,s.add("10003","Captain America","20"));
	}

}
