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
	
}
