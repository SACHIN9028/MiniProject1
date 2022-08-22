package in.sachinit.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sachinit.entity.Plan;
import in.sachinit.service.PlanService;

@RestController
public class PlanRestController {
	@Autowired
	private PlanService planService;
	
	@GetMapping("/category")
	public ResponseEntity<Map<Integer,String>> planCategories()
	{
		Map<Integer, String> categories= planService.getPlanCategories();
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan)
	{
		String responseMsg="";
		boolean isSaved = planService.savePlan(plan);
		    if(isSaved) {
		    	responseMsg="Plan saved";
		    }
		    else
		    	responseMsg="Plan not saved";
		
		return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> viewPlans()
	{
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId)
	{
		Plan planById = planService.getPlanById(planId);
		return new ResponseEntity<>(planById,HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId)
	{
		String responseMsg="";
		boolean isDeleted = planService.deletePlan(planId);
		if(isDeleted)
		{
			responseMsg="Plan deleted";
		}
		else
			responseMsg="plan not deleted";
		return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan)
	{
		String responseMsg="";
		   boolean isUpdated = planService.updatePlan(plan);
		   if(isUpdated)
			{
				responseMsg="Plan Updated";
			}
			else
				responseMsg="plan not Updated";
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		
		
	}
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> planStatusChange(@PathVariable Integer planId,@PathVariable String status)
	{
		String responseMsg="";
		boolean isStatusChange = planService.planstatusChange(planId,status);
		
		if(isStatusChange)
		{
			responseMsg="Plan Status changed";
		}
		else
		    responseMsg="Plan Status not changed";
		    
		return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
	}
	
	
	

}
