package lab04_25;

public interface Queue {
	void enqueue(Object elem);
	Object dequeue();
	boolean empty();
}