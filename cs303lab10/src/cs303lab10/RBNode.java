package cs303lab10;


public class RBNode<K extends Comparable<? super K>, V>{

	public RBNode<K,V> parent;//parent node
	public RBNode<K,V> left;//left child
	public RBNode<K,V> right;//right child
	public K key;//data held in this node
	public V value;
	public boolean color;//true = red, black = false
	
	/*
	 * constructs a new BSTNode
	 */
	public RBNode(){}
	
}