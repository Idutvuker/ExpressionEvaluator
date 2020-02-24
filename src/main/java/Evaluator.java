import java.util.ArrayList;

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

	private float parse_nested(MyIterator iterator) {
		if (iterator.get().equals("(")) {
			iterator.next();
			float e = parse_sum(iterator);
			assert(iterator.get().equals(")"));
			iterator.next();
			return e;
		}
		float f = Float.valueOf(iterator.get());
		iterator.next();
		return f;
	}
}
