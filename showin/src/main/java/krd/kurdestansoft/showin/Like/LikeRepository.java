package krd.kurdestansoft.showin.Like;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LikeRepository extends PagingAndSortingRepository<Like, Long> {
    List<Like> findAllByUserId(long userId);
    List<Like> findAllByPlaceId(long placeId);

}
