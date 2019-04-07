
public class ConsTree<T> extends BinaryTree<T> {
	T data;
	BinaryTree<T> left;
	BinaryTree<T> right;
	
	public ConsTree(T data, BinaryTree<T> left, BinaryTree<T> right) {
		data = this.data;
		left = this.left;
		right = this.right;
	}

	public ConsTree(T data){
		// Used this stackoverflow: https://stackoverflow.com/questions/
		// 285177/how-do-i-call-one-constructor-from-another-in-java#285184
		// to figure out how to use this
		this(data, new EmptyTree<T>(), new EmptyTree<T>());
	}
	
    public String toString( String indent ) {
	return right.toString( indent + "   " ) + "\n" + 
	       indent + "/\n" + 
	       indent + data + "\n" + 
	       indent + "\\" + 
	       left.toString( indent + "   ");
    }
    public String toString() {
	return toString("");
    }
}
