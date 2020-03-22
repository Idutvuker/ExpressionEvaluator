import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluatorTest {

	@Test
	void eval() {
		Evaluator evaluator = new Evaluator();

		assertEquals(evaluator.eval("3 + 5*2* ( 0.6- 0.1)"), 8.0, 1e-5);
		assertEquals(evaluator.eval("1 + 1 / 3"), 1.3333333, 1e-5);
		assertEquals(evaluator.eval("1 + sin(3 * 3.1415926535)"), 1.0, 1e-5);
	}
}