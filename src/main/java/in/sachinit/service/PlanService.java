package in.sachinit.service;

import java.util.List;
import java.util.Map;

import in.sachinit.entity.Plan;

public interface PlanService {

	
	public Map<Integer,String> getPlanCategories();
	//all the categories should come from database and display in dropdown
	public boolean savePlan(Plan plan);//upsert()method
	//create Plan
	public Plan getPlanById(Integer planId);//to get the record in editable mode
	//particular planid should be display in editable mode
	public List<Plan> getAllPlans();
	//view all plan in table form in page
	//more than one plan
	public boolean updatePlan(Plan plan);//once the record came to editable mode you can update the plan
	
	public boolean deletePlan(Integer PlanId);
	//hard delete
	public boolean planstatusChange(Integer planId,String status);//soft delete 
	
	
}
