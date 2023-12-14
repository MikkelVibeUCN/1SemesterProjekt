package controller;
import model.SalesAssistant;
import model.SalesAssistantContainer;

/**
 * SalesAssistantController handles everything to do with salesassistants
 * @author gruppe-1
 */

public class SalesAssistantController {
	private SalesAssistantContainer salesAssistantContainer;
	
	
	public SalesAssistantController(){
		salesAssistantContainer = SalesAssistantContainer.getInstance();
	}
	
	public SalesAssistant findSalesAssistant(int employeeID) {
		return salesAssistantContainer.findSalesAssistant(employeeID);
	}
}