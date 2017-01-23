class SimpleLinkedList
{
	private int head;
	private SimpleLinkedList next;
	
	public SimpleLinkedList(int head, SimpleLinkedList simpleLinkedList)
	{
		this.head = head;
		this.next = simpleLinkedList;
	}

	public static void main(String[] args) {
		SimpleLinkedList simpleLinkedList = new SimpleLinkedList(3, null);
		simpleLinkedList = new SimpleLinkedList(10, simpleLinkedList);
		simpleLinkedList = new SimpleLinkedList(15, simpleLinkedList);

		/* Print the first node */
		System.out.println(simpleLinkedList.head);
		/* Print the next to first node */
		System.out.println(simpleLinkedList.next);

		/* OR
		System.out.println(simpleLinkedList.next.head);
		*/


	}

	public String toString()
	{
		return String.format("%d",head);
	}
}


