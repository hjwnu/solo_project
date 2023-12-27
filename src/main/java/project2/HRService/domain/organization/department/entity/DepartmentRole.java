package project2.HRService.domain.organization.department.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project2.HRService.domain.organization.employee.entity.Role;
import project2.HRService.global.generic.BaseEntity;
@Entity
@Getter @Setter
public class DepartmentRole extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
