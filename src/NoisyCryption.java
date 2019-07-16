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

		// Program Name
		final String PROGRAM_NAME = "NKRPT";
		// Version Number {<Major Release>, <Minor Update>, <Bug Fix>}
		final int[] VERSION_NUMBER = { 0, 0, 0 };
		// Program header
		System.out.println(PROGRAM_NAME + " - Version " + "\"" + VERSION_NUMBER[0] + "." + VERSION_NUMBER[1] + "."
				+ VERSION_NUMBER[2] + "\"");
		System.out.println("Created by Fronrich Puno\n");
		engine();
	}

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

		// get valid file to apply function to

		// if all valid return the PreProcessor
		String[] function = new String[2];
		System.out.print(false);
		// FIXME
		return new PreProcessor(0, null);
	}

	// Ask client wether to continue or not
	private static boolean cont(Scanner keyboard) {

	}

}
