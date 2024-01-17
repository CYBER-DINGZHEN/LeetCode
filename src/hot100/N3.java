package hot100;

import java.util.HashMap;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
public class N3 {
    public static void main(String[] args) {
        //找出不含有重复字符字串的最长字串长度
        //不含重复字符，这个条件怎么使用
        String s="afeujfhueiahfuiehanfuiaehfeiugdxc";
        System.out.println(n3(s));
    }
    //滑动窗口思想
    public static int n3(String s){
        if(s.isEmpty())return 0;
        HashMap<Character,Integer> hm=new HashMap<>();
        //用一个hash表，遍历字符串来添加字符从而实现字串的重复字符判断
        int res=0;
        int left=0;
        //right右指针开始移动
        for (int right = 0; right <s.length() ; right++)
        {
           if(hm.containsKey(s.charAt(right)))//发现即将添加的字符有重复了，则需要移动左指针了

           {
               left=Math.max(left,hm.get(s.charAt(right))+1);
               //左指针应该移动到哪里？应该移动到重复字符的上次出现位置来使得字符串重新满足要求
               //而上次出现的位置可以用hash表找到对应的值
               //注意如果这个重复字符出现在了左指针当前位置的左怎么办？
               //例"afeujfa",遍历到第二个f的时候，左指针需要移动到原先f的位置，hash表记录过了
               //那当我再次遍历到a时，同样满足了containskey条件，但是此时我们肯定是不能把左指针移动到曾经的a位置。
               //所以利用一个max判断，左指针动不动，怎么动？
               //这个Max是精髓，保证了左指针不会向左移动。
           }
            hm.put(s.charAt(right),right);
            //hash表里面存的是什么？字符，和字符所在的索引（最后一次）
            //所以下次遇到这个字符，读取该字符对应的值就是上次的放该字符的位置


            //更新最大值
            res=Math.max(res,right-left+1);
        }
return  res;

        }
}
