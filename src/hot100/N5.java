package hot100;

import javax.sound.midi.Soundbank;
import javax.xml.stream.events.EndDocument;

import java.util.ArrayList;

/**
 * 最长回文字串
 */


public  class N5 {
    public static void main(String[] args) {
        String s="eeeeeeeeeeeeese";
        String s1 = N5.longestPalindrom(s);
        System.out.println(s1);
    }

    public static String longestPalindrom(String s){
        int left=0;
        int right=0;
        String res=null;
        ArrayList<String> ress=new ArrayList<>();
        for( left=0;left<s.length();left++){
            for (right=left;right<s.length();right++){
                String temp = s.substring(left, right + 1);
                if (isPalindrome(s,left,right)){
                    ress.add(temp);
                }
            }
        }
        //System.out.println(ress);
        int temp=0;
        for (String string : ress) {

            if (string.length() > temp) {
                temp = string.length();
                res = string;
            }
        }
        //System.out.println(res);
        return res==null?s.substring(0,1):res;
    }


    public static boolean isPalindrome(String s, Integer start, Integer end){
        if(end-start==1)return false;
        while (start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
