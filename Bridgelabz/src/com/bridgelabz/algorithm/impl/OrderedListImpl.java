package com.bridgelabz.algorithm.impl;

import com.bridgelabz.algorithm.interfaces.OrderedList;
import com.bridgelabz.datastructures.programs.Node;
import com.bridgelabz.functionalprogramming.util.Utility;

public class OrderedListImpl implements OrderedList {
    Node first;

    public OrderedListImpl() {
	// ZERO ARGUMENT CONSTRUCTOR
	this.first = null;
    }

    @Override
    public OrderedList list() {
	// CREATES THE ORDERED LIST WITH 0 SIZE
	System.out.println("Created an empty ordered list");
	return new OrderedListImpl();
    }

    @Override
    public void add(Node item) {
	// ADDS THE ELEMENT TOT THE CORRECT POSITION DEPENDING ON THE NATURAL SORTING
	// ORDER
	
	
	Node previous = first;
	Node current = first;
	// int data = Utility.stringToInteger(item.getInfo());

	if (first == null) {

	    first = item;
	    first.setNext(null);
	    return;
	}
	System.out.println("is item : "+item.getInfo()+" less than "+first.getInfo()+" : :"+item.getInfo().toString().compareTo(first.getInfo().toString()));
	if (item.getInfo().toString().compareTo(first.getInfo().toString()) <= 0) {
	    System.out.println(item.getInfo());
	    item.setNext(first);
	    first = item;
	    return;
	}

	while (current != null) {
	    System.out.println("Inside while ");
	    // System.out.println("|"+item.getInfo()+"|");
	    // System.out.println("|"+first.getInfo()+"|");
	    System.out.println(item+""+current);
	    if (item.getInfo().toString().compareTo(current.getInfo().toString()) < 0) {
		previous = current;
		current = current.getNext();
	    } else {
		break;
	    }

	}
	previous.setNext(item);
	item.setNext(current);

    }

    @Override
    public boolean isEmpty() {
	// CHECKS IF THE LIST IS EMPTY OR NOT
	if (first != null) {
	    return false;
	}
	return true;
    }

    @Override
    public int size() {
	// FINDS OUT THE NUMBER OF ITEMS PRESENT IN THE LIST

	Node iterator = first;

	int sizeCounter = 0;

	if (iterator != null) {
	    sizeCounter++;
	    System.out.println(iterator.getInfo());
	    // System.out.println(iterator.getInfo());
	    iterator = iterator.getNext();
	}

	return sizeCounter;

    }

    @Override
    public int index(Node item) {
	// RETURNS THE RAEAL INDEX OF THE ELEMENT IF FOUND ELSE IT WILL RETURN -1
	if (first != null) {
	    int counter = 0;
	    Node iterator = first;

	    while (iterator != null) {
		// System.out.println("The value of list item is " + iterator.getInfo());
		if (item.getInfo().compareTo(iterator.getInfo()) == 0) {

		    return counter;
		}
		counter++;
		iterator = iterator.getNext();
	    }

	}
	return -1;
    }

    @Override // yet to be tested
    public Node pop() {

	if (first == null) {

	    System.out.println("No elements found list is empty");
	    return null;

	} else if (this.size() == 1) {
	    Node returningNode = first;
	    Node temp = first;
	    temp = temp.getNext();
	    first.setNext(null);
	    first = temp;
	    return returningNode;
	}

	else {
	    Node iterator = first;
	    Node previous = iterator;
	    Node previousOfPrevious = previous;
	    while (iterator != null) {
		previousOfPrevious = previous;
		previous = iterator;
		iterator = iterator.getNext();
	    }
	    previousOfPrevious.setNext(null);
	    return previous;
	}

    }

    @Override
    public Node pop(int position) {
	// DELETE THE ELEMENT AT THE SPECIFIED POSITION

	if (first == null) {
	    System.out.println("List is empty cannot be popped...");
	    return null;

	}
	if (position == 0) {
	    Node item = first;
	    first = first.getNext();
	    item.setNext(null);
	    return item;
	}

	Node previous = first;
	Node current = first;
	Node next = first;
	if (this.size() > position) {
	    while (position >= 0) {
		previous = current;
		current = next;
		next = next.getNext();
		position--;
	    }

	    previous.setNext(next);
System.out.println("Element is popped out : "+current.getInfo());
	    return current;

	}
	System.out.println("Element position is invalid lack of elements present ..");
	return null;
    }

    @Override
    public void remove(Node item) {
	// REMOVES THE FIRST MATCHED ITEM
	if (this.size() == 0) {
	    System.out.println("List is empty");
	    return;

	}
	if (item.getInfo().compareTo(first.getInfo()) == 0) {

	    Node temp = first;
	    temp = temp.getNext();
	    first.setNext(null);
	    first = temp;
	    return;
	}
	Node iterator = first;
	Node previous = iterator;
	boolean isFound = false;
	while (iterator != null) {
	    if ((iterator.getInfo().toString().trim().compareTo(item.getInfo().toString().trim())) == 0) {
		System.out.println("match found removing the element " + item.getInfo());
		isFound = true;
		break;
	    }

	    previous = iterator;
	    iterator = iterator.getNext();
	}
	if (isFound) {

	    Node next = iterator.getNext();
	    previous.setNext(next);
	    iterator.setNext(null);

	    return;
	}

	System.out.println("Element not found ...");
	return;

    }

    @Override
    public boolean search(Node item) {
	// RETURNS TRUE FOR THE METHOD IF THE ITEM IS PRESENT ELSE IT RETURNS FALSE
	Node iterator = first;

	while (iterator != null) {
	    if (item.getInfo().compareTo(iterator.getInfo()) == 0) {

		return true;
	    }
	    iterator = iterator.getNext();
	}
	return false;

    }

}
