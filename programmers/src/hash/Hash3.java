package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h2>위장</h2>
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 </br>
 * 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다. </br>
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.</br>
 *
 * <h3>제한사항</h3>
 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다. </br>
 * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.</br>
 * 같은 이름을 가진 의상은 존재하지 않습니다.</br>
 * clothes의 모든 원소는 문자열로 이루어져 있습니다.</br>
 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.</br>
 * 스파이는 하루에 최소 한 개의 의상은 입습니다.</br>
 */
public class Hash3 {
    public static void main(String[] args) {
        //1.{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"blue-t", "top"}, {"jean", "bottom"}, {"coat", "outer"}
        //2.{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"} //5
        //3.{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"} //3
        String[][] clothes = new String[][] {
                {"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}
        };

        Map<String, List<String>> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String item = clothe[1];
            String name = clothe[0];
            if (map.containsKey(item)) {
                List<String> exist = map.get(item);
                exist.add(name);
                map.put(item, exist);
                continue;
            }
            List<String> newKeys = new ArrayList<>();
            newKeys.add(name);
            map.put(item, newKeys);
        }

        //마직막 이 수학식을 이해하는데에 시간이 걸렸다.
        //각 아이템의 갯수 * 꼭 한번은 입을 경우
        //그리고 마지막에 아무것도 입지 않는 경우를 빼준다.
       int answer = 1;
        for (String s : map.keySet()) {
            answer *= map.get(s).size() + 1;
        }

        answer -= 1;

        System.out.println(answer);
    }
}