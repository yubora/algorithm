package java.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h2>체육복</h2>
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. <br>
 * 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. <br>
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
 * <p>
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.<br>
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 *</p>
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 <br>
 * 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 */
public class Greedy1 {
    public static void main(String[] args) {
        int answer = 0;
        int totStudent = 13;
        int[] lost = new int[]{1, 2, 5, 6, 10, 12, 13};
        int[] reserve = new int[]{2, 3, 4, 5, 7, 8, 9, 10, 11, 12};

        Arrays.sort(lost);
        Arrays.sort(reserve);

        answer = totStudent - lost.length;

        List<Integer> lostList = new ArrayList<>();
        for (int l : lost) {
            lostList.add(l);
        }

        List<Integer> reserveList = new ArrayList<>();
        for (int r : reserve) {
            reserveList.add(r);
        }

        List<Integer> can_not_borrow = new ArrayList<>();
        for (Integer r : reserveList) {
            if (lostList.contains(r)) {
                lostList.remove(r);
                can_not_borrow.add(r);
                answer++;
            }
        }
        reserveList.removeAll(can_not_borrow);

        if (!reserveList.isEmpty()) {
            for (int r : reserveList) {
                if (lostList.isEmpty()) {
                    break;
                }
                if (lostList.contains(r - 1)) {
                    lostList.remove(lostList.indexOf(r - 1));
                    answer++;

                } else if (lostList.contains(r + 1)) {
                    lostList.remove(lostList.indexOf(r + 1));
                    answer++;
                }
            }
        }

        System.out.println("수업을 들을 수 있는 학생 수 : " + answer);
    }

}
