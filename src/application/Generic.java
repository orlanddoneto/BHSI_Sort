package application;

public class Generic<T extends Comparable<T>> implements Comparable<Generic<T>> {
	private T value;

	@Override
	public int compareTo(Generic<T> o) {
		if (this.value instanceof Integer) {
			return ((Integer) this.value).compareTo((Integer) o.getValue());// cast para integer
		} else if (this.value instanceof String) {
			return ((String) this.value).compareTo((String) o.getValue());// cast para String
		} else {
			return ((Double) this.value).compareTo((Double) o.getValue());// cast para Double
		}
	}

	public Generic(T value) {
		this.value = value;
	}

	public Generic() {
	};

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
