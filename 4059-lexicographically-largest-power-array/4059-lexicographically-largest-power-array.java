class Solution {
    int[] res;
    int[] done;

    private void f(List<Integer> A, int i) {
        if (i == 15) return;
        if (done[i] == 1) {
            f(A, i + 1);
            return;
        }
        List<Integer> L = new ArrayList<>();
        List<Integer> R = new ArrayList<>();
        for (int a : A) {
            if ((a & (1 << (14 - i))) != 0) {
                L.add(a);
            } else {
                R.add(a);
            }
        }
        if (!L.isEmpty()) {
            res[i] += L.size();
            f(L, i + 1);
        }
        if (!R.isEmpty()) {
            done[i] = 1;
            f(R, i + 1);
        }
    }

    public int[] largestPower(int[] A) {
        res = new int[15];
        done = new int[15];
        List<Integer> list = new ArrayList<>(A.length);
        for (int a : A) {
            list.add(a);
        }
        f(list, 0);
        return res;
    }
}