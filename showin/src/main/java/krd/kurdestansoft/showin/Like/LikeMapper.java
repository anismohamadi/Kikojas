package krd.kurdestansoft.showin.Like;

import krd.kurdestansoft.showin.place.Place;
import krd.kurdestansoft.showin.place.PlaceDTO;
import krd.kurdestansoft.showin.place.PlaceMapper;
import krd.kurdestansoft.showin.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring", uses = {PlaceMapper.class,UserMapper.class})
public interface LikeMapper {
    Like toLike(LikeDTO likeDTO);
    LikeDTO toLikeDTO(Like like);
    List<Like> toLikes(List<LikeDTO> likeDTOS);
    List<LikeDTO> toLikeDTOS(List<Like> likes);



}
