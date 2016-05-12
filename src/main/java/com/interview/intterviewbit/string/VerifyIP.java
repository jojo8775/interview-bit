package com.interview.intterviewbit.string;

import java.util.ArrayList;
import java.util.List;

public class VerifyIP
{
	public List<String> findIPs(String s){
		List<List<String>> resultList = new ArrayList<List<String>>();
		findIPs(resultList, new ArrayList<String>(), 0, s);
		
		List<String> ips = new ArrayList<String>();
		for(List<String> ip : resultList){
			StringBuilder sb = new StringBuilder();
			sb.append(ip.get(0));
			for(int i=1; i<ip.size(); i++){
				sb.append(".").append(ip.get(i));
			}
			ips.add(sb.toString());
		}
		
		return ips;
	}
	
	private void findIPs(List<List<String>> resultList, List<String> ip, int start, String s){
		if(ip.size() == 4 && start < s.length()){
			return;
		}
		
		if(ip.size() == 4 && start==s.length()){
			List<String> result = new ArrayList<String>(ip);
			resultList.add(result);
			return;
		}
		
		for(int i=1; i<=3; i++){
			if(start + i > s.length()){
				return;
			}
			
			String sub = s.substring(start, start+i);
			
			if(Integer.valueOf(sub) > 255){
				return;
			}
			
			ip.add(sub);
			findIPs(resultList, ip, start + i, s);
			ip.remove(ip.size() - 1);
		}
	}
	
	public static void main(String[] args){
		List<String> ips = new VerifyIP().findIPs("25525511135");
		
		System.out.println(ips.size());
	}
}
