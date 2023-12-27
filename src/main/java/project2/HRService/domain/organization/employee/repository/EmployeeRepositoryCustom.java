package project2.HRService.domain.organization.employee.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import project2.HRService.domain.organization.department.entity.QDepartment;
import project2.HRService.domain.organization.department.entity.QDepartmentEmployee;
import project2.HRService.domain.organization.department.entity.QDepartmentRole;
import project2.HRService.domain.organization.employee.entity.Employee;
import project2.HRService.domain.organization.employee.entity.QEmployee;
import project2.HRService.domain.organization.employee.entity.QRole;

import java.util.List;

public interface EmployeeRepositoryCustom {
    List<Employee> findEmployeeByRole(String roleName);

    class CustomImpl implements EmployeeRepositoryCustom {
        private final JPAQueryFactory queryFactory;
        public CustomImpl(EntityManager em) {
            this.queryFactory = new JPAQueryFactory(em);
        }
        @Override
        public List<Employee> findEmployeeByRole(String roleName) {
            QEmployee employee = QEmployee.employee;
            QDepartmentEmployee departmentEmployee = QDepartmentEmployee.departmentEmployee;
            QDepartment department = QDepartment.department;
            QDepartmentRole departmentRole = QDepartmentRole.departmentRole;
            QRole role = QRole.role;

            return queryFactory.select(employee)
                    .join(employee.departmentEmployees, departmentEmployee)
                    .join(departmentEmployee.department, department)
                    .join(department.departmentRoles, departmentRole)
                    .join(departmentRole.role, role)
                    .where(role.name.eq(roleName))
                    .fetch();
        }
    }
}
