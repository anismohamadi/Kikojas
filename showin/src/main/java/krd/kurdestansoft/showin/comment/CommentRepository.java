package krd.kurdestansoft.showin.comment;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CommentRepository extends PagingAndSortingRepository <Comment, Long>{
    List<Comment> findAllByUserId(long userId);
    List<Comment> findAllByPlaceId(long placeId);
}
