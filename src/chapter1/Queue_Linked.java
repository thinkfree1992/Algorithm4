package chapter1;

public class Queue_Linked<T> {
	private int size;
	private Node rear;
	private Node tail;
	
	private class Node{
		T t;
		Node front;
		Node later;
	}
	
	public void enqueue(T t){
		Node oldtail = tail;
		tail = new Node();
		tail.t = t;
		//tail.front = oldtail;
		tail.later = null;
		size++;
		if(size == 1)
			rear = tail;
		else
			oldtail.later = tail;
	}
	
	public T dequeue(){
		T t = null;
		if(size > 0){
			 t = rear.t;
			rear = rear.later;
			//rear.front = null;
			size--;
		}
		return t;
	}
	
	public static void main(String[] args){
		Queue_Linked ql = new Queue_Linked();
		ql.enqueue(34);
		ql.enqueue("dfsafs");
		ql.enqueue(234);
		ql.enqueue(4324);
		System.out.println(ql.size);
		System.out.println(ql.dequeue());
		System.out.println(ql.dequeue());
	}
}
