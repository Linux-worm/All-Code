import java.util.*;
import static java.lang.System.*;

public class SinglyLinkedList
{
	private static class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}

	static int length = 0;
	static Node head = null;

	/** Insert new node at the starting of the list */
	public static Node insertAtStart(int data)
	{
		Node temp = new Node(data);
		if(head == null)
		{	
			head = temp;	
			length = 1;
		}
		else
		{
		temp.next = head;
		head = temp;
		}
		length += 1;
		return head;
	}

	/** Insert new node at the end of the list */
	public static Node insertAtEnd(int data)
	{
		Node temp = new Node(data);
		if(head == null)
		{
			head = temp;
			length = 1;
		}
		else
		{
			Node current = head;
			while(current.next != null)
				current = current.next;

			current.next = temp;
			temp.next = null;
			length += 1;	
		}		
		return head;
	}

	/** Insert new node at the given position */
	public static Node insertAtPosition(int position, int data)
	{
		if(position <= 0 || position > length + 1)
		{	
			out.println("Insertion not possible at this point");
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
				current = current.next;
			temp.next = current.next;
			current.next = temp;
			length += 1;
		}
		return head;
	}

	/** Display the List */
	public static void display(Node head)
	{
		out.print("HEAD->");
		Node current = head;
		if(head == null)
		{
			out.println("List is Empty");
			return ;
		}
		while(current != null)
		{
			out.print(current.data+"->");
			current = current.next;
		}

		out.println("NULL");	
	}

	/** Display the List in reverse order */
	public void displayReverse(Node head)
	{
		out.print("Null->");
		if(head == null) return;
		displayReverse(head.next);
		out.print(head.data+"->");
		out.println("Head");
	}


	/** Display List using toString function 
	public String toString()
	{
		String result = "Head->";
		Node temp = head;
		while(temp != null)
		{
			result += temp.data+"->";
			temp = temp.next;
		}
		result += "Null";
		return result;
	}
	*/

	/** Delete the node from the start of the list */
	public static Node deleteFromStart()
	{
		if(head == null)
		{
			out.println("Deletion not possible");
			return head;
		}
		Node temp = head;
		head = temp.next;
		length -= 1;
		return head;
	}

	/** Delete a node from the end of the list */
	public static Node deleteFromEnd()
	{
		if(head == null)
		{
			out.println("Deletion not possible");
			return head;
		}
		Node temp = head;
		Node current = head.next;

		while(current.next != null)
		{
			temp = temp.next;
			current = current.next;
		}
		temp.next = null;
		length -= 1;
		return head;
	}

	/** Delete a node at a given position */
	public static Node deleteAtPosition(int position)
	{
		if(position <= 0 || position > length)
		{
			out.println("Deletion not possible");
			return head;
		}
		else if(position == 1)
			deleteFromStart();
		else if(position == length)
			deleteFromEnd();		
		else
		{
			Node temp = head;
			Node current = head.next;
			for(int i = 1; i < position - 1; i++)
			{
				temp = temp.next;
				current = current.next;
			}
			temp.next = current.next;
			length -= 1;
		}	
		return head;
	}

	/** Find the middle element */
	public static int findMiddle()
	{
		Node temp = head;
		for(int i = 1; i <= (length / 2); i++)
			temp = temp.next;
		return temp.data;
	}

	/** Delete a node with given data */
	public static Node deleteWithData(Node a)
	{
		Node temp = head;
		Node current = head.next;
		while(temp != null)
		{
			if(a.data == current.data)   //if(current.data == a)
			{
				temp.next = current.next;
				return head;
			}
			temp = temp.next;
			current = current.next;
		}
		length -= 1;
		return head;
	}

	/** Checks for the equslity of two objects 
	public boolean equals(Object o)
	{
		Node temp = (Node) o;
		return (temp.data == data);
	}
	*/

	/** Find the element position */
	public static int findPosition(int data)
	{
		Node temp = head;
		int position = 1;
		while(temp != null)
		{
			if(temp.data == data)
				return position;
			temp = temp.next;
			position += 1;
		}
		return Integer.MIN_VALUE;
	}

	/** Remove everything from the List */
	public static void clearAll()
	{
		head = null;
		length = 0;
	}

	/** Checks whether a List has Cycle */
	public static boolean hasCycle(Node head)
	{
		Node slow = head;
		Node fast = head;
		while(slow != null && fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow.equals(fast))
				return true;
		}
		return false;
	}
	
	/** Main method */
	static public void main(String [] args)
	{
		Scanner sc = new Scanner(in);
		out.println("Enter the number of nodes to be inserted at first");
		int n = sc.nextInt();
		while(n -- > 0)
		{
			int data = sc.nextInt();
			insertAtEnd(data);
		}
		display(head);
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
			out.println("Enter your choice from above");
			choice = sc.nextInt();

			switch(choice)
			{
				case 1:
					out.println("Enter the position at which insertion is to be done");
					int p = sc.nextInt();
					out.println("Enter the data to be inserted");
					int d = sc.nextInt();
					insertAtPosition(p, d);
					break;
				case 2:
					out.println("Enter the position at which insertion is to be done");
					int po = sc.nextInt();
					deleteAtPosition(po);
					break;
				case 3:
					out.println("The length of the List is:"+length);
					break;
				case 4:
					out.println("The middle of the List is:"+findMiddle());
					break;
				case 5:
					out.println("The list is:");
					display(head);	
					break;
				case 6:
					out.println("Enter the data to be searched");
					int da = sc.nextInt();
					out.println("The position of "+da+" is:"+findPosition(da)); 	
					break;
				case 7:
					out.println("Enter the data/Node to be deleted");
					int a = sc.nextInt();
					Node b = new Node(a);
					deleteWithData(b);
					break;	
				default:
					out.println("Invalid Choice enter your choice from above");
			}
			out.println("Want more(Y/n)");
			ans = sc.next().charAt(0);
		}
		while(ans == 'y' || ans == 'Y'); 
		clearAll();
		insertAtPosition(1, 3);
		insertAtPosition(2,5);
		insertAtPosition(3,4 );
		insertAtPosition(4,2 ); 
		insertAtPosition(2,10 );
		display(head);
		if(hasCycle(head))
			out.println("The List has Cycle");
		else
			out.println("The List does not contain cycle");		

	}	
}
