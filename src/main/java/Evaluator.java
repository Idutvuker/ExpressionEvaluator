import java.util.ArrayList;
import java.lang.Math;

public class Evaluator
{
	float eval(String expression) {
		ArrayList<String> pe = Parser.parse(expression);
		return parse_sum(new MyIterator(pe));
	}


	private float parse_sum(MyIterator iterator) {
		float left = parse_mul(iterator);
		while (!iterator.isNull())
		{

			if (iterator.get().equals("+")) {
				iterator.next();
				float right = parse_mul(iterator);

				left += right;
				continue;
			}
			else if (iterator.get().equals("-")){
				iterator.next();
				float right = parse_mul(iterator);
				left -= right;
				continue;
			}
			return left;
		}
		return left;
	}

	private float parse_mul(MyIterator iterator) {
		float left = parse_nested(iterator);

		while (!iterator.isNull())
		{
			if (iterator.get().equals("*")) {
				iterator.next();
				float right = parse_nested(iterator);
				left *= right;
				continue;
			}
			else if (iterator.get().equals("/")){
				iterator.next();
				float right = parse_nested(iterator);
				left /= right;
				continue;
			}
			return left;
		}
		return left;
	}

	private float parse_pow(MyIterator iterator) {
		assert(iterator.get().equals("("));
		iterator.next();
		float a = parse_sum(iterator);
		assert(iterator.get().equals(","));
		iterator.next();
		float b = parse_sum(iterator);
		assert(iterator.get().equals(")"));
		iterator.next();
		return (float) Math.pow(a, b);
	}

	private float parse_nested(MyIterator iterator) {
		if (iterator.get().equals("(")) {
			iterator.next();
			float e = parse_sum(iterator);
			assert(iterator.get().equals(")"));
			iterator.next();
			return e;
		}
		if (iterator.get().equals("sin")) {
			iterator.next();
			assert(iterator.get().equals("("));
			iterator.next();
			float e = (float) Math.sin(parse_sum(iterator));
			assert(iterator.get().equals(")"));
			iterator.next();
			return e;
		}
		if (iterator.get().equals("pow")) {
			iterator.next();
			return parse_pow(iterator);
		}

		if (iterator.get().equals("cos")) {
			iterator.next();
			assert(iterator.get().equals("("));
			iterator.next();
			float e = (float) Math.cos(parse_sum(iterator));
			assert(iterator.get().equals(")"));
			iterator.next();
			return e;
		}

		if (iterator.get().equals("e")) {
			iterator.next();
			return (float) Math.E;
		}

		if (iterator.get().equals("pi")) {
			iterator.next();
			return (float) Math.PI;
		}

		float f = Float.valueOf(iterator.get());
		iterator.next();
		return f;
	}
}
