import java.io.File;

/**
 * FindFile is a class that looks through directories and files to find the
 * target file entered.
 * 
 * @author katarinamcgaughy
 *
 */
public class FindFile {

	// maxFiles is the maximum number of files
	private int maxFiles;
	// files is the list of files
	private ArrayList files = new ArrayList();
	// count represents the number of matching files
	private int count= 0;

	/**
	 * setMaxFiles this function sets the maximum number of files
	 * 
	 * @param maxFiles: maximum number of files
	 */
	public void setMaxFiles(int maxFiles) {
		if (maxFiles > 0 && maxFiles < 20) {
			this.maxFiles = maxFiles;
		} else {
			System.out
					.println("Number of files must be greater " + "than 0 and less than 20. Setting to defualt of 1.");
			this.maxFiles = 1;
		}
	}

	/**
	 * getMaxFiles This function returns the maximum number of files
	 * 
	 * @return
	 */
	public int getMaxFiles() {
		return this.maxFiles;
	}

	/**
	 * Constructor
	 * 
	 * @param maxFiles: takes in the maximum number of files
	 */
	public FindFile(int maxFiles) {
		setMaxFiles(maxFiles);
	}

	/**
	 * directorySearch this function takes a starting directory and searches for the
	 * target file
	 * 
	 * @param targetFile:     the target file
	 * @param directoryStart: starting directory
	 */
	public void directorySearch(String targetFile, String directory) throws IllegalArgumentException, RuntimeException {
		File dir = new File(directory);
		if (!dir.exists()) {
			throw new IllegalArgumentException();
		}
		//System.out.println(dir.getPath());

		File[] f = dir.listFiles();
		if (f != null) {
			for (File fileOrDir : f) {
					if (fileOrDir.isDirectory()) {
						directorySearch(targetFile, fileOrDir.getAbsolutePath());
					} 
					else if (fileOrDir.isFile()){
						if (fileOrDir.getName().equals(targetFile)) {
							this.count++;
							if (this.count <= this.maxFiles) {
								this.files.insert(fileOrDir.getAbsolutePath(), this.files.getCount());
								System.out.println("File has been found.");
							}
							else {
								throw new RuntimeException("Max files reached.");
							}	
						}
					}else {
						assert( false );
					}
				} 
		} else {
			System.out.println("Empty Directory.");
		}
	}

	/***
	 * getCount
	 * 
	 * @return: the number of matching files found
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * getFiles this returns the array of file locations
	 * 
	 * @return: the array of the file locations up until the maxFile
	 */
	public String[] getFiles() {
		if (this.files.size() != 0) {
			String[] fileString = new String[this.files.size()];
			for (int i = 0; i < this.files.size(); i++) {
				fileString[i] = this.files.get(i).toString();
				System.out.println(fileString[i]);
			}
			return fileString;
		}
		return null;
	}
}
