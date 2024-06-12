package hufs.sweepyswipe.service;

import hufs.sweepyswipe.domain.TrashItem;
import hufs.sweepyswipe.domain.TrashType;
import hufs.sweepyswipe.Dto.TrashItemDto;
import hufs.sweepyswipe.Dto.TrashTypeDto;
import hufs.sweepyswipe.repository.TrashItemRepository;
import hufs.sweepyswipe.repository.TrashTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TrashService {

    private final TrashTypeRepository trashTypeRepository;
    private final TrashItemRepository trashItemRepository;

    public List<TrashTypeDto> findAllTrashTypes() {
        return trashTypeRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<TrashItemDto> findItemsByTrashType(Long typeId) {
        return trashItemRepository.findAllByTrashTypeId(typeId).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Transactional
    public TrashTypeDto saveTrashType(TrashType trashType) {
        return convertToDto(trashTypeRepository.save(trashType));
    }

    @Transactional
    public TrashItemDto saveTrashItem(TrashItem trashItem) {
        return convertToDto(trashItemRepository.save(trashItem));
    }

    private TrashTypeDto convertToDto(TrashType trashType) {
        TrashTypeDto dto = new TrashTypeDto();
        dto.setId(trashType.getId());
        dto.setName(trashType.getName());
        dto.setCaution(trashType.getCaution());
        dto.setDisposalMethod(trashType.getDisposalMethod());
        dto.setItems(trashType.getItems().stream().map(this::convertToDto).collect(Collectors.toList()));
        return dto;
    }

    private TrashItemDto convertToDto(TrashItem trashItem) {
        TrashItemDto dto = new TrashItemDto();
        dto.setId(trashItem.getId());
        dto.setName(trashItem.getName());
        dto.setRecyclable(trashItem.isRecyclable());
        return dto;
    }

    public TrashType convertToEntity(TrashTypeDto dto) {
        TrashType trashType = new TrashType();
        trashType.setId(dto.getId());
        trashType.setName(dto.getName());
        trashType.setCaution(dto.getCaution());
        trashType.setDisposalMethod(dto.getDisposalMethod());
        trashType.setItems(dto.getItems().stream().map(this::convertToEntity).collect(Collectors.toList()));
        return trashType;
    }

    public TrashItem convertToEntity(TrashItemDto dto) {
        TrashItem trashItem = new TrashItem();
        trashItem.setId(dto.getId());
        trashItem.setName(dto.getName());
        trashItem.setRecyclable(dto.isRecyclable());
        // trashType 설정을 추가할 수 있습니다. 필요한 경우:
        // trashItem.setTrashType(trashTypeRepository.findById(dto.getTrashTypeId()).orElse(null));
        return trashItem;
    }
}
