package sort;

import java.util.Arrays;

/**
 * <h2>h-index</h2>
 * 어떤 과학자가 발표한 논문 n편 중,
 * h번 이상 인용된 논문이
 * h편 이상이고
 * 나머지 논문이 h번 이하 인용되었다면
 * h의 최댓값이 이 과학자의 H-Index입니다.</br>
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, </br>
 * 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 */
public class Sort1 {
    public static void main(String[] args) {
        int[] citations = new int[]{0,1,2,3,4};
        int hIndex = 0;

        Arrays.sort(citations);

        for (int i = 1; i <= citations.length; i++) {
            // 논문 수
            int cnt = 0;

            // 나머지 논문의 인용 횟수
            int rest = 0;

            // i번 이상 인용된 논문
            for (int c : citations) {
                if (i <= c) {
                    cnt ++;
                } else {
                    rest ++;
                }
            }

            if (cnt >= i && rest <= i) {
                hIndex = i;
            }
        }



        System.out.println(hIndex);
    }

}
