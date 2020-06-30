package program.learning.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yanxinming on 2020/6/12
 */
public class Id76 {
    private static String minWindow(String s, String t) {
        String result = "";
        if (s.length() < t.length() || s.length() <= 0) {
            return result;
        }
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int  i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        int l = 0, r = -1;
        int min = s.length() + 1;
        while (r < s.length() && l < s.length() - t.length() + 1) {
            if (contains(sMap, tMap)) {
                if (r - l + 1 < min) {
                    result = s.substring(l, r + 1);
                    min = result.length();
                    if (min == t.length()) {
                        return result;
                    }
                }
                while (l < s.length() - t.length() + 1) {
                    sMap.put(s.charAt(l), Math.max(sMap.getOrDefault(s.charAt(l), 0) - 1, 0));
                    l++;
                    if (t.indexOf(s.charAt(l)) > -1) {
                        break;
                    }
                }

            } else {
                while (++r < s.length()) {
                    if (t.indexOf(s.charAt(r)) > -1) {
                        sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
                        if (contains(sMap, tMap)) {
                            break;
                        }
                    }
                }
            }
        }


        return result;
    }

    private static boolean contains(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
        Iterator it = tMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            char c = (char) entry.getKey();
            if (sMap.getOrDefault(c, 0) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ABAACBAB";
        String t = "ABC";
        System.out.println(JSONObject.toJSONString(minWindow(s, t)));
    }
}
