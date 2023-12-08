package model;

import java.util.ArrayList;
import java.util.Scanner;

public class SalesAssistantContainer {
	private ArrayList<SalesAssistant> salesAssistants;
	private static SalesAssistantContainer instance;
	
	private SalesAssistantContainer() {
		salesAssistants = new ArrayList<>();
	}
	
	public static SalesAssistantContainer getInstance() {
		if(instance == null) {
			instance = new SalesAssistantContainer();
		}
		return instance;
	}

	public ArrayList<SalesAssistant> getList() {
		return salesAssistants;
	}
	
	public SalesAssistant findSalesAssistant(int employeeID) {
		SalesAssistant result = null; 
		
		boolean found = false;
		int start = 0;
		int end = salesAssistants.size();
		int middle = salesAssistants.size()/2;
		while(!found) {
			if(salesAssistants.get(middle).getID() == employeeID) {
				result = salesAssistants.get(middle);
				found = true;
			}
			else if(middle == end) {
				found = true;
			}
			else if(employeeID > salesAssistants.get(middle).getID()) {
				start = middle;
				middle = (start+end)/2;
			}
			else if(employeeID < salesAssistants.get(middle).getID()){
				end = middle;
				middle = (start+end)/2;
			}
		}
		return result;
	}
	
	public void addSalesAssistant(SalesAssistant salesAssistant) {
		salesAssistants.add(salesAssistant);
	}
	
//	public void addSalesAssistant(SalesAssistant salesAssistant) {
//		boolean found = false;
//		int i = -1;
//		while(!found && ++i <= salesAssistants.size()) {
//			if(salesAssistants.size() > 0 && i == salesAssistants.size()) {
//				SalesAssistant currentSalesAssistant = salesAssistants.get(i);
//				int id = currentSalesAssistant.getID();
//
//				if(i == 0 && salesAssistant.getID() < id) {
//					salesAssistants.add(0, salesAssistant);
//					found = true;
//				}
//				else if(salesAssistants.get(i-1).getID() > salesAssistant.getID() && salesAssistant.getID() > id) {
//					salesAssistants.add(i, salesAssistant);
//					found = true;
//				}
//			}
//			else {
//				salesAssistants.add(salesAssistant);
//				found = true;
//			}	
//		}
//	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		SalesAssistantContainer container = SalesAssistantContainer.getInstance();
		
		for(int i = 0; i < 100; i++) {
			SalesAssistant newAssistant = new SalesAssistant("swagman", "sejemail", "vesterbro", "sdasaaa", 5);
			container.addSalesAssistant(newAssistant);
		}
		
		SalesAssistant newAssistant = new SalesAssistant("swagman", "sejemail", "vesterbro", "sdasaaa", 5);
		container.addSalesAssistant(newAssistant);
		
		container.findSalesAssistant(45);
		
		keyboard.next();

	}
	
}
