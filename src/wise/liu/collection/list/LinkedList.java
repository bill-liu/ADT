package wise.liu.collection.list;

import java.util.Iterator;

public class LinkedList<AnyType> implements Iterable<AnyType> {
	private int theSize;
	private int modCount;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	
	private static class Node<AnyType>{
		public AnyType data;
		public  Node<AnyType> prev;
		public  Node<AnyType> next;
		public Node(AnyType data,Node<AnyType> prev, Node<AnyType> next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	public LinkedList(){
		this.clear();
	}
	
	public void clear(){
		beginMarker = new Node<AnyType>(null,null,null);
		endMarker = new Node<AnyType>(null,beginMarker,null);
		beginMarker.next = endMarker;
		
		theSize = 0;
		modCount++;
	}
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public boolean add(AnyType x){
		add(size(),x);
		return true;
	}
	public void add(int idx,AnyType x){
		addBefore(getNode(idx),x);
	}
	
	public AnyType get(int idx){
		return getNode(idx).data;
	}
	public AnyType set(int idx,AnyType newVal){
		Node<AnyType> p = getNode(idx);
		AnyType oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}
	public AnyType remove(int idx){
		return remove(getNode(idx));
	}
	
	private AnyType remove(Node<AnyType> oldNode){
		oldNode.next.prev = oldNode.prev;
		oldNode.prev.next = oldNode.next;
		theSize--;
		modCount++;
		
		return oldNode.data;
	}
	private Node<AnyType> getNode(int idx){
		Node<AnyType> p;
		
		if(idx<0 || idx>size()){
			throw new IndexOutOfBoundsException();
		}
		
		if(idx<size()/2){
			p = beginMarker;
			for(int i=0;i<idx;i++){
				p = p.next;
			}
		}else{
			p = endMarker;
			for(int i = size();i>idx;i--){
				p = p.prev;
			}
		}
		
		return p;
	}
	
	private void addBefore(Node<AnyType> prev,AnyType x){
		Node<AnyType> newNode = new Node<AnyType>(x,prev.prev,prev);
		newNode.prev.next = newNode;
		prev.prev = newNode;
		theSize++;
		modCount++;
	}
	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

