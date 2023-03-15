package practice;

import java.util.*;

/**
 * <h2>햄버거 만들기</h2>
 * https://school.programmers.co.kr/learn/courses/30/lessons/133502
 */
public class Hamburger {
    public static void main(String[] args) {
        int[] ingredient = new int[]{1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 1, 1, 2, 3, 3, 1, 2, 3, 1, 3, 3, 3, 2, 1, 2, 3, 1};
//        int[] ingredient = new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1};
//        int[] ingredient = new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2};
        List<Integer> list = new ArrayList<>();
        boolean doAgain;
        int startIdx = 0;
        int answer = 0;

        for (int i : ingredient) {
            list.add(i);
        }

        do {
            List<Integer> integrate = new ArrayList<>();
            doAgain = false;

            for (int i = startIdx; i < list.size(); i++) {
                if (!integrate.isEmpty()) {
                    if (integrate.get(integrate.size() - 1) == 3 && list.get(i) == 1) {
                        list.remove(i);
                        list.remove(i - 1);
                        list.remove(i - 2);
                        list.remove(i - 3);
                        doAgain = true;
                        startIdx = Math.max(i - 3 - 2, 0);
                        break;
                    } else if (integrate.get(integrate.size() - 1) + 1 == list.get(i)) {
                        integrate.add(list.get(i));
                    } else {
                        integrate.clear();
                    }
                }
                if (list.get(i) == 1) {
                    integrate.add(1);
                }
            }
            if (doAgain) {
                answer++;
            }
        } while (doAgain);

        System.out.println("answer: " + answer);
    }
}
