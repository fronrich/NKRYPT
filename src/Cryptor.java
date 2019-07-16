/**
 * @author Fronrich Puno
 * 
 *         An interface containing the basic methods used by both the encrypting
 *         class and the decrypting class.
 * 
 *         Both of these classes have the ability to read, write, and process files,
 *         however the functionality of these methods will vary.
 */
public interface Cryptor {
	// Reads from a File
	void ReadFile();
	
	// Processes File
	void ProcessFile();

	// Writes to a file
	void writeFile();
}
