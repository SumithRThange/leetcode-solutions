class LRUCache {
    class Node{
        int key, val;
        Node prev, next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        map.clear();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = (map.get(key));
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = (map.get(key));
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
        } else {
            if(map.size() == capacity){
                Node node = tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insertAfterHead(node);

        }
    }
    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insertAfterHead (Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */