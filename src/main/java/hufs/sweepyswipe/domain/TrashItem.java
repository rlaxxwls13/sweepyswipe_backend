package hufs.sweepyswipe.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class TrashItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 예: 권투글러브, 우의 등

    private boolean recyclable; // 재활용 가능 여부

    @ManyToOne
    @JoinColumn(name = "trash_type_id")
    private TrashType trashType;
}
