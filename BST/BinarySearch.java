import java.util.*;

public class BinarySearch {
    private class TreeNode {
        int val;
        TreeNode left, right;
    
        public TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    TreeNode root;
    public BinarySearch() {
        root = null;
    }

    private void insert(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val); 
            if (root == null) {
                root = node; 
            }
        } else if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                insert(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                insert(node.right, val);
            }
        }
    }

    public void insert(int val) {
        insert(root, val); 
    }
    
    private void Inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        Inorder(node.left,res);       
        res.add(node.val);
        Inorder(node.right,res);      
    }

    public void print() {
        System.out.print("Tree (In-Order): ");
        List<Integer> res = new ArrayList<>();
        Inorder(root,res);
        System.out.println(res);
    }

    private TreeNode search(TreeNode root, int val){

        if(root == null) return root;

        if(root.val == val){
            return root;
        }
        if(root.val < val){
             return search(root.right,val);
        }
        else{
            return search(root.left,val);
        }
    }
    
    public void search(int val){
        TreeNode isFound = search(root,val);
        if(isFound != null){
            System.out.println("found the value");
        }
        else{
            System.out.println(" not found the value");
        }

    }
    
    private int min(TreeNode root){
        while(root.left!= null){
            root = root.left;
        }

        return root.val;
    }

    private TreeNode delete(TreeNode root, int val){
        if(root == null) return null;

        if(val < root.val){
            root.left = delete(root.left , val);
        }
        else if(val > root.val){
            root.right = delete(root.right , val);
        }
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                int successor = min(root.right);
                root.val = successor;
                root.right = delete(root.right,successor);
            }
        }
        return root;
    }
    
    public void delete(int val){
        TreeNode deleted =  delete(root,val);
        if(deleted != null){
            System.out.println("success delete");
        }
    }
    
    private boolean isNodeExists(TreeNode root,int p){
        if(root == null){
            return false;
        }
        if(root.val == p){
            return true;
        }
        boolean left = isNodeExists(root.left,p);
        if(left){
            return true;
        }
        return isNodeExists(root.right,p);
    }
    
    private int findheight(TreeNode root, int p, int height){
        if(root == null)    return -1;
        if(root.val == p) return height;

        int left = findheight(root.left,p,height+1);

        if(left != -1){
            return left;
        }

        return findheight(root.right , p ,height + 1);
    }   

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null) return null;

        if(root.val == p || root.val == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);

        if(left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }

    public TreeNode findDistance(TreeNode root,int p ,int q){
        if(isNodeExists(root,p) && isNodeExists(root,q)){
            return lowestCommonAncestor(root,p,q);
        }
        return null;
    }
    public int findDistance(int p , int q){
        TreeNode ancestor_root = findDistance(root,p,q);
        if(ancestor_root == null) return -1;
        int ans =( findheight(ancestor_root, p,0) + findheight(ancestor_root,q,0));
        return ans;
    }
    
    public void print(TreeNode root) {
        System.out.print("Tree (In-Order): ");
        List<Integer> res = new ArrayList<>();
        Inorder(root,res);
        System.out.println(res);
    }

    private String serializable(TreeNode root){
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> leveller = new LinkedList<>();
        leveller.add(root);
        while(!leveller.isEmpty()){
            TreeNode node = leveller.poll();

            if(node == null){
                result.append("#$");
            }
            else{
                result.append(node.val).append( "$");
                leveller.offer(node.left);
                leveller.offer(node.right);
            }
        }
        return result.toString();
    }
    
    private TreeNode deserializable(String serializedStr){
        Queue<TreeNode> q = new LinkedList<>();

        String[] stringArray = serializedStr.split("\\$");
        TreeNode root = new TreeNode(Integer.parseInt(stringArray[0]));
        q.add(root);

        for(int idx = 1 ; idx < stringArray.length ; idx++){
            TreeNode parent = q.poll();

            if((!stringArray[idx].equals("#"))){
                TreeNode left = new TreeNode(Integer.parseInt(stringArray[idx]));
                parent.left = left;
                q.offer(left);
            }
            if(!stringArray[idx++].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(stringArray[idx]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
        
    }
    public String serialize(){
        String res = serializable(root);
        return res;
    }
    public void deserialize(String s){
        TreeNode root = deserializable(s);
        print(root);
    }
    public static void main(String[] args) {
        BinarySearch bst = new BinarySearch();

        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(8);
        bst.insert(12);
        bst.insert(25);
        bst.insert(18);
        bst.print(); 
        
        //bst.search(12) ;
        
        bst.insert(28);
        //bst.delete(12);
        // int distance = bst.findDistance(8,25);
        // System.out.println(distance);
        String serialized = bst.serialize();
        System.out.println(serialized);
        System.out.println("deserialized");
        bst.deserialize(serialized);
        
    }
}

