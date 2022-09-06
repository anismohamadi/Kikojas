package krd.kurdestansoft.showin.image;

import io.swagger.annotations.ApiModelProperty;
import krd.kurdestansoft.showin.common.BaseDTO;
import krd.kurdestansoft.showin.place.PlaceDTO;

import lombok.Data;


@Data
public class ImageDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String image;


    @ApiModelProperty(required = true, hidden = false)
    private PlaceDTO place;
    //این dto جوابگوی تمام نیاز های ماست
}
