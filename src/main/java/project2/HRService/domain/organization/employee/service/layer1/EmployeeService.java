package project2.HRService.domain.organization.employee.service.layer1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project2.HRService.domain.organization.department.entity.Department;
import project2.HRService.domain.organization.department.entity.DepartmentEmployee;
import project2.HRService.domain.organization.department.service.layer2.DepartmentCrudService;
import project2.HRService.domain.organization.department.service.layer2.DepartmentEmployeeService;
import project2.HRService.domain.organization.employee.dto.EmployeeDto;
import project2.HRService.domain.organization.employee.entity.Employee;
import project2.HRService.domain.organization.employee.entity.Role;
import project2.HRService.domain.organization.employee.mapper.EmployeeMapper;
import project2.HRService.domain.organization.employee.service.layer2.EmployeeCrudService;
import project2.HRService.domain.organization.employee.service.layer2.RoleService;

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
        // 부서 조회
        Department department = departmentCrudService.findByName(postDto.getDepartment());
        Role role = roleService.findByName(postDto.getRole());

        // 직원 엔티티 생성
        Employee employee = mapper.postDtoToEntity(postDto);

        // DepartmentEmployee 관계 설정 및 저장
        DepartmentEmployee departmentEmployee = linkDepartmentAndEmployee(department, employee, role);

         employee = crudService.save(employee); // 직원 저장
        departmentEmployeeService.save(departmentEmployee); // 부서-직원 관계 저장
        return mapper.entityToResponseDto(employee);
    }


    private DepartmentEmployee linkDepartmentAndEmployee(Department department, Employee employee, Role role) {
        DepartmentEmployee departmentEmployee =  new DepartmentEmployee().setRelation(employee, department, role);
        employee.addDepartmentEmployee(departmentEmployee);
        department.addDepartmentEmployee(departmentEmployee);
        return departmentEmployee;
    }
}