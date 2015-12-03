package wise.liu.collection.list;


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

	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public boolean contains(AnyType x) {
		return false;
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
		return null;
	}
	
}
