package exercise.mapper;

import exercise.model.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {EntityManager.class})
public abstract class ReferenceMapper {

    @PersistenceContext
    private EntityManager entityManager;

    @ObjectFactory
    public <T extends BaseEntity> T resolve(Long id, @TargetType Class<T> type) {
        if (id == null) {
            return null;
        }
        return entityManager.find(type, id);
    }
}
