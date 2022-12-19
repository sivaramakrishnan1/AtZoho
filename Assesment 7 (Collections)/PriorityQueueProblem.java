/*
7. Write a Java program to
a. insert an element into the priority queue at the first position
b. to retrieve an element (at a specified index) from a given priority
queue to search an element in a priority queue
c. to compare two priority queue
d. to print all the elements of a priority queue using the position of the
elements.
*/

import java.util.PriorityQueue;

class PriorityQueueProblem
{
	public static void main(String args[])
	{
		PriorityQueue<Integer> p = new PriorityQueue<>();
		
		p.offer(4);
		p.offer(2);
		p.offer(3);

		// a. insert an element into the priority queue at the first position
		p.offer(1);
		
		System.out.println(p);
		
		// b. to retrieve an element (at a specified index) from a given priority
		// queue to search an element in a priority queue
		System.out.println("Fetching 3rd element from the queue");
		PriorityQueue<Integer> copy = new PriorityQueue<>(p);
		for(int i = 0 ; i < copy.size() ; i++)
		{
			if(i == 3)
			{
				System.out.println(copy.poll());
			}
			copy.poll();
		}
		
		System.out.println("Comparing two queueus : " + p.equals(copy));
		
		// d. to print all the elements of a priority queue using the position of the elements.
		for(int i: p)
			System.out.print(i + " ");
		
	}
}