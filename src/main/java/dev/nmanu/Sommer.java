package dev.nmanu;

public class Sommer {
	private Object[] data;

	private Sommer(JSONBuilder builder) {
		this.data = builder.data;

	}

	static class JSONBuilder {
		private Object[] data;

		public Sommer build() {
			return new Sommer(this);
		}

		public JSONBuilder addData(Object[] data) {
			this.data = data;
			return this;
		}

	}

	public Object[] getData() {
		return data;
	}

	public void setData(Object[] data) {
		this.data = data;
	}

}
