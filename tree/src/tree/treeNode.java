package tree;

public class treeNode{
	int data;
	treeNode left;
        treeNode right;
        treeNode parent;

	public treeNode(int data, treeNode left, treeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
                
	}
	public treeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
                
	}
        public String toString(){
            return Integer.toString(this.data);
        }
    public void testNode() {
        this.data = 20;
    }
}