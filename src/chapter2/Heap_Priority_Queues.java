package chapter2;

import java.util.Iterator;

/**
 * 使用数组实现堆，并实现优先队列
 * @author thinkfree1992
 *
 * @param <T>
 */
public class Heap_Priority_Queues<T extends Comparable<T>> implements Iterable<T> {
	private T[] arr;
	private int size;
	
	public Heap_Priority_Queues(int capacity) {
		arr = (T[]) new Comparable[capacity + 1];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void insert(T t) {
		arr[++size] = t;
		swim(size);
	}
	
	public T delMax() {
		T t = arr[1];
		arr[1] = arr[size];
		arr[size--] = null;
		sink(1);
		return t;
	}
	public void swim(int size) {
		int temp = size;
		while(temp > 1 && arr[temp/2].compareTo(arr[temp]) < 0) {
			exchange(temp >> 1, temp);
			temp = temp >> 1;
		}
	}
	
	public void sink(int site) {
		while(2*site < size){
			int j = 2 * site;
			if(arr[j].compareTo(arr[j + 1]) < 0)
				j++;
			if(!(arr[site].compareTo(arr[j]) < 0)) 
				break;
			exchange(site, j);
			site = j;
		}
	}
	
	public T max() {
		return arr[1];
	}
	
	public void exchange(int min , int max) {
		T temp = arr[max];
		arr[max] = arr[min];
		arr[min] = temp;
	}
	
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T>{
		public boolean hasNext() {
			return size > 0;
		}
		
		public T next() {
			return delMax();
		}
	}
	public static void main(String[] args) {
		Heap_Priority_Queues<Integer> hpq = new Heap_Priority_Queues<Integer>(10);
		hpq.insert(1);
		hpq.insert(5);
		hpq.insert(8);
		hpq.insert(343);
		System.out.println(hpq.delMax());
		for(int c : hpq) {
			System.out.println(c);
		}
	}
}
