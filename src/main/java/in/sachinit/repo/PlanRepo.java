package in.sachinit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sachinit.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer>{

}
