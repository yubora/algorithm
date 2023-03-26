package java.practice;


import java.util.Arrays;
import java.util.List;

/**
 * <h2>[카카오 인턴] 키패드 누르기</h2>
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 */
public class Keypad {
    public static void main(String[] args) {
        int[] numbers = new int[]{2};
        String hand = "right";
        StringBuilder result = new StringBuilder();

        // *, 0, # 은 각각 10, 11, 12로 치환
        int nowLeft = 10;
        int nowRight = 12;
        String myHand = "right".equals(hand) ? "R" : "L";

        List<Integer> rightNum = Arrays.asList(3, 6, 9);
        List<Integer> leftNum = Arrays.asList(1, 4, 7);

        for (int n : numbers) {
            if (n == 0) {
                n = 11;
            }
            if (rightNum.contains(n)) {
                nowRight = n;
                result.append("R");
            } else if (leftNum.contains(n)) {
                nowLeft = n;
                result.append("L");
            } else {
                int diffR = Math.abs(n - nowRight);
                int diffL = Math.abs(n - nowLeft);
                diffR = (diffR / 3) + (diffR % 3); // 가로거리 + 세로거리
                diffL = (diffL / 3) + (diffL % 3);

                if (diffR > diffL) {
                    result.append("L");
                    nowLeft = n;
                } else if (diffR < diffL) {
                    result.append("R");
                    nowRight = n;
                } else {
                    result.append(myHand);
                    if (myHand.equals("R")) {
                        nowRight = n;
                    } else {
                        nowLeft = n;
                    }
                }
            }
        }

        System.out.println(result);
    }


}
