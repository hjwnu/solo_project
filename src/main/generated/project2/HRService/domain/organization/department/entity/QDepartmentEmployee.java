package project2.HRService.domain.organization.department.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDepartmentEmployee is a Querydsl query type for DepartmentEmployee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepartmentEmployee extends EntityPathBase<DepartmentEmployee> {

    private static final long serialVersionUID = -1535119912L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDepartmentEmployee departmentEmployee = new QDepartmentEmployee("departmentEmployee");

    public final project2.HRService.global.generic.QBaseEntity _super = new project2.HRService.global.generic.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final QDepartment department;

    public final project2.HRService.domain.organization.employee.entity.QEmployee employee;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final project2.HRService.domain.organization.employee.entity.QRole role;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QDepartmentEmployee(String variable) {
        this(DepartmentEmployee.class, forVariable(variable), INITS);
    }

    public QDepartmentEmployee(Path<? extends DepartmentEmployee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDepartmentEmployee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDepartmentEmployee(PathMetadata metadata, PathInits inits) {
        this(DepartmentEmployee.class, metadata, inits);
    }

    public QDepartmentEmployee(Class<? extends DepartmentEmployee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QDepartment(forProperty("department")) : null;
        this.employee = inits.isInitialized("employee") ? new project2.HRService.domain.organization.employee.entity.QEmployee(forProperty("employee")) : null;
        this.role = inits.isInitialized("role") ? new project2.HRService.domain.organization.employee.entity.QRole(forProperty("role")) : null;
    }

}

