package chapter1;

import java.util.Iterator;

public class Bag_Linked<T> implements Iterable<T> {
	private Node first;
	private int size;
	
	public Bag_Linked(){
		
	}
	
	private class Node{
		T t;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return size;
	}
	
	public void add(T t){
		Node oldfirst = first;
		first = new Node();
		first.t = t;
		first.next = oldfirst;
		size++;
	}
	
	public Iterator<T> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T>{
		public boolean hasNext(){
			return size > 0;
		}
		public T next(){
				T t = first.t;
				first = first .next;
				size--;
			return t;
		}
	}
	
	public static void main(String[] args){
		Bag_Linked bag = new Bag_Linked();
		bag.add(34);
		bag.add("fadsjsaf");
		bag.add("dfsafsa");
		for(Object i : bag){
			System.out.println(i);
		}
	}
}
