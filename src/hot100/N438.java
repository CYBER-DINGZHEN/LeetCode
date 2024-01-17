package hot100;
//438.找到字符串中所有的字母异位词
//给定两个字符串s和p，找到s中所有的p的异位词的子串，返回这些字串的初始索引。不考虑答案输出的顺序。
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class N438 {
    public static void main(String[] args) {
        //思考，异位词如何处理？
        //对异位词进行排序，所得到的string一定相同
        String s = "cbaebabacd", p = "abc";
        System.out.println(n438(s, p));

        //两个指针一起动，切出来的字符串进行判断即可
    }
    public static List<Integer> n438(String s,String p){

        String ppp=stringsort(p);
        int j=p.length();
        HashMap<String,List<Integer>> hm=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        hm.put(ppp,list);

        for (int i = 0; i < s.length(); i++) {
            if(j>s.length())break;
            String temp= stringsort(s.substring(i,j));
            if(hm.containsKey(temp)){
                List<Integer> list1=hm.get(temp);
                list1.add(i);
                hm.put(temp,list1);
            }
            j++;
        }
        return list;
    }
    public static String stringsort(String ss){
        char[] pp=ss.toCharArray();
        Arrays.sort(pp);
        return new String(pp);
    }
    }

