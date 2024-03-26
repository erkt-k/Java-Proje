package CENG112_HW1_G03;

public class Bag<T> implements IBag<T> {
	
	private int maxCapacity;
	private T[] items;
	
	@SuppressWarnings("unchecked")
	public Bag() {
		maxCapacity = 0;
		T[] tempBag = (T[]) new Object[0];
		items = tempBag;
	}
	@SuppressWarnings("unchecked")
	public Bag(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		T[] tempBag = (T[]) new Object[maxCapacity];
		items = tempBag;
	}
	
	public boolean add(T newEntry) {
		if (!isFull() && newEntry != null && newEntry instanceof T) {
				items[getCurrentSize()] = newEntry;
				return true;
		} else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		return getCurrentSize() == 0;
	}

	public boolean isFull() {
		return getCurrentSize() == maxCapacity;
	}

	public T removeByIndex(int index) throws ArrayIndexOutOfBoundsException{
		if ( 0 <= index && index < maxCapacity) {
			T removedItem = items[index];
			items[index] = null;
			
			for (int i = index; i < items.length - 1; i++) {
				if (items[i] == null && items[i + 1] != null) {
					items[i] = items[i+1]; 
					items[i+1] = null;
				}
			}
			return removedItem;
		} else {
			System.out.println("Wrong index");
			return null;
		}
	}


	public boolean remove(T anEntry) {
		for(int i = 0; i < items.length; i++) {
			if (items[i] == anEntry) {
				items[i] = null;
				for (int x = 0; x < items.length - 1; x++) {
					if (items[x] == null && items[x + 1] != null) {
						items[x] = items[x+1];
						items[x+1] = null;
					}
				}
				return true;
			}
		}
		return false;
	}

	public T remove() {
		if(!isEmpty()) {
			T removedItem = items[items.length-1];
			items[items.length-1] = null;
			for (int x=0; x<items.length-1;x++) {
				if (items[x]==null && items[x+1]!=null) {
					items[x] = items[x+1];
					items[x+1] = null;
				}
			}
			return removedItem;
		} else {
			System.out.println("The Bag Is Empty.");
			return null;
		}

	}

	public int getFrequenctOf(T anEntry) {
		int frequency = 0;
		for (int i = 0; i<items.length;i++) {
			if(anEntry.equals(items[i])) {
				frequency++;
			}
		}
		return frequency;
	}

	public int getIndexOf(T anEntry) {

		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(anEntry))
			{
				return i;
			}
		}
		return -1;
	}

	public boolean contains(T anEntry) {
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(anEntry)) {
				return true;
			}
		}
		return false;
	}

	public void clear() {
		for (int i = 0; i < items.length; i++) {
			items[i] = null;
		}

	}

	public void displayItems() {
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
	}

	public int getCurrentSize() {
		int currentSize = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				currentSize++;
			}
		}
		return currentSize;
	}
	
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] newArray = (T[]) new Object[getCurrentSize()];
		int newArrayIndex = 0;
		for (T item : items) {
			if (item != null) {
				newArray[newArrayIndex] = item;
				newArrayIndex++;
			}
		}
		return newArray;
	}
	


}
