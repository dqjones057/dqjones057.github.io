package Assignment3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LargestValueEachTreeRow {
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

    public List<Integer> largestValues(TreeNode root) {
        // Since we are looking level by level, I assume BFS is the appropriate way to traverse
        if (root == null) {
            return new ArrayList<Integer>();
        }
        // Here we will prep for bfs by creating a queue for traversal
        ArrayList<Integer> answers = new ArrayList<>();
        Queue<LargestValueEachTreeRow.TreeNode> queue = new LinkedList<>();

        // Enqueue the root node first
        queue.offer(root);
        while (!queue.isEmpty()) {
            // Start max at very small number, keep track of number of nodes at this level
            int currMax = Integer.MIN_VALUE;
            int numNodes = queue.size();

            // iterates through all nodes at current level
            for (int i = 0; i < numNodes; i++) {
                // dequeues a node on this level, stores value for comparison to max
                TreeNode currNode = queue.poll();
                currMax = Math.max(currMax, currNode.val);

                // Must remember to enqueue children upon removal of a node
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            // Add the max for the current level to
            answers.add(currMax);
        }
        return answers;
    }

    public static void main(String[] args) {
        LargestValueEachTreeRow test = new LargestValueEachTreeRow();
        // setup tree
         TreeNode root = new TreeNode(1);
         root.left = new TreeNode(3);
         root.right = new TreeNode(2);
         root.right.right = new TreeNode(9);
         root.left.left = new TreeNode(5);
         root.left.right = new TreeNode(3);

         List<Integer> results = test.largestValues(root);

         System.out.println("Expected: 1,3,9\n" + "Result: " +  results);

    }
}

