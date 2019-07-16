import java.util.Scanner;

/**
 * @author Fronrich Puno
 * 
 * @since July 15, 2019
 * 
 * @version 0.0.0
 * 
 * @see readme.md for descripition
 */
public class NoisyCryption {

	public static void main(String[] args) {
		header();
		engine();
	}

	// Descriptive information about the program
	private static void header() {
		// Program Name
		final String PROGRAM_NAME = "NKRPT";
		// Version Number {<Major Release>, <Minor Update>, <Bug Fix>}
		final int[] VERSION_NUMBER = { 0, 0, 0 };
		// Program header
		System.out.println(PROGRAM_NAME + " - Version " + "\"" + VERSION_NUMBER[0] + "." + VERSION_NUMBER[1] + "."
				+ VERSION_NUMBER[2] + "\"");
		System.out.println("Created by Fronrich Puno\n");
	}

	// primary engine
	private static void engine() {
		Scanner keyboard = new Scanner(System.in);
		// Program will run as long as client desires
		boolean run = true;
		while (run) {
			PreProcessor processInfo = getInfo(keyboard);
			Cryptor cryptor = processInfo.getFunction() == 0 ? new Encryptor(processInfo.getFilePath())
					: new Decryptor(processInfo.getFilePath());
		}
		keyboard.close();
	}

	// Asks for file, then lists options for client
	// 0 is encrypt, 1 is decrypt
	// anything else results in
	private static PreProcessor getInfo(Scanner keyboard) {
		// first get valid function
		// input as String to prevent runtime errors
		String functionAsString = "";
		boolean validFunction = false;
		while (!validFunction) {
			System.out.println("Please input a valid function\n" + "- 0 is the ENCRYPT function\n"
					+ "- 1 is the DECRYPT function");
			System.out.print("Enter your choice here: ");
			functionAsString = keyboard.next();
			System.out.println();
			if (functionAsString.equals("0") || functionAsString.equals("1"))
				validFunction = true;
			else {
				System.out.println("\"" + functionAsString + "\" is not a valid option.\n");
				validFunction = false;
			}
		}
		int function = Integer.parseInt(functionAsString);
		assert function == 0 || function == 1;
		// get valid file to apply function to
		String fileName = "";
		// if all valid return the PreProcessor
		// FIXME
		System.out.println("You picked to " + (function == 0 ? "ENCRYPT" : "DECRYPT") + " the file \"" + fileName + "\"");
		return new PreProcessor(function, fileName);
	}

	// Ask client whether to continue or not
	private static boolean cont(Scanner keyboard) {

	}

}
