package project2.HRService.domain.organization.employee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project2.HRService.global.generic.BaseEntity;

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
}
