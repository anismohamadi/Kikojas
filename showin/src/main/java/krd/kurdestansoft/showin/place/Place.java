package krd.kurdestansoft.showin.place;

import krd.kurdestansoft.showin.Like.Like;
import krd.kurdestansoft.showin.comment.Comment;
import krd.kurdestansoft.showin.common.BaseEntity;
import krd.kurdestansoft.showin.image.Image;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name =  "tbl_place")
@Audited
@Data
public class Place  extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "address")
    private String address;

    @Column(name = "start_service")
    private Integer starService;


    @Column(name = "end_service")
    private Integer endService;

    @Column(name = "location")
    private Point<G2D> location;

    @Enumerated()
    @Column(name = "type")
    private  Type type;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "place", cascade = CascadeType.ALL)
    private List<Image> images;

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> likeList;

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> commentList;

}

