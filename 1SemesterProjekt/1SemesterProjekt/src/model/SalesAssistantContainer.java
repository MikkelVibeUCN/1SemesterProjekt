package model;

import java.util.ArrayList;
import java.util.Collections;

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
		int end = salesAssistants.size()-1;
		int middle = salesAssistants.size()/2;
		while(!found && middle != end) {
			if(salesAssistants.get(middle).getID() == employeeID) {
				result = salesAssistants.get(middle);
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
}
