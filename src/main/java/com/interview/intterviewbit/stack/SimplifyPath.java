package com.interview.intterviewbit.stack;

import java.util.Stack;

public class SimplifyPath
{
	public String simplifyPath(String a) {
	    if(a.length() > 0 && a.charAt(a.length() - 1) == '/'){
	        a = a.substring(0,a.length()-1);
	    }
	    
	    Stack<String> stack = new Stack<String>();
	    int start = 0, back=0;
	    for(int i=0; i<a.length(); i++){
	        if(a.charAt(i) == '/'){
	            stack.push(a.substring(start, i));
                start = i;
	        }
	        else if(i == a.length()-1) {
	            stack.push(a.substring(start));
	        }
	    }
	    
	    Stack<String> stack2 = new Stack<String>();
	    while(!stack.isEmpty()){
	        String str = stack.pop();
	        if(str.equals("/") || str.equals("/.") || str.isEmpty()){
	            //do nothing 
	            continue;
	        }
	        
	        if(str.equals("/..")){
	            back++;
	        }
	        else{
	            if(back>0){
	                back--;
	            }
	            else{
	                stack2.push(str);
	            }
	        }
	    }
	    
	    if(stack2.isEmpty()){
	        return "/";
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    while(!stack2.isEmpty()){
	        sb.append(stack2.pop());
	    }
	    
	    return sb.toString();
	}
	
	public static void main(String[] args){
		String s = new SimplifyPath().simplifyPath("/.");
		System.out.println(s);
	}
}
