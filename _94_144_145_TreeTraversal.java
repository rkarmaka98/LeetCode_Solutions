import java.util.List;
import java.util.Deque;

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

    //-----------------------------------------------------------------------------------------------------------------

    //Iterative Approaches O(N)--->T, O(N)--->S takes advantages of recursion call stack which memorizes nodes.

    /*
    Preorder Traversal
     */
    class Solution {
        List<Integer> list=new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            dfs(root);
            return list;
        }

        public void dfs(TreeNode node){
            //edge case when the root node is null as it throws exception in push method.
            if(node==null){
                return;
            }
            stack.push(node);
            while(!stack.isEmpty()){
                //visit the current node
                TreeNode currNode=stack.pop();
                list.add(currNode.val);

                //Check the null condition as if has no children node.
                //We push right node first as it is stack data structure LIFO
                if(currNode.right!=null){
                    stack.push(currNode.right);
                }
                if(currNode.left!=null){
                    stack.push(currNode.left);
                }
            }
        }
    }
}
