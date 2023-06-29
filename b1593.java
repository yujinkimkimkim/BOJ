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
//        // arr ���ڿ��� �󵵼��� �����ϴ� �ؽø� ����
//        Map<Character, Integer> arrFrequency = new HashMap<>();
//        for (char c : arr.toCharArray()) {
//            arrFrequency.put(c, arrFrequency.getOrDefault(c, 0) + 1);
//        }
//
//        // �ʱ� �����̵� �������� �󵵼� ���
//        Map<Character, Integer> windowFrequency = new HashMap<>();
//        for (int i = 0; i < w; i++) {
//            char c = ginputArr.charAt(i);
//            windowFrequency.put(c, windowFrequency.getOrDefault(c, 0) + 1);
//        }
//
//        // ù ��° �����쿡�� �󵵼� �� �� cnt ���� ���� ����
//        if (checkFrequencies(arrFrequency, windowFrequency)) {
//            cnt++;
//        }
//
//        // �����̵� �����츦 ���������� �̵��ϸ� �󵵼� ��
//        for (int i = w; i < g; i++) {
//            char leftChar = ginputArr.charAt(i - w);
//            char rightChar = ginputArr.charAt(i);
//
//            // ���� ������ �󵵼� ����
//            windowFrequency.put(leftChar, windowFrequency.get(leftChar) - 1);
//            if (windowFrequency.get(leftChar) == 0) {
//                windowFrequency.remove(leftChar);
//            }
//
//            // ������ ������ �󵵼� ����
//            windowFrequency.put(rightChar, windowFrequency.getOrDefault(rightChar, 0) + 1);
//
//            // �󵵼� �� �� cnt ���� ���� ����
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

