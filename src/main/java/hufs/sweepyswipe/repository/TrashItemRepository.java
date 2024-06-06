package hufs.sweepyswipe.repository;

import hufs.sweepyswipe.domain.TrashItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrashItemRepository extends JpaRepository<TrashItem, Long> {
    // JpaRepository는 기본적인 CRUD 메서드를 제공합니다.
}