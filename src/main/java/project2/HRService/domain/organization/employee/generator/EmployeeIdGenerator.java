package project2.HRService.domain.organization.employee.generator;

import jakarta.persistence.EntityManager;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class EmployeeIdGenerator implements IdentifierGenerator {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyMM");
    private final EntityManager entityManager;

    public EmployeeIdGenerator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public synchronized Long generateEmployeeId() {
        ZonedDateTime today = ZonedDateTime.now();
        String datePart = today.format(DATE_FORMATTER);
        int countToday = getCountOfEmployeesJoinedToday(today);
        return Long.parseLong(datePart + String.format("%02d", countToday + 1));
    }

    private int getCountOfEmployeesJoinedToday(ZonedDateTime date) {
        // 데이터베이스에서 오늘 날짜로 시작하는 사번을 가진 직원의 수를 쿼리합니다.
        String jpql = "SELECT COUNT(e) FROM Employee e WHERE e.id LIKE :datePattern";
        Long count = (Long) entityManager.createQuery(jpql)
                .setParameter("datePattern", date.format(DATE_FORMATTER) + "%")
                .getSingleResult();
        return count.intValue();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        return generateEmployeeId();
    }
}