/**
 * This class is meant to represent an ArrayList.
 * 
 * @author Katarina McGaughy
 *
 */
public class ArrayList {

	//ArayList is an array of Objects 
	private Object[] ArrayList;
	//count keeps track of how many Objects are in the array
	private int count = 0;
	
	/**
	 * getCount
	 * @return: returns the number of elements in the array
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * ArrayList Constructor that initializes the ArrayList
	 */
	public ArrayList() {
		ArrayList = new Object[0];
	}

	/**
	 * insert This function adds an object to the index entered
	 * 
	 * @param o:     some type of Object
	 * @param index: must be positive and less than or equal to the ArrayList length
	 *               PRE: ArrayList without Object entered POST: Object Added to the
	 *               ArrayList after ArrayList has been resized and elements moved
	 */
	public void insert(Object o, int index) {
		resizeArray();
		if (index >= 0 && index < this.ArrayList.length) {
			shiftElementsAdded(index);
			ArrayList[index] = o;
			this.count++;
		} 
		else {
			System.out.println("Invalid index entered. Index must be positive and less then or equal "
					+ "to the number of elements in the array.");
		}
	}

	/**
	 * shiftElementsAdded This function shifts the elements back by 1 starting from
	 * where the new element was added
	 * 
	 * @param index: index of element added PRE: none POST: reorganized elements in
	 *               ArrayList
	 */
	public void shiftElementsAdded(int index) {
		for (int i = (this.ArrayList.length - 1); i > index; i--) {
			ArrayList[i] = ArrayList[i - 1];
		}
	}


	/**
	 * resizeArray This function increases the size of the ArrayList by 1 PRE: none
	 * POST: increased size of ArrayList by 1
	 */
	public void resizeArray() {
		Object[] biggerArray = new Object[this.ArrayList.length + 1];
		for (int i = 0; i < this.ArrayList.length; i++) {
			biggerArray[i] = ArrayList[i];
		}
		this.ArrayList = biggerArray;
	}

	/**
	 * remove This function removes an object at the index entered
	 * 
	 * @param index: must be positive and less than or equal to the ArrayList length
	 *               PRE: ArrayList with Object at index entered POST: ArrayList
	 *               without Object at index entered and resized with elements moved
	 */
	public Object remove(int index) {
		Object elementRemoved = null;
		if (index >=0 && index < this.ArrayList.length-1) {
			elementRemoved = ArrayList[index];
			ArrayList[index] = null;
			shiftElementsRemoved(index);
			decreaseArray();
			this.count--;
			System.out.println(elementRemoved + " succesfully removed.");
			
		} else if (index == this.ArrayList.length-1){
			elementRemoved = ArrayList[index];
			ArrayList[index] = null;
			decreaseArray();
			this.count--;
			System.out.println(elementRemoved + " succesfully removed.");
		}
		
		else {
			System.out.println("Invalid index entered. Index must be positive and less then or equal "
					+ "to the number of elements in the array.");
		}
		return elementRemoved;

	}

	/**
	 * decreaseArray This function decreases the size of the ArrayList by 1 PRE:
	 * none POST: decreased size of ArrayList by 1
	 */
	public void decreaseArray() {
		Object[] smallerArray = new Object[this.ArrayList.length - 1];
		for (int i = 0; i < smallerArray.length; i++) {
			smallerArray[i] = ArrayList[i];
		}
		this.ArrayList = smallerArray;
	}

	/**
	 * shiftElementsRemoved This function shifts the elements forward by 1 where the
	 * element was removed
	 * 
	 * @param index: index of element removed PRE: none POST: reorganized elements
	 *               in ArrayList
	 
	*/
	public void shiftElementsRemoved(int index) {
		Object [] temp = new Object[this.count];
		 for (int i = 0; i < this.count; i++) {
			 for(int j = i; j < this.count - 1; j++){
				 temp[j] = ArrayList[j+1];
			 }
		 }
		 ArrayList = temp;
	}
	
	/**
	 * size
	 * 
	 * @return: the number of elements in the array
	 */
	public int size() {
		return this.count;
	}

	/**
	 * toString
	 * 
	 * @return: a String representation of each element in the ArrayList
	 */
	public String toString() {
		String array = "";
		for (int i = 0; i < this.ArrayList.length; i++) {
			if (ArrayList[i] != null) {
				array = array + " [" + ArrayList[i].toString() + "] ";
			}
		}
		return array;
	}

	/**
	 * isEmpty
	 * 
	 * @return: true if the number of elements in the array is 0
	 */
	public boolean isEmpty() {
		//return this.ArrayList.length == 0;
		return this.count == 0;
	}

	/**
	 * indexOf This function takes in an Object and returns the index where the
	 * Object is located in the array
	 * 
	 * @param o: Object user would like to find in the array
	 * @return: index where Object is located
	 */
	public int indexOf(Object o) {
		if (o == null) {
			System.out.println("Object can't be null.");
		} else {
			for (int i = 0; i < this.ArrayList.length; i++) {
				if (ArrayList[i].equals(o)) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * equals this function compares two ArrayLists
	 * 
	 * @return : true if they are the same and false if not
	 */
	public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}

		ArrayList that = (ArrayList) other;

		if (this.count != that.count) {
			return false;
		}
		for (int i = 0; i < this.ArrayList.length; i++) {

			if (!(this.ArrayList[i].equals(that.ArrayList[i]))) {
				return false;
			}
		}

		return true;

	}

	/**
	 * get This function takes in an index and returns the Object located at that
	 * index
	 * 
	 * @param index: index of array
	 * @return: Object located at the index entered
	 */
	public Object get(int index) {
		if (index < 0 || index > this.ArrayList.length) {
			System.out.println("Invalid index entered. Index must be positive and less then or equal "
					+ "to the number of elements in the array.");
		} else {
			return ArrayList[index];
		}
		return null;
	}

}
