package chapter2;
/**
 * 使用链表实现的有序优先队列
 */
import java.util.Iterator;

public class Linked_Priority_Queues<T extends Comparable<T>> implements Iterable<T> {
	private Node max;
	private Node first;
	private Node tail;
	private int size;
	private class Node {
		T t;
		Node pre;
		Node next;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void insert(T t) {
		//Node old = new Node();
		//first.t = t;
		if(size == 0) {
			first = new Node();
			first.t = t;
			size++;
			max = tail = first;
		}
		else {
			/**
			 * 插入队尾
			 */
			if(tail.t.compareTo(t) >= 0) {
				Node old = tail;
				tail = new Node();
				tail.t = t;
				tail.pre = old;
				old.next = tail;
				size++;
			}
			/**
			 * 插入队前
			 */
			if(first.t.compareTo(t) <=0)
			{
				Node old = first;
				first = new Node();
				first.t = t;
				first.next = old;
				old.pre = first;
				max = first;
				size++;
			}
			
			/**
			 * 插入队中(前）
			 */
			if(first.t.compareTo(t) > 0 && tail.t.compareTo(t) < 0){
				Node temp = first.next;
				for(int i = 0; i < size - 2; i++) {
					if(temp.t.compareTo(t) > 0) {
						temp = temp.next;
					}
				}
				Node old = new Node();
				old.t = t;
				old.next = temp;
				old.pre = temp.pre;
				temp.pre.next = old;
				temp.pre = old;
				size++;
			}
		}
	}
	
	public void delMax() {
		max = max.next;
		size --;
	}
	
	public T max() {
		return max.t;
	}

	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T>{
		public boolean hasNext() {
			return tail != null;
		}
		
		public T next() {
			T temp = tail.t;
			tail = tail.pre;
			size--;
			return temp;
		}
	}
	public static void main(String[] args) {
		Linked_Priority_Queues<Integer> lpq = new Linked_Priority_Queues<Integer>();
		lpq.insert(4);
		lpq.insert(2);
		lpq.insert(9);
		lpq.insert(3);
		lpq.insert(8);
		lpq.insert(5);
		lpq.insert(32342);
		lpq.insert(234234);
		lpq.insert(42342423);
		for(int c : lpq) {
			System.out.println(c);
		}
	}
}
