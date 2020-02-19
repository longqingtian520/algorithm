package com.criss.wang.algorithm.longestcharacterwithnorepeat;

import java.util.*;

/**
 * @Author wangqiubao
 * @Date 2020/2/18 14:28
 * @Version 1.0
 * @Description 查询无重复字符的最长字串  题目描述：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 解决方案：
 * --- 滑动窗口法：
 * 定义两个指针，start和end，代表当前窗口的开始和结束位置，同样使用hashset,当窗口中出现重复的字符时，start++,没有重复时，end++,每次更新长度的最大值
 **/
public class Lcwnr {

    // 法一：===================================================时间复杂度O(n)
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int[] map = new int[256];
        int l = 0;
        int r = 0; // 滑动窗口为[l, r)，其间为不重复的元素
        int res = 0;
        while (l < s.length()) {
            if (r < s.length() && map[s.charAt(r)] == 0) {
                map[s.charAt(r++)]++;
                res = Math.max(res, r - l);
            } else {
                map[s.charAt(l++)]--;
            }
        }
        return res;
    }

    // 法二：思想和法一相同，只是数据结构不同===================时间复杂度O(n)
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int res = 0;
        int end = 0, start = 0;
        Set<Character> set = new HashSet<>();
        while (start < n && end < n) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - start);
            }
        }

        Iterator<Character> it = set.iterator();
        String str = "";
        while (it.hasNext()) {
            str += it.next();
        }
        System.out.println(str);

        return res;
    }

    // 法三：========================================================时间复杂度O(n^2)
    static int newnum = 0;//定义新的集合的长度
    static int oldnum = 0;//定义旧的集合的长度

    private static void fun1(String s) {
        ArrayList<Character> list = null;
        if (s.length() == 0) {
            oldnum = 0;//如果字符串长度为1最终结果长度等于0
        } else if (s.length() == 1) {
            oldnum = 1;//如果字符串长度等于1最终结果长度就等于1
        } else {
            for (int i = 0; i < s.length(); i++) {//因为我这里循环利用的是第一个和他后面的字符进行比较，
                // 所以必须就在前面判断字符串长度是否是1，否则就不可以
                list = new ArrayList<>();
                list.add(s.charAt(i));
                for (int j = i + 1; j < s.length(); j++) {
                    if (!list.contains(s.charAt(j))) {
                        list.add(s.charAt(j));
                        newnum = list.size();
                    } else {
                        break;
                    }
                }
                if (oldnum <= newnum) {
                    oldnum = newnum;
                }
            }
        }
        System.out.println(oldnum);

    }

    public static void main(String[] args) {
        String str = "世界军事传播界知识世界只是传播军事力度";
        System.out.println(lengthOfLongestSubstring1(str));
        fun1(str);
    }
}
