package project2.HRService.domain.organization.department.entity;

import lombok.*;
import project2.HRService.domain.organization.employee.entity.Employee;
import jakarta.persistence.*;
import project2.HRService.domain.organization.employee.entity.Role;
import project2.HRService.global.generic.BaseEntity;
@Entity
@Getter@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentEmployee extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public DepartmentEmployee setRelation(Employee employee, Department department){
        this.department = department;
        this.employee = employee;
        return this;
    }

    public DepartmentEmployee setRelation(Employee employee, Department department, Role role){
        this.department = department;
        this.employee = employee;
        this.role = role;
        return this;
    }
}

