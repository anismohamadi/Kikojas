package krd.kurdestansoft.showin.image;

import krd.kurdestansoft.showin.place.PlaceMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring" , uses = {PlaceMapper.class})
public interface ImageMapper {

    Image toImage(ImageDTO imageDTO);
    ImageDTO toImageDTO(Image image);
    List<Image> toImages(List<ImageDTO> imageDTOS);
    List<ImageDTO> toImageDTOS(List<Image> images);

}
