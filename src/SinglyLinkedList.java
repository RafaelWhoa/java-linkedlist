import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     * <p>
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data != null) {
            SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.setNext(head);
                head = newNode;
            }
            size++;
        } else {
            throw new IllegalArgumentException("Error: Invalid data!");
        }
    }

    /**
     * Adds the element to the back of the list.
     * <p>
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data != null) {
            SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
            if (size == 0) {
                head = newNode;
            } else {
                tail.setNext(newNode);
            }
            tail = newNode;
            size++;
        } else {
            throw new IllegalArgumentException("Error: Invalid data!");
        }
    }

    /**
     * Removes and returns the first data of the list.
     * <p>
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (size > 1) {
            T elementToRemove = head.getData();
            head = head.getNext();
            size--;
            return elementToRemove;
        } else if (size == 1) {
            T elementToRemove = head.getData();
            head = null;
            tail = null;
            size--;
            return elementToRemove;
        } else {
            throw new NoSuchElementException("Error: List must not be empty!");
        }
    }

    /**
     * Removes and returns the last data of the list.
     * <p>
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if (size > 1) {
            SinglyLinkedListNode<T> newTail = rGetElementBeforeTail(head);
            T elementToRemove = newTail.getNext().getData();
            tail = newTail;
            newTail.setNext(null);
            size--;
            return elementToRemove;
        } else if (size == 1){
            T elementToRemove = head.getData();
            head = null;
            tail = null;
            size--;
            return elementToRemove;
        }
        else {
            throw new NoSuchElementException("Error: List must not be empty!");
        }
    }

    /**
     * Returns recursively the node before tail.
     *
     * @param currentNode current node for recursion.
     * @return the node before tail
     */
    private SinglyLinkedListNode<T> rGetElementBeforeTail(SinglyLinkedListNode<T> currentNode) {
        if (currentNode.getNext() == tail) {
            return currentNode;
        }
        return rGetElementBeforeTail(currentNode.getNext());
    }

    /**
     * Returns the head node of the list.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}