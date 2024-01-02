package project2.HRService.domain.organization.employee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project2.HRService.domain.organization.department.entity.DepartmentRole;
import project2.HRService.global.generic.BaseEntity;

import java.util.List;

@Getter @Setter
@Entity
public class Role extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    @OrderBy
    private Integer rank;

    @OneToMany
    private List<EmployeeRole> employeeRoles;
    @OneToMany
    private List<DepartmentRole> departmentRoles;
    public void addEmployeeRoles(EmployeeRole employeeRole) {
        this.employeeRoles.add(employeeRole);
    }
    public void removeEmployeeRoles(EmployeeRole employeeRole) {
        this.employeeRoles.remove(employeeRole);
    }
    public void addDepartmentRoles(DepartmentRole departmentRole) {
        this.departmentRoles.add(departmentRole);
    }
    public void removeDepartmentRoles(DepartmentRole departmentRole) {
        this.departmentRoles.remove(departmentRole);
    }
}
