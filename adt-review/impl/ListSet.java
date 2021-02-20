package impl;

import java.util.Iterator;
import adt.List;
import adt.Set;

/**
 * ListSet
 * 
 * A basic list implementation of a set (I was surprised
 * to find that I hadn't made one yet.)
 * 
 * @author Thomas VanDrunen
 * CSCI 345, Wheaton College
 * June 12, 2015
 */
public class ListSet<E> implements Set<E> {

    /**
     * The internal representation of this set. The
     * constructor makes this a linked list, but in
     * principle it doesn't matter.
     */
    private List<E> internal;
    
    /**
     * Size of the linked list
     */
    private int size;
    /**
     * Plain constructor. Currently chooses a linked
     * list representation, but that can be changed easily enough.
     */
    public ListSet() {
        internal = new LinkedList<E>();
        size=0;
    }
    
    
    public Iterator<E> iterator() {
         return internal.iterator();
   }

    /**
     * Add an item to the set. (Do nothing if it's 
     * already there.)
     * @param item The item to add
     */
    public void add(E item) {
         if(!this.contains(item)) {
        	 size++;
        	 internal.add(item);
         }
         
    }

    /**
     * Does this set contain the item?
     * @param item The item to check
     * @return True if the item is in the set, false otherwise
     */
    public boolean contains(E item) {
    	for(Iterator<E> it = internal.iterator();it.hasNext();) {
    		if(it.next().equals(item))return true;
    	}
    	return false;
    }

    /**
     * Remove an item from the set, if it's there
     * (ignore otherwise).
     * @param item The item to remove
     */   
    public void remove(E item) {
    	int index=-1;
    	int i=0;
    	for(Iterator<E> it = internal.iterator();it.hasNext();) {
    		if(it.next().equals(item)) {
    			index =i;
    			break;
    		}
    		i++;
    	}
    	if(index!=-1) {
    		internal.remove(index);
    		size--;
    	}
    }

    /**
     * The number of items in the set
     * @return The number of items.
     */
    public int size() {
    	return size;
    }

    /**
     * Is the set empty?
     * @return True if the set is empty, false otherwise.
     */
    public boolean isEmpty() {
         return size==0;
    }
    
    @Override
    public String toString() {
        String toReturn = "[";
        boolean prefix = false;
        for (E item : this) {
            if (prefix)
                toReturn += ", ";
            toReturn += item;
            prefix = true;
        }
        return toReturn +"]";
    }

}
