package hufs.sweepyswipe.controller;

import hufs.sweepyswipe.Dto.TrashItemDto;
import hufs.sweepyswipe.Dto.TrashTypeDto;
import hufs.sweepyswipe.domain.TrashItem;
import hufs.sweepyswipe.domain.TrashType;
import hufs.sweepyswipe.service.TrashService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trash")
@RequiredArgsConstructor
public class TrashController {

    private final TrashService trashService;

    @GetMapping("/types")
    public ResponseEntity<List<TrashTypeDto>> getAllTrashTypes() {
        return ResponseEntity.ok(trashService.findAllTrashTypes());
    }

    @GetMapping("/types/{typeId}/items")
    public ResponseEntity<List<TrashItemDto>> getItemsByTrashType(@PathVariable Long typeId) {
        return ResponseEntity.ok(trashService.findItemsByTrashType(typeId));
    }

    @PostMapping("/types")
    public ResponseEntity<TrashTypeDto> createTrashType(@RequestBody TrashTypeDto trashTypeDto) {
        TrashType trashType = trashService.convertToEntity(trashTypeDto);
        return ResponseEntity.ok(trashService.saveTrashType(trashType));
    }

    @PostMapping("/items")
    public ResponseEntity<TrashItemDto> createTrashItem(@RequestBody TrashItemDto trashItemDto) {
        TrashItem trashItem = trashService.convertToEntity(trashItemDto);
        return ResponseEntity.ok(trashService.saveTrashItem(trashItem));
    }
}
