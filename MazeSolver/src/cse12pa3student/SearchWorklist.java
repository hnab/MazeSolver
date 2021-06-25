package cse12pa3student;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */

class StackWorklist implements SearchWorklist {
	ArrayList<Square> sWorklist;
	public StackWorklist()
	{
		this.sWorklist=new ArrayList<>();
	}
	@Override
	/**
	 * Accepts a Square object as argument and add the Square object to the head of the Stack work list
	 */
	public void add(Square c) {
		this.sWorklist.add(0,c);
		
	}

	@Override
	
	/**
	 * Removes and returns the head of the Stack work list and throws NoSuchElementException if the Stack 
	 * workList is empty
	 */
	public Square remove() {
		// TODO Auto-generated method stub
		if (!this.sWorklist.isEmpty())
		{
			Square toBeRemoved=this.sWorklist.remove(0);
			return toBeRemoved;
		}
		else
			throw new NoSuchElementException();
	}

	@Override
	/**
	 * Returns true if the queue work list is empty and false otherwise
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return sWorklist.isEmpty();
	}
}

class QueueWorklist implements SearchWorklist {
	ArrayList<Square> qWorklist;
	public QueueWorklist()
	{
		this.qWorklist=new ArrayList<>();
	}
	@Override
	/**
	 * Accepts a Square object as argument and add the Square object to the end of the queue work list
	 */
	public void add(Square c) {
		// TODO Auto-generated method stub
		this.qWorklist.add(c);
		
		
		
	}

	@Override
	/**
	 * Removes and returns the head of the queue worklist and throws NoSuchElementException if the queue 
	 * workList is empty
	 */
	public Square remove() {
		// TODO Auto-generated method stub
		if (!this.qWorklist.isEmpty())
		{
			Square toBeRemoved=this.qWorklist.remove(0);
			return toBeRemoved;
		}
		else
			throw new NoSuchElementException();
		
	}

	@Override
	/**
	 * Returns true if the queue work list is empty and false otherwise
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return qWorklist.isEmpty();
	}
}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
