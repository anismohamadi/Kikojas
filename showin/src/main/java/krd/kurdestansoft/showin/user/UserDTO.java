package krd.kurdestansoft.showin.user;

import io.swagger.annotations.ApiModelProperty;
import krd.kurdestansoft.showin.common.BaseDTO;
import lombok.Data;


@Data
public class UserDTO  extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private  String fullname;

    @ApiModelProperty(required = true, hidden = false)
    private  String pasword;

    @ApiModelProperty(required = true, hidden = false)
    private  String email;

    @ApiModelProperty(required = true, hidden = false)
    private  Gender gender;



}
