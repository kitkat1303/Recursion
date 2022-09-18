/**
 * This driver class performs various tests on the FindFile class
 * @author katarinamcgaughy
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		TestDriver("Testing a invalid file:", 10," ", "/Users/katarinamcgaughy/test");
		TestDriver("Testing file that exists twice.", 10,"b.txt", "/Users/katarinamcgaughy/test");
		TestDriver("Testing file that exists 3 times but limit 2.", 2,"k.txt", "/Users/katarinamcgaughy/test");
		TestDriver("Testing file that exists 1.", 10,"a.txt", "/Users/katarinamcgaughy/test");
	}
		        
	
	public static void TestDriver(String des, int numberOfFiles, String fileTarget, String directory) {
		System.out.println(des);
		FindFile f = new FindFile(numberOfFiles);
		try {
			f.directorySearch(fileTarget, directory);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Printing the files found.");
		f.getFiles();
		System.out.println("End of Test.");
		System.out.println();
	}

}
