package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.variable.Variable;
 
public class MainClass {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int varNum = in.nextInt();
		Variable var = null;
		ArrayList<Variable> vars = new ArrayList<>();
		HashMap<String, HashMap<String, Double>> memberships = new HashMap<>();
		HashMap<String , Double> membership;
		for (int i = 0; i < varNum; i++) {
			var = new Variable();
			var.makeVariable();
			vars.add(var);
			memberships.put(var.getName(), var.getMembership());
		}
		var = new Variable();
		var.makeOutVar();
		int ruleNum = in.nextInt();
		for (int i = 0; i < ruleNum; i++) {
			in = new Scanner(System.in);
			String ruleForm = in.nextLine();
			String[] ruleParts = ruleForm.split(" ");
			Double mem1 , mem2 , mem;
			String varName=ruleParts[1];
			membership = memberships.get(varName);
			mem1 = membership.get(ruleParts[3]);
			String operator = ruleParts[4];
			varName=ruleParts[5];
			membership = memberships.get(varName);
			mem2 = membership.get(ruleParts[7]);
			if(operator.equals("AND"))
				mem = Math.min(mem1 , mem2);
			else mem = Math.max(mem1, mem2);
			var.addMembership(ruleParts[ruleParts.length-1], mem);
//			for(int j = 1 ; j < ruleParts.length ; j++){
//				
//			}
		}
		Double output = var.outputDefuzzification();
		System.out.println(output);
 
	}
 
}