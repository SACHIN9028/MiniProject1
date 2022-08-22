package in.sachinit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sachinit.entity.Plan;
import in.sachinit.entity.PlanCategory;
import in.sachinit.repo.PlanCategoryRepo;
import in.sachinit.repo.PlanRepo;
@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepo planRepo;
	@Autowired
	private PlanCategoryRepo planCategoryRepo;
	@Override
	public Map<Integer, String> getPlanCategories() {
		// TODO Auto-generated method stub
		List<PlanCategory> categories = planCategoryRepo.findAll();
		Map<Integer,String> categoryMap=new HashMap<>();//logic to convert List to Map
		categories.forEach(category ->{
			categoryMap.put(category.getCategoryId(),category.getCategoryName());
		});
		
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		// TODO Auto-generated method stub
	           Plan save = planRepo.save(plan);	
		      
		
		return save.getPlanId()!=null;
	}

	@Override
	public Plan getPlanById(Integer planId) {
		// TODO Auto-generated method stub
		Optional<Plan> findById = planRepo.findById(planId);//Optional is container class in that class value may available or may not available you have ti check that
		 if(findById.isPresent()) 
		 {
		   return findById.get();//get the data in editable mode
		 }
		 else  return null;
			
		 
	}

	@Override
	public List<Plan> getAllPlans() {
		// TODO Auto-generated method stub
	    List<Plan> findAll = planRepo.findAll();
		return findAll;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		Plan save = planRepo.save(plan);
		return save.getPlanId()!=null;
		
	}

	@Override
	public boolean deletePlan(Integer PlanId) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
		planRepo.deleteById(PlanId);//return type is void
		flag=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean planstatusChange(Integer planId, String status) {
		// TODO Auto-generated method stub
		Optional<Plan> findById = planRepo.findById(planId);// first fetch the existing data
		if(findById.isPresent())
		{
			Plan plan = findById.get();
			plan.setActiveSw(status);//updating only one column value not everything
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
