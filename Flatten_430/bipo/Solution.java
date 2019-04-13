package Flatten_430.bipo;

/*
// Definition for a Node.
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
*/
class Solution {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node ptr = head;
        while(ptr != null){
            if(ptr.child == null && ptr.next != null){
                ptr = ptr.next;
                continue;
            }else if(ptr.child != null){
                if(ptr.next != null){
                    stack.push(ptr.next);
                }
                ptr.next = ptr.child;
                ptr.child.prev = ptr;
                ptr.child = null; //cost me 20 mins to debug
                ptr = ptr.next;
                continue;
            }
            if(!stack.empty()){
                Node next = stack.pop();
                ptr.next = next;
                next.prev = ptr;
                ptr = next;
            }else{
                break;
            }
        }
        return head;
    }
}
