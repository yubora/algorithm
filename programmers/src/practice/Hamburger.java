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


        // Stack을 이용하여 다시 풀어보기
        // Stack을 이용하면 훨씬 더 간결해질 것 같아 다시 풀어보았다.
        // 이전 풀이보다 속도도 훨씬 개선되었다.
        // Stack의 길이가 햄버거 완성 재료 갯수인 4이상이 되면
        // 하나씩 꺼내서 빵-고기-야채-빵, 즉 1321 (위에서 부터 꺼내기 때문에 본래 햄버거 순서의 역순으로)이 맞는지 확인하고,
        // 맞다면 answer의 카운트를 올리고, 다르다면 재료들을 분리하여 Stack에 다시 역순으로 담는다.
        Stack<String> list = new Stack<>();
        int answer = 0;

        for (int i : ingredient) {
            list.push(Integer.toString(i));

            if (list.size() >= 4) {
                StringBuilder sb = new StringBuilder();
                sb.append(list.pop());
                sb.append(list.pop());
                sb.append(list.pop());
                sb.append(list.pop());

                if ("1321".equals(sb.toString())) {
                    answer++;
                } else {
                    String[] trash = sb.toString().split("");
                    for (int j = trash.length - 1; j >= 0; j--) {
                        list.push(trash[j]);
                    }
                }
            }
        }


//        List<Integer> list = new ArrayList<>();
//        boolean doAgain;
//        int startIdx = 0;
//        int answer = 0;
//
//        for (int i : ingredient) {
//            list.add(i);
//        }
//
//        do {
//            List<Integer> integrate = new ArrayList<>();
//            doAgain = false;
//
//            for (int i = startIdx; i < list.size(); i++) {
//                if (!integrate.isEmpty()) {
//                    if (integrate.get(integrate.size() - 1) == 3 && list.get(i) == 1) {
//                        list.remove(i);
//                        list.remove(i - 1);
//                        list.remove(i - 2);
//                        list.remove(i - 3);
//                        doAgain = true;
//                        startIdx = Math.max(i - 3 - 2, 0);
//                        break;
//                    } else if (integrate.get(integrate.size() - 1) + 1 == list.get(i)) {
//                        integrate.add(list.get(i));
//                    } else {
//                        integrate.clear();
//                    }
//                }
//                if (list.get(i) == 1) {
//                    integrate.add(1);
//                }
//            }
//            if (doAgain) {
//                answer++;
//            }
//        } while (doAgain);

        System.out.println("answer: " + answer);
    }
}
