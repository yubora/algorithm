package java.stack_queue;

import java.util.Stack;

/**
 * <h2>올바른 괄호</h2>
 * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
 * <p>
 * "()()" 또는 "(())()" 는 올바른 괄호입니다.
 * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 * </p>
 * - 제한사항
 * 문자열 s의 길이 : 100,000 이하의 자연수
 * 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
 */
public class Stack1 {
    public static void main(String[] args) {
        String brackets = ")()())";

        // 풀이3: 정확성 100, 효율성 100
        // - String.split()을 String.toCharArray()로 변경 : String 보다 char 타입으로 가공하는 것이 속도면에서 빠름
        // - main의 반환 타입을 맞추기 위해 일부러 불필요한 push/pop을 하다보니 효율성 문제가 생긴 것 같다.
        //   프로그래머스 툴에서 불필요한 push/pop을 없애니 시간초과 문제가 해결 되었다.
        char[] splited = brackets.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char next : splited) {
            if (stack.isEmpty()) {
                if (next == (')')) {
                    System.out.println(false);
                    break;
                }
                stack.push(next);
            } else {
                char prev = stack.peek();
                if (prev == '(' && next== ')') {
                    stack.pop();
                } else {
                    stack.push(next);
                }
            }
        }
        System.out.println(stack.isEmpty());


        // 풀이1: 정확성 100, 효율성 0
//        String[] splited = brackets.split("");
//        Stack<String> stack = new Stack<>();
//
//        for(String next : splited) {
//            if (!stack.isEmpty()) {
//                String prev = stack.peek();
//                if (prev.equals("(") && next.equals(")")) {
//                    stack.push(next);
//                    stack.pop();
//                    stack.pop();
//                } else {
//                    stack.push(next);
//                }
//            } else {
//                stack.push(next);
//            }
//        }
//        System.out.println(stack.isEmpty());

        // 풀이2: 정확성 100, 효율성 0
//        boolean answer = false;
//        String[] splited = brackets.split("");
//
//        Stack<String> stack = new Stack<>();
//        Queue<String> queue = new LinkedList<>();
//
//        for (String bracket : splited) {
//            queue.offer(bracket);
//        }
//
//        int limit = queue.size();
//        for (int i = 0; i < limit; i++) {
//            if (stack.isEmpty()) {
//                String next = queue.poll();
//                stack.push(next);
//            }
//
//
//            if (stack.peek().equals("(") && queue.peek().equals(")")) {
//                stack.pop();
//                queue.poll();
//            } else {
//                stack.push(queue.poll());
//            }
//
//            if (stack.isEmpty() && queue.isEmpty()) {
//                answer = true;
//                break;
//            } else if (!stack.isEmpty() && queue.isEmpty()) {
//                break;
//            }
//        }
//
//        System.out.println(answer);
    }

}
