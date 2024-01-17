package hot100;

import static java.lang.Math.*;

/*给定一个长度为 n 的整数数组 height 。

有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。*/
public class N11 {
    public static void main(String[] args) {
//最大储水量由高min(height(i1,i2))和底abs(i2-i1)决定
// s=(height[r]-height[l])*(l-r)
//考虑两个指针从左右向中间移动，但是满足什么条件需要移动呢？
//比较s，移动后更新s
//存在一个问题，两个指针理论上是不应该同时移动的，先动哪一个？
//谁矮谁动，矮的那边作为边界的最大值已经被记录，移动高的没有意义，移动矮的，让矮这边有机会成为边界值。

int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println(n11(arr));
    }
    public static int n11(int[] height){
        int l=0,r=height.length-1;
        int s=0;
       while(r>=l){
           int s_cur=min(height[r],height[l])*(r-l);
           s=max(s,s_cur);
if(height[l]>height[r])r--;
else l++;
       }
       return  s;
    }
}
