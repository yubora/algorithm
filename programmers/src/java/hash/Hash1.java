package java.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <h2>완주하지 못한 선수</h2>
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * <p>
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * - 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 */
public class Hash1 {
    public static void main(String[] args) {
        // <문제 이해>
        //1. participant 정렬하여 동명이인이 몇인지 확인
        //2. participant의 이름이 completion에 있는지 loop 하여 해당 이름 participant에서 제거

        // <다시 생각해보기>
        //a. <1> hash를 이용한다면 정렬이 필요 X
        //b. <2> 동명이인이 같이 제거되므로 X
        //c. 첫번째 작업으로 participant 길이만큼의 HashMap 선언

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};


        String answer = "";

        // 참가자를 담은 HashMap 생성 (key:index, value:name)
        Map<String, String> origin = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            origin.put(String.valueOf(i), participant[i]);
        }

        // 완주자 배열과 참가자 HashMap을 순회하면서 HashMap에 해당 완주자가 있는지 조회
        // 있다면 HashMap의 현재 index의 value(참가자 이름)를 ""(Empty String)으로 변경
        // 동명이인이 모두 Empty String으로 변경되지 않아야 하기때문에 첫번째 매칭 이후 내부 loop 탈출
        for (String c : completion) {
            for (int j = 0; j < origin.size(); j++) {
                if (c.equals(origin.get(String.valueOf(j)))) {
                    origin.put(String.valueOf(j), "");
                    break;
                }
            }
        }

        // 완주자 배열을 모두 순회하면, 참가자 HashMap에서 value가 Empty String이 아닌 값을 return
        //keySet을 통해 Hash맵을 순회하여 value를 얻을 수 있다.
        for (String key : origin.keySet()) {
            if (!origin.get(key).equals("")) {
                answer = origin.get(key);
            }
        }

        System.out.println(answer);
    }


    // asis  이전에 내가 풀었던 풀이인가보다. Hash문제이니 Hash를 이용하여 다시 풀어보기로 했다.
//    import java.util.Arrays;
//
//    class Solution {
//        public String solution(String[] participant, String[] completion) {
//            String answer = "";
//
//            Arrays.sort(participant);
//            Arrays.sort(completion);
//
//            int p;
//            for(p = 0; p < participant.length-1; p++) {
//                if(p == completion.length-1){
//                    answer = participant[p+1];
//                }
//                if(!participant[p].equals(completion[p])){
//                    answer = participant[p];
//                }
//            }
//            return answer;
//        }
//    }
}
