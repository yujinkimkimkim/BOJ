package baekjoon;
import java.util.*;
import java.io.*;

public class b1593 {

    public static void main(String[] args) throws IOException{
    	Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int g = sc.nextInt();

        String arr = sc.next();
        String ginputArr = sc.next();

        int cnt = 0;
        boolean flag = false;
        for(int i = 0 ; i < g-w ; i++)
        {
            flag = true;
            for(int j = 0 ; j < w ; j++)
            {
                if(arr.indexOf(ginputArr.charAt(i+j)) < 0)
                    flag = false;
            }
            if(flag)
                cnt++;
        }
        System.out.println(cnt);
    }
}
//
//package baekjoon;
//import java.util.*;
//import java.io.*;
//
//public class b1593 {
//
//    public static void main(String[] args) throws IOException{
//    	Scanner sc = new Scanner(System.in);
//
//        int w = sc.nextInt();
//        int g = sc.nextInt();
//
//        String arr = sc.next();
//        String ginputArr = sc.next();
//
//        int cnt = 0;
//
//        // arr 문자열의 빈도수를 저장하는 해시맵 생성
//        Map<Character, Integer> arrFrequency = new HashMap<>();
//        for (char c : arr.toCharArray()) {
//            arrFrequency.put(c, arrFrequency.getOrDefault(c, 0) + 1);
//        }
//
//        // 초기 슬라이딩 윈도우의 빈도수 계산
//        Map<Character, Integer> windowFrequency = new HashMap<>();
//        for (int i = 0; i < w; i++) {
//            char c = ginputArr.charAt(i);
//            windowFrequency.put(c, windowFrequency.getOrDefault(c, 0) + 1);
//        }
//
//        // 첫 번째 윈도우에서 빈도수 비교 후 cnt 증가 여부 결정
//        if (checkFrequencies(arrFrequency, windowFrequency)) {
//            cnt++;
//        }
//
//        // 슬라이딩 윈도우를 오른쪽으로 이동하며 빈도수 비교
//        for (int i = w; i < g; i++) {
//            char leftChar = ginputArr.charAt(i - w);
//            char rightChar = ginputArr.charAt(i);
//
//            // 왼쪽 문자의 빈도수 감소
//            windowFrequency.put(leftChar, windowFrequency.get(leftChar) - 1);
//            if (windowFrequency.get(leftChar) == 0) {
//                windowFrequency.remove(leftChar);
//            }
//
//            // 오른쪽 문자의 빈도수 증가
//            windowFrequency.put(rightChar, windowFrequency.getOrDefault(rightChar, 0) + 1);
//
//            // 빈도수 비교 후 cnt 증가 여부 결정
//            if (checkFrequencies(arrFrequency, windowFrequency)) {
//                cnt++;
//            }
//        }
//
//        System.out.println(cnt);
//    }
//
//    private static boolean checkFrequencies(Map<Character, Integer> arrFrequency, Map<Character, Integer> windowFrequency) {
//        for (Map.Entry<Character, Integer> entry : arrFrequency.entrySet()) {
//            char c = entry.getKey();
//            int freq = entry.getValue();
//            if (windowFrequency.getOrDefault(c, 0) < freq) {
//                return false;
//            }
//        }
//        return true;
//    }
//}

