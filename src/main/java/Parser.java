import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser
{
	public static ArrayList<String> parse(String line) {
		ArrayList<String> list = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(line, " ()*/+-", true);

		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if (!token.trim().isEmpty())
				list.add(token);
		}
		return list;
	}
}
