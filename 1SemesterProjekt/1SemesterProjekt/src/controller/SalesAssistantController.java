package controller;
import model.SalesAssistant;
import model.SalesAssistantContainer;

public class SalesAssistantController {
	private SalesAssistantContainer salesAssistantContainer;
	
	
	public SalesAssistantController(){
		salesAssistantContainer = SalesAssistantContainer.getInstance();
	}
	
	public SalesAssistant findSalesAssistant(int employeeID) {
		return salesAssistantContainer.findSalesAssistant(employeeID);
	}
}