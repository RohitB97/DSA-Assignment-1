import java.io.*;
import java.util.*;

public class TreeNode<Key extends Comparable<Key>, Value> {
	public Key key;
	public Value value;
	public TreeNode<Key,Value> left_node;
	public TreeNode<Key,Value> right_node;

	// Rank is defined as the size of the left sub tree of the node
	// This attribute is introduced to attain O(h) in finding median
	public int rank;

	public TreeNode(Key k, Value v){
		this.key = k;
		this.value = v;
		this.left_node = null;
		this.right_node = null;
		this.rank = 0;
	}

	private boolean isInRange(Key low, Key high){

		if(low == null && this.key.compareTo(high) >= 0)
			return false;

		if(high == null && this.key.compareTo(low) <= 0)
			return false;
		
		if(!(this.key.compareTo(high) < 0 && this.key.compareTo(low) > 0))
			return false;

		else{

			boolean left_BST = true, right_BST = true;

			if(this.left_node != null)
				left_BST = this.left_node.isInRange(low,this.key);

			if(this.right_node != null)
				right_BST = this.right_node.isInRange(this.key,high);

			if(left_BST && right_BST)
				return true;

			else
				return false;

		}
	}

	public boolean isBST(){
		return isInRange(null,null);
	}

}