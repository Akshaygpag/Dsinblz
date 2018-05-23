/**
 * @author Akshay
 * @version 1.0.0
 * @since 23-May-2018
 */

package com.bridgelabz.algorithm.impl;

import com.bridgelabz.algorithm.interfaces.DeQue;
import com.bridgelabz.datastructures.programs.Node;

/**
 * @author bridgeit
 *
 */
public class DeQueImpl implements DeQue {

    Node front;
    Node rear;
    
    /* (non-Javadoc)
     * @see com.bridgelabz.algorithm.interfaces.DeQue#Deque()
     */
    @Override
    public DeQue Deque() {
	// bridgeit 
	return new DeQueImpl();
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.algorithm.interfaces.DeQue#addFront(com.bridgelabz.datastructures.programs.Node)
     */
    @Override
    public void addFront(Node item) {
	// bridgeit 
	
	
	
	
	
	
	
	
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.algorithm.interfaces.DeQue#addRear(com.bridgelabz.datastructures.programs.Node)
     */
    @Override
    public void addRear(Node item) {
	// bridgeit 
	
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.algorithm.interfaces.DeQue#removeFront()
     */
    @Override
    public Node removeFront() {
	// bridgeit 
	return null;
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.algorithm.interfaces.DeQue#removeRear()
     */
    @Override
    public Node removeRear() {
	// bridgeit 
	return null;
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.algorithm.interfaces.DeQue#isEmpty()
     */
    @Override
    public boolean isEmpty() {
	// bridgeit 
	return false;
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.algorithm.interfaces.DeQue#size()
     */
    @Override
    public int size() {
	// bridgeit 
	return 0;
    }

}
