package hackerrank.challenges.w37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerrank.com/contests/w37/challenges/dynamic-line-intersection
// Not Getting


public class DynamicLineIntersectionJ {

    public static void main(String args[]) throws IOException {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        // Set<Point> set = new HashSet<>();
        int[] arr = new int[100001];
        for (int t0 = 0; t0 < n; t0++) {
            String[] input = in.readLine().split(" ");
            if (input[0].equals("+")) {
                // set.add(new Point(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
                int k = Integer.parseInt(input[1]);
                int b = Integer.parseInt(input[2]);
                int bb = b % k;
                // int kk = (arr.length - bb) / k;
                for (int i = bb; i < arr.length; i += k) {
                    arr[i]++;
                }
                continue;
            }
            if (input[0].equals("-")) {
                // set.remove(new Point(Integer.parseInt(input[1]),
                // Integer.parseInt(input[2])));
                int k = Integer.parseInt(input[1]);
                int b = Integer.parseInt(input[2]);
                int bb = b % k;
                // int kk = (arr.length - bb) / k;
                for (int i = bb; i < arr.length; i += k) {
                    arr[i]--;
                }
                continue;
            }
            System.out.println(arr[Integer.parseInt(input[1])]);
        }

    }
}
