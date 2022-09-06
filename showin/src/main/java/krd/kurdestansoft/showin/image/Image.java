package krd.kurdestansoft.showin.image;


import krd.kurdestansoft.showin.common.BaseEntity;
import krd.kurdestansoft.showin.place.Place;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Audited
@Table(name = "tbl_image")
public class Image extends BaseEntity {


    @NotNull
    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "place_id",unique = true)
    private Place place;







}
