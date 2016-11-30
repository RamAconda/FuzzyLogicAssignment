package com.variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.set.Set;

public class Variable {
	private String name ;
	private double value;
	private ArrayList<Set> sets;
	private HashMap<String , Double> membership;
	
	public Variable(){
		membership = new HashMap<>();
		sets = new ArrayList<>();
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, Double> getMembership() {
		return (HashMap<String, Double>) membership.clone();
	}
	
	public void addMembership(String setName , Double mem){
		membership.put(setName, mem);
	}
	public Double getMembership(String setName){
		return membership.get(setName);
	}
	
	public void setSets() {
		Scanner in = new Scanner(System.in);
		int setN = in.nextInt();
		for(int i = 0 ; i < setN ; i++){
			Set set = new Set();
			set.makeSet();
			sets.add(set);
		}
	}
	
	public void setMembership() {
		String setName ;
		double setMem;
		for(int i = 0 ; i < sets.size();i++){
			setMem = sets.get(i).membership(value);
			setName = sets.get(i).getName();
			membership.put(setName, setMem);
		}
	}
	
	public void makeVariable(){
		Scanner in = new Scanner(System.in);
		setName(in.next());
		//in = new Scanner(System.in);
		setValue(in.nextDouble());
		in = new Scanner(System.in);
		setSets();
		setMembership();
	}
	
	public void makeOutVar() {
		Scanner in = new Scanner(System.in);
		setName(in.next());
		in = new Scanner(System.in);
		setSets();
	}
	
	public Double outputDefuzzification(){
		Double memSum=0.0; // memberships summition 
		Double thePast = 0.0; // البسط بتاع الكسر في المعادله
		for(int i = 0 ; i < sets.size() ; i++){
			String setName = sets.get(i).getName();
			Double setMax = sets.get(i).getMaxBoundry();
			Double setMem = membership.get(setName);
			memSum += setMem;
			thePast += setMax*setMem;
		}
		return thePast/memSum;
	}
}
