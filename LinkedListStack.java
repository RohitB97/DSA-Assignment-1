import java.io.*;
import java.util.*;

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

}