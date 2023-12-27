package project2.HRService.domain.organization.department.service.CRUD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import project2.HRService.domain.organization.department.entity.Department;
import project2.HRService.domain.organization.department.dto.*;
import project2.HRService.domain.organization.department.mapper.DepartmentMapper;
import project2.HRService.domain.organization.department.repository.DepartmentRepository;
import project2.HRService.global.generic.GenericCrudService;
import project2.HRService.global.generic.GenericMapper;


@Service
public class DepartmentCrudService
        extends GenericCrudService.GenericCrud<Department, DepartmentDto.PostDto, DepartmentDto.ResponseDto, DepartmentDto.PatchDto, Long> {
    private final DepartmentRepository repository;

    private final DepartmentMapper mapper;

    public DepartmentCrudService(DepartmentRepository repository,DepartmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void establishDepartment(DepartmentDto.PostDto postDto) {
        //스케줄링을 통한 부서생성예약
    }

    @Override
    protected JpaRepository<Department, Long> getRepository() {
        return repository;
    }
    @Override
    protected GenericMapper<Department, DepartmentDto.PostDto, DepartmentDto.ResponseDto, DepartmentDto.PatchDto, Long> getMapper(){return mapper;}


    @Override
    protected void setId(Department newEntity, Long departmentId) {
        newEntity.setId(departmentId);
    }

    public Department findByName(String name) {
        return repository.findByName(name);
    }

}
