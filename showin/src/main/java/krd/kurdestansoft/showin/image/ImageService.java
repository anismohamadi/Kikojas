package krd.kurdestansoft.showin.image;


import krd.kurdestansoft.showin.place.Place;
import org.mapstruct.Mapper;

import java.util.List;


public interface ImageService {

    Image save(Image image);
    void delete(Long id);
    Image getById(Long id);
    List<Image> getAll();
   Image getByPlaceId(Long placeId);

}
