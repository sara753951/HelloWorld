package program.learning.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * Created by yanxinming on 2020/6/5
 */
public class Id49 {
    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupsMap = new HashMap<>(16);
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if (!groupsMap.containsKey(str)) {
                groupsMap.put(str, new ArrayList<>());
            }
            groupsMap.get(str).add(strs[i]);
        }

        return new ArrayList<>(groupsMap.values());
    }
    private static List<List<String>> groupAnagrams2(String[] strs) {

        HashMap<String, List<String>> groupsMap = new HashMap<>(16);
        for (int i = 0; i < strs.length; i++) {
            String str = getCountStr(strs[i]);
            if (!groupsMap.containsKey(str)) {
                groupsMap.put(str, new ArrayList<>());
            }
            groupsMap.get(str).add(strs[i]);
        }
        return new ArrayList<>(groupsMap.values());
    }

    private static String getCountStr(String str) {
        int[] array = new int[26];
        for (int i = 0; i < str.length(); i++) {
            array[str.charAt(i) - 'a']++;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int c : array) {
            stringBuffer.append(c).append("#");
        }
        return stringBuffer.toString();
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = new String[]{"", ""};
        System.out.println(JSONObject.toJSONString(groupAnagrams2(strs)));
    }

}
