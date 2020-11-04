package wise.liu.datastructure.collection.list;

import wise.liu.datastructure.collection.Collection;

public interface List<AnyType> extends Collection<AnyType> {
	AnyType get(int idx);
	AnyType set(int idx,AnyType newVal);
	void add(int idx,AnyType x);
	void remove(int idx);
	
	List<AnyType> listIterator(int pos);
}
