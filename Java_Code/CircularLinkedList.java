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
		if(isEmpty())
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
		if(isEmpty())
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

	/** Insert a new Node in the middle at a position */
	public static void insertAtPosition(int position, int data)
	{
		if(position <= 0 || position > length + 1)
		{
			out.println("Insertion not possible");
			return;
		}
		else if(position == 1)
			insertAtStart(data);
		else if(position == length + 1)
			insertAtEnd(data);
		else
		{
			Node newNode = new Node(data);
			Node temp = head;
			for(int i = 1; i < position - 1; i++)
				temp = temp.getNext();
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
			length += 1;
		}
	}

	/** Delete a node from the start of the List */
	public static int deleteFromStart() throws Exception
	{
		if(isEmpty())
			throw new Exception("Deletion not possible");
		Node temp = head;
		int d = head.getData();
		while(temp.getNext() != head)
			temp = temp.getNext();
		temp.setNext(head.getNext());
		head = head.getNext();
		length -= 1;
		return d;
	}

	/** Delete a node from the end of the List */
	public static int deleteFromEnd() throws Exception
	{
		if(isEmpty())
			throw new Exception("Deletion not possible");
		Node temp = head;
		while(temp.getNext().getNext() != head)
			temp = temp.getNext();
		int d = temp.getNext().getData();
		temp.setNext(head);
		length -= 1;
		return d;
	}

	/** Delete a node from the middle of the List at a given position */
	public static int deleteFromPosition(int position) throws Exception 
	{
		int d = 0;
		if(position <= 0 || position > length)
			throw new Exception("Deletion not possible");
		else if(position == 1)
			d = deleteFromStart();
		else if(position == length)
			d = deleteFromEnd();
		else
		{
			Node temp = head;
			for(int i = 1; i < position - 1; i++)
				temp = temp.getNext();
			d = temp.getNext().getData();
			temp.setNext(temp.getNext().getNext());
			length -= 1;
		}
		return d;
	}

	/** Clear the list */
	public static void clearAll()
	{
		head =  null;
		length = 0;
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
	public static void main(String[] args)  throws Exception {
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
		insertAtEnd(12);
		display(head);
		insertAtPosition(2, 1);
		display(head);
		out.println("Deleted is:"+deleteFromStart());		
		display(head);
		//clearAll();
		out.println("Deleted is:"+deleteFromEnd());		
		display(head);
		out.println("Deleted is:"+deleteFromPosition(4));		
		display(head);
	}
}