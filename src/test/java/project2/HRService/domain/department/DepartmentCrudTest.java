//package project2.HRService.domain.department;
//import static org.junit.jupiter.params.provider.Arguments.arguments;
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//import static project2.HRService.domain.organization.department.entity.Department.Status.*;
//
//import jakarta.validation.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import project2.HRService.domain.organization.department.entity.Department;
//import project2.HRService.domain.organization.department.dto.DepartmentDto;
//import project2.HRService.domain.organization.department.mapper.DepartmentMapper;
//import project2.HRService.domain.organization.department.repository.DepartmentRepository;
//import project2.HRService.domain.organization.department.service.CRUD.DepartmentCrudService;
//import project2.HRService.domain.organization.department.service.Layer2.DepartmentGenericCrud;
//import project2.HRService.global.utils.CustomBeanUtils;
//
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Stream;
//
//@ExtendWith(MockitoExtension.class)
//public class DepartmentCrudTest {
//
//    @Mock
//    private DepartmentRepository departmentRepository;
//
//    @Mock
//    private DepartmentMapper departmentMapper;
//
//    @InjectMocks
//    private DepartmentCrudService departmentCrud;
//
//    // 샘플 데이터
//    private Department department;
//    private Department department2;
//    private DepartmentDto.PostDto postDto;
//    private DepartmentDto.PatchDto patchDto;
//    private DepartmentDto.ResponseDto responseDto;
//    private static final ZonedDateTime date = ZonedDateTime.of(2012,3,3,3,6,30,3, ZoneId.of("Asia/Seoul"));
//    private static final Long id = 1L;
//    private Validator validator;
//
//    @BeforeEach
//    void setUpValidator() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }
//    @BeforeEach
//    void setUp() {
//        // 샘플 데이터 초기화
//        department = new Department("HR",null,date,"NAMI");
//        department2 = new Department("dev",ACTIVE,date,"FRANKY");
//        patchDto = new DepartmentDto.PatchDto( "A", ACTIVE, date, "D");
//        postDto = new DepartmentDto.PostDto("HR",ACTIVE,date,"Don");
//        responseDto = new DepartmentDto.ResponseDto("HR","AAA",ACTIVE,date);
//    }
//    @Nested
//    class CreateTest {
//        static Stream<Arguments> validPostDtoProvider() {
//            String[] names = {"HR","Dev","Finance"};
//            Department.Status[] statuses = {ACTIVE, INACTIVE};
//            ZonedDateTime[] dates = {date, ZonedDateTime.now()};
//            String[] heads = {"A","B",null};
//            return  Stream.of(names)
//                            .flatMap(name -> Stream.of(statuses)
//                                    .flatMap(status -> Stream.of(dates)
//                                            .flatMap(date -> Stream.of(heads)
//                                                    .map(head -> arguments(new DepartmentDto.PostDto(name, status, date,head))))));
//        }
//
//        @ParameterizedTest
//        @MethodSource("validPostDtoProvider")
//        void testCreateDepartmentWithVariousParameters(DepartmentDto.PostDto postDto) {
//            Department department = new Department();
//            // postDto로 Department 매핑 시뮬레이션
//            when(departmentMapper.postDtoToEntity(any(DepartmentDto.PostDto.class))).thenAnswer(invocation -> {
//                DepartmentDto.PostDto argPostDto = invocation.getArgument(0);
//                Department newDepartment = new Department();
//                newDepartment.setName(argPostDto.getName());
//                newDepartment.setStatus(argPostDto.getStatus());
//                newDepartment.setEstablishDate(argPostDto.getEstablishDate());
//                return newDepartment;
//            });
//            when(departmentRepository.save(any(Department.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//            Department result = departmentCrud.create(postDto);
//
//            assertNotNull(result);
//            ArgumentCaptor<Department> departmentCaptor = ArgumentCaptor.forClass(Department.class);
//            verify(departmentMapper).postDtoToEntity(postDto);
//            verify(departmentRepository).save(departmentCaptor.capture());
//            assertEquals(postDto.getName(), result.getName());
//            assertEquals(postDto.getStatus(), result.getStatus());
//            assertEquals(postDto.getEstablishDate(), result.getEstablishDate());
//            if (postDto.getHead() != null) {
//                assertEquals(postDto.getHead(), result.getHead());
//            }
//        }
//
//        @Test
//        void testCreateDepartmentWithExceptionInMapping() {
//            when(departmentMapper.postDtoToEntity(any())).thenThrow(new RuntimeException("Mapping failed"));
//
//            assertThrows(RuntimeException.class, () -> departmentCrud.create(postDto));
//        }
//    }
//
//    @Nested
//    class ReadTests {
//        @Test
//        void testFindDepartment() {
//
//            when(departmentRepository.findById(id)).thenReturn(Optional.of(department));
//            when(departmentMapper.entityToResponseDto(department)).thenReturn(responseDto);
//
//            DepartmentDto.ResponseDto foundResponseDto = departmentCrud.find(id);
//
//            assertNotNull(foundResponseDto);
//            verify(departmentRepository).findById(id);
//
//            assertEquals(department.getName(), foundResponseDto.getName());
//            assertEquals(department.getStatus(), foundResponseDto.getStatus());
//            assertEquals(department.getEstablishDate(), foundResponseDto.getEstablishDate());
//        }
//
//        @Test
//        void testFindDepartmentWithNotFoundException() {
//            when(departmentRepository.findById(anyLong())).thenReturn(Optional.empty());
//
//            assertThrows(RuntimeException.class, () -> departmentCrud.find(id));
//        }
//
//        @Test
//        void testFindAllDepartments() {
//            List<Department> departments = Arrays.asList(department, department2);
//            when(departmentRepository.findAll()).thenReturn(departments);
//            when(departmentMapper.entityToResponseDto(any(Department.class)))
//                    .thenAnswer(invocation -> {
//                        Department dept = invocation.getArgument(0);
//                        return new DepartmentDto.ResponseDto(dept.getName(), dept.getHead(), dept.getStatus(), dept.getEstablishDate());
//                    });
//
//            List<DepartmentDto.ResponseDto> results = departmentCrud.findAll();
//
//            verify(departmentRepository).findAll();
//            assertEquals(2, results.size());
//            assertEquals(departments.get(0).getName(), results.get(0).getName());
//            assertEquals(departments.get(0).getStatus(), results.get(0).getStatus());
//            assertEquals(departments.get(0).getEstablishDate(), results.get(0).getEstablishDate());
//            // 두 번째 요소에 대한 검증
//            assertEquals(departments.get(1).getName(), results.get(1).getName());
//            assertEquals(departments.get(1).getStatus(), results.get(1).getStatus());
//            assertEquals(departments.get(1).getEstablishDate(), results.get(1).getEstablishDate());
//
//        }
//    }
//
//    @Nested
//    class UpdateTests {
////        static Stream<Arguments> patchDtoProvider() {
////            Long[] ids = {id, 2L};
////            String[] names = {"HR","Dev", null};
////            Department.Status[] statuses = {ACTIVE, INACTIVE, null};
////            ZonedDateTime[] dates = {date, ZonedDateTime.now(), null};
////            String[] heads = {"A","B",null};
////            return Stream.of(ids)
////                    .flatMap(id -> Stream.of(names)
////                            .flatMap(name -> Stream.of(statuses)
////                                    .flatMap(status -> Stream.of(dates)
////                                            .flatMap(date -> Stream.of(heads)
////                                                    .map(head -> arguments(new DepartmentDto.PatchDto(name, status, date, head)))))));
////        }
////        @Test
////        void testUpdateWithNonExistentId() {
////            Long nonExistentId = -1L; // 가정: 이 ID는 존재하지 않음
////
////            when(departmentRepository.findById(nonExistentId)).thenReturn(Optional.empty());
////
////            assertThrows(RuntimeException.class, () -> departmentCrud.update(nonExistentId, patchDto), "Entity not found");
////        }
////
////        @Test
////        void testPatchDtoToEntityWithNullPatchDto() {
////            assertThrows(RuntimeException.class, () -> departmentCrud.update(1L, null));
////        }
////
////        @Test
////        void testPatchDtoToEntityWithValidPatchDto() {
////            // 적절한 모킹 설정
////            when(departmentRepository.findById(any())).thenReturn(Optional.of(new Department()));
////            when(departmentMapper.departmentPatchDtoToDepartment(patchDto)).thenReturn(new Department());
////
////            assertDoesNotThrow(() -> departmentCrud.update(1L, patchDto));
////        }
////
////        @Test
////        void testCopyNonNullProperties() {
////            Department original = new Department();
////            original.setName("Original Name");
////            original.setStatus(Department.Status.ACTIVE);
////
////            Department updated = new Department();
////            updated.setName(null); // 이 속성은 복사되지 않아야 함
////            updated.setStatus(Department.Status.INACTIVE); // 이 속성은 복사되어야 함
////
////            CustomBeanUtils<Department> utils = new CustomBeanUtils<>();
////            utils.copyNonNullProperties(updated, original);
////
////            // 검증: null이 아닌 속성만 복사됨
////            assertEquals("Original Name", original.getName());
////            assertEquals(Department.Status.INACTIVE, original.getStatus());
////        }
////
////        @Test
////        void testUpdateAndSaveEntity() {
////            Department original = new Department();
////            original.setName("Original Name");
////            original.setStatus(Department.Status.ACTIVE);
////
////            Department updated = new Department();
////            updated.setName("Updated Name");
////            updated.setStatus(null); // 이 속성은 복사되지 않아야 함
////
////            when(departmentRepository.save(original)).thenReturn(original);
////
////            CustomBeanUtils<Department> utils = new CustomBeanUtils<>();
////            Department result = utils.copyNonNullProperties(updated, original);
////            departmentRepository.save(result); // 저장
////
////            // 검증: 병합된 결과가 올바른지 확인
////            assertEquals("Updated Name", original.getName());
////            assertEquals(Department.Status.ACTIVE, original.getStatus());
////        }
////
////        @Test
////        void testUpdateMethodWithDatabaseConnectionError() {
////            // 데이터베이스 연결 오류 시뮬레이션
////            when(departmentRepository.findById(any())).thenThrow(new RuntimeException("Database connection error"));
////
////            assertThrows(RuntimeException.class, () -> departmentCrud.update(1L, new DepartmentDto.PatchDto()));
////        }
////
////        @ParameterizedTest
////        @MethodSource("patchDtoProvider")
////        void testUpdateDepartment(DepartmentDto.PatchDto patchDto) {
////            // invalid id Test;
////            if (patchDto.getId() < 0) {
////                assertThrows(RuntimeException.class, () -> departmentCrud.update(patchDto.getId(), patchDto));
////                return;
////            }
////            // update test with valid id;
////            when(departmentRepository.findById(any())).thenAnswer(invocation -> {
////                Long id = invocation.getArgument(0, Long.class);
////                if (id.equals(department.getId())) {
////                    return Optional.of(department);
////                } else if (id.equals(department2.getId())) {
////                    return Optional.of(department2);
////                } else {
////                    return null;
////                }
////            });
////            when(departmentRepository.save(any(Department.class))).thenReturn(department);
////            when(departmentMapper.departmentPatchDtoToDepartment(any(DepartmentDto.PatchDto.class)))
////                    .thenAnswer(invocation -> {
////                        DepartmentDto.PatchDto argPatchDto = invocation.getArgument(0);
////                        Department newDepartment = new Department();
////                        // argPatchDto의 값으로 newDepartment 설정
////                        newDepartment.setName(argPatchDto.getName());
////                        newDepartment.setStatus(argPatchDto.getStatus());
////                        newDepartment.setEstablishDate(argPatchDto.getEstablishDate());
////                        newDepartment.setHead(argPatchDto.getHead());
////                        return newDepartment;
////                    });
////            when(departmentMapper.departmentToDepartmentResponseDto(any())).thenReturn(responseDto);
////
////            // When
////            DepartmentDto.ResponseDto updatedResponseDto = departmentCrud.update(patchDto.getId(), patchDto);
////
////            // Then
////            assertNotNull(updatedResponseDto);
////            ArgumentCaptor<Department> departmentCaptor = ArgumentCaptor.forClass(Department.class);
////            verify(departmentRepository).save(departmentCaptor.capture());
////            verify(departmentMapper).departmentPatchDtoToDepartment(patchDto);
////
////            Department updatedDepartment = departmentCaptor.getValue();
////            assertNotNull(updatedDepartment);
////            // 검증: 캡처된 Department 객체의 필드 값이 patchDto의 값과 일치하는지 확인
////            if (patchDto.getName() != null) {
////                assertEquals(patchDto.getName(), updatedDepartment.getName());
////            }
////            if (patchDto.getStatus() != null) {
////                assertEquals(patchDto.getStatus(), updatedDepartment.getStatus());
////            }
////            if (patchDto.getEstablishDate() != null) {
////                assertEquals(patchDto.getEstablishDate(), updatedDepartment.getEstablishDate());
////            }
////            if (patchDto.getHead() != null) {
////                assertEquals(patchDto.getHead(), updatedDepartment.getHead());
////            }
////        }
//    }
//
//    @Nested
//    class DeleteTests {
//        @Test
//        void testDeleteDepartment() {
//            doNothing().when(departmentRepository).deleteById(id);
//
//            assertDoesNotThrow(() -> departmentCrud.delete(id));
//            verify(departmentRepository).deleteById(id);
//        }
//
//
//        @Test
//        void testDeleteAllDepartments() {
//            doNothing().when(departmentRepository).deleteAll();
//
//            assertDoesNotThrow(() -> departmentCrud.deleteAll());
//            verify(departmentRepository).deleteAll();
//        }
//    }
//}