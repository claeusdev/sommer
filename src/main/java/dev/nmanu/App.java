package dev.nmanu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/*
 * Sommer: A simple object serializer
 * @author: Nana Adjei Manu
 * @license: MIT
 * 
 */
public class App {
	public static void main(String[] args) throws IOException {
		// String filename = "test.txt";
		// if (args.length > 1) {
		// filename = args[1];
		// }
		//
		// readAllLines(filename);
		//
		Sommer.JSONBuilder builder = new Sommer.JSONBuilder();
		Sommer s = builder.addData(new Integer[] { 1, 2, 3, 4, 5 }).build();
		System.out.println("output: " + s);

	}

	public static void readAllLines(String fp) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(fp));
		for (String line : lines) {
			System.out.println("Line: " + line);
		}
	}
}
