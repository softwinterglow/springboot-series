package come.example.ProductionReadyFeatures.repositories;

import come.example.ProductionReadyFeatures.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}