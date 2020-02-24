import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

	@Test
	void parse() {
		Parser p = new Parser();

		List<String> actual = Parser.parse("(( 0.3 35 222/2*2(\n))");
		List<String> expected = Arrays.asList("(", "(", "0.3", "35", "222", "/", "2", "*", "2", "(", ")", ")");

		assertEquals(expected, actual);


	}
}