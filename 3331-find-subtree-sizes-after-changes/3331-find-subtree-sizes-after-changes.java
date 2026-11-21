import java.util.*;

class Solution {
    List<Integer>[] tree;
    int[] parent, newParent, ans;
    String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.parent = parent;
        this.s = s;
        this.newParent = Arrays.copyOf(parent, n);
        this.ans = new int[n];

        tree = new ArrayList[n];
        Arrays.setAll(tree, i -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] closest = new int[26];
        Arrays.fill(closest, -1);
        reassign(0, closest);

        // Rebuild children using the updated parents
        for (int i = 0; i < n; i++) tree[i].clear();
        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        getSizes(0);
        return ans;
    }

    private void reassign(int node, int[] closest) {
        int c = s.charAt(node) - 'a';
        int prev = closest[c];
        if (node != 0 && prev != -1) {
            newParent[node] = prev;
        }

        closest[c] = node;
        for (int nxt : tree[node]) {
            reassign(nxt, closest);
        }
        closest[c] = prev;
    }

    private int getSizes(int node) {
        int count = 1;
        for (int nxt : tree[node]) {
            count += getSizes(nxt);
        }
        return ans[node] = count;
    }
}