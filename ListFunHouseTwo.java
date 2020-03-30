//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;

public class ListFunHouseTwo
{
	private ListNode theList;
	
	public ListFunHouseTwo()
	{
		theList = new ListNode();
	}
	
	public void add(Comparable data)
	{
		theList = new ListNode(data, theList);
	}
	
	//this method will return the number of nodes present in list
	public int nodeCount()
	{
   	int count=0;
   	ListNode temp = theList;
   	
   	while (temp.getNext() != null) {
   		count++;
   		temp = temp.getNext();
   	}
   	return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node at the front of the list.  Once finished, the first node will occur twice.
	public void doubleFirst()
	{
		theList = new ListNode(theList.getValue(), theList);
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public void doubleLast()
	{
	   	ListNode header = theList;
	   	while (theList.getNext().getValue() != null) {
	   		theList = theList.getNext();
	   	}
	   	theList.setNext(new ListNode(theList.getValue(), null));
	   	theList = header;
	}

	//this method will set the value of every xth node in the list
	public void setXthNode(int x, Comparable value)
	{
		ListNode current = theList;
		int count=1;

		while (current.getNext() != null) {
			current = current.getNext(); // increment current by 1
			count++; // increment counter
			if (count == x) { // if pointing at xth node
				current.setValue(value);
				count=1; // reset counter
				current = current.getNext();
			}
		}
	}	

	//this method will remove every xth node in the list
	public void removeXthNode(int x)
	{
		ListNode current = theList;
		ListNode previous = current;
		int count=1;
		
		try {
			while (current.getNext() != null) { // iterate through the list until the end
				previous = current; // set the previous node to the current node

				current = current.getNext(); // increment current by 1
				count++; // increment counter
				if (count == x) { // if pointing at xth node
					previous.setNext(current.getNext()); // set previous node's 'next' pointer to x nodes ahead
					count=1; // reset counter
					current = current.getNext(); // set current value to previous's 'next' pointer
				}
			}
			
		} catch (Exception e) {
			
		}

	
	}		
	//this method will return a String containing the entire list
   public String toString()
   {
   	String output="";
   	ListNode temp = theList;
   	
   	while (theList != null) {
   		output += theList.getValue() + " ";
   		theList = theList.getNext();
   	}
   	theList = temp;
   	return output;
   }			
	
}