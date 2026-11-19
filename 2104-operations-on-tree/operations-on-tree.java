class LockingTree {
    int[] parent;
    int[] locked;
    List<Integer>[] children;

    public LockingTree(int[] parent) {
        int n = parent.length;
        this.parent = parent;
        locked = new int[n];
        children = new ArrayList[n];
        for(int i=0;i<n;i++){
            children[i] = new ArrayList<>(); 
        }
        for(int i=1;i<n;i++){
            children[parent[i]].add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(locked[num] != 0){
            return false;
        }
        locked[num] = user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(locked[num] != user){
            return false;
        }
        locked[num] = 0;
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        //check if current node is locked
        if(locked[num] != 0){
            return false;
        }
        int cur = parent[num];
        while(cur != -1){
            if(locked[cur] != 0){
                return false;
            }
            cur = parent[cur];
        }
        //checl and unlock all decendents
        if(!unlockdesendants(num)){
            return false;
        }
        locked[num] = user;
        return true;
    }

    private boolean unlockdesendants(int num){
        boolean found = false;
        for(int child : children[num]){
            if(locked[child] != 0){
                locked[child] = 0;
                found = true;
            }
            if(unlockdesendants(child)){
                found = true;
            }
        }
        return found;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */