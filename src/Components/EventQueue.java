package Components;
import java.util.PriorityQueue;

/*
 * Encapsulates the event queue used by interrupt system.
 * EventQueue will be a Priority Queue implemented as a Binary Heap data structure
 * 
 */
public class EventQueue {
	
	PriorityQueue <EventControlBlock> queue = new PriorityQueue<EventControlBlock>();
		
	public void enQueue(EventControlBlock event) {
	    queue.add(event);
	}
		  
	public void deQueue(EventControlBlock event) {
		queue.remove(event);
	}
}
