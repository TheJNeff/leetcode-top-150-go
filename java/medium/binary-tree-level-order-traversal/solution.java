/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }

 Is this not just BFS? I think it's just BFS...

 It is easily solved with BFS, but... if we want to go faster, maybe we can try DFS

 In DFS, you can ensure tree is evaluated left to right simply by recursing on left before right. 

 Yeah, DFS is much faster and more efficient. 
 */
class Solution {

    List<List<Integer>> dfsResult = new ArrayList();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //return bfs(root);
        dfs(root, 0);
        return dfsResult;
    }

    void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level == dfsResult.size()) {
            dfsResult.add(new ArrayList()); 
        }
        dfsResult.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    List<List<Integer>> bfs (TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }      
            }
            result.add(level);
        }
        return result;
    }
}