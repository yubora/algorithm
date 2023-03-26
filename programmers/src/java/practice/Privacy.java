package java.practice;


import java.util.*;

/**
 * <h2>[2023 KAKAO BLIND RECRUITMENT] 개인정보 수집 유효기간</h2>
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 */
public class Privacy {
    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = new String[]{"Z 3", "D 5"};
        String[] privacies = new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> termMap = new HashMap<>();
        for (String str : terms) {
            String[] tmp = str.split(" ");
            termMap.put(tmp[0], Integer.valueOf(tmp[1]));
        }

        String[] splitedToday = today.split("\\.");
        for (int i = 0; i < privacies.length; i++) {
            int todayYear = Integer.valueOf(splitedToday[0]) * 12 * 28;
            int todayMonth = Integer.valueOf(splitedToday[1]) * 28;
            int todayDate = Integer.valueOf(splitedToday[2]);

            int todayCont = todayYear + todayMonth + todayDate;

            String[] tmp = privacies[i].split(" ");
            String[] splitedDate = tmp[0].split("\\.");

            int year = Integer.valueOf(splitedDate[0]) * 12 * 28;
            int month = Integer.valueOf(splitedDate[1]) * 28;
            int date = Integer.valueOf(splitedDate[2]);

            int validDate = year + month + date + (termMap.get(tmp[1]) * 28);

            if (todayCont >= validDate) {
                answer.add(i + 1);
            }
        }
        System.out.println(Arrays.toString(answer.toArray()));
    }


}
