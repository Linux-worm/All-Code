public class SimpleLinkedList
{
	private int head;
	private SimpleLinkedList tail;
	
	public SimpleLinkedList(int head, SimpleLinkedList simpleLinkedList)
	{
		this.head = head;
		this.tail = simpleLinkedList;
	}

     /** Returns the size of list using recusrion 
     **/
	public int size()
	{
		if(tail == null)
			return 1;

		return 1 + tail.size();
	}

	/** Returns the size of list using no-recusrion 
     **/

	public int iterativeSize()
	{
		SimpleLinkedList p = this;
		int sum = 0;
		while(p != null)
		{
			sum += 1;
			p = p.tail;
		}
		return sum;
	}

	/** Returns the ith item of the lis
	where front item is item 0 */

	public int get(int i)
	{
		if(i == 0)
			return head;

		return tail.get(i - 1);
	}

	public static void main(String[] args) {
		SimpleLinkedList simpleLinkedList = new SimpleLinkedList(3, null);
		simpleLinkedList = new SimpleLinkedList(10, simpleLinkedList);
		simpleLinkedList = new SimpleLinkedList(15, simpleLinkedList);

		/* Print the first node */
		System.out.println(simpleLinkedList.head);
		/* Print the tail to first node */
		System.out.println(simpleLinkedList.tail);
		System.out.println(simpleLinkedList.iterativeSize());
		System.out.println(simpleLinkedList.size());
		System.out.println(simpleLinkedList.get(1));


		/* OR
		System.out.println(simpleLinkedList.tail.head);
		*/


	}

	public String toString()
	{
		return String.format("%d",head);
	}
}


