package hufs.sweepyswipe.Dto;

import lombok.Data;

import java.util.List;

@Data
public class TrashTypeDto {
    private Long id;
    private String name;
    private String caution;
    private String disposalMethod;
    private List<TrashItemDto> items;
}
