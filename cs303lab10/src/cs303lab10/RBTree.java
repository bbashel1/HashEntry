package cs303lab10;

public class RBTree<K extends Comparable< ? super K>, V> {

	public RBNode<K,V> root;
	public RBNode<K,V> nil = new RBNode<>(); 
	
	public RBTree(){
		nil.color = false;
		root = nil;
	}
	
	/*
	 * insert new node into tree
	 * @param data data for new node
	 * @param value value for new node
	 */
	public void rBInsert(K data, V value){
		
		//create new BSTNode with data = data
		RBNode<K,V> z = new RBNode<>();
		z.key = data;
		z.value = value;
		
		//nil BSTNode
		RBNode<K,V> y = nil;
		//x refers to the root of this tree
		RBNode<K,V> x = this.root;
		
		//iterate through elements until finding proper parent for z, which will be y
		while (x != nil){
			y = x;
			if (z.key.compareTo(x.key) < 0){
				x = x.left;
			}
			else {x = x.right;}
		}
		
		//set the parent of z to y
		z.parent = y;
		
		//handle special case where z is first element added to the binary search tree
		if (y == nil){
			this.root = z;
		}
		//handle case where z should be left child of y
		else if (z.key.compareTo(y.key)< 0){
			y.left = z;
		}
		//handle case where z should be right child of y
		else {y.right = z;}
		
		z.left = nil;
		z.right = nil;
		z.color = true;
		rBInsertFixup(z);
	}
	
	/*
	 * Rearranges tree so that x becomes the left child of its right child, 
	 * keeping its left subtree, and inheriting its former right child���s 
	 * left subtree as its right.
	 * @param x the node to become the left child of its right child
	 */
	public void leftRotate(RBNode<K,V> x){
		
		RBNode<K,V> y = x.right;
		x.right = y.left;
		
		if (y.left != nil){ y.left.parent = x; }
		y.parent = x.parent;
		if (x.parent == nil){ this.root = y; }
		else if (x == x.parent.left) { x.parent.left = y; }
		else { x.parent.right = y; }
		y.left = x;
		x.parent = y;
	}
	
	/*
	 * Rearranges tree so that x becomes the right child of its left child, 
	 * keeping its right subtree, and inheriting its former left child���s 
	 * right subtree as its left.
	 * @param x the node to become the right child of its left child
	 */
	public void rightRotate(RBNode<K,V> x){
		
		RBNode<K,V> y = x.left;
		x.left = y.right;
		
		if (y.right != nil){ y.right.parent = x; }
		y.parent = x.parent;
		if (x.parent == nil){ this.root = y; }
		else if (x == x.parent.right) { x.parent.right = y; }
		else { x.parent.left = y; }
		y.right = x;
		x.parent = y;
	}
	
	/*
	 * maintains red-black properties after an insertion
	 * @param z the newly inserted node
	 */
	public void rBInsertFixup(RBNode<K,V> z){
		
		RBNode<K,V> y;
		
		while (z.parent.color == true && z.parent.parent != null){
			
			if (z.parent == z.parent.parent.left){
				y = z.parent.parent.right;
				if (y.color == true){
					z.parent.color = false;
					y.color = false;
					z.parent.parent.color = true;
					z = z.parent.parent;
				}
				else{
					if (z == z.parent.right){
				
					z = z.parent;
					this.leftRotate(z);
				}
				z.parent.color = false;
				z.parent.parent.color = true;
				rightRotate(z.parent.parent);
				}
			}
			else {
				y = z.parent.parent.left;
				if (y.color == true){
					z.parent.color = false;
					y.color = false;
					z.parent.parent.color = true;
					z = z.parent.parent;
				}
				else {
					if (z == z.parent.left){
						z = z.parent;
						this.rightRotate(z);
					}
					z.parent.color = false;
					z.parent.parent.color = true;
					leftRotate(z.parent.parent);
				}
			}
		}
		this.root.color = false;
	}
	
	/*
	 * searches for a node whose data == data
	 * @param data the data to be found in the binary search tree
	 * @returns BSTNode<T> the BSTNode whose data == data or null if no node is found
	 */
	public RBNode<K,V> search(K key){
		
		//use searchHelper method on root and data to allow for a recursive search of the tree
		return searchHelper(this.root, key);
		
	}
	
	/*
	 * recursive search of binary search tree to find node whose data == data
	 * @param data the data to be found in the binary search tree
	 * @returns BSTNode<T> the BSTNode whose data == data or null if no node is found
	 */
	private RBNode<K,V> searchHelper(RBNode<K,V> x, K key){
		
		//test special cases
		if (x == null || x.key.equals(key)){
			return x;
		}
		
		//if data < x.data, go left in tree
		if (key.compareTo(x.key) < 0){
			return searchHelper(x.left, key);
		}
		return searchHelper(x.right, key);
	}
}
