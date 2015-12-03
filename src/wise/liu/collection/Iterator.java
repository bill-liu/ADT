package wise.liu.collection;

public interface Iterator<AnyType> {
	boolean hasNext();
	AnyType next();
	void remove();
}
