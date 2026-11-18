class Trie {

    class Node {
        Node[] links = new Node[26];
        boolean flag = false;
    }
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.links[index] == null){
                node.links[index] = new Node();
            }
            node = node.links[index];
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.links[index] == null){
                return false;
            }
            node = node.links[index];
        }
        return node.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()){
            int index = c - 'a';
            if(node.links[index] == null){
                return false;
            }
            node = node.links[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */