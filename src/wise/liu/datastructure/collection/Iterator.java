package wise.liu.datastructure.collection;

public interface Iterator<AnyType> {
	boolean hasNext();
	AnyType next();
	void remove();
}
