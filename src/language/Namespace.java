package language;

import java.io.File;
import java.io.FileNotFoundException;

public class Namespace {
	private java.util.Scanner scanner;
	
	public String BARBARIAN;
	public String SKELETON;
	
	public String CANON;
	
	public String BARBARIAN_KING;
	
	public Namespace(String filename) throws FileNotFoundException {
		scanner = new java.util.Scanner(new File(filename));
		scanner.useDelimiter(",");
		BARBARIAN = scanner.next();
		SKELETON  = scanner.next();
		scanner.next();
		CANON = scanner.next();
		scanner.next();
		BARBARIAN_KING = scanner.next();
		scanner.close();
	}
	
}
