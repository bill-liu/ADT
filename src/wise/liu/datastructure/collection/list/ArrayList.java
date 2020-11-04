package wise.liu.datastructure.collection.list;



public class ArrayList<AnyType> implements Iterable<AnyType> {
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private AnyType[] theItems;
	
	public ArrayList(){
		clear();
	}
	
	public int size() {
		return theSize;
	}

	public boolean isEmpty() {
		return 0==theSize;
	}

	public void trimToSize(){
		ensureCapacity(size());
	}
	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public AnyType get(int idx) {
		if(idx < 0 || idx >= size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[idx];
	}

	public AnyType set(int idx, AnyType newVal) {
		if(idx <0 || idx >= size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		AnyType old = theItems[idx];
		theItems[idx] = newVal; 
		return old;
	}
	
	public boolean add(AnyType x) {
		add(size(),x);
		return true;
	}
	
	public void add(int idx,AnyType x){
		if(theItems.length == size()){
			ensureCapacity(size() * 2 + 1);
		}
		for(int i = theSize; i > idx; i--){
			theItems[i] = theItems[i-1];
		}
		theItems[idx] = x;
		
		theSize++;
	}
	
	public AnyType remove(int idx) {
		AnyType removeItem = theItems[idx];
		for(int i = idx ; i > idx ; i++){
			theItems[i] = theItems[i+1]; 
		}
		theSize--;
		return removeItem;
	}

	
	private void ensureCapacity(int newCapacity) {
		if(newCapacity < theSize)
			return;
		AnyType[] old = theItems;
		theItems = (AnyType[])new Object[newCapacity];
		for(int i=0;i<size();i++){
			theItems[i] = old[i];
		}
	}

	@Override
	public java.util.Iterator<AnyType> iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements java.util.Iterator<AnyType>{
		private int current = 0;
		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public AnyType next() {
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			return theItems[current++];
		}

		@Override
		public void remove() {
			ArrayList.this.remove(current--);
		}
		
	}
	public static void printList(ArrayList<String> list){
		for(String str:list){
			System.out.println(str);
		}
	}
	public static void main(String args[]){
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		printList(list);
		java.util.Iterator it =list.iterator();
		if(it.hasNext()){
			it.remove();
		}
		printList(list);
	}
}
