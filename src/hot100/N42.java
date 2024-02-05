package hot100;

public class N42 {
    public static void main(String[] args) {
        int[] h={0,1,0,2,1,0,1,3,2,1,2,1};
        //System.out.println(trap(h));
        System.out.println(trap_doublepoints(h));
    }
    public static int trap(int[] height){
        //rain=min(lmax,rmax)-height
        int len=height.length;
        int sum=0;
        int[] lmax=new int[len];
        lmax[0]=0;
        int[] rmax=new int[len];
        rmax[len-1]=0;

        //这里有个核心思想是，本处的左最大值，只需要前一处的最大值和前一处本身的值进行比较即可。
        for (int i = 1; i < len; i++) {
            lmax[i]=Math.max(lmax[i-1],height[i-1]);
        }
        for (int i = len-2; i >=0 ; i--) {
            rmax[i]=Math.max(rmax[i+1],height[i+1]);
        }
        for(int i=0;i<len;i++){
           // lmax[i]=lmax(height,i);
            //rmax[i]=rmax(height,i);
            int h=Math.min(lmax[i],rmax[i]);
            sum+=h>height[i]?(h-height[i]):0;
        }
        return sum;

    }
    //待修改版，漏洞百出
    public static int trap_doublepoints(int[] height){
         int l=1;
         int r=height.length-2;
         int res=0;
         int lm=height[0];
         int rm=height[r+1];
         //头尾不用管，看h[1],左0高度，右高度一定大于等于h[r]
        //所以只要h[r]>=h[1]左边的，即可记录结果，移动左指针
        while(l<r){

            if(lm<=rm)
            {
                res+=lm>height[l]?lm-height[l]:0;
                lm=Math.max(lm,height[l]);
                l++;
            }
            else
            {
                res+=rm>height[r]?rm-height[r]:0;
                rm=Math.max(rm,height[r]);
                r--;
            }
        }
        return res;
    }
    public static int lmax(int[] arr,int index){
        int res=0;
        if(index==0)return 0;
        for(int i=0;i<index;i++)
            res=Math.max(res,arr[i]);
        return res;
    }
    public static int rmax(int[] arr,int index){
        int res=0;
        if(index==arr.length-1)return 0;
        for(int i=arr.length-1;i>index;i--)
            res=Math.max(res,arr[i]);
        return res;
    }
}

