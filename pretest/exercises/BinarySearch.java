package exercises;

public class BinarySearch {

    /**
     * Find the position of an item in a given array, if it is anywhere.
     * PRECONDITION: The array is sorted and contains no null elements.
     * @param array An array sorted by its elements' natural ordering
     * (as expressed by compareTo()).
     * @param item The item for which to search.
     * @return A position in the array which contains the item, or -1 if
     * it does not occur in the array (including if the array is empty or null)
     */
    public static <T extends Comparable<T>> int binarySearch(T[] array, T item) {
    	if(array==null || array.length==0) { //Catches outlier cases
    		return -1;
    	}
    	
    	int start = 0; //The beggining of the array to be searched
    	int end = array.length; //The end of the array to be searched
    	int middle = (start+end)/2;// The middle of the array, and ellement to be sorted
    	
    	while(start<end) {
    		int compare = array[middle].compareTo(item); //keeps track of the result of a comparison
    		if(compare ==0) {
    			return middle;
    		}else if(compare==-1) {
    			start = middle+1;
    			middle=(start+end)/2;
    		}else if(compare==1) {
    			end = middle;
    			middle=(start+end)/2;
    		}
    		
    	}
    	return -1;
    }
    
}
