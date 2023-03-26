package java.exhaustive_search;

import java.util.*;

/**
 * <h2>최소직사각형</h2>
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
public class Es1 {
    public static void main(String[] args) {
        int[][] sizes = new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};

        Set<Integer> larger = new HashSet<>();
        Set<Integer> smaller = new HashSet<>();

        for (int[] size : sizes) {
            if (size[0] >= size[1]) {
                larger.add(size[0]);
                smaller.add(size[1]);
            } else {
                larger.add(size[1]);
                smaller.add(size[0]);
            }
        }

        int w = Collections.max(larger);
        int h = Collections.max(smaller);

        int answer = w * h;

        System.out.println(answer);

    }
}
