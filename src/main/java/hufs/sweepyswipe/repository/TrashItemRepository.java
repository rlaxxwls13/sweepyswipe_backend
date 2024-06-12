package hufs.sweepyswipe.repository;

import hufs.sweepyswipe.domain.TrashItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TrashItemRepository extends JpaRepository<TrashItem, Long> {
    List<TrashItem> findAllByTrashTypeId(Long trashTypeId);
}
