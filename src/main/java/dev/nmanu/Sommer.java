package dev.nmanu;

import java.io.Serializable;
import java.nio.file.*;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sommer {
	private String data;

	private Sommer(JSONBuilder builder) {
		this.data = builder.jsonString;
	}

	static class JSONBuilder implements Serializable {
		private static final ObjectMapper MAPPER = new ObjectMapper();
		private List<Object> data;
		private String jsonString;

		public Sommer build() {
			return new Sommer(this);
		}

		public JSONBuilder addData(List<Object> data) {
			this.data = data;
			return this;
		}

		public JSONBuilder parseToJSON() throws JsonProcessingException {
			// Java object to JSON file - default compact-print
			// MAPPER.writeValue(new File("output.json"), staff);

			// write Java object to JSON file with pretty print
			// MAPPER.writerWithDefaultPrettyPrinter()
			// .writeValue(new File("output.json"), data);

			// convert Java object to JSON string - default compact-print
			String jsonString = MAPPER.writeValueAsString(data);

			System.out.println(jsonString);

			// convert Java object to JSON string - with json pretty-print
			String jsonStringPrettyPrint = MAPPER
					.writerWithDefaultPrettyPrinter()
					.writeValueAsString(data);
			this.jsonString = jsonStringPrettyPrint;
			return this;
		}

	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
