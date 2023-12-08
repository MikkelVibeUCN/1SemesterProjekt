package controller;
import model.*;

public class SalesAssistantController {
	private SalesAssistantContainer salesAssistantContainer;
	
	
	public SalesAssistantController(){
		salesAssistantContainer = SalesAssistantContainer.getInstance();
	}
	
	public SalesAssistant findSalesAssistant(int employeeID) {
		SalesAssistant salesAssistant = salesAssistantContainer.findSalesAssistant(employeeID);
		return salesAssistant;
	}
	}

