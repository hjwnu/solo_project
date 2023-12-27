package project2.HRService.domain.organization.department.mapper;

import org.mapstruct.*;
import project2.HRService.domain.organization.department.dto.*;
import project2.HRService.domain.organization.department.entity.Department;
import project2.HRService.global.generic.GenericMapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends GenericMapper<Department, DepartmentDto.PostDto, DepartmentDto.ResponseDto, DepartmentDto.PatchDto, Long> {

    default  DepartmentDto.ResponseDto entityToResponseDto(Department entity) {
        if ( entity == null ) {
            return null;
        }

        DepartmentDto.ResponseDto.ResponseDtoBuilder responseDto = DepartmentDto.ResponseDto.builder();

        responseDto.name( entity.getName() );
        responseDto.status( entity.getStatus() );
        responseDto.establishDate( entity.getEstablishDate() );
        responseDto.headCount(entity.getDepartmentEmployees().size()); // 겸직 포함
        return responseDto.build();
    }
}
