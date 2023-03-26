package java.exhaustive_search;

import java.util.*;

/**
 * <h2>모의고사</h2>
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=java
 */
public class Es2 {
    public static void main(String[] args) {
        // 매개변수
        int[] answers = new int[]{4,5,5,2,4,5,5};

        // 수포자 1,2,3가 각각 찍는 방법
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        // 패턴 인덱스
        int[] pointers = new int[]{0, 0, 0};

        // 수포자 1,2,3의 정답 수
        int[] answerCnt = {0, 0, 0};

        for (int i : answers) {
            for (int j = 0; j < patterns.length; j++) {
                // 정답과 수포자의 패턴이 일치하면 수포자의 인덱스에 해당하는 정답 수 카운트 ++
                if (i == patterns[j][pointers[j]]) {
                    answerCnt[j]++;
                }
                // 다음 패턴으로 이동
                pointers[j]++;

                // 패턴을 한번 완료 했으면 다시 처음으로 이동
                if (pointers[j] >= patterns[j].length) {
                    pointers[j] = 0;
                }
            }
        }

        int maxPoints = Arrays.stream(answerCnt).max().getAsInt();
        List<Integer> winner = new ArrayList<>();

        int idx = 1;
        for (int cnt: answerCnt) {
            if (cnt == maxPoints) {
                winner.add(idx);
            }
            idx++;
        }

        System.out.println(Arrays.toString(winner.stream().mapToInt(i -> i).toArray()));
    }
}
