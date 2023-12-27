package project2.HRService.domain.organization.employee.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import project2.HRService.domain.organization.employee.entity.QRole;

public interface RoleCustomRepository {
    String findNameByName(String name);
    class RoleCustomRepositoryImpl implements RoleCustomRepository{
        private final JPAQueryFactory queryFactory;

        RoleCustomRepositoryImpl(JPAQueryFactory queryFactory) {
            this.queryFactory = queryFactory;
        }

        public String findNameByName(String name) {
            QRole role = QRole.role;
            return queryFactory.select(role.name)
                    .from(role)
                    .where(role.name.eq(name))
                    .fetchOne();
        }
    }

}