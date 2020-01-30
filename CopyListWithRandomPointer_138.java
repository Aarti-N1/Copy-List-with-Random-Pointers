package medium;

public class CopyListWithRandomPointer_138 {

	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public Node copyRandomList(Node head) {
	        if(head==null)
	            return null;
	        Node cur= head;
	        Node copyHead= null; 
	        while(cur!=null){
	            Node copyCur = new Node(cur.val);
	            if(copyHead == null){
	                copyHead= copyCur;
	            }
	            Node actualNext = cur.next;
	            cur.next = copyCur;
	            copyCur.next = actualNext;
	            cur=actualNext;
	        }
	        //copy Jumps
	        cur = head;
	        while(cur!=null){
	            //System.out.println(cur.val);
	            if(cur.random!=null){
	              //  System.out.println("a");
	                cur.next.random = cur.random.next;
	            }
	            cur=cur.next.next;
	        //    System.out.println("b");
	        }
	        // re-reference original nexts
	        cur = head;
	        while(cur!=null){
	            // System.out.println("Cur"+cur.val);
	            Node temp = cur.next.next;
	            if(temp==null){
	                cur.next.next= null;
	                cur.next = null;
	            }else{
	                cur.next.next= temp.next;
	                cur.next = temp;        
	            }
	            cur = temp;
	        }
	        return copyHead;
	        
	    }
}
