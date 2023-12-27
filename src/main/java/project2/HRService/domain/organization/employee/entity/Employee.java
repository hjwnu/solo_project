package project2.HRService.domain.organization.employee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project2.HRService.domain.organization.department.entity.DepartmentEmployee;
import project2.HRService.domain.organization.employee.service.CRUD.EmployeeCrudService;
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

    public enum Status {
        PERMANENT, CONTRACT, PART_TIME, INTERN, TEMPORARY
    }

    @PrePersist
    public void onPrePersist() {
        if (this.id == null) {
            EmployeeCrudService crudService = BeanUtils.getBean(EmployeeCrudService.class);
            this.id = crudService.generate();
        }
    }

}
