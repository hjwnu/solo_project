package project2.HRService.domain.organization.employee.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmployee is a Querydsl query type for Employee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmployee extends EntityPathBase<Employee> {

    private static final long serialVersionUID = 228587522L;

    public static final QEmployee employee = new QEmployee("employee");

    public final project2.HRService.global.generic.QBaseEntity _super = new project2.HRService.global.generic.QBaseEntity(this);

    public final StringPath corporation = createString("corporation");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final ListPath<project2.HRService.domain.organization.department.entity.DepartmentEmployee, project2.HRService.domain.organization.department.entity.QDepartmentEmployee> departmentEmployees = this.<project2.HRService.domain.organization.department.entity.DepartmentEmployee, project2.HRService.domain.organization.department.entity.QDepartmentEmployee>createList("departmentEmployees", project2.HRService.domain.organization.department.entity.DepartmentEmployee.class, project2.HRService.domain.organization.department.entity.QDepartmentEmployee.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final EnumPath<Employee.Status> type = createEnum("type", Employee.Status.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QEmployee(String variable) {
        super(Employee.class, forVariable(variable));
    }

    public QEmployee(Path<? extends Employee> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployee(PathMetadata metadata) {
        super(Employee.class, metadata);
    }

}

