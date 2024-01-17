package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//最小覆盖字串
//给一个字符串s和一个字符串t，在字符串s里找出包含t所有字母的最小字串;
public class N76 {
    public static void main(String[] args) {
        System.out.println(n76("ADOBECODEBANC", "ABC"));
    }

    public static String n76(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>(); //need储存目标值各个字母出现的次数
        HashMap<Character, Integer> window = new HashMap<>();//window储存滑动窗口中有效字母出现的次数

        for (int i = 0; i < t.length(); i++)
            need.put(t.charAt(i), need.getOrDefault((t.charAt(i)), 0) + 1);//统计目标字串包含的所有字母出现次数


        int left = 0;//主动增加
        int right = 0;//被动增加
        int valid = 0;
        int start = 0;
        long len = 0x7fffffffffffffffL;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c))//含有这个字母，还要判断value值是否相同
            {

                window.put(c, window.getOrDefault(c, 0) + 1);

                if ((window.get(c))==need.get(c))
                    valid++;//vaild表示什么？有一个字母已经符合
            }


            //判断左侧窗口是否需要收缩，即判断窗口是否符合条件

            while (valid == need.size())
            {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d))
                {
                    if (need.get(d).equals(window.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == 0x7fffffffffffffffL ? "" : s.substring(start, (int) (start + len));
    }
}
        //最后只需要知道最短的起始索引与长度即可




