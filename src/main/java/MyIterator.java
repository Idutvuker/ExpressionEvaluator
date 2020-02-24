import java.util.ArrayList;

public class MyIterator {
	ArrayList<String> list;
	private int i = 0;

	MyIterator(ArrayList<String> list) {
		this.list = list;
	}

	String get() {
		return list.get(i);
	}
	MyIterator next() {
		i++;
		return this;
	}
	boolean isNull() {
		return (i == list.size());
	}
}
