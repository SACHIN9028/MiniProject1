package in.sachinit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sachinit.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
