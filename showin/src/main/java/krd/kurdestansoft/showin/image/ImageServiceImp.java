package krd.kurdestansoft.showin.image;

import krd.kurdestansoft.showin.common.exeption.NotFoundException;
import krd.kurdestansoft.showin.place.Place;
import krd.kurdestansoft.showin.place.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageServiceImp implements ImageService{


    private final ImageRepository repository;
    private  final PlaceService service;


    @Override
    public Image save(Image  image) {
    Long plcId=image.getPlace().getId();
    Place place=service.getById(plcId);
    image.setPlace(place);
        return repository.save(image);
    }

    @Override
    public void  delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Image getById(Long id) {

        Optional<Image> optionalImage=repository.findById(id);

        if (!optionalImage.isPresent()){
            throw new NotFoundException("NotFound");
        }
        return optionalImage.get();
    }

    @Override
    public List<Image> getAll() {

        return (List<Image>) repository.findAll();
    }

    @Override
    public Image getByPlaceId(Long placeId) {
        Place place=service.getById(placeId);
        return  repository.findByPlace(place);
    }



}
