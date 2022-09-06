package krd.kurdestansoft.showin.comment;

import krd.kurdestansoft.showin.place.PlaceMapper;
import krd.kurdestansoft.showin.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring", uses = {PlaceMapper.class, UserMapper.class})

public interface CommentMapper {

    Comment toComment(CommentDTO commentDTO);
    CommentDTO toCommentDTO(Comment comment);
    List<CommentDTO> toCommentDTOS(List<Comment> comments);
    List<Comment> toComments(List<CommentDTO> commentDTOS);

}


