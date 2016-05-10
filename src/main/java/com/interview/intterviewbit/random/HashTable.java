package com.interview.intterviewbit.random;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K,V>
{
	private static final int MOD = 128;
	private Object[] table = new Object[MOD];
	private int size = 0;
	
	public void put(K key, V val){
		if(key == null){
			throw new IllegalArgumentException("Key cannot be null");
		}
		
		int index = key.hashCode() % MOD;
		if(table[index] == null){
			table[index] = new ArrayList<Entry<K, V>>();
		}
		
		List<Entry<K,V>> entries = (List<Entry<K,V>>)table[index];
		
		boolean entryExists = false;
		for(Entry<K, V> entry : entries){
			if(entry.key.equals(key)){
				entry.val = val;
				entryExists = true;
				break;
			}
		}
		
		if(!entryExists){
			entries.add(new Entry<K, V>(key, val));
			size++;
		}
	}
	
	public V get(K key){
		if(key ==null){
			throw new IllegalArgumentException("Key cannot be null");
		}
		
		int index = key.hashCode() % MOD;
		if(table[index] == null){
			return null;
		}
		
		List<Entry<K,V>> entries = (List<Entry<K,V>>)table[index];
		for(Entry<K,V> entry : entries){
			if(entry.key.equals(key)){
				return entry.val;
			}
		}
		
		return null;
	}
	
	public boolean remove(K key){
		if(key ==null){
			throw new IllegalArgumentException("Key cannot be null");
		}
		
		int index = key.hashCode() % MOD;
		if(table[index] == null){
			return false;
		}
		
		List<Entry<K,V>> entries = (List<Entry<K,V>>) table[index];
		
		int removeIndex = -1;
		for(int i=0; i<entries.size(); i++){
			if(entries.get(i).key.equals(key)){
				removeIndex = i;
				break;
			}
		}
		
		if(removeIndex == -1){
			return false;
		}
		
		entries.remove(removeIndex);
		size--;
		return true;
	}
	
	public int getSize(){
		return size;
	}
	
	public static void main(String[] args){
		HashTable<String, Long> hashTable = new HashTable<String, Long>();
		hashTable.put("Jeebs", 101L);
		hashTable.put("John", 101L);
		
		System.out.println(hashTable.getSize());
		System.out.println(hashTable.get("Jeebs"));
		
		hashTable.put("Jeebs", 201L);
		System.out.println(hashTable.get("Jeebs"));
		
		hashTable.remove("Jeebs");
		System.out.println(hashTable.get("Jeebs"));
		System.out.println(hashTable.get("John"));
		
		System.out.println(hashTable.getSize());
	}
	
	private static class Entry<K,V>{
		public K key;
		public V val;
		
		public Entry(K key, V val){
			this.key = key;
			this.val = val;
		}
	}
}
