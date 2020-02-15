package cus1151HW1;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	/*Your functions (on the left) correspond to the following java Queue functions (on the right)
	 * toTest.enqueue(String a) = toCompare.add(String a)
	 * toTest.dequeue() = toCompare.poll()
	 * toTest.front() = toCompare.peek()
	 * 
	 * This private class performs this interface for you.
	 */
    private static class JavaQueue{
    	//DO NOT EDIT THIS CLASS
    	Queue<String> queue;
    	protected JavaQueue(){
    		queue = new LinkedList<String>();
    	}
    	protected void enqueue(String a){
    		queue.add(a);
    	}
    	protected String dequeue(){
    		return queue.poll();
    	}
    	protected String front(){
    		return queue.peek();
    	}
    }

	public static void main(String[] args){

		testEmpty(new ListQueue(),new JavaQueue());
		testOne(new ListQueue(),new JavaQueue());
		testMany(new ListQueue(),new JavaQueue());
		System.out.print(testMany(new ListQueue(),new JavaQueue()));	
	}
	
	public static boolean testEmpty(ListQueue yourQueue, JavaQueue correctQueue){
		//TODO implement a test of the three functions when the queues are empty
		//Compare the result of your queue  against the java implementation
		if (yourQueue.front()!=correctQueue.front()) {
			return false;
		}
		if(yourQueue.dequeue()!=correctQueue.dequeue()) {
			return false;
		}
		if (yourQueue.front()!=correctQueue.front()) {
			return false;
		}
		yourQueue.enqueue("a");
		correctQueue.enqueue("a");
		if (yourQueue.front()!=correctQueue.front()) {
			return false;
		}
		return true;
	}
	
	public static boolean testOne(ListQueue a, JavaQueue b){
		//TODO implement a test of the three functions when the queues have one element
		//Compare the result of your queue  against the java implementation
		a.enqueue("a");
		b.enqueue("a");
		if (a.front()!=b.front()) {
			return false;
		}
		if(a.dequeue()!=b.dequeue()) {
			return false;
		}
		if (a.front()!=b.front()) {
			return false;
		}
		a.enqueue("b");
		b.enqueue("b");
		if (a.front()!=b.front()) {
			return false;
		}
		return true;
	}
	
	public static boolean testMany(ListQueue a, JavaQueue b){
		//TODO implement a test of the three functions when the queues have many elements
		//Compare the result of your queue  against the java implementation
		//More than one test may be necessary
		a.enqueue("a");
		b.enqueue("a");
		a.enqueue("b");
		b.enqueue("b");
		if (a.front()!=b.front()) {
			return false;
		}
		if(a.dequeue()!=b.dequeue()) {
			return false;
		}
		if (a.front()!=b.front()) {
			return false;
		}
		a.enqueue("c");
		b.enqueue("c");
		if (a.front()!=b.front()) {
			return false;
		}
		// second time
		a.enqueue("a");
		b.enqueue("a");
		a.enqueue("b");
		b.enqueue("b");
		a.enqueue("c");
		b.enqueue("c");
		a.enqueue("d");
		b.enqueue("d");
		if (a.front()!=b.front()) {
			return false;
		}
		if(a.dequeue()!=b.dequeue()) {
			return false;
		}
		if (a.front()!=b.front()) {
			return false;
		}
		
		
		return true;
	}
}
