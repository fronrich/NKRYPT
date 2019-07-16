/**
 * @author Fronrich Puno
 * 
 *         This is a data structure which specializes in holding file access
 *         information and processing information.
 */
public class PreProcessor {
	// 0 is encrypt 1 is decrypt
	private final int FUNCTION;
	private String FILE_PATH;
	
	// once set these variables cannot be altered
	public PreProcessor(int function, String filePath) {
		FUNCTION = function;
		FILE_PATH = filePath;
	}
	
	// access function
	public int getFunction() {
		return FUNCTION;
	}
	
	// access file path
	public String getFilePath() {
		return FILE_PATH;
	}
}
