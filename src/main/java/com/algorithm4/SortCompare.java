package com.algorithm4;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg. equals("Insertion")) Insertion.sort(a);
        if (alg. equals("Selection")) Selection.sort(a);
        if (alg. equals("Shell")) Shell.sort(a);
//        if (alg. equals(" Merge")) Merge.sort(a);
//        if (alg. equals(" Quick")) Quick.sort(a);
//        if (alg. equals(" Heap")) Heap.sort( a);
        return timer. elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        // 使用 算法 alg 将 T 个 长度 为 N 的 数组 排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            // 进行 一次 测试（ 生成 一个 数组 并排 序)
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        args = new String[]{"Selection", "Insertion", "2", "10"};
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T); // 算法 1 的 总 时间
        double t2 = timeRandomInput(alg2, N, T); // 算法 2 的 总 时间
        StdOut.printf("For %d random Doubles n %s is ", N, alg1);
        StdOut.printf("%.11f times faster than %s", t2 / t1, alg2);

    }
}
