package project2.HRService.domain.organization.employee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project2.HRService.domain.organization.department.entity.DepartmentEmployee;
import project2.HRService.domain.organization.employee.service.layer2.EmployeeCrudService;
import project2.HRService.global.generic.BaseEntity;
import project2.HRService.global.utils.BeanUtils;

import java.util.List;

@Entity
@Table(name = "employee")
@Getter@Setter
public class Employee  extends BaseEntity {
    @Id
    Long id;
    @Column(nullable = false)
    private String corporation;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status type;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<DepartmentEmployee> departmentEmployees;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<EmployeeRole> employeeRoles;

    public enum Status {
        PERMANENT, CONTRACT, PART_TIME, INTERN, TEMPORARY
    }

    public void addDepartmentEmployee(DepartmentEmployee departmentEmployee) {
        this.departmentEmployees.add(departmentEmployee);
    }
    public void removeDepartmentEmployee(DepartmentEmployee departmentEmployee) {
        this.departmentEmployees.remove(departmentEmployee);
    }
    @PrePersist
    public void onPrePersist() {
        if (this.id == null) {
            EmployeeCrudService crudService = BeanUtils.getBean(EmployeeCrudService.class);
            this.id = crudService.generateId();
        }
    }

}
