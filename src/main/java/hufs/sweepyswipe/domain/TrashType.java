package hufs.sweepyswipe.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class TrashType {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 예: 일반쓰레기, 재활용 등

    @OneToMany(mappedBy = "trashType")
    private List<TrashItem> items;

    private String caution; // 유의사항 추가
    private String disposalMethod; // 배출방법 추가
}
