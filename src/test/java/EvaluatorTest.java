import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluatorTest {

	@Test
	void eval() {
		Evaluator evaluator = new Evaluator();

		assertEquals(evaluator.eval("3 + 5*2* ( 0.6- 0.1)"), 8.0, 1e-5);
		assertEquals(evaluator.eval("1 + 1 / 3"), 1.3333333, 1e-5);
		assertEquals(evaluator.eval("1 + sin(3 * 3.1415926535)"), 1.0, 1e-5);
		assertEquals(evaluator.eval("pow(3 + 1, 3 -1)"), 16.0, 1e-5);
		assertEquals(evaluator.eval("cos(sin(1))"), 0.66636674, 1e-5);

		assertEquals(evaluator.eval("pow(cos(0.3), 2.0) + pow(sin(0.3), 2.0)"), 1.0, 1e-5);

		assertEquals(evaluator.eval("cos(pi / 2.0)"), 0.0, 1e-5);
		assertEquals(evaluator.eval("pow(e, 1.1447298858494002)"), Math.PI, 1e-5);
	}
}