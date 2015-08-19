import static org.junit.Assert.*;
import org.junit.Test;

public class HelloWorldTest {
	public HelloWorld h = new HelloWorld();
	@Test
	public void testHello() {
		h.hello();
		assertEquals("Hello World!!!", h.getStr());
	}
}

