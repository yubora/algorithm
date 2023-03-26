package java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <h2>대충만든 자판</h2>
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
 */
public class NonsenseKeyboard {
    public static void main(String[] args) {
        String[] keymap = new String[]{"ABCE"};
        String[] targets = new String[]{"ABDE", "ABZE"};
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            String[] splitTarget = targets[i].split("");
            List<Integer> compare = new ArrayList<>(); // keymap별로 splitTarget 문자를 누르는 횟수 모음 (이 중, 최솟값을 count에 합산)

            for (int j = 0; j < splitTarget.length; j++) {
                compare.clear();

                for (String key : keymap) {
                    if (key.contains(splitTarget[j])) {
                        compare.add(key.indexOf(splitTarget[j]) + 1);
                    }
                }

                if (compare.isEmpty()) {
                    count = -1;
                    break;
                } else {
                    count += Collections.min(compare);
                }
            }
            answer.add(count);
        }

        System.out.println("answer: " + Arrays.toString(answer.toArray()));
    }


}
