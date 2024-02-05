package algorithm;
/**
 * 递归的学习
 */

import javax.sound.midi.InvalidMidiDataException;
import java.util.Arrays;
public class recursion {
    public static void main(String[] args) {
        int arr[]={1,8,5,9,4,2,3,5,7};
/*        Integer res = findLarge(arr, 0, arr.length - 1);
        System.out.println(res);*/
        mergerSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
/*    public static Integer findLarge(int[]arr,int left,int right){
        if (left==right)return arr[left];
        int mid=(left+right)/2;
        int lr=findLarge(arr,left,mid);
        int rr=findLarge(arr,mid+1,right);
        return Math.max(lr,rr);
    }*/
    public static void mergerSort(int[] arr,int l,int r){
        if(l==r)return;//递归终止条件;

        int mid=(l+r)/2;
        mergerSort(arr,l,mid);//左边排好
        mergerSort(arr,mid+1,r);//右边排好
        //合并
        mergeTwo(arr,l,mid,r);
    }
    public static void mergeTwo(int[] arr,int l,int mid,int r) {
        //怎么合并有序数组？
        int lp = l;
        //m = (l + r) / 2;
        int rp = mid + 1;
        int[] temp = new int[r - l + 1];
        int index = 0;
        while (lp <= mid && rp <= r) {
            /*if(arr[lp]<=arr[rp]){
                temp[index]=arr[lp];
                lp++;
            }
            else {
                temp[index]=arr[rp];
                rp++;
            }
            index++;*/
            //代码优化
            temp[index++] = arr[lp] <= arr[rp] ? arr[lp++] : arr[rp++];
        }
            //有任意一个指针走到终点循环都会中止，直接把另一节剩下的数放后面就行了
        while (lp<=mid){
            temp[index++]=arr[lp++];
        }
        while (rp<=r){
            temp[index++]=arr[rp++];
        }
        //现在temp临时数组放的是有序的，我想让arr数组对应的位置变成temp里有序的
        //即将temp刷回去
        //注意此时arr的边界是l和r，这是大问题下的子问题；
        for (int i = 0; i < index; i++) {
            arr[l++]=temp[i];
        }
    }

        }


