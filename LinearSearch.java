/**
 * LinearSearch class performs a linear search to find a target word in a text
 * file
 * 
 * @author katarinamcgaughy
 *
 */
public class LinearSearch extends SearchAlgorithm {

	/**
	 * LinearSearch Constructor
	 */
	public LinearSearch() {
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
		for (int i = 0; i < words.length; i++) {
			incrementCount();
			if (words[i].equals(wordToFind)) {
				return i;
			}
		}

		if (getCount() == words.length) {
			resetCount();
			throw new ItemNotFoundException();
		}
		return -1;
	}

	/**
	 * recSearch this function calls the recSearchHelper function which returns the
	 * index where the word is found in the array of words Side Note: this function
	 * produces a Stack Overflow error
	 * 
	 * @param: words: an array of words wordToFind: the word to search for
	 * @return: the index where the word is found
	 * 
	 */
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		return helper(words, wordToFind, 0);
	}

	/**
	 * recSearchHelper this function takes in an array of words,a target word, and a
	 * starting index. The function returns the index where the word is found. If
	 * the word is not found it throws an exception
	 * 
	 * @param: words: an array of words wordToFind: the word to search for index:
	 *                starting index
	 * @return: the index where the word is found
	 * @throws ItemNotFoundException
	 * 
	 */
	public int helper(String[] words, String wordToFind, int index) throws ItemNotFoundException {
		this.incrementCount();
		if (index == words.length) {
			throw new ItemNotFoundException();
		} else if (words[index].equals(wordToFind)) {
			return index;
		} else {
			return helper(words, wordToFind, index + 1);
		}
	}

}
