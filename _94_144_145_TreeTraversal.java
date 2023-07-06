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

    //Morris threaded Tree Traversal  O(N)--->T, O(1)--->S Instead of storing previous node information on stack frame
    //keep track of only current and last nodes
    class Solution {
        List<Integer> list=new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            dfsMorris(root);
            return list;
        }

        public void dfsMorris(TreeNode root){
            //Keep track of curr and last nodes; Initialize curr as root node.
            TreeNode curr=root;
            TreeNode last;

            while(curr!=null){
                //If left node is not null find the right most node of that left subtree
                if(curr.left!=null){
                    //initialize last node as left node and iterate until rightmost last node
                    last=curr.left;
                    //if right node is curr means we already traversed it
                    while(last.right!=null && last.right!=curr){
                        last=last.right;
                    }
                    //if right pointer of last node is null visit current node and add the thread to curr node
                    //proceeds to traverse left subtree
                    if(last.right==null){
                        list.add(curr.val);
                        last.right=curr;
                        curr=curr.left;
                    }
                    //If right pointer of last is not null so we set as null as already traversed and proceeds to right
                    //Subtree Iteration
                    else{
                        last.right=null;
                        curr=curr.right;
                    }

                }
                //If left subtree is not present visit curr and proceeds to right subtree
                else{
                    list.add(curr.val);
                    curr=curr.right;
                }
            }
        }
    }
}
