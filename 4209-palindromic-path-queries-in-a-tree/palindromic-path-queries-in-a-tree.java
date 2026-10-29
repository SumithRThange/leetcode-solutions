

class Solution {
    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        int[][] up = new int[LOG][n];
        int[] parent = new int[n];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] size = new int[n];
        int[] order = new int[n];
        int[] rootMask = new int[n];

        Arrays.fill(parent, -1);

        // Iterative DFS to avoid stack overflow on a long tree.
        int[] stack = new int[n];
        int top = 0, timer = 0;
        stack[top++] = 0;
        parent[0] = 0;
        rootMask[0] = 1 << (s.charAt(0) - 'a');

        while (top > 0) {
            int u = stack[--top];

            tin[u] = timer;
            order[timer++] = u;
            size[u] = 1;

            for (int v : graph[u]) {
                if (v == parent[u]) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                rootMask[v] = rootMask[u]
                        ^ (1 << (s.charAt(v) - 'a'));

                stack[top++] = v;
            }
        }

        // Calculate subtree sizes in reverse DFS order.
        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            size[parent[u]] += size[u];
        }

        // Binary lifting table for LCA.
        for (int i = 0; i < n; i++) {
            up[0][i] = parent[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        Fenwick bit = new Fenwick(n);
        char[] chars = s.toCharArray();

        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int delta = (1 << (chars[u] - 'a'))
                          ^ (1 << (c - 'a'));

                // Every root-to-node path inside u's subtree
                // changes by the same XOR mask.
                bit.rangeXor(tin[u], tin[u] + size[u] - 1, delta);
                chars[u] = c;
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int ancestor = lca(u, v, depth, up, LOG);

                int mask = getMask(u, rootMask, tin, bit)
                         ^ getMask(v, rootMask, tin, bit)
                         ^ (1 << (chars[ancestor] - 'a'));

                // At most one character can have odd frequency.
                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    private int getMask(
            int u, int[] rootMask, int[] tin, Fenwick bit) {
        return rootMask[u] ^ bit.query(tin[u]);
    }

    private int lca(
            int u, int v, int[] depth, int[][] up, int LOG) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if (((diff >> k) & 1) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }

    static class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int index, int delta) {
            for (int i = index + 1; i <= n; i += i & -i) {
                tree[i] ^= delta;
            }
        }

        void rangeXor(int left, int right, int delta) {
            update(left, delta);

            if (right + 1 < n) {
                update(right + 1, delta);
            }
        }

        int query(int index) {
            int result = 0;

            for (int i = index + 1; i > 0; i -= i & -i) {
                result ^= tree[i];
            }

            return result;
        }
    }
}
