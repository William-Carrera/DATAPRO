package exercises;

public class SelectionSort {
    /**
     * Uses selection sort to sort a generic array of objects. 
     * 
     * NOTE: the tests for this exercise assume you the selection sort. If you use any other sorting algorithm
     * or any variation on selection sort that does not make the same number of comparisons as selection sort,
     * the tests will fail.
     * 
     * array - An array objects that implement Comparable to sort
     * 
     * PRECONDITION: 
     *  -array contains comparable objects. Array is non-null.
     * 
     * POSTCONDITION: 
     *  - array is sort in decreasing order. More formally, for all n <= m, array[n].compareTo(array[m]) >= 0.
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
    	T temp; //used for swaping elements
		int i,j,small; //beginning of unsorted elements; iterates through the unsorted items; keeps track of the smallest item
    	for(i=0;i<array.length;i++) {
    		small=i;
    		for(j=i+1;j<array.length;j++) {
    			if(array[small].compareTo(array[j])>0)
    				small=j;
    		}
    		temp = array[i];
    		array[i] = array[small];
    		array[small]=temp;
    	}
    }
}
