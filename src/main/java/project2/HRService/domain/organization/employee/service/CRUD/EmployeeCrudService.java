package project2.HRService.domain.organization.employee.service.CRUD;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import project2.HRService.domain.organization.employee.dto.EmployeeDto;
import project2.HRService.domain.organization.employee.entity.Employee;
import project2.HRService.domain.organization.employee.mapper.EmployeeMapper;
import project2.HRService.domain.organization.employee.repository.EmployeeRepository;
import project2.HRService.global.generic.GenericCrudService;
import project2.HRService.global.generic.GenericMapper;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EmployeeCrudService extends GenericCrudService.GenericCrud<Employee, EmployeeDto.PostDto, EmployeeDto.ResponseDto, EmployeeDto.PatchDto, Long > {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;
    private final EntityManager entityManager;
    public EmployeeCrudService(EmployeeRepository repository, EmployeeMapper mapper, EntityManager entityManager) {
        this.repository = repository;
        this.mapper = mapper;
        this.entityManager = entityManager;

    }

    @Override
    protected JpaRepository<Employee, Long > getRepository() { return repository; }

    @Override
    protected void setId(Employee newEntity, Long id) { newEntity.setId(id); }

    @Override
    public GenericMapper<Employee,
            EmployeeDto.PostDto,
            EmployeeDto.ResponseDto, EmployeeDto.PatchDto, Long > getMapper() {  return mapper; }

    public synchronized Long generate() {
        ZonedDateTime thisMonth = ZonedDateTime.now();
        String datePart = thisMonth.format(DateTimeFormatter.ofPattern("yyMM"));
        int countToday = getCountOfEmployeesJoinedToday(thisMonth, entityManager);
        return Long.parseLong(datePart + String.format("%03d", countToday + 1));
    }

    private int getCountOfEmployeesJoinedToday(ZonedDateTime date, EntityManager entityManager) {
        LocalDate localDate = date.toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();

        // 이번 달에 입사한 직원 수 카운팅
        String jpql = "SELECT COUNT(e) FROM Employee e WHERE FUNCTION('YEAR', e.createdAt) = :year AND FUNCTION('MONTH', e.createdAt) = :month";
        Query query = entityManager.createQuery(jpql);

        Long count = (Long) query.setParameter("year", year)
                .setParameter("month", month)
                .getSingleResult();
        return count.intValue();
    }

}
