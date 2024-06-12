package hufs.sweepyswipe.Dto;

import lombok.Data;

@Data
public class TrashItemDto {
    private Long id;
    private String name;
    private boolean recyclable;
}
