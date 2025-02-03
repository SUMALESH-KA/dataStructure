 import java.util.*;

 public class LockUnlock{

    static class Node{
            int data;
            List<Node> children;
            boolean isLock;
            boolean isLockable;
            Node parent;
    
        public Node(int data) {
            this.children = new ArrayList<>();
            this.data = data;
            this.isLockable = true;
            this.isLock = false;
        }
        public Node(int data,Node parent) {
            this.children = new ArrayList<>();
            this.data = data;
            this.isLockable = true;
            this.isLock = false;
            this.parent = parent;
        }
    
    }

    public void lockNode(Node root){
        root.isLock = true;
    }

    public static void main(String []args){
        lock lockNode = new lock();

    }
}
