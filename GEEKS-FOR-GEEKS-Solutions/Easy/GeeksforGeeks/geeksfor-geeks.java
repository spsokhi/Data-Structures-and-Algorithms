import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            System.out.println(myFun(n));
        }
        sc.close();
    }

    public static int myFun(int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            int tmp = q.poll();
            q.poll();
            q.add(tmp);
        }
        return q.peek();
    }
}
