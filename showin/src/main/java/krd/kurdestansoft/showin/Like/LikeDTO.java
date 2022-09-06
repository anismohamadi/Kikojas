package krd.kurdestansoft.showin.Like;

import io.swagger.annotations.ApiModelProperty;
import krd.kurdestansoft.showin.common.BaseDTO;
import krd.kurdestansoft.showin.place.Place;
import krd.kurdestansoft.showin.place.PlaceDTO;
import krd.kurdestansoft.showin.user.User;
import krd.kurdestansoft.showin.user.UserDTO;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class LikeDTO extends BaseDTO {

  @ApiModelProperty(required = true, hidden = false)
    private UserDTO user;

  @ApiModelProperty(required = true, hidden = false)
    private PlaceDTO place;

}
