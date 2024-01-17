package hot100;

import java.util.HashMap;
import java.util.Map;

public class N1 {
    public static void main(String[] args) {
            int nums[]={3,3};
            int target=6;
        int[] ints = n1(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public  static int[] n1(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();//键存key，值存索引
        //int temp=0;
        int[] a=new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                a[0]=map.get(target-nums[i]);
                a[1]=i;
            }
            map.put(nums[i],i);
        }
        return a;
    }
}
