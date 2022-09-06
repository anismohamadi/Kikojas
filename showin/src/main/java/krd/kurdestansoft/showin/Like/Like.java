package krd.kurdestansoft.showin.Like;

import krd.kurdestansoft.showin.common.BaseEntity;
import krd.kurdestansoft.showin.place.Place;
import krd.kurdestansoft.showin.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Data
@Audited
@Table(name = "tbl_like")
public class Like extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private  Place place;






}
