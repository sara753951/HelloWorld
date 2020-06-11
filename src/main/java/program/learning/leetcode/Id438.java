package program.learning.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanxinming on 2020/6/11
 */
public class Id438 {
    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if (s.length() < p.length()) {
            return results;
        }

        int[] pCodeArray = getCodeArray(p);
        String pCode = getCode(pCodeArray);

        int[] sCodeArray = new int[26];
        for (int i = 0, j = i + p.length() - 1; j < s.length(); i++, j++) {
            if (i == 0) {
                sCodeArray = getCodeArray(s.substring(i, j + 1));
            } else {
                sCodeArray[s.charAt(i - 1) - 'a']--;
                sCodeArray[s.charAt(j) - 'a']++;
            }
            String currentCode = getCode(sCodeArray);
            if (pCode.equals(currentCode)) {
                results.add(i);
            }
        }

        return results;
    }

    private static int[] getCodeArray(String p) {
        int[] codeArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            codeArray[p.charAt(i) - 'a']++;
        }
        return codeArray;
    }


    private static String getCode(int[] codeArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < codeArray.length; i++) {
            sb.append(codeArray[i]).append("#");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(JSONObject.toJSONString(findAnagrams(s, p)));
    }

}
