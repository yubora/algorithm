package hash;

import java.util.Arrays;

/**
 * <h2>전화번호 목록</h2>
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, </br>
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 */
public class Hash2 {
    public static void main(String[] args) {
        String[] phone_book = {"567", "88", "12", "123", "1235"};

        boolean answer = true;

        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String s = phone_book[i];
            if (phone_book[i + 1].startsWith(s)) {
                answer = false;
                break;
            }
        }

        //=========================================================

        //Runtime 에러남
        //매개변수 해싱 ("idx", "number")
//        Map<Integer, String> phoneBookMap = new HashMap<>();
//        for (int i = 0; i < phone_book.length; i++) {
//            phoneBookMap.put(i, phone_book[i]);
//        }
//
//        for (Integer key : phoneBookMap.keySet()) {
//            String tmp = phoneBookMap.get(key);
//            for (String target : phone_book) {
//                if (!tmp.equals(target)) {
//                    String substring = target.substring(0, tmp.length());
//                    if (tmp.equals(substring)) {
//                        answer = false;
//                        break;
//                    }
//                }
//            }
//            if (!answer) {
//                break;
//            }
//        }

        System.out.println(answer);
    }
}