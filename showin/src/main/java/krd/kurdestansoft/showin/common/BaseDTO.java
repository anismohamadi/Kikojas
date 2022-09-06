package krd.kurdestansoft.showin.common;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Data
public class BaseDTO {


        @ApiModelProperty(required = false, hidden = true)
        private  Long id;

        @ApiModelProperty(required = false, hidden = true)
        private Integer version;

        @ApiModelProperty(required = false, hidden = true)
        private Date createdDat;

        @ApiModelProperty(required = false, hidden = true)
        private  String createdBy;

        @ApiModelProperty(required = false, hidden = true)
        private Date lastModifiedDate;

        @ApiModelProperty(required = false, hidden = true)
        private String lastModifiedBy;
    }


