package hufs.sweepyswipe.controller;

import hufs.sweepyswipe.service.TrashService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trash")
@RequiredArgsConstructor
public class TrashViewController {

    private final TrashService trashService;

    @GetMapping("/types")
    public String getAllTrashTypes(Model model) {
        model.addAttribute("trashTypes", trashService.findAllTrashTypes());
        return "trashTypes"; // trashTypes.html 템플릿을 반환
    }

    @GetMapping("/types/{typeId}/items")
    public String getItemsByTrashType(@PathVariable Long typeId, Model model) {
        model.addAttribute("items", trashService.findItemsByTrashType(typeId));
        return "trashItems"; // trashItems.html 템플릿을 반환
    }
}
