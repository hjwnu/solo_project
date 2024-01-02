package project2.HRService.domain.organization.employee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project2.HRService.global.generic.BaseEntity;

@Entity
@Getter
@Setter
public class EmployeeRole extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
