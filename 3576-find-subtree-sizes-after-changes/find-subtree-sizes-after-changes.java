class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];
        List<Integer>[] modified = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            modified[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] nearest = new int[26];
        Arrays.fill(nearest, -1);

        buildTree(0, parent, tree, modified, s, nearest);

        int[] ans = new int[n];
        calculateSize(0, modified, ans);

        return ans;
    }

    private void buildTree(int node, int[] parent,
            List<Integer>[] tree,
            List<Integer>[] modified,
            String s, int[] nearest) {

        int ch = s.charAt(node) - 'a';
        int old = nearest[ch];

        // Keep original parent if no matching ancestor exists
        int newParent = (old == -1) ? parent[node] : old;

        if (node != 0) {
            modified[newParent].add(node);
        }

        nearest[ch] = node;

        for (int child : tree[node]) {
            buildTree(child, parent, tree, modified, s, nearest);
        }

        // Backtrack
        nearest[ch] = old;
    }

    private int calculateSize(int node,
            List<Integer>[] tree,
            int[] ans) {

        int size = 1;

        for (int child : tree[node]) {
            size += calculateSize(child, tree, ans);
        }

        return ans[node] = size;
    }
}