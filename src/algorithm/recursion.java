package algorithm;
/**
 * 递归的学习
 */

import java.util.Arrays;
public class recursion {
    public static void main(String[] args) {
        int arr[]={1,8,5,9,4,2,3,5,7};
        Integer res = findLarge(arr, 0, arr.length - 1);
        System.out.println(res);
    }
    public static Integer findLarge(int[]arr,int left,int right){
        if (left==right)return arr[left];

        int mid=(left+right)/2;
        int lr=findLarge(arr,left,mid);
        int rr=findLarge(arr,mid+1,right);

        return Math.max(lr,rr);
    }
    public static void mergerSort(int[] arr,int l,int r){
        if(l==r)return;//递归终止条件;

        int mid=(l+r)/2;
        mergerSort(arr,l,mid);//左边排好
        mergerSort(arr,mid+1,r);//右边排好


    }
}
