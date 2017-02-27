import java.util.*;
import static java.lang.System.*;

/** Node Class */
class Node
{
	Node next, previous;
	int data;

	/* New node creation */
	Node(int data)
	{
		next = null;
		previous = null;
		this.data = data;
	}

	/** Setters and Getters */
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

	public void setPrevious(Node previous)
	{
		this.previous = previous;
	}

	public Node getPrevious()
	{
		return this.previous;
	}
}

/** Doubly Linked List class and operations */
public class DoublyLinkedList
{
	static Node head = null;
	static Node tail = null;
	static int length = 0;

	/** Check whether the List is empty */
	public static boolean isEmpty()
	{
		return(head == null);
	}

	/** Returns the length */
	public static int getLength()
	{
		return length;
	}

	/** Find the position of the element */
	public static int findPosition(int data)
	{
		int position = 1;
		Node temp = head;
		while(temp != null)
		{
			if(temp.getData() == data)
				return position;
			position += 1;
			temp = temp.getNext();
		}
		return Integer.MIN_VALUE;
	}
	/** Insert a new node at the start of the List */
	public static Node insertAtStart(int data)
	{
		Node temp = new Node(data);
		if(isEmpty())
		{
			head = temp;
			tail = temp;
		}
		else
		{
			temp.setNext(head);
			head.setPrevious(temp);
			head = temp;
		}
		length += 1;
		return head;
	}

	/** Insert a new node at the end of the List */
	public static Node insertAtEnd(int data)
	{
		Node temp = new Node(data);
		if(isEmpty())
		{
			head = temp;
			tail = temp;
		}
		else
		{
			temp.setPrevious(tail);
			tail.setNext(temp);
			tail = temp;
		}
		length += 1;
		return head;
	}
	
	/** Insert a new Node at a position */
	public static Node insertAtPosition(int position, int data)
	{
		if(position <= 0 || position > length + 1)
		{
			out.println("Insertion not possible");
			return head;
		}
		else if(position == 1)
			insertAtStart(data);
		else if(position == length + 1)
			insertAtEnd(data);
		else
		{
			Node temp = new Node(data);
			Node current = head;
			for(int i = 1; i < position - 1; i++)
				current = current.getNext();
			temp.setNext(current.getNext());
			temp.setPrevious(current);
			current.setNext(temp);
			temp.getNext().setPrevious(temp);
			length += 1;	 
		}
		return head;
	}


	/** Delete a node from the start of the List */
	public static int deleteFromStart()
	{
		int d = head.getData();
		if(isEmpty())
		{
			out.println("Deletion not possible");
			return 1;
		}
		else
			head = head.getNext();
		length -= 1;
		return d;
	}

	/** Delete a node from the end of the List */
	public static int deleteFromEnd()
	{
		int d = tail.getData();
		if(isEmpty())
		{
			out.println("Deletion not possible");
			return 1;
		}
		else
		{
			tail = tail.getPrevious();
			tail.setNext(null);
		}
		length -= 1;
		return d;
	}

	/** Delete a node at a given position */
	public static int deleteAtPosition(int position)
	{
		int d = 0;
		if(position <= 0 || position > length + 1)
		{
			out.println("Deletion not possible");
			return 1;
		}
		else if(position == 1)
			deleteFromStart();
		else if(position == length)
			deleteFromEnd();
		else
		{
			Node temp = head;
			for(int i = 1; i < position - 1;i++)
				temp = temp.getNext();
			d = temp.getNext().getData();
			temp.setNext(temp.getNext().getNext());
			temp.getNext().setPrevious(temp);
			length -= 1;
		}
		return d;
	}

	/** Delete matched */
	public static int deleteMatched(Node a)
	{
		int d = 0;
		if(head.getData() == a.getData())
			d = deleteFromStart();
		else if(tail.getData() == a.getData())
			d = deleteFromEnd();
		else
		{
			Node temp = head;
			while(temp.getNext() != null)
			{
				if(temp.getData() == a.getData())
				{
					d = temp.data;
					temp.getPrevious().setNext(temp.getNext());
					temp.getNext().setPrevious(temp.getPrevious());
				}
				temp = temp.getNext();
			}
			length -= 1;		
		}
		return d;
	}

	/** Returns the middle node of the List */
	public static int findMiddle()
	{
		Node temp = head;
		for(int i = 1; i <= (length / 2); i++)
			temp = temp.getNext();
		return temp.getData();
	}


	/** Display the List */
	public static void display(Node head)
	{
		Node temp = head;
		out.print("HEAD<=>");
		while(temp != null)
		{
			out.print(temp.data+"<=>");
			temp = temp.getNext();
		}
		out.println("NULL");
	}

	/** Clear the List */
	public static void clearAll()
	{
		head = null;
		tail = null;
		length = 0;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(in);
		out.println("Enter the number of nodes to be inserted at first");
		int n = sc.nextInt();
		while(n -- > 0)
		{
			int data = sc.nextInt();
			insertAtEnd(data);
		}		
		int choice = 0;
		char ans = ' ';
		do
		{
			out.println("Enter 1 for Insert");
			out.println("Enter 2 for Delete");
			out.println("Enter 3 to get the  length of the List");
			out.println("Enter 4 to find the middle node of the list");
			out.println("Enter 5 to Display the List");
			out.println("Enter 6 to find the position of a node");
			out.println("Enter 7 to Delete a node with given node");
			out.println("Enter 8 to delete List completely");
			out.println("Enter 9 to check whether is List is empty or not");
			out.println("Enter your choice from above");
			choice = sc.nextInt();
			int p = 0, d = 0;
			switch(choice)
			{				
				case 1:
					out.println("Enter the position at which data is to be inserted");
					p = sc.nextInt();
					out.println("Enter the data to be inserted");
					d = sc.nextInt();
					insertAtPosition(p, d);
					break;
				case 2:
					out.println("Enter the position at which data is to be deleted");
					p = sc.nextInt();
					out.println("The deleted node is:"+deleteAtPosition(p));
					break;
				case 3:
					out.println("The length of the List is:"+getLength());
					break;
				case 4:
					out.println("The middle element of the List is:"+findMiddle());
					break;
				case 5:
					out.println("The List is:");
					display(head);
					break;
				case 6:
					out.println("Enter the data to be searched");
					d = sc.nextInt();
					out.println("The position of "+d+" is:"+findPosition(d));		
					break;
				case 7:
					out.println("Enter the node/data to be deleted");
					d = sc.nextInt();
					Node b = new Node(d);
					out.println("The deleted node is:"+deleteMatched(b));
					break;
				case 8:
					clearAll();
					break;
				case 9:
					if(isEmpty())
						out.println("The list is empty");
					else
						out.println("The list is not empty");
					break;
				default:
					out.println("Invalid choice, Enter your choice from above");
					break;						
			}
			out.println("Want more(Y/n)");
			ans = sc.next().charAt(0);
		}
		while(ans == 'y' || ans == 'Y'); 	
	}

}