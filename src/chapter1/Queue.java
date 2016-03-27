package chapter1;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
	private int capacity;
	private int front;
	private int rear;
	private T[] arr;
	private int size;
	
	/**
	 * 初始化Queue
	 */
	public Queue(int cp){
		arr = (T[])new Object[cp];
		this.size = 0;
		this.capacity = cp;
	}
	
	/**
	 * 队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * 队列大小
	 * @return
	 */
	public int size(){
		return size;
	}
	
	public void enqueue(T t){
		if(size <= capacity){
			if(rear == arr.length){
				rear = 0;
			}
			arr[rear++] = t;
			size++;	
		}
		else {
			System.out.println("队列已满");
		}
	}
	
	public T dequeue(){
		T temp = null;
		if(size > 0){
			if(front == arr.length)
				front = 0;
			temp = arr[front];
			arr[front++] = null;
			size--;
		}
		else {
			System.out.println("队列已空");
		}
		return temp;
	}
	
	public Iterator<T> iterator(){
		return new ListIterator();
	}
	
	private  class ListIterator implements Iterator<T>{
		public boolean hasNext(){
			return size > 0;
		}
		public void remove(){
			
		}
		public T next(){
			T temp = null;
			if(size > 0){
				if(rear == 0)
					rear = arr.length;
				temp = arr[--rear];
				size--;
			}
			return temp;
		}
	}
	
	public static void main(String[] args){
		Queue<String> queue = new Queue<String>(5);
		System.out.println(queue.isEmpty());
		queue.enqueue("a");
		queue.enqueue("abd");
		queue.enqueue("fjasf");
		queue.enqueue("dfasf");
		queue.enqueue("fasfas");
		//System.out.println(queue.isEmpty() + "\n " + queue.size()+ "\n " + queue.rear);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue("ab1");
		queue.enqueue("ab2");
		queue.dequeue();
		Iterator i = queue.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		System.out.println(queue.isEmpty() + "\n " + queue.size());
		
	}
}
