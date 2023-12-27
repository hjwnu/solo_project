package project2.HRService.domain.organization.department.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDepartment is a Querydsl query type for Department
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepartment extends EntityPathBase<Department> {

    private static final long serialVersionUID = 477318410L;

    public static final QDepartment department = new QDepartment("department");

    public final project2.HRService.global.generic.QBaseEntity _super = new project2.HRService.global.generic.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final ListPath<DepartmentEmployee, QDepartmentEmployee> departmentEmployees = this.<DepartmentEmployee, QDepartmentEmployee>createList("departmentEmployees", DepartmentEmployee.class, QDepartmentEmployee.class, PathInits.DIRECT2);

    public final ListPath<DepartmentRole, QDepartmentRole> departmentRoles = this.<DepartmentRole, QDepartmentRole>createList("departmentRoles", DepartmentRole.class, QDepartmentRole.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.ZonedDateTime> establishDate = createDateTime("establishDate", java.time.ZonedDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final EnumPath<Department.Status> status = createEnum("status", Department.Status.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QDepartment(String variable) {
        super(Department.class, forVariable(variable));
    }

    public QDepartment(Path<? extends Department> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDepartment(PathMetadata metadata) {
        super(Department.class, metadata);
    }

}

