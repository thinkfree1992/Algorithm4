package chapter1;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
	private T[] arr = null;
	private int size = 0;
	
	/**
	 * initializeds an empty Bag
	 */

	public Bag(int cap){
		arr = (T[])new Object[cap];
		size = 0;
	}
	
	/**
	 * 添加一个元素
	 */
	public void add(T t){
		if(size == arr.length){
			resize(2 * arr.length);
		}
		arr[size++] = t;
	}
	
	/**
	 * 数组是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * 返回数组大小
	 * @return
	 */
	public int size(){
		return size;
	}
	 /**
	  * 修改数组大小
	  * @param length
	  */
	public void resize(int length){
		T[] temp = (T[])new Object[length];
		for(int i = 0; i < arr.length; i++){
			temp[i] = arr[i];
		}
		arr = temp;
	}
	
	public Iterator<T> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<T>{
		public boolean hasNext(){
			return size > 0;
		}
		public void remove(){
			
		}
		public T next(){
			return arr[--size];
		}
	}
	
	public static void main(String[] args){
		Bag<Integer> a = new Bag<Integer>(5);
		a.add(10);
		a.add(5);
		a.add(8);
		a.add(7);
		Iterator i = a.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}

