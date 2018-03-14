import java.io.*;
import java.util.*;

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

}