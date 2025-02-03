public class LockManager {

    public void lockNode(LockUnlock.Node root){
        root.isLock = true;
    }
    public boolean checkParentLock(LockUnlock.Node root){
        if(root == null) return true;

        if(!root.isLock){
            
        }
    }

    public void lock(LockUnlock.Node root) {
        if (!root.isLockable) {
            return;
        }
        ancestorLock(root);
        checkParentLock(root);
        lockNode(root);
        LockUnlock.Node current = root.parent;
        while (current != null) {
            current.isLockable = false;
            current = current.parent;
        }
    }
}