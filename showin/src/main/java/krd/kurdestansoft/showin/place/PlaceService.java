package krd.kurdestansoft.showin.place;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.util.List;

public interface PlaceService {

    Place save(Place place);
    Place update(Place place);
    void delete(Long id);
    Place getById(Long id);
    List<Place> getAll();
    List<Place> findNearest(Point<G2D > candidPoint,double distance);

}
