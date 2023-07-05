import java.util.ArrayList;

public class _94_144_145_TreeTraversal {
    //Recursive Approaches O(N)--->T, O(N)--->S takes advantages of recursion call stack which memorizes nodes.

    /*
    Preorder Traversal
     */
    class Solution {
        List<Integer> list=new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            dfs(root);
            return list;
        }

        public void dfs(TreeNode node){
            if (node==null){
                return;
            }
            list.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }

    /*
    Inorder Traversal
     */
    class Solution {
        List<Integer> list=new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            dfs(root);
            return list;
        }

        public void dfs(TreeNode node){
            if (node==null){
                return;
            }
            dfs(node.left);
            list.add(node.val);
            dfs(node.right);
        }
    }

    /*
    Postorder Traversal
     */
    class Solution {
        List<Integer> list=new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            dfs(root);
            return list;
        }

        public void dfs(TreeNode node){
            if (node==null){
                return;
            }
            dfs(node.left);
            dfs(node.right);
            list.add(node.val);
        }
    }
}
