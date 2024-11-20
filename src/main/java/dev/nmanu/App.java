package dev.nmanu;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.*;

/*
 * Sommer: A simple object serializer
 * @author: Nana Adjei Manu
 * @license: MIT
 * 
 */
public class App {
	public static void main(String[] args) throws IOException {
		Sommer.JSONBuilder builder = new Sommer.JSONBuilder();
		Sommer s = builder.addData(List.of(new User("Nana", "Manu", 33), new User("Kwame", "Manu", 30)))
				.parseToJSON().build();
		System.out.println("output: " + s.getData());

	}

	public static void readAllLines(String fp) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(fp));
		for (String line : lines) {
			System.out.println("Line: " + line);
		}
	}
}
