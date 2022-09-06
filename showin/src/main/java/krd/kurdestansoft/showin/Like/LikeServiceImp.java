package krd.kurdestansoft.showin.Like;

import krd.kurdestansoft.showin.common.exeption.NotFoundException;
import krd.kurdestansoft.showin.place.Place;
import krd.kurdestansoft.showin.place.PlaceService;
import krd.kurdestansoft.showin.user.User;
import krd.kurdestansoft.showin.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LikeServiceImp implements LikeService{

    private  final LikeRepository repository;
    private  final PlaceService placeService;
    private  final UserService userService;

    @Override
    public Like save(Like like) {
        Long userId = like.getUser().getId();
        User user = userService.getById(userId);
        Long placeId = like.getPlace().getId();
        Place place = placeService.getById(placeId);
        like.setUser(user);
        like.setPlace(place);
        return repository.save(like);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Like getById(Long id) {
        Optional<Like> optionalLike=repository.findById(id);
        if (!optionalLike.isPresent()){
            throw new NotFoundException("Not Found");
        }
        return optionalLike.get();
    }

    @Override
    public List<Like> getAll() {
        return (List<Like>) repository.findAll();
    }

    @Override
    public List<Like> getAllByUserId(Long userId) {

        return repository.findAllByUserId(userId);
    }

    @Override
    public List<Like> getAllByPlaceId(Long placeId) {

        return repository.findAllByPlaceId(placeId);
    }
}
