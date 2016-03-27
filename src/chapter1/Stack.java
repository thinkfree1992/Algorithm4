package chapter1;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
	/**
	 * define variations
	 */
	private T[] arr;
	private int size;
	
	/**
	 * define the size of Stack
	 * @param capacity
	 */
	public Stack(int capacity){
		arr = (T[])new Object[capacity];
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void push(T t){
		arr[size++] = t;
	}
	
	public T pop(){
		T temp = null;
		if(size > 0)
		temp = arr[--size];
		return temp;
	}
	
	 public Iterator<T> iterator(){
		return new ListIterator();
	}
	
	 class ListIterator implements Iterator<T>{
		public boolean hasNext(){
			return size > 0;
		}
		
		public void remove(){
			
		}
		public T next(){
			T temp = null;
			while(size > 0){
				temp = arr[--size];
			}
			return temp;
		}
	}
	 
	 public static void main(String[] args){
		 Stack<String> stack = new Stack<String>(5);
		 stack.push("sf");
		 stack.push("ab");
		 stack.pop();
//		 Iterator<String> i = stack.iterator();
//		 while(i.hasNext()){
//			 System.out.println(i.next());
//		 }
		 for(String s : stack){
			 System.out.println(s);
		 }
	 }
}
