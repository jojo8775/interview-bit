package com.interview.intterviewbit.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffK
{
	public int find(List<Integer> list, int k){
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0; i<list.size(); i++){
			int t1 = k + list.get(i);
			int t2 = list.get(i) - k;
			
			if(map.containsKey(t1) || map.containsKey(t2)){
				return 1;
			}
			else{
				map.put(list.get(i), i);
			}
		}
		
		return 0;
	}
}
