package project2.HRService.domain.organization.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.HRService.domain.organization.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByName(String name);
}

