package algorithm.assignment4;

public class _3_1 {
    public static void main(String[] args){
        int[][] work = new int[4][4];
        int[] result = new int[4];
        work[0][0] = 8;
        work[0][1] = 3;
        work[0][2] = 6;
        work[0][3] = 5;
        work[1][0] = 4;
        work[1][1] = 9;
        work[1][2] = 2;
        work[1][3] = 8;
        work[2][0] = 8;
        work[2][1] = 1;
        work[2][2] = 5;
        work[2][3] = 4;
        work[3][0] = 9;
        work[3][1] = 3;
        work[3][2] = 7;
        work[3][3] = 5;

        result = findGreedy(work, 4);
        for(int i = 0; i < 4; i++){
            System.out.println(result[i]);
        }
        System.out.println();
        result = findBrute(work, 4);
        for(int i = 0; i < 4; i++){
            System.out.println(result[i]);
        }
        System.out.println();
        result = findGreedy2(work, 4);
        for(int i = 0; i < 4; i++){
            System.out.println(result[i]);
        }

    }

    public static int[] findGreedy(int[][] work, int n){
        int[] result = new int[n];
        boolean[] decided = new boolean[n];
        int job_num, min;

        for(int i = 0; i < n; i++){
            min = 100; //임의의 큰 수
            job_num = -1;
            for(int j = 0; j < n; j++){
                if(min > work[i][j] && !decided[j]){
                    min = work[i][j];
                    job_num = j;
                }
            }
            decided[job_num] = true;
            result[i] = job_num;
        }

        return result;
    }

    public static int[] findGreedy2(int[][] work, int n){
        int count;
        int min_cost, min_worker, min_job;
        boolean[] decided_worker = new boolean[n];
        boolean[] decided_job = new boolean[n];
        int[] result = new int[n];

        for(count = 0; count < n; count++){
            min_cost = Integer.MAX_VALUE;
            min_worker = -1;
            min_job = -1;
            for(int i = 0; i < n; i++){
                if(decided_worker[i]){
                    continue;
                }
                for(int j = 0; j < n; j++){
                    if(decided_job[j]){
                        continue;
                    }
                    if(min_cost > work[i][j]){
                        min_cost = work[i][j];
                        min_job = j;
                        min_worker = i;
                    }

                }
            }

            decided_worker[min_worker] = true;
            decided_job[min_job] = true;
            result[min_worker] = min_job;
        }
        return result;
    }


    public static int[] findBrute(int[][] work, int n) {
        int[] cur = new int[n];
        boolean[] decided = new boolean[n];
        int[] min = {Integer.MAX_VALUE};
        int[] best = new int[n];

        // 모든 배정 방법 탐색
        findBruteResult(0, n, work, cur, decided, 0, min, best);

        return best;
    }

    private static void findBruteResult(int person, int n, int[][] work, int[] cur, boolean[] decided, int curCost, int[] min, int[] best) {
        if (person == n) {
            if (curCost < min[0]) {
                min[0] = curCost;
                System.arraycopy(cur, 0, best, 0, n);
            }
            return;
        }

        for (int job = 0; job < n; job++) {
            if (!decided[job]) {
                decided[job] = true;
                cur[person] = job;
                findBruteResult(person + 1, n, work, cur, decided, curCost + work[person][job], min, best);
                decided[job] = false;
            }
        }
    }
}
