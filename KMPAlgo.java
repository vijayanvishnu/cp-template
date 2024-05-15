
import java.util.*;
class Solution {
    private static int[] lpsComputation(char str[]){
        int i = 0;
        int j = 1;
        int lps[] = new int[str.length];
        while(j < str.length){
            if(str[i] == str[j]){
                i++;
                lps[j] = i;
                j++;
            }else{
                if(i == 0){
                    i = 0;
                    j++;
                }else{
                    i = lps[i - 1];
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        char str[] = "AAACAAAA".toCharArray();
        char ptn[] = "AA".toCharArray();
        int lps[] = lpsComputation(str);
        int i = 0;
        int j = 0;
        while(i < str.length){
            if(str[i] == ptn[j]){
                i++;
                j++;
                if(j == ptn.length){
                    System.out.println("Found At : "+(i-j+1));
                    j = lps[j - 1];
                }
            }else{
                if(j == 0){
                    ++i;
                }else{
                    j = lps[j - 1];
                }
            }
        }
        
    }
}