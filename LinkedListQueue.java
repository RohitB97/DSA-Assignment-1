import java.io.*;
import java.util.*;

interface Queue<T> {
    /**
    * Returns the number of elements in the queue.
    * return number of elements in the queue.
    */
    
    public int size();
    /**
    * Returns whether the queue is empty.
    * return true if the queue is empty, false otherwise.
    */
    
    public boolean isEmpty();
    /**
    * Inspects the element at the front of the queue.
    * return element at the front of the queue.
    * exception EmptyQueueException if the queue is empty.
    */
    
    public T front() throws NoSuchElementException;
    /**
    *Inserts an element at the rear of the queue.
    * param element new element to be inserted.
    */
    
    public void enqueue (T element);
    /**
    * Removes the element at the front of the queue
    * return element removed.
    * exception EmptyQueueException if the queue is empty.
    */

    public T dequeue() throws NoSuchElementException;
}

class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T d, Node<T> n){
        this.data = d;
        this.next = n;
    }
}

public class LinkedListQueue<T> implements Queue<T> {
    private int size = 0;
    private Node<T> list_head,list_tail;

    public LinkedListQueue(){
        this.list_head = null;
        this.list_tail = null;
    }

    public void enqueue (T element) {
        Node<T> new_node = new Node<T>(element, null);
        
        if(this.list_tail == null){
            this.list_tail = new_node;
            this.list_head = new_node;
        }

        else{
            this.list_tail.next = new_node;
            this.list_tail = this.list_tail.next;
        }
        
        this.size++;
    }

    public T front() throws NoSuchElementException{
        if(this.list_head != null){
            return (this.list_head.data);
        }

        else{
            throw new NoSuchElementException();
        }
    }

    public T dequeue() throws NoSuchElementException{
        if(this.list_head != null){
            T pop = this.list_head.data;
            
            this.list_head = this.list_head.next;
            
            this.size--;
            
            if(this.list_head == null)
                this.list_tail = null;
            
            return pop;
        }

        else{
            throw new NoSuchElementException();
        }
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return (this.list_head == null);
    }

    public static void main(String[] args){
        LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
        queue.enqueue(45);
        queue.enqueue(35);
        queue.enqueue(25);
        queue.enqueue(15);
        queue.enqueue(65);
        queue.enqueue(75);
    }
}