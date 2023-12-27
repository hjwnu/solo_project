package project2.HRService.domain.organization.department.entity;

import lombok.*;
import project2.HRService.global.converter.ZonedDateTimeConverter;
import jakarta.persistence.*;
import project2.HRService.global.generic.BaseEntity;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter @Setter
@RequiredArgsConstructor @AllArgsConstructor
public class Department extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Convert(converter = ZonedDateTimeConverter.class)
    @Column(nullable = false)
    private ZonedDateTime establishDate;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<DepartmentEmployee> departmentEmployees;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<DepartmentRole> departmentRoles;

    public enum Status {
        ACTIVE, INACTIVE
    }
}

