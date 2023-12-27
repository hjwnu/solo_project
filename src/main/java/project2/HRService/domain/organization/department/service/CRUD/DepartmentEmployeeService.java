package project2.HRService.domain.organization.department.service.CRUD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import project2.HRService.domain.organization.department.dto.DepartmentEmployeeDto;
import project2.HRService.domain.organization.department.entity.Department;
import project2.HRService.domain.organization.department.entity.DepartmentEmployee;
import project2.HRService.domain.organization.department.mapper.DepartmentEmployeeMapper;
import project2.HRService.domain.organization.department.repository.DepartmentEmployeeRepository;
import project2.HRService.domain.organization.employee.entity.Employee;
import project2.HRService.domain.organization.employee.entity.Role;
import project2.HRService.global.generic.GenericCrudService;
import project2.HRService.global.generic.GenericMapper;

@Service
public class DepartmentEmployeeService extends GenericCrudService.GenericCrud<DepartmentEmployee, DepartmentEmployeeDto.PostDto,
        DepartmentEmployeeDto.ResponseDto, DepartmentEmployeeDto.PatchDto, Long> {
    private final DepartmentEmployeeRepository repository;
    private final DepartmentEmployeeMapper mapper;

    public DepartmentEmployeeService(DepartmentEmployeeRepository repository, DepartmentEmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    protected JpaRepository<DepartmentEmployee, Long> getRepository() {
        return repository;
    }
    @Override
    protected void setId(DepartmentEmployee newEntity, Long id) {
        newEntity.setId(id);
    }

    @Override
    protected GenericMapper<DepartmentEmployee, DepartmentEmployeeDto.PostDto,
            DepartmentEmployeeDto.ResponseDto, DepartmentEmployeeDto.PatchDto, Long> getMapper() {
        return mapper;
    }

    public DepartmentEmployee setRelation(DepartmentEmployee entity, Employee employee, Department department, Role role){
        entity.setEmployee(employee);
        entity.setDepartment(department);
        entity.setRole(role);
        return entity;
    }

}
