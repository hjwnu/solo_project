package project2.HRService.domain.organization.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.HRService.domain.organization.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
