package krd.kurdestansoft.showin.comment;


import krd.kurdestansoft.showin.common.exeption.NotFoundException;
import krd.kurdestansoft.showin.place.Place;
import krd.kurdestansoft.showin.place.PlaceService;
import krd.kurdestansoft.showin.place.PlaceServiceImp;
import krd.kurdestansoft.showin.user.User;
import krd.kurdestansoft.showin.user.UserService;
import lombok.AllArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImp implements CommentService {

    private final CommentRepository repository;
    private  final PlaceService placeService;
    private  final UserService userService;


    @Override
    public Comment save(Comment comment) {
        Long userId = comment.getUser().getId();
        User user = userService.getById(userId);
        Long placeId = comment.getPlace().getId();
        Place place = placeService.getById(placeId);
        comment.setUser(user);
        comment.setPlace(place);
        return repository.save(comment);

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Comment getById(Long id) {
        Optional<Comment> optionalComment=repository.findById(id);
        if (!optionalComment.isPresent()){
            throw new NotFoundException("Not Found");
        }
        return optionalComment.get();
    }

    @Override
    public List<Comment> getAll() {
        return (List<Comment>) repository.findAll();
    }

    @Override
    public List<Comment> getAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public List<Comment> getAllByPlaceId(Long placeId) {
        return repository.findAllByPlaceId(placeId);
    }
}
