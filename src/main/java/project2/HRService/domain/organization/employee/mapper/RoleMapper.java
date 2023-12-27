package project2.HRService.domain.organization.employee.mapper;

import org.mapstruct.Mapper;
import project2.HRService.domain.organization.employee.dto.RoleDto;
import project2.HRService.domain.organization.employee.entity.Role;
import project2.HRService.global.generic.GenericMapper;
@Mapper(componentModel = "spring")
public interface RoleMapper extends GenericMapper<Role, RoleDto.PostDto, RoleDto.ResponseDto, RoleDto.PatchDto, Long> {
}
