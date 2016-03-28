package chapter1;

import java.util.Iterator;

public class Double_Linked<T> implements Iterable<T> {
	private int size;
	private Node head;
	private Node tail;
	
	private class Node {
		T t;
		Node pre;
		Node next;
	}
	
	public boolean isEmpty() {
		return size == 0;
		// rear == null;
	}
	
	public int size() {
		return size;
	}
	
	public void insertheadBefore(T t) {
		Node oldhead = head;
		head = new Node();
		head.t = t;
		if(size == 0)
			tail = head;
		else {
			head.next = oldhead;
			head.pre = null;
			oldhead.pre = head;
		}
		size++;
	}
	
	public void insertheadAfter(T t) {
		Node temp1 = new Node();
		temp1.t = t;
		temp1.next = head.next;
		temp1.pre = head;
		head.next.pre = temp1;
		head.next = temp1;
		size++;
	}
	
	public void inserttailAfter(T t) {
		Node oldtail = tail;
		tail = new Node();
		tail.t = t;
		if(size == 0) 
			head = tail;
		else {
			tail.next = null;
			tail.pre = oldtail;
			oldtail.next = tail;
		}
		size++;
	}
	
	public void inserttailBefore(T t) {
		Node temp2 = new Node();
		temp2.t = t;
		temp2.next = tail;
		temp2.pre = tail.pre;
		tail.pre.next = temp2;
		tail.pre = temp2;     // 第68行與第69行交換將導致錯誤；
		size++;
	}
	
	/**
	 * 通过插入从头开始第一个指定元素的前面
	 * @param t
	 * @param t1
	 */
	public void insertAnyPlaceBefore1(T t, T t1) {
		Node temp1 = head;
		while(t != temp1.t) {
			temp1 = temp1.next;
		}
		Node temp2 = new Node();
		temp2.t = t1;
		temp2.next = temp1;
		temp2.pre = temp1.pre;
		temp1.pre.next = temp2;
		temp1.pre = temp2;
		size++;
	}
	
	public void InsertAnyPlaceAfter2(int size, T t) {
		int i = 0;
		Node temp1 = head;
		while(i++ != size){
			temp1 = temp1.next;
		}
		Node temp2 = new Node();
		temp2.t = t;
		temp2.next = temp1.next;
		temp2.pre = temp1;
		temp1.next.pre = temp2;
		temp1.next = temp2;
		this.size++;
	}
	public Iterator<T> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T> {
		public boolean hasNext() {
			return size > 0;
		}
//		public T next() {
//			T t = tail.t;
//			tail = tail.pre;
//			size --;
//			return t;
//		}
		
		public T next() {
			T t = head.t;
			head = head.next;
			size --;
			return t;
		}
	}
	
	public static void main(String[] args) {
		Double_Linked<Integer> dl = new Double_Linked();
		dl.insertheadBefore(1);
		dl.insertheadBefore(2);
		dl.insertheadAfter(3);
		dl.inserttailAfter(4);
		dl.inserttailBefore(5);
		dl.insertheadBefore(6);
		dl.inserttailBefore(7);
		dl.insertAnyPlaceBefore1(3, 8);
		dl.InsertAnyPlaceAfter2(5, 9);
		Iterator<Integer> i = dl.iterator();
		for(int c : dl) {
			System.out.println(c);
		}
	}
}
