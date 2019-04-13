import java.util.LinkedList;

public class FlattenaMultilevelDoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Node flatten(Node head) {
        LinkedList<Node> list = new LinkedList<Node>();
		Node ptr = head;
        
		while (ptr != null) {
			if (ptr.child == null) {
				if (ptr.next != null) {
					ptr = ptr.next;
				} else {
					ptr.next = list.peekLast();
					Node buf = ptr;
					ptr = list.pollLast();
					if (ptr == null) {
						break;
					}
					ptr.prev = buf;
				}
			} else {
				list.add(ptr.next);
				ptr.next = ptr.child;
				ptr.child.prev = ptr;
				Node buf = ptr;
				ptr = ptr.child;
				buf.child = null;
			}
		}
		
		return head;
    }
	
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;

	    public Node() {}

	    public Node(int _val,Node _prev,Node _next,Node _child) {
	        val = _val;
	        prev = _prev;
	        next = _next;
	        child = _child;
	    }
	};

}

