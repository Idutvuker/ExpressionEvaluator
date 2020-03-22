import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

	@Test
	void parse() {

		List<String> actual = Parser.parse("(( 0.3 35 222/2*2(\n))*sin(22+33)");
		List<String> expected = Arrays.asList("(", "(", "0.3", "35", "222", "/", "2", "*", "2", "(", ")", ")",
												"*","sin","(","22","+","33",")");

		assertEquals(expected, actual);

		actual = Parser.parse("cos (  sin (sin(1)) * 2)");
		expected = Arrays.asList("cos", "(", "sin", "(", "sin", "(", "1", ")", ")", "*", "2", ")");

		assertEquals(expected, actual);


	}
}