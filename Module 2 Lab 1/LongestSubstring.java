import java.util.*;
public class LongestSubstring {
    
    public static String check(char c, String st){
        String s = "";
        int f = 0;
        for(int i=0; i<st.length() ; i++){
            if(f == 1){
                s += st.charAt(i)+"";
            }
            
            if(c == st.charAt(i)){
                f = 1;
            }
        }
        
        if(f == 0){
            s = st+"";
        }
        
        return s;
    }
    
    public static int lengthOfLongestSubstring(String s){
        HashMap<Character, Integer> hm = new HashMap<>();
        String max="";
        String temp="";
        
        for(int i=0 ; i<s.length() ; i++){
            if(!hm.containsKey(s.charAt(i))){
                temp += s.charAt(i)+"";
                hm.put(s.charAt(i),i);
            }
            
            else{
                if(max.length() < temp.length()){
                    max = temp;
                }
                temp = check(s.charAt(i),temp);
                temp += s.charAt(i)+"";
            }
        }
        if(max.length()<temp.length()){
            max = temp;
        }
        return max.length();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int n = lengthOfLongestSubstring(s);
        System.out.println(n);
        input.close();
    }
}
                                                                                                                            