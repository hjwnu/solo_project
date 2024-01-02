package project2.HRService.global.generic;


import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import project2.HRService.global.exception.BusinessLogicException;
import project2.HRService.global.exception.ExceptionCode;
import project2.HRService.global.utils.CustomBeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface GenericCrudService<E, P, R, U, ID> {
    E create(P postDto);

    E save(E entity);

    E find(ID id);

    E findByName(String str);

    List<E> findAll();

    Page<R> findPage(int page, int size);

    List<E> findList(int page, int size);

    E update(ID id, U patchDto);

    void delete(ID id);

    void deleteAll();

    R getResponse(ID id);

    @Transactional
    abstract class GenericCrud<E, P, R, U, ID> implements GenericCrudService<E, P, R, U, ID> {

        protected abstract JpaRepository<E, ID> getRepository();

        protected abstract void setId(E newEntity, ID id);

        protected abstract GenericMapper<E, P, R, U, ID> getMapper();

        public R entityToResponse(E entity) {
            return getMapper().entityToResponseDto(entity);
        }

        @Override
        public E create(P postDto) {
            E entity = getMapper().postDtoToEntity(postDto);
            return getRepository().save(entity);
        }

        @Override
        public E save(E entity) {
            return getRepository().save(entity);
        }

        @Override
        public E find(ID id) {
            return verifyExist(id);
        }

        @Override
        public R getResponse(ID id) {
            return getMapper().entityToResponseDto(verifyExist(id));
        }

        @Override
        public Page<R> findPage(int page, int size) {
            List<R> findAllDto = getResponseList(getRepository().findAll());
            Page<R> findPage = new PageImpl<>(findAllDto, PageRequest.of(page, size), findAllDto.size());
            VerifiedNoEntity(findPage);
            return findPage;
        }


        @Override
        public List<E> findList(int page, int size) {

            List<E> findAll = getRepository().findAll();

            VerifiedNoEntity(findAll);
            return findAll;
        }

        @Override
        public E update(ID id, U patchDto) {
            E originEntity = verifyExist(id);
            E newEntity = getMapper().patchDtoToEntity(patchDto);
            setId(newEntity, id);
            CustomBeanUtils<E> customBeanUtils = new CustomBeanUtils<E>();
            customBeanUtils.copyNonNullProperties(newEntity, originEntity);
            return getRepository().save(originEntity);
        }


        @Override
        public void delete(ID id) {
            getRepository().delete(verifyExist(id));
        }

        @Override
        public void deleteAll() {
            getRepository().deleteAll();
        }

        private E verifyExist(ID id) {
            Optional<E> optional
                    = getRepository().findById(id);
            return optional.orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND));
        }

        @NotNull
        private List<R> getResponseList(List<E> findAll) {
            List<R> findAllDto = new ArrayList<>();
            for (E e : findAll) {
                findAllDto.add(getMapper().entityToResponseDto(e));
            }
            return findAllDto;
        }

        private void VerifiedNoEntity(Page<R> findAll) {
            if (findAll.getTotalElements() == 0) {
                throw new BusinessLogicException(ExceptionCode.NOT_FOUND);
            }
        }

        private void VerifiedNoEntity(List<E> findAll) {
            if (findAll.size() == 0) {
                throw new BusinessLogicException(ExceptionCode.NOT_FOUND);
            }
        }
    }
}
