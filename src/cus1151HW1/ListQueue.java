package cus1151HW1;

public class ListQueue {
	private class Node{
		//TODO Implement Linked List Node
		private String data;
		private Node next;
		public Node(String a) {
			this.data=a;
			this.next=null;
		}
		
		public void add(Node a) {
			this.next=a;
		}
		
		public Node next() {
			return this.next;
		}
		
		public String show() {
			return this.data;
		}
		
	}
	Node head;
	Node tail;
	//Class variables here, if necessary
	
	
	public ListQueue(String a){
		this.head=new Node(a);
		this.tail=this.head;
		
		//TODO Implement constructor
	}
	
	public void enqueue(String toInput) {
		Node newNode=new Node(toInput);
		this.tail.add(newNode);
		this.tail=this.tail.next();
		// TODO Implement enqueue
	}
	
	public String dequeue(){
		if (this.head.show()!=null) {
			String data=this.head.show();
			this.head=this.head.next();
			return data;
			
		}
		// TODO Implement dequeue
		return null;
	}
	
	public String front(){
		if (this.head.show()!=null) {
			String data=this.head.show();
			return data;
		}
		// TODO Implement front
		return null;
	}

}