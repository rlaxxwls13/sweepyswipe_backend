package hufs.sweepyswipe.controller;

import hufs.sweepyswipe.domain.TrashItem;
import hufs.sweepyswipe.service.TrashItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trash-items")
public class TrashItemController {
    @Autowired
    private TrashItemService trashItemService;

    @GetMapping
    public List<TrashItem> getAllTrashItems() {
        return trashItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrashItem> getTrashItemById(@PathVariable Long id) {
        return trashItemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}