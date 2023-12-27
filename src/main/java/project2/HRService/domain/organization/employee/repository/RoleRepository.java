package project2.HRService.domain.organization.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project2.HRService.domain.organization.employee.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
