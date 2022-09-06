package krd.kurdestansoft.showin.comment;

import krd.kurdestansoft.showin.common.BaseEntity;
import krd.kurdestansoft.showin.place.Place;
import krd.kurdestansoft.showin.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "tbl_commnet")
@Audited
public class Comment extends BaseEntity {

    @NotNull
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;



}
