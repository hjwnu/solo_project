package project2.HRService.global.generic;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import project2.HRService.global.utils.CustomBeanUtils;

import java.util.List;

public interface GenericCrudService<E, P, R, U, ID> {
    E create(P postDto);
    E save(E entity);
    E find(ID id);
    List<E> findAll();
    E update(ID id, U patchDto);
    void delete(ID id);
    void deleteAll();
    @Transactional
    abstract class GenericCrud<E, P, R, U, ID> implements GenericCrudService<E, P, R, U, ID> {
        protected abstract JpaRepository<E, ID> getRepository();

        protected abstract  void setId(E newEntity, ID id);
        protected abstract GenericMapper<E, P, R, U,ID> getMapper();

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
            return getRepository().findById(id)
                    .orElseThrow(() -> new RuntimeException("Entity not found"));
        }

        @Override
        public List<E> findAll() {
            return getRepository().findAll();
        }

        @Override
        public E update(ID id, U patchDto) {
            E originEntity = getRepository().findById(id)
                    .orElseThrow(() -> new RuntimeException("Entity not found"));
            E newEntity = getMapper().patchDtoToEntity(patchDto);
            setId(newEntity, id);
            return updateAndSaveEntity(originEntity, newEntity);
        }

        private E updateAndSaveEntity(E originEntity, E newEntity) {
            CustomBeanUtils<E> customBeanUtils = new CustomBeanUtils<E>();
            customBeanUtils.copyNonNullProperties(newEntity, originEntity);
            return getRepository().save(originEntity);
        }

        @Override
        public void delete(ID id) {
            getRepository().deleteById(id);
        }

        @Override
        public void deleteAll(){ getRepository().deleteAll();  }

    }
}
