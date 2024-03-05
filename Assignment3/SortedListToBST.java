package Assignment3;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class SortedListToBST {

  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){return null;}
        // First step is to find the middle element and make it the root of the BST
        ListNode middle = findMiddleElement(head);

        // Convert the middle element to the root node
        TreeNode root = new TreeNode(middle.val);

        // If slowPtr is returned and still at the head node, there is only ONE node, just return it
        if(head == middle){
            return root;
        }

        // recursive cases
        root.left = sortedListToBST(head); // left side of root/middle element
        root.right = sortedListToBST(middle.next);//  right side of root
        return root;
    }


    public ListNode findMiddleElement(ListNode head){
        // find middle element by using fast and slow pointers
        // By the time the fastPtr reaches end of list, slowPtr will be at middle element
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        ListNode leftTail =  null; // this will point to the last node before middle element

        while(fastPtr != null && fastPtr.next != null){
            // fastPtr moves 2 nodes at a time, slowPtr moves 1
            // leftTail is one step behind slowPtr so we know where left side ends
            leftTail = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        if(leftTail != null){
            leftTail.next = null;
        }
        return slowPtr;
    }

    public static void main(String[] args) {
        SortedListToBST test = new SortedListToBST();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode ans = test.sortedListToBST(head);

        // Print out with BFS
        ArrayList<Integer> results = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(ans);
        while(!queue.isEmpty()){
            int currentLevel = queue.size();

            for(int i = 0; i < currentLevel; i++){
                TreeNode node = queue.poll();
                results.add(node.val);

                if(node.left != null){queue.offer(node.left);}
                if(node.right != null){queue.offer(node.right);}
            }

        }
        System.out.println("Result " + results);

    }
}
