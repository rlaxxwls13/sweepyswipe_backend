package hufs.sweepyswipe.repository;

import hufs.sweepyswipe.domain.TrashType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrashTypeRepository extends JpaRepository<TrashType, Long> {
}
