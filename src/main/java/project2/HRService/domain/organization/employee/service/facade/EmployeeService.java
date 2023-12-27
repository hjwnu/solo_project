package project2.HRService.domain.organization.employee.service.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project2.HRService.domain.organization.department.entity.Department;
import project2.HRService.domain.organization.department.entity.DepartmentEmployee;
import project2.HRService.domain.organization.department.service.CRUD.DepartmentCrudService;
import project2.HRService.domain.organization.department.service.CRUD.DepartmentEmployeeService;
import project2.HRService.domain.organization.employee.dto.EmployeeDto;
import project2.HRService.domain.organization.employee.entity.Employee;
import project2.HRService.domain.organization.employee.entity.Role;
import project2.HRService.domain.organization.employee.mapper.EmployeeMapper;
import project2.HRService.domain.organization.employee.service.CRUD.EmployeeCrudService;
import project2.HRService.domain.organization.employee.service.CRUD.RoleService;

import java.util.ArrayList;
import java.util.List;

@Service @Slf4j
public class EmployeeService {
    private final EmployeeCrudService crudService;
    private final RoleService roleService;
    private final DepartmentCrudService departmentCrudService;
    private final DepartmentEmployeeService departmentEmployeeService;
    private final EmployeeMapper mapper;

    public EmployeeService(EmployeeCrudService crudService, RoleService roleService, DepartmentCrudService departmentCrudService, DepartmentEmployeeService departmentEmployeeService, EmployeeMapper mapper) {
        this.crudService = crudService;
        this.roleService = roleService;
        this.departmentCrudService = departmentCrudService;
        this.departmentEmployeeService = departmentEmployeeService;
        this.mapper = mapper;
    }

    @Transactional
    public EmployeeDto.ResponseDto createEmployee(EmployeeDto.PostDto postDto) {
        // 부서 및 역할 조회
        Employee employee = createAndSaveEmployee(postDto);
        return mapper.entityToResponseDto(employee);
    }

    private Employee createAndSaveEmployee(EmployeeDto.PostDto postDto) {
        Department department = departmentCrudService.findByName(postDto.getDepartment());
        Role role = roleService.findByName(postDto.getRole());

        // 직원 엔티티 생성
        Employee employee = mapper.postDtoToEntity(postDto);

        // DepartmentEmployee 관계 설정 및 저장
        DepartmentEmployee departmentEmployee =
                departmentEmployeeService.setRelation(new DepartmentEmployee(), employee, department, role);

        linkDepartmentAndEmployee(department, employee, departmentEmployee);

        departmentCrudService.save(department); // 부서에 직원 추가
        crudService.save(employee); // 직원 저장
        departmentEmployeeService.save(departmentEmployee); // 부서-직원 관계 저장

        return employee;
    }

    private void linkDepartmentAndEmployee(Department department, Employee employee, DepartmentEmployee departmentEmployee) {
        List<DepartmentEmployee> list = new ArrayList<>();
        list.add(departmentEmployee);
        employee.setDepartmentEmployees(list);

        department.setDepartmentEmployees(list);
    }
}