class lock {
    public void lock(Node root){
        if(!root.isLockable){
            return;
        }
        if(root.parent!= null && root.parent.isLock){
            return;
        }
        root.isLock = true;

        Node current = root.parent;
        while (current != null) {
            current.isLockable = false;
            current = current.parent;
        }
    }
}
