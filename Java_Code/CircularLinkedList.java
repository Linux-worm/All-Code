import java.util.*;
import static java.lang.System.*;

/** Node class */
class Node
{
	private int data;
	private Node next;
	Node(int data)
	{
		this.data = data;
		this.next = null;
	}

	/** Geeters and Setters */
	public void setData(int data)
	{
		this.data = data;
	}

	public int getData()
	{
		return this.data;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	public Node getNext()
	{
		return this.next;
	}
}

/** Circular Linked List Class and operations */
public class CircularLinkedList
{
	static int length = 0;
	static Node head = null;
	
	/** Checks whether the List is empty */
	public static boolean isEmpty()
	{
		return(head == null);
	}

	/** Returns the length of the List */
	public static int getLength()
	{
		return length;
	}

	/** Insert a new Node at the start of the List */
	public static void insertAtStart(int data)
	{
		Node newNode = new Node(data);
		if(head == null)
		{
			head = newNode;
			head.setNext(head);
		}
		else
		{
			Node temp = head;
			while(temp.getNext() != head)
				temp = temp.getNext();
			temp.setNext(newNode);
			newNode.setNext(head);
			head = newNode;
		}
		length += 1;
	}

	/** Insert a new Node at the End of the List */
	public static void insertAtEnd(int data)
	{
		Node newNode = new Node(data);
		if(head == null)
		{
			head = newNode;
			head.setNext(head);
		}
		else
		{
			Node temp = head;
			while(temp.getNext() != head)
				temp = temp.getNext();
			temp.setNext(newNode);
			newNode.setNext(head);	
		}
		length += 1;
	}

	/** Display the List */
	public static void display(Node head)
	{
		Node temp = head.getNext();
		out.print("Head->"+head.getData()+"->");
		while(temp != head)
		{
			out.print(temp.getData()+"->");
			temp = temp.getNext();
		}
		out.println("HEAD");
	}
	
	/** Main method */
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		int n = sc.nextInt();
		while(n -- > 0)
		{
			int data = sc.nextInt();
			insertAtEnd(data);
		}
		display(head);
		insertAtStart(0);
		display(head);		
	}


}