public class AVL {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.val = data;
        }
    }
     TreeNode root;
    AVL() {
        this.root = null;
    }
    int height(TreeNode root) {
        if (root == null)
            return -1;

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }
    TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return rotate(root);
    }
    TreeNode rotateRight(TreeNode p) {
        if (p.left == null) {
            return p;
        }
        TreeNode c = p.left;
        TreeNode t = c.right;

        p.left = t;
        c.right = p;

        return c;
    }
    TreeNode rotateLeft(TreeNode c) {
        TreeNode p = c.right;
        TreeNode t = p.left;

        p.left = c;
        c.right = t;

        return p;
    }
    public TreeNode rotate(TreeNode root){
        //left
        if(height(root.left) - height(root.right) > 1){
            if(height(root.left.left) - height(root.left.right) > 0){
                return rotateRight(root);
            }
            if(height(root.left.left) - height(root.left.right) < 0){
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        }
        //right
        if(height(root.left) - height(root.right) < -1){
            if(height(root.right.left) - height(root.right.right) < 0){
                return rotateLeft(root);
            }
            if(height(root.right.left) - height(root.right.right) > 0){
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }
        return root;
    }
    public void insertion(int val){
        root = insert(root,val);
    }
    public void height(){
        System.out.println(height(root));
    }
    public static void main(String[] args) {
        AVL avlTree = new AVL();
        for(int i = 0 ; i < 1000 ; i++){
            avlTree.insertion(i);
        }
        avlTree.height();
    }
}