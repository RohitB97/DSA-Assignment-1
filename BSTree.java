import java.io.*;
import java.util.*;
import java.lang.Math;

public class BSTree<Key extends Comparable<Key>, Value> {
	private TreeNode<Key,Value> _root;

	public BSTree(){
		this._root = null;
	}

	// Insert Set

	private TreeNode<Key,Value> recursive_insert(Key newKey, Value newValue, TreeNode<Key,Value> node){
		if(node == null){
			node = new TreeNode<Key,Value>(newKey,newValue);
			return node;
		}

		if(newKey.compareTo(node.key) > 0)
			node.right_node = recursive_insert(newKey, newValue, node.right_node);

		else if(newKey.compareTo(node.key) < 0)
			node.left_node = recursive_insert(newKey, newValue, node.left_node);

		else
			node.value = newValue;

		return node;
	}

	public void insert(Key newKey, Value newValue){
		this._root = this.recursive_insert(newKey, newValue, this._root);
	}

	// ValueOf set

	private Value recursive_valueOf(Key searchKey, TreeNode<Key,Value> node){

		if(node == null)
			return null;

		if(searchKey.compareTo(node.key) > 0)
			return recursive_valueOf(searchKey, node.right_node);

		else if(searchKey.compareTo(node.key) < 0)
			return recursive_valueOf(searchKey, node.left_node);

		else
			return node.value;
	}

	public Value valueOf(Key searchKey){
		return this.recursive_valueOf(searchKey, this._root);
	}

	// MinNode Set

	private TreeNode<Key,Value> recursive_getMinNode(TreeNode<Key,Value> node){
		if(node.left_node != null)
			return recursive_getMinNode(node.left_node);
		else
			return node;
	}

	public TreeNode<Key,Value> getMinNode(){
		return this.recursive_getMinNode(this._root);
	}

	// MaxNodeSet

	private TreeNode<Key,Value> recursive_getMaxNode(TreeNode<Key,Value> node){
		if(node.right_node != null)
			return recursive_getMaxNode(node.right_node);
		else
			return node;
	}

	public TreeNode<Key,Value> getMaxNode(){
		return this.recursive_getMaxNode(this._root);
	}

	// MedianNode Set

	private TreeNode<Key,Value> recursive_getMedianNode(TreeNode<Key,Value> node, int median_position, int current_position){
		
	}

	public TreeNode<Key,Value> getMedianNode(){

	}

	// height

	private int recursive_height(TreeNode<Key,Value> node){

		if(node == null)
			return -1;

		int left_tree_height = recursive_height(node.left_node);
		int right_tree_height = recursive_height(node.right_node);

		if(left_tree_height > right_tree_height)
			return (left_tree_height + 1);
		else
			return (right_tree_height + 1);
	}

	public int height(){
		return this.recursive_height(this._root);
	}

	// size

	private int recursive_size(TreeNode<Key,Value> node){

		if(node == null)
			return 0;

		int left_tree_size = recursive_size(node.left_node);
		int right_tree_size = recursive_size(node.right_node);

		return (1 + left_tree_size + right_tree_size);
	}

	public int size(){
		return this.recursive_size(this._root);
	}

	// Utilization Set

	public double utilisation(){
		int number_of_keys = this.size();
		int max_keys = (int)Math.pow(2, this.height()+1) - 1;

		return ((double)number_of_keys / (double)max_keys); 
	}

	// Delete Set

	private TreeNode<Key,Value> fetch_predecessor(TreeNode<Key,Value> node){
		
		if(node.right_node != null)
			return fetch_predecessor(node.right_node);
		
		else
			return node;
	}

	private TreeNode<Key,Value> recursive_delete(Key searchKey, TreeNode<Key,Value> node){

		if(searchKey.compareTo(node.key) > 0)
			node.right_node = recursive_delete(searchKey, node.right_node);

		else if(searchKey.compareTo(node.key) < 0)
			node.left_node = recursive_delete(searchKey, node.left_node);

		else{

			if(node.left_node == null && node.right_node == null)
				node = null;

			else if (node.left_node == null)
				node = node.right_node;

			else if(node.right_node == null)
				node = node.left_node;

			else{
				TreeNode<Key,Value> temp_node = this.fetch_predecessor(node.left_node);
				node = this.recursive_delete(temp_node.key,node);
				node.key = temp_node.key;
				node.value = temp_node.value;
			}
		}

		return node;
	}

	public void delete(Key searchKey){
		this._root = this.recursive_delete(searchKey, this._root);
	}

	// RangeToString Set

	private String recursive_rangeToString(Key low, Key high, TreeNode<Key,Value> node){
		if(node == null)
			return "";

		String range_string = "" + recursive_rangeToString(low,high,node.left_node);

		if(node.key.compareTo(low) >= 0 && node.key.compareTo(high) <= 0)
			range_string += node.key + " ";

		range_string += recursive_rangeToString(low,high,node.right_node);

		return range_string;
	}

	public String rangeToString(Key low, Key high){
		return (this.recursive_rangeToString(low,high,this._root).trim());
	}

	// PrettyPrint Set

	private String prettyPrintTreeWithRoot(TreeNode<Key,Value> node, String prefix){

		String pretty_string = "";
		
		if(node == null){
			pretty_string += (prefix + "-null") + "\n";
		}

		else{
			pretty_string += (prefix + "-" + node.key) + "\n";
			String prefix_left = prefix + " |";
			String prefix_right = prefix + "  ";
			pretty_string += prettyPrintTreeWithRoot(node.left_node,prefix_left);
			pretty_string += prettyPrintTreeWithRoot(node.right_node,prefix_right);
		}

		return pretty_string;
	}

	public String prettyPrint(){
		return this.prettyPrintTreeWithRoot(this._root, "");
	}

}