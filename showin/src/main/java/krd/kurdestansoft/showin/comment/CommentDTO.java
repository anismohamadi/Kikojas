package krd.kurdestansoft.showin.comment;

import io.swagger.annotations.ApiModelProperty;
import krd.kurdestansoft.showin.common.BaseDTO;
import krd.kurdestansoft.showin.place.PlaceDTO;
import krd.kurdestansoft.showin.user.UserDTO;
import lombok.Data;

@Data
public class CommentDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private String text;

    @ApiModelProperty(required = true, hidden = false)
    private UserDTO user;

    @ApiModelProperty(required = true, hidden = false)
    private PlaceDTO place;
}
