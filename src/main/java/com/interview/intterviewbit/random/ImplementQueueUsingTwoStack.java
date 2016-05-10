package com.interview.intterviewbit.random;

import java.util.Stack;

public class ImplementQueueUsingTwoStack<T>
{
	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();
	
	public void enqueue(T val){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		
		stack1.push(val);
		
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
	}
	
	public T deQueue(){
		if(stack1.isEmpty()){
			return null;
		}
		
		return stack1.pop();
	}
	
	public static void main(String[] args){
		ImplementQueueUsingTwoStack<Integer> queue = new ImplementQueueUsingTwoStack<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		for(int i=0; i<6; i++){
			System.out.println(queue.deQueue());
		}
	}
}
