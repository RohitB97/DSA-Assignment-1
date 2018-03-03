import java.io.*;
import java.util.*;

interface Stack<T> {
    /**
    * Return the number of elements in the stack.
    */
    public int size();
    /**
    * Return whether the stack is empty.
    * return true if the stack is empty, false otherwise.
    */
    public boolean isEmpty();
    /**
    * Inspect the element at the top of the stack.
    * return top element in the stack.
    * exception EmptyStackException if the stack is empty.
    */
    public T top() throws EmptyStackException;
    /**
    * Insert an element at the top of the stack.
    * param element to be inserted.
    */
    public void push (T element);
    /**
    * Remove the top element from the stack.
    * return element removed.
    * exception EmptyStackException if the stack is empty.
    */
    public T pop() throws EmptyStackException;
}

class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T d, Node<T> n){
        this.data = d;
        this.next = n;
    }
}

public class LinkedListStack<T> implements Stack<T> {

    private int size = 0;
    private Node<T> list_head;

    public LinkedListStack(){
        this.list_head = null;
    }

    public void push (T element) {
        this.list_head = new Node<T>(element, list_head);
        this.size++;
    }

    public T top() throws EmptyStackException{
        if(this.list_head != null){
            return(this.list_head.data);
        }

        else{
            throw new EmptyStackException();
        }
    }

    public T pop() throws EmptyStackException{
        if(this.list_head != null){
            T pop = this.list_head.data;
            this.list_head = this.list_head.next;
            this.size--;
            return pop;
        }

        else{
            throw new EmptyStackException();
        }
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return (this.list_head == null);
    }

    public static void main(String[] args){
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
        stack.push(45);
        stack.push(35);
        stack.push(25);
        stack.push(15);
        stack.push(65);
        stack.push(75);
    }
}