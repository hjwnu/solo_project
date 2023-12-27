package project2.HRService.domain.organization.department.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDepartmentRole is a Querydsl query type for DepartmentRole
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepartmentRole extends EntityPathBase<DepartmentRole> {

    private static final long serialVersionUID = -390550368L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDepartmentRole departmentRole = new QDepartmentRole("departmentRole");

    public final project2.HRService.global.generic.QBaseEntity _super = new project2.HRService.global.generic.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final QDepartment department;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final project2.HRService.domain.organization.employee.entity.QRole role;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QDepartmentRole(String variable) {
        this(DepartmentRole.class, forVariable(variable), INITS);
    }

    public QDepartmentRole(Path<? extends DepartmentRole> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDepartmentRole(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDepartmentRole(PathMetadata metadata, PathInits inits) {
        this(DepartmentRole.class, metadata, inits);
    }

    public QDepartmentRole(Class<? extends DepartmentRole> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QDepartment(forProperty("department")) : null;
        this.role = inits.isInitialized("role") ? new project2.HRService.domain.organization.employee.entity.QRole(forProperty("role")) : null;
    }

}

