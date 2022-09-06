package krd.kurdestansoft.showin.image;

import krd.kurdestansoft.showin.place.Place;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {

  Image findByPlace(Place place);

}
