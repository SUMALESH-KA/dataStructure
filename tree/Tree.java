import java.util.*;

public class Tree{
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int data){
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }
    static List<Integer> preOrder = new ArrayList<>();
    static List<Integer> inOrder = new ArrayList<>();
    static List<Integer> postOrder = new ArrayList<>();
    

    public static Node getTree(){
        Node root = new Node(10);
        root.left = new Node(45);
        root.right = new Node(5);

        root.left.left = new Node(3);
        root.left.right= new Node(4);

        root.right.left = new Node(7);
        root.right.right = new Node(8);

        return root;
    }
    public static void preOrder(Node root){
        if(root == null) return;
        preOrder.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
        
    }
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        inOrder.add(root.val);
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        postOrder.add(root.val);
    }
    public static int levelOrder(Node root , int target){
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<Node> leveler = new LinkedList<>();
        leveler.add(root);
        int level = 0;
        if(root.val == target){
            return level;
        }
        while(!leveler.isEmpty()){
            List<Integer> li = new ArrayList<>();
            int size = leveler.size();
            for(int i = 0; i < size; i++){
                Node node = leveler.poll();
                if(node.val == target){
                    return level;
                }
                li.add(node.val);
                if(node.left!= null) leveler.add(node.left);
                if(node.right!= null) leveler.add(node.right);
            }
            level++;
            levelOrder.add(li);
        }
        System.out.println(levelOrder);
        return -1;
        // System.out.print("[");
        // for(int i = 0; i < levelOrder.size(); i++){
        //     System.out.print("[");
        //     for(int j = 0 ; j < levelOrder.get(i).size(); j++){
        //         System.out.print(levelOrder.get(i).get(j));
        //         if(j != (levelOrder.get(i).size()) - 1){
        //             System.out.print(",");
        //         }
        //     }
        //     System.out.print("]");
        // }
        // System.out.print("]");

    }
    public static void printlist(List<Integer> list){
        for(int i : list){
            System.out.print(i + " ");
        }
    }

    public static void check(String choice , Node root , int target){

        if(choice.equals("preorder")){
            System.out.println("Preorder Traversal: ");
            preOrder(root);
            printlist(preOrder);
        }else if(choice.equals("inorder")){
            System.out.println("Inorder Traversal: ");
            inOrder(root);
            printlist(inOrder);
        }else if(choice.equals("levelorder")){
            System.out.println("Level Order traversal");
            int res = levelOrder(root, target);
            System.out.println(res);
        }
        else{
            System.out.println("postOrder Traversal: ");
            postOrder(root);
            printlist(postOrder);
        }
    }
    public static void main(String args[]){
        Node root = getTree();

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        int target = sc.nextInt();
        check(choice,root,target);
        sc.close();

    }
}
