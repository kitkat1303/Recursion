/**
 * BinarySearch class is a class that uses a binary search to find a target word
 * in a text file
 * 
 * @author katarinamcgaughy
 *
 */
public class BinarySearch extends SearchAlgorithm {

	/**
	 * BinarySearch Constructor
	 */
	public BinarySearch() {
		super();
	}

	/**
	 * search this function takes in an array of words and a target word and returns
	 * the index where the word is found if the word is not found it throws an
	 * exception
	 * 
	 * @param: words: an array of words wordToFind: the word to search for
	 * @return: the index where the word is found
	 * 
	 */
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {
		int LowIndex = 0;
		int HighIndex = words.length - 1;
		int MidIndex = -1;
		while (LowIndex <= HighIndex) {
			this.incrementCount();
			MidIndex = (HighIndex + LowIndex) / 2;
			if (words[MidIndex].equals(wordToFind)) {
				return MidIndex;
			}
			// if target word is before...
			else if (words[MidIndex].compareTo(wordToFind) > 0) {
				HighIndex = MidIndex - 1;
			}
			// if target is after...
			else if (words[MidIndex].compareTo(wordToFind) < 0) {
				LowIndex = MidIndex + 1;
			} else {
				throw new ItemNotFoundException();
			}
		}
		throw new ItemNotFoundException();
	}

	/**
	 * recSearch this function calls the recSearchHelper function which returns the
	 * index where the word is found in the array of words
	 * 
	 * @param: words: an array of words wordToFind: the word to search for
	 * @return: the index where the word is found
	 * 
	 */
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		return recSearchHelper(words, wordToFind, 0, words.length);
	}

	/**
	 * recSearchHelper this function takes in an array of words,a target word, and a
	 * start and end index. the function returns the index where the word is found
	 * if the word is not found it throws an exception
	 * 
	 * @param: words: an array of words wordToFind: the word to search for start:
	 *                starting index end: ending index
	 * @return: the index where the word is found
	 * 
	 */
	public int recSearchHelper(String[] words, String wordToFind, int start, int end) throws ItemNotFoundException {
		this.incrementCount();
		int middle = (start + end) / 2;

		if (end < start) {
			throw new ItemNotFoundException();
		}

		if (words[middle].compareTo(wordToFind) > 0) {
			return recSearchHelper(words, wordToFind, start, middle - 1);
		}

		if (words[middle].compareTo(wordToFind) < 0) {
			return recSearchHelper(words, wordToFind, middle + 1, end);
		}

		if (wordToFind.equals(words[middle])) {
			return middle;
		}
		throw new ItemNotFoundException();
	}
}
