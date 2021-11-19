import java.io.File;

public class MorseCodeConverter<T> {
	protected static MorseCodeTree tree = new MorseCodeTree();

	public MorseCodeConverter() {
		
	}
	
	/**
	 * Convert String Morse Code Into English
	 * 
	 * @param String encoded input
	 * @return String decoded output
	 * @throws None
	 */
	public static String convertToEnglish(String input) {
		String result = "";
		String[] words = input.split(" / ");
	
		for (String word : words) {
			String[] letters = word.split(" ");
			
			for (String letter : letters) {
				result += MorseCodeConverter.tree.fetch(letter);
			}
			
			result += " ";
		}
		
		return result.trim();
	}

	/**
	 * Convert Morse Code File Into English
	 * @param file
	 * @return
	 * @throws java.io.FileNotFoundException
	 */
	public static String convertToEnglish(java.io.File file) throws java.io.FileNotFoundException {
		if (file == null) { throw new java.io.FileNotFoundException("File provided was null"); }
		
		java.util.ArrayList<String> lines = new java.util.ArrayList<String>();
		java.util.Scanner scanner = new java.util.Scanner(file);
		String result = "";
		
		while (scanner.hasNext()) {
			lines.add(scanner.nextLine());
		}
		for (int i = 0; i < lines.size(); i++) {
			result += MorseCodeConverter.convertToEnglish(lines.get(i));
		}
	
		scanner.close();
		return result.trim();
	}

	/**
	 * Print A MorseCodeTree
	 * 
	 * @return String tree
	 * @throws None
	 */
	public static String printTree() {
		if (tree == null) { return ""; }
		
		java.util.ArrayList<String> list = tree.toArrayList();
		String result = "";
		
		for (String letter : list) {
			result += letter + " ";
		}
		
		return result.trim();
	}
	
}
