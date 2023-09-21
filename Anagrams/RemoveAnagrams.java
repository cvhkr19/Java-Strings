package Strings.Anagrams;

import java.util.ArrayList;
import java.util.List;

public class RemoveAnagrams {
    static boolean isAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        int [] hash = new int[26];
        for(int i = 0;i < a.length();i++){
            hash[a.charAt(i) - 'a']++;
            hash[b.charAt(i) - 'a']--;
        }
        for(int i = 0;i < 26;i++){
            if(hash[i] != 0){ // > 0, can fail.
                return false;
            }
        }
        return true;
    }
    static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        for(int i = 0;i < words.length - 1;i++){
            if(!isAnagram(words[i],words[i+1])){
                result.add(words[i+1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String [] words = {"abba","baba","bbaa","cd","cd"};
        System.out.println(removeAnagrams(words));

    }
}
