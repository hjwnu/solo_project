package project2.HRService.domain.organization.department.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project2.HRService.domain.organization.department.service.CRUD.DepartmentCrudService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentCrudService departmentService;
    private  final HttpStatus ok = HttpStatus.OK;
//    @PatchMapping("/{id}")
//    public ResponseEntity<SingleResponseDto<DepartmentDto.ResponseDto>> patchDepartment(@PathVariable("id") @Positive long id,
//                                                                                        @Valid @RequestBody DepartmentDto.PatchDto patchDto){
//        SingleResponseDto<DepartmentDto.ResponseDto> responses = new SingleResponseDto<>(departmentService.update(id, patchDto),ok);
//        return new ResponseEntity<>(responses, ok);
//    }
}
