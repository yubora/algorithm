package java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <h2>바탕화면 정리</h2>
 * https://school.programmers.co.kr/learn/courses/30/lessons/161990
 */
public class Wallpaper {
    public static void main(String[] args) {
        String[] wallpaper = new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."};
        int[] answer = new int[4];

        List<Integer> lux = new ArrayList<>();
        List<Integer> luy = new ArrayList<>();
        List<Integer> rdx = new ArrayList<>();
        List<Integer> rdy = new ArrayList<>();

        for (int i = 0; i < wallpaper.length; i++) {
            String[] splited = wallpaper[i].split("");
            for (int j = 0; j < splited.length; j++) {
                if ("#".equals(splited[j])) {
                    lux.add(i);
                    luy.add(j);
                    rdx.add(i+1);
                    rdy.add(j+1);
                }

            }
        }

        answer[0] = Collections.min(lux);
        answer[1] = Collections.min(luy);
        answer[2] = Collections.max(rdx);
        answer[3] = Collections.max(rdy);

        System.out.println(lux);
        System.out.println(luy);
        System.out.println(rdx);
        System.out.println(rdy);
        System.out.println(Arrays.toString(answer));
    }


}
