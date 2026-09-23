class Solution {
    private int[][] treeCnt;
    private int[] treeProd;
    private int modVal;

    private void merge(int[] res, int[] l, int[] r) {
        java.util.Arrays.fill(res, 0, modVal, 0);
        res[modVal] = (l[modVal] * r[modVal]) % modVal;
        
        for (int i = 0; i < modVal; ++i) res[i] = l[i];
        for (int i = 0; i < modVal; ++i) {
            int shifted = (l[modVal] * i) % modVal;
            res[shifted] += r[i];
        }
    }

    private void addNode(int node, int val) {
        val %= modVal;
        java.util.Arrays.fill(treeCnt[node], 0);
        treeCnt[node][val] = 1;
        treeProd[node] = val;
    }

    private void build(int[] nums, int node, int l, int r) {
        if (l == r) {
            addNode(node, nums[l]);
            return;
        }
        int mid = l + (r - l) / 2;
        build(nums, node * 2, l, mid);
        build(nums, node * 2 + 1, mid + 1, r);
        
        treeProd[node] = (treeProd[node * 2] * treeProd[node * 2 + 1]) % modVal;
        for (int i = 0; i < modVal; ++i) treeCnt[node][i] = treeCnt[node * 2][i];
        for (int i = 0; i < modVal; ++i) {
            int shifted = (treeProd[node * 2] * i) % modVal;
            treeCnt[node][shifted] += treeCnt[node * 2 + 1][i];
        }
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            addNode(node, val);
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) update(node * 2, l, mid, idx, val);
        else update(node * 2 + 1, mid + 1, r, idx, val);
        
        treeProd[node] = (treeProd[node * 2] * treeProd[node * 2 + 1]) % modVal;
        for (int i = 0; i < modVal; ++i) treeCnt[node][i] = treeCnt[node * 2][i];
        for (int i = 0; i < modVal; ++i) {
            int shifted = (treeProd[node * 2] * i) % modVal;
            treeCnt[node][shifted] += treeCnt[node * 2 + 1][i];
        }
    }
    private int[] query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            int[] res = new int[modVal + 1];
            System.arraycopy(treeCnt[node], 0, res, 0, modVal);
            res[modVal] = treeProd[node];
            return res;
        }
        int mid = l + (r - l) / 2;
        if (qr <= mid) return query(node * 2, l, mid, ql, qr);
        if (ql > mid) return query(node * 2 + 1, mid + 1, r, ql, qr);
        
        int[] lRes = query(node * 2, l, mid, ql, qr);
        int[] rRes = query(node * 2 + 1, mid + 1, r, ql, qr);
        int[] merged = new int[modVal + 1];
        merge(merged, lRes, rRes);
        return merged;
    }

    public int[] resultArray(int[] nums, int modVal, int[][] queries) {
        int n = nums.length;
        if (n == 0) return new int[0];
        this.modVal = modVal;
        this.treeCnt = new int[4 * n][modVal];
        this.treeProd = new int[4 * n];
        
        build(nums, 1, 0, n - 1);
        
        int[] ans = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int updateIdx = queries[i][0];
            int newVal = queries[i][1];
            int startIdx = queries[i][2];
            int rem = queries[i][3];

            update(1, 0, n - 1, updateIdx, newVal);
            ans[i] = query(1, 0, n - 1, startIdx, n - 1)[rem];
        }
        
        return ans;
    }
}