package project2.HRService.domain.organization.department.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import project2.HRService.domain.organization.department.entity.QDepartment;

public interface DepartmentCustomRepository {
    String findDepartmentNameByName(String name);
}

class DepartmentCustomRepositoryImpl implements DepartmentCustomRepository {

    private final JPAQueryFactory queryFactory;

    public DepartmentCustomRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    public String findDepartmentNameByName(String name) {
        QDepartment department = QDepartment.department;
        return queryFactory.select(department.name)
                .from(department)
                .where(department.name.eq(name))
                .fetchOne();
    }
}
