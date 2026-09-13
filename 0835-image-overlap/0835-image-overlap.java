class Solution {
        public int largestOverlap(int[][] img1, int[][] img2) {

                int N = img1.length; 

                int res = 0; 

                int[][] Ones1 = new int[N * N][2]; 
                int c1 = 0; 

                int[][] Ones2 = new int[N * N][2]; 
                int c2 = 0; 

                for (int r = 0; r < N; r += 1) {
                        for (int c = 0; c < N; c += 1) {
                                if (img1[r][c] == 1) {
                                        Ones1[c1++] = new int[]{r, c}; 
                                }
                                if (img2[r][c] == 1) {
                                        Ones2[c2++] = new int[]{r, c};  
                                }
                        }
                }   
                int[][] counter = new int[60][60]; 

                for (int i = 0; i < c1; i++) {
                        for (int j = 0; j < c2; j++) {
                                int dr = Ones2[j][0] - Ones1[i][0] + 30; 
                                int dc = Ones2[j][1] - Ones1[i][1] + 30;    // 保证值非负:  

                                counter[dr][dc]++; 

                                res = Math.max(res, counter[dr][dc]);  
                        }
                } 
                return res; 
        }
}