package com.interview.intterviewbit.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification
{
	public List<String> textJustification(List<String> strList, int len)
	{
		if(strList.isEmpty()){
	        return strList;
	    }
	    
        int beg = 0, end = strList.size() - 1, count = 0;
		
		ArrayList<String> result = new ArrayList<String>();
		
		while(beg <= end){
			int initialBeg = beg;
			int spaceCount = 0;
			count = strList.get(beg).length();
			
			while(beg + 1 <= end && count + 1 + strList.get(beg + 1).length() <= len){
				count += 1 + strList.get(++beg).length();
				spaceCount++;
			}

			int blankSpace = len - count;
			StringBuilder sb = new StringBuilder();
			sb.append(strList.get(initialBeg));
			if(initialBeg == beg){
				while(blankSpace-- > 0){
					sb.append(" ");
				}
			}
			else if(beg == end){
			    for(int i = initialBeg+1; i<=beg; i++){
					sb.append(" ").append(strList.get(i));
				}
				while(blankSpace-- > 0){
					sb.append(" ");
				}
			}
			else{
				int	padding = blankSpace/spaceCount;
				int	extraPaddin = blankSpace%spaceCount;
				for(int i = initialBeg+1; i<=beg; i++){
					sb.append(" ");
					int j=padding; 
					while(j--> 0){
						sb.append(" ");
					}
					if(extraPaddin-- > 0){
						sb.append(" ");
					}
					sb.append(strList.get(i));
				}
			}
			
			beg++;
			result.add(sb.toString());
		}
		
		return result;
	}
	
	public static void main(String[] args){
//		List<String> strList = Arrays.asList("This", "is", "an", "example", "of", "text", "justification.");
		List<String> strList = Arrays.asList("What", "must", "be", "shall", "be.");
		List<String> result = new TextJustification().textJustification(strList, 12);
		print(result);
	}
	
	private static void print(List<String> ll){
		for(String s : ll){
			System.out.println(s);
		}
	}
}
