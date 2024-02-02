package hot100;
/**
 *  反转字符串
 *
 */
public class N344 {
    public void reverseString(char[] s){
        int r= s.length-1;
        int l=0;
        while (r>=l){
            swap(s,l,r);
            r--;
            l++;
        }
    }
    public void swap(char[] s,int l,int r){
        char temp=s[l];
        s[l]=s[r];
        s[r]=temp;
    }
}
