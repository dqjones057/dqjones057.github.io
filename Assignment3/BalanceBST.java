package Assignment3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BalanceBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // Approach: Using the hints I decided to do an inorder traversal of the tree to store values
    // in a sorted array. I then used that sorted array to recursively build a balanced version of the
    //  tree. Traversal is O(n) +
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        createInorderArray(root,inorder);

        // will return the root node of the balanced tree
        return arrayToBST(inorder, 0, inorder.size()-1);

    }

    private void createInorderArray(TreeNode root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        // Inorder traversal
        createInorderArray(root.left, inorder);
        inorder.add(root.val);
        createInorderArray(root.right, inorder);

    }
    private TreeNode arrayToBST(ArrayList<Integer> inorder, int first, int last){
        if(first > last){
            return null;
        }

        // Make the midpt of subarray the root
        int mid = (first+last)/2;
        TreeNode root = new TreeNode(inorder.get(mid));

        // Everything to the left of the root element forms the left subtree
        root.left = arrayToBST(inorder, first, mid-1);

        // Eerything to th righ tif the root element forms the right subtree
        root.right = arrayToBST(inorder, mid+1, last);

        return root;
    }

    public static void main(String[] args) {
        BalanceBST test = new BalanceBST();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        TreeNode ans = test.balanceBST(root);
        ArrayList<Integer> results = new ArrayList<>();
        // BFS traversal
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
