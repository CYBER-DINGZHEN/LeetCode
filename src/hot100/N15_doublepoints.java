package hot100;

import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//利用双指针消去无效解。
public class N15_doublepoints {
    public static void main(String[] args) {
        int[] nums ={-1,0,1,2,-1,-4};
        System.out.println(n15_doublepoins(nums));
    }
    public static List<List<Integer>> n15_doublepoins(int[] nums){
        Arrays.sort(nums);
        //固定一个指针指向最小的元素，其他两个指针开始从两侧向中间移动
        List<List<Integer>> lists=new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if(nums[k]>0)break;
            //固定k;移动i，j
            if(k>0&&nums[k]==nums[k-1])continue;//元素相同的话，跳过，不然会得到重复的结果
            int i=k+1;
            int j=nums.length-1;
            while(i<j)
            {
                int s=nums[k]+nums[i]+nums[j];
                //注意，已经排过序了
               if(s<0){
                   while (i<j&&nums[i]==nums[++i]);
               }
               else if(s>0) {
                   while (i<j  && nums[j] == nums[--j]) ;
               }
               else {
                   List<Integer> list=new ArrayList<>();
                   Collections.addAll(list,nums[k],nums[i],nums[j]);
                   lists.add(list);
                   while (i<j&&nums[i]==nums[++i]);
                   while (i<j&&nums[j]==nums[--j]);
               }


            }

        }



return lists;
    }
}
