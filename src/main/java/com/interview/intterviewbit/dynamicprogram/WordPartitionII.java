package com.interview.intterviewbit.dynamicprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given

s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].
A solution is
 [ "cats and dog", "cat sand dog" ] 
 * @author jojo
 *
 */
public class WordPartitionII
{
	public List<String> wordBreak(String a, List<String> b) {
        //setting up dictionary
        Set<String> dict = new HashSet<String>(b);
        
        ArrayList<String>[] dp = new ArrayList[a.length() + 1];
        dp[0] = new ArrayList<String>();
        
        for(int i=0; i<a.length(); i++){
            //Skipping index which does not have a word
            if(dp[i] == null){
                continue;
            }
            
            for(int j=i+1; j<=a.length(); j++){
                if(dict.contains(a.substring(i,j))){
                    if(dp[j] == null){
                        dp[j] = new ArrayList<String>();
                    }
                    
                    dp[j].add(a.substring(i,j));
                }
            }
        }
        
        //checking if a sentence could be constructed 
        if(dp[dp.length - 1] == null){
            return new ArrayList<String>();
        }
        
        ArrayList<String> result = new ArrayList<String>();
        dfs(result, new ArrayList<String>(), a.length(), dp);
        Collections.sort(result);
        
        return result;
	}
	
	private void dfs(ArrayList<String> result, ArrayList<String> temp, int end, ArrayList<String>[] dp){
	    //base case
	    if(end <= 0){
	        StringBuilder sb = new StringBuilder();
	        sb.append(temp.get(temp.size() - 1));
	        
	        for(int i = temp.size() - 2; i>=0; i--){
	            sb.append(" ").append(temp.get(i));
	        }
	        
	        result.add(sb.toString());
	        return;
	    }
	    
	    for(String word : dp[end]){
	        temp.add(word);
	        dfs(result, temp, end - word.length(), dp);
	        temp.remove(temp.size() - 1);
	    }
	}	
	public static void main(String[] args){
		List<String> dic = Arrays.asList("cat", "cats", "sand", "and", "dogs");
		List<String> result = new WordPartitionII().wordBreak("catsanddogs", dic);
		
		System.out.println(result.size());
	}
}
