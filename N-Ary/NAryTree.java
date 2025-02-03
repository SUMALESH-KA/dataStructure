import java.util.*;

public class NAryTree {
    TreeNode root;
    private static class TreeNode{
        int val;
        List<TreeNode> children;

        TreeNode(int data){
            this.val = data;
            this.children = new ArrayList<>();
        }
    }
    
    public void preOrder(TreeNode root,List<Integer> li){
        if(root == null){
            return;
        }
        li.add(root.val);
        System.out.print(root.val + " ");
        for(int index = 0; index < root.children.size(); index++){
            preOrder(root.children.get(index),li);
        }
    }

    public void postOrder(TreeNode root,List<Integer> li){
        if(root == null){
            return;
        }
        for(int index = 0; index < root.children.size(); index++){
            postOrder(root.children.get(index),li);
        }
        li.add(root.val);
        System.out.print(root.val + " ");
    }
    
    public void inOrder(TreeNode root,List<Integer> li){
        if(root == null){
            return;
        }
        for(int index = 0; index < root.children.size() - 1; index++){
            inOrder(root.children.get(index),li);
        }
        li.add(root.val);
        System.out.print(root.val + " ");
        if (root.children.size() > 0) {
            inOrder(root.children.get(root.children.size() - 1), li);
        }
    }

    public void levelOrder(TreeNode root){
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> leveler = new LinkedList<>();
        leveler.add(root);
        int level = 0;
        while(!leveler.isEmpty()){
            List<Integer> li = new ArrayList<>();
            int size = leveler.size();
            for(int i = 0; i < size; i++){
                TreeNode node = leveler.poll();

                li.add(node.val);
                for(int j = 0 ; j < node.children.size(); j++){
                    leveler.add(node.children.get(j));
                }
            }
            level++;
            levelOrder.add(li);
        }

        System.out.println(levelOrder);
    }

    public void zigzag(TreeNode root){
        List<List<Integer>> levelOrder = new ArrayList<>();
        Deque<TreeNode> leveler = new ArrayDeque<>();
        
        if (root != null) {
            leveler.add(root);
        }
        
        boolean reverse = false;
        
        while (!leveler.isEmpty()) {
            List<Integer> li = new ArrayList<>();
            int size = leveler.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node;
                
                if (reverse) {
                    node = leveler.removeLast(); // Remove from the end for reverse order
                    li.add(node.val);
                    // Add children in reverse order
                    for (int j = node.children.size() - 1; j >= 0; j--) {
                        leveler.addFirst(node.children.get(j));
                    }
                } else {
                    node = leveler.removeFirst(); // Remove from the front for normal order
                    li.add(node.val);
                    for (TreeNode child : node.children) {
                        leveler.addLast(child);
                    }
                }
            }
            reverse = !reverse; // Toggle the reverse flag
            levelOrder.add(li); // Add the current level to the result
        }

        System.out.println(levelOrder);
    }

    public int sum(TreeNode root){
        Deque<TreeNode> leveler = new ArrayDeque<>();
        int sum = 0;
        leveler.add(root);
        //sum += root.val;
        while (!leveler.isEmpty()) {
            int size = leveler.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = leveler.poll();
                sum += node.val;
                    for (int j = 0; j < node.children.size(); j++) {
                        leveler.add(node.children.get(j));
                    }
            }
        }
        return sum;
    }

    void Constructtree(){
        this.root = new TreeNode(1);

        root.children.add(new TreeNode(2));
        root.children.get(0).children.add(new TreeNode(3));
        root.children.get(0).children.add(new TreeNode(4));
        root.children.get(0).children.add(new TreeNode(5));

        root.children.add(new TreeNode(6));
        root.children.get(1).children.add(new TreeNode(7));
        root.children.get(1).children.add(new TreeNode(8));
        root.children.get(1).children.add(new TreeNode(9));
        root.children.get(1).children.get(0).children.add(new TreeNode(34));

        root.children.add(new TreeNode(10));
        root.children.get(2).children.add(new TreeNode(11));
        root.children.get(2).children.add(new TreeNode(12));
        root.children.get(2).children.add(new TreeNode(13));
    }

    private int depth(TreeNode root , int val){
                Queue<TreeNode> leveler = new LinkedList<>();
                leveler.add(root);
                int height = 0;
                while(!leveler.isEmpty()){
                    int size = leveler.size();
                    for(int i = 0; i < size; i++){
                        TreeNode node = leveler.poll();
                        if(node.val == val){
                            return height + 1;
                        }
                        for(int j = 0 ; j < node.children.size(); j++){
                            leveler.add(node.children.get(j));
                        }
                    }
                    height++;
                }
                return height;

    }
    
    public void preOrder(){
        List<Integer> li = new ArrayList<>();
        preOrder(root,li);
        System.out.println(li);
    }
    public void levelOrder(){
        levelOrder(root);
    }

    public void postOrder(){
        List<Integer> li = new ArrayList<>();
        postOrder(root,li);
        System.out.println(li);
    }

    public void inOrder(){
        List<Integer> li = new ArrayList<>();
        inOrder(root,li);
        System.out.println(li);
    }
    public void zigzag(){
        zigzag(root);
    }
    public void sum(){
        int sum = sum(root);
        System.out.println(sum);
    }
    public void depthFind(int val){
        int depth = depth(root,val);
        System.out.println(depth);
    }
    
    public static void main(String args[]){
        NAryTree nAry = new NAryTree();
        nAry.Constructtree();
        nAry.preOrder();
        nAry.postOrder();
        nAry.inOrder();
        nAry.levelOrder();
        nAry.zigzag();
        nAry.sum();
        nAry.depthFind(34);
    }
}
