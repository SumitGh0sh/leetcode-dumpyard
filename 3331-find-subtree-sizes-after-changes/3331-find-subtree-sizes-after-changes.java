import java.util.Arrays;

class Solution {
    int[] head, to, next;
    int[] newHead, newNext;
    int[] newParent, ans;
    String s;
    int edgeIdx;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.newParent = Arrays.copyOf(parent, n);
        this.ans = new int[n];

        head = new int[n];
        Arrays.fill(head, -1);
        to = new int[Math.max(1, n - 1)];
        next = new int[Math.max(1, n - 1)];
        edgeIdx = 0;

        for (int i = 1; i < n; i++) {
            addOrigEdge(parent[i], i);
        }

        int[] closest = new int[26];
        Arrays.fill(closest, -1);
        reassign(0, closest);

        newHead = new int[n];
        Arrays.fill(newHead, -1);
        newNext = new int[Math.max(1, n - 1)];
        edgeIdx = 0;

        for (int i = 1; i < n; i++) {
            addNewEdge(newParent[i], i);
        }

        getSizes(0);
        return ans;
    }

    private void addOrigEdge(int u, int v) {
        to[edgeIdx] = v;
        next[edgeIdx] = head[u];
        head[u] = edgeIdx++;
    }

    private void addNewEdge(int u, int v) {
        newNext[edgeIdx] = newHead[u];
        newHead[u] = edgeIdx++;
    }

    private void reassign(int node, int[] closest) {
        int c = s.charAt(node) - 'a';
        int prev = closest[c];
        if (node != 0 && prev != -1) {
            newParent[node] = prev;
        }

        closest[c] = node;
        for (int e = head[node]; e != -1; e = next[e]) {
            reassign(to[e], closest);
        }
        closest[c] = prev;
    }

    private int getSizes(int node) {
        int count = 1;
        for (int e = newHead[node]; e != -1; e = newNext[e]) {
            count += getSizes(to[e]);
        }
        return ans[node] = count;
    }
}