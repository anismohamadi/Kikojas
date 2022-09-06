package krd.kurdestansoft.showin.place;
import krd.kurdestansoft.showin.common.exeption.NotFoundException;
import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class PlaceServiceImp implements PlaceService{

    private final PlaceRepository repository;

    @Override
    public Place save(Place place) {
        return repository.save(place);
    }

    @Override
    public Place update(Place place) {
        Place lastSavePlace = getById(place.getId());
        lastSavePlace.setTitle(place.getTitle());
        lastSavePlace.setAddress(place.getAddress());
        lastSavePlace.setStarService(place.getStarService());
        lastSavePlace.setEndService(place.getEndService());
        lastSavePlace.setType(place.getType());
        lastSavePlace.setLocation(place.getLocation());

        return repository.save(lastSavePlace);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Place getById(Long id) {

        Optional<Place> optionalPlace=repository.findById(id);

        if (!optionalPlace.isPresent()){
            throw new NotFoundException("NotFound");
        }

        return optionalPlace.get();
    }

    @Override
    public List<Place> getAll() {

        return (List<Place>) repository.findAll();
    }

    @Override
    public List<Place> findNearest(Point<G2D> candidPoint, double distance) {
        return repository.findAllWithDistance(candidPoint,distance);
    }
}
