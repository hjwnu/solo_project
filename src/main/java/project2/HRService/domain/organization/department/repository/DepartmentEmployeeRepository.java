package project2.HRService.domain.organization.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.HRService.domain.organization.department.entity.DepartmentEmployee;

public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployee, Long> {
//    @Query("SELECT de FROM DepartmentEmployee de WHERE de.department.id = :departmentId AND de.role = 'Lead'")
//    Optional<DepartmentEmployee> findCurrentHead(@Param("departmentId") Long departmentId);
}
