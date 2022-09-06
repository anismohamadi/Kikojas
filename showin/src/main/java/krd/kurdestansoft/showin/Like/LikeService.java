package krd.kurdestansoft.showin.Like;

import java.util.List;

public interface LikeService {
    Like save(Like like);
    void delete(Long id);
    Like getById(Long id);
    List<Like> getAll();
    List<Like> getAllByUserId(Long userId);
    List<Like> getAllByPlaceId(Long placeId);

}
