package hot100;

import java.lang.annotation.Target;
import java.util.*;

//给你一个整数数组 nums ，
// 判断是否存在三元组 [nums[i], nums[j], nums[k]]
// 满足 i != j、i != k 且 j != k ，
// 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
// 请你返回所有和为 0 且不重复的三元组。
public class N15 {
    //和两数之和很像，移动一下变成nums[i]+nums[j]=-nums[k];
    //把-nums[k]当作是target，化为两数之和问题
    //两数之和如何解决？一个target，返回两个索引（对应的数之和为target）
    //target和i;看target-num[j]是有没有key？有就读取他的值，是对应的索引
    //没有就放进去

    //问题，怎么去掉重复解呢？
    public static void main(String[] args) {
 int nums[]={-1,0,1,2,-1,-4};
        System.out.println(n11(nums));
    }

    public static List<List<Integer>> n11(int[]nums){

        HashMap<Integer,Integer> hm=new HashMap<>();
        List<List<Integer>> lists=new ArrayList<>();
        //List<List<Integer>> lists=new ArrayList<>();
        for(int k= nums.length-1;k>=0;k--){
            //List<Integer> a=new ArrayList<>();
            for(int i=0;i<k;i++){
                if(hm.containsKey(-nums[k]-nums[i])){
                    List<Integer> a=new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[k]);
                    a.add(-nums[k]-nums[i]);
                    lists.add(a);

                }
               hm.put(nums[i],i);
            }

        }
        return lists  ;
            }

        }


