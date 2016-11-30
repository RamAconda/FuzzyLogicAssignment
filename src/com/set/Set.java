package com.set;

import java.util.ArrayList;
import java.util.Scanner;

public class Set {
	private boolean type;
	private String name;
	private ArrayList<Double> boundries;
	
	public boolean getType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Double> getBoundries() {
		return boundries;
	}
	public void setBoundries() {
		Scanner in = new Scanner(System.in);
		for(int i = 0 ; i < 3 ; i++)
			boundries.add(in.nextDouble());
		if(type == true)
			boundries.add(in.nextDouble());
	}
	
	
	
	public double membership(double value){
		if(type == true) //trapezoidal
			return trapMem(value);
		else  //triangle
			return triMem(value);
	}
	
	private double triMem(double value) {
		if(value == boundries.get(1))
			return 1.0;
		if(value > boundries.get(0) && value < boundries.get(1))
			return (value-boundries.get(0))/(boundries.get(1)-boundries.get(0));
		if(value > boundries.get(1) && value < boundries.get(2))
			return (boundries.get(2)-value)/(boundries.get(2)-boundries.get(1));
		return 0.0;
	}
	
	private double trapMem(double value) {
		if(value >= boundries.get(1) && value <= boundries.get(2))
			return 1.0;
		if(value > boundries.get(0) && value < boundries.get(1))
			return (value - boundries.get(0))/(boundries.get(1)-boundries.get(0));
		if(value > boundries.get(2) && value < boundries.get(3))
			return (boundries.get(3)-value)/(boundries.get(3)-boundries.get(2));
		return 0.0;
	}
	

	public void makeSet(){
		Scanner in = new Scanner(System.in);
		setName(in.next());
		String ty = in.next();
		if(ty == "triangle") setType(false);
		else setType(true);
		setBoundries();
		
	}
}
