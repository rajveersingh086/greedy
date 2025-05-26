package greedy;
import java.util.*;
public class jumpgame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
         int maxreach = 0;
         for (int i=0;i<n;i++){
            if(i>maxreach) return false;
                maxreach = Math.max(maxreach ,i+nums[i]);
            }
         
         return true;
    }
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array :");
        int n = sc.nextInt();
        int []nums = new int[n];
        for (int i = 0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        jumpgame jump = new jumpgame();
        if(jump.canJump(nums)){
            System.out.println("you can reach it");
        }
        else{
            System.out.println("you can not reach it");
        }
    }
}