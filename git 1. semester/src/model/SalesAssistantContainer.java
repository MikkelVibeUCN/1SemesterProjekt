package model;

import java.util.ArrayList;

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
		boolean found = false;
		int i = -1;
		while(!found && ++i < salesAssistants.size()) {
			SalesAssistant currentSalesAssistant = salesAssistants.get(i);
			int id = currentSalesAssistant.getID();
			if(i != 0 && id < salesAssistants.get(i+1).getID() &&
					id > salesAssistants.get(i-1).getID()) {
				salesAssistants.add(i, currentSalesAssistant);
			}
		}
	}
	
	
	public static void main(String[] args) {
		SalesAssistantContainer container = SalesAssistantContainer.getInstance();
		
		

	}
	
}
