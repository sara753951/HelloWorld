//给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 
//JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。 
//
// 说明: 
//
// 
// 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排
//序更靠前 
// 所有的机场都用三个大写字母表示（机场代码）。 
// 假定所有机票至少存在一种合理的行程。 
// 
//
// 示例 1: 
//
// 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
// 
//
// 示例 2: 
//
// 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。 
// Related Topics 深度优先搜索 图 
// 👍 228 👎 0

package program.learning.leetcode.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Id332ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket = Arrays.asList("JFK","KUL");
        tickets.add(ticket);
        ticket = Arrays.asList("JFK","NRT");
        tickets.add(ticket);
        ticket = Arrays.asList("NRT","JFK");
        tickets.add(ticket);
//        ticket = Arrays.asList("LHR", "SFO");
//        tickets.add(ticket);
        Solution solution = new Id332ReconstructItinerary().new Solution();
        List<String> re = solution.findItinerary(tickets);
        System.out.println(JSON.toJSONString(re));

    }
    class SolutionWA {
        public List<String> findItinerary(List<List<String>> tickets) {
            List<String> result = new ArrayList<>();
            //判空
            if (tickets.size() < 1) {
                return result;
            }
            //构造图
            int[][] graph = new int[tickets.size() + 1][tickets.size() + 1];
            HashMap<String, Integer> ticketsMap = new HashMap<>();
            HashMap<Integer, String> indexMap = new HashMap<>();
            for (List<String> ticket : tickets) {
                String from = ticket.get(0);
                String to = ticket.get(1);
                if (!ticketsMap.containsKey(from)) {
                    ticketsMap.put(from, ticketsMap.size());
                    indexMap.put(ticketsMap.get(from), from);
                }
                if (!ticketsMap.containsKey(to)) {
                    ticketsMap.put(to, ticketsMap.size());
                    indexMap.put(ticketsMap.get(to), to);
                }
                graph[ticketsMap.get(from)][ticketsMap.get(to)] = 1;
            }
            //起点不存在
            if (!ticketsMap.containsKey("JFK")) {
                return result;
            }
            int start = ticketsMap.get("JFK");
            result.add("JFK");
            boolean flag = true;
            while (flag) {
                String current = "ZZZ";
                for (int i = 0; i < tickets.size() + 1; i++) {
                    //贪心
                    if (1 == graph[start][i] && indexMap.get(i).compareTo(current) < 0) {
                        current = indexMap.get(i);
                    }
                }
                if (!"ZZZ".equals(current)) {
                    result.add(current);
                    graph[start][ticketsMap.get(current)] = 0;
                    start = ticketsMap.get(current);
                } else {
                    flag = false;
                }
            }

            return result;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                String from = ticket.get(0);
                String to = ticket.get(1);
                if (!map.containsKey(from)) {
                    map.put(from, new PriorityQueue<>());
                }
                map.get(from).offer(to);
            }
            dfs("JFK");

            Collections.reverse(result);
            return result;
        }

        private void dfs(String node) {
            while (map.containsKey(node) && map.get(node).size() > 0) {
                String temp = map.get(node).poll();
                dfs(temp);
            }
            result.add(node);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
}