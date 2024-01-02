package project2.HRService.domain.organization.employee.service.layer2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import project2.HRService.domain.organization.employee.dto.RoleDto;
import project2.HRService.domain.organization.employee.entity.Role;
import project2.HRService.domain.organization.employee.mapper.RoleMapper;
import project2.HRService.domain.organization.employee.repository.RoleRepository;
import project2.HRService.global.generic.GenericCrudService;

import java.util.List;

@Service
public class RoleService extends GenericCrudService.GenericCrud<Role, RoleDto.PostDto, RoleDto.ResponseDto, RoleDto.PatchDto, Long> {
    private final RoleRepository repository;
    private final RoleMapper mapper;

    public RoleService(RoleRepository repository, RoleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    protected JpaRepository<Role, Long> getRepository() {
        return repository;
    }

    @Override
    protected RoleMapper getMapper(){return mapper;}

    @Override
    protected void setId(Role newEntity, Long aLong) {
        newEntity.setId(aLong);
    }

    @Override
    public Role findByName(String str) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }
}
