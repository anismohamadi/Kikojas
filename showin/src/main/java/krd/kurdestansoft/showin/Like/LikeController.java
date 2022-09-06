package krd.kurdestansoft.showin.Like;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import krd.kurdestansoft.showin.image.Image;
import krd.kurdestansoft.showin.image.ImageDTO;
import krd.kurdestansoft.showin.place.Place;
import krd.kurdestansoft.showin.place.PlaceDTO;
import krd.kurdestansoft.showin.user.User;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
@AllArgsConstructor

public class LikeController {
    private  final LikeService service;
    private  final  LikeMapper mapper;


    @PostMapping
    public ResponseEntity<Void> save(@RequestBody LikeDTO likeDTO){
        Like like=mapper.toLike(likeDTO);
        service.save(like);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{id}")
    public  ResponseEntity<LikeDTO> getById(@PathVariable Long id){
        Like like=service.getById(id);
        LikeDTO likeDTO=mapper.toLikeDTO(like);
        return  ResponseEntity.ok(likeDTO);
    }

    @GetMapping(value = "/v1")
    public ResponseEntity<List<LikeDTO>> getAll()
    {
        List<Like> likes=    service.getAll();
        List<LikeDTO> likeDTOS =   mapper.toLikeDTOS(likes);
        return ResponseEntity.ok(likeDTOS);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/v1/getByPlace/{plcId}")
    public ResponseEntity<List<LikeDTO>> getByPlaceId(@PathVariable Long placeId){
        List<Like> likes=service.getAllByPlaceId(placeId);
        List<LikeDTO> likeDTOs=mapper.toLikeDTOS(likes);
        return  ResponseEntity.ok(likeDTOs);
    }


    @GetMapping("/v1/getByUser/{userId}")
    public ResponseEntity<List<LikeDTO>> getByUserId(@PathVariable Long userId){
        List<Like> likes=service.getAllByUserId(userId);
        List<LikeDTO> likeDTOs=mapper.toLikeDTOS(likes);
        return  ResponseEntity.ok(likeDTOs);
    }






}
