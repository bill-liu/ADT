package wise.liu.datastructure.collection.list;

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
		@Override
		public String toString(){
			return data.toString();
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
			p = beginMarker.next;
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
		return new LinkedListIterator();
	}
	
	@Override
	public String toString(){
		Node<AnyType> current = beginMarker.next;
		StringBuffer sb = new StringBuffer("");
		while(current != endMarker){
			sb.append(current.data.toString()).append(" ");
			current = current.next;
		}
		return sb.toString();
	}
	private class LinkedListIterator implements Iterator<AnyType>{
		private Node<AnyType> current =  beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		@Override
		public boolean hasNext() {
			return current != endMarker;
		}

		@Override
		public AnyType next() {
			if(modCount != expectedModCount){
				throw new java.util.ConcurrentModificationException();
			}
			if(!hasNext()){
				throw new java.util.NoSuchElementException();
			}
			
			AnyType nextItem = current.data;
			current = current.next;
			okToRemove = true;
			
			return nextItem;
		}
		
		@Override
		public void remove(){
			if(modCount != expectedModCount){
				throw new java.util.ConcurrentModificationException();
			}
			if(!okToRemove){
				throw new IllegalStateException();
			}
			
			LinkedList.this.remove(current.prev);
			okToRemove = false;
			expectedModCount++;
		}
	}
}

class TestLinkedList{
	public static void main(String args[]){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("123");
		linkedList.add("abc");
		linkedList.add("刘应明");
		Iterator it = linkedList.iterator();
		
		while(it.hasNext()){
			String n = (String)it.next();
			if("刘应明".equals(n)){
				it.remove();
			}
		}
		System.out.println(linkedList.toString());
	}
}
