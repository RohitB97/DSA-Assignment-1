import java.io.*;
import java.util.*;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T d, Node<T> n){
        this.data = d;
        this.next = n;
    }
}