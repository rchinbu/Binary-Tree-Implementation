public class EmptyTree<T> extends BinaryTree<T> {
	public EmptyTree(){
		
	}
	public String toString( String indent ) {
		return "";
        }
	public String toString() {
        	return toString("");
	}
}