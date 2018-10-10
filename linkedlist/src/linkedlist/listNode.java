package linkedlist;

public class listNode{
	int data;
	listNode next;

	public listNode(int data, listNode next) {
		this.data = data;
		this.next = next;
	}
	public listNode(int data) {
		this.data = data;
		this.next = null;
	}
        public String toString(){
            return Integer.toString(this.data);
        }
}