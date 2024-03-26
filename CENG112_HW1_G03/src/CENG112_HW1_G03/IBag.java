package CENG112_HW1_G03;

public interface IBag<T> {
	
	public boolean add(T newEntry);
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public T removeByIndex(int index);
	
	public boolean remove(T anEntry);
	
	public T remove();
	
	public int getFrequenctOf(T anEntry);
	
	public int getIndexOf(T anEntry);
	
	public boolean contains(T anEntry);
	
	public void clear();
	
	public void displayItems();
	
	public int getCurrentSize();
	
	public T[] toArray();
	
}
