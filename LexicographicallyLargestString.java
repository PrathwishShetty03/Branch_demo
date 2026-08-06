import java.util.*;

public class LexicographicallyLargestString {

    public static void main(String[] args) {

        // String s = "xxxxyxxxxtyahayshssshsbaaaavabaa";
        String s="dfhdf";
        int k = 2;
        System.out.println("Original : "+s);

        String result = largestString(s, k);

        System.out.println(result);
    }
    
    public static String largestString(String s, int k) {
        
        int freq[]=new int[26];
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            freq[c-'a']+=1;
        }
        
        
        int i=25;
        while(i>=0){
            
            if(freq[i]>0){
                int val=Math.min(freq[i],k);

                
                for(int j=0;j<val;j++){
                    sb.append((char)(i+'a'));
                }
                
                
                // System.out.println("k: "+k+" val: "+freq[i]);
                if(freq[i]>k){
                    
                    int idx=i-1;
                    // System.out.println((char)(idx+'a'));
                    while(idx>=0){
                        if(freq[idx]>0){
                            sb.append((char)(idx+'a'));
                            freq[idx]-=1;
                            break;
                        }
                        idx-=1;
                    }
                }
                freq[i]-=val;
            }else{
                i-=1;
            }
        }
        return sb.toString();
    }
}