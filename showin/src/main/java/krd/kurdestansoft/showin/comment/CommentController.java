package krd.kurdestansoft.showin.comment;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import krd.kurdestansoft.showin.Like.Like;
import krd.kurdestansoft.showin.Like.LikeDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {

    private final CommentService service;
    private final CommentMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CommentDTO commentDTO) {
        Comment comment = mapper.toComment(commentDTO);
        service.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<CommentDTO> getById(@PathVariable Long id) {
        Comment comment = service.getById(id);
        CommentDTO commentDTO = mapper.toCommentDTO(comment);
        return ResponseEntity.ok(commentDTO);
    }

    @GetMapping(value = "/v1")
    public ResponseEntity<List<CommentDTO>> getAll() {
        List<Comment> comments = service.getAll();
        List<CommentDTO> commentDTOS = mapper.toCommentDTOS(comments);
        return ResponseEntity.ok(commentDTOS);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/getByPlace/{plcId}")
    public ResponseEntity<List<CommentDTO>> getByPlaceId(@PathVariable Long placeId) {
        List<Comment> comments = service.getAllByPlaceId(placeId);
        List<CommentDTO> commentDTOS = mapper.toCommentDTOS(comments);
        return ResponseEntity.ok(commentDTOS);
    }


    @GetMapping("/v1/getByUser/{userId}")
    public ResponseEntity<List<CommentDTO>> getByUserId(@PathVariable Long userId) {
        List<Comment> comments = service.getAllByUserId(userId);
        List<CommentDTO> commentDTOS = mapper.toCommentDTOS(comments);
        return ResponseEntity.ok(commentDTOS);
    }

}
