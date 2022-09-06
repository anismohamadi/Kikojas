package krd.kurdestansoft.showin.user;

import krd.kurdestansoft.showin.Like.Like;
import krd.kurdestansoft.showin.comment.Comment;
import krd.kurdestansoft.showin.common.BaseEntity;
import krd.kurdestansoft.showin.image.Image;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Audited
@Table(name = "tbl_user")
@Data
public class User extends BaseEntity {

    @NotNull
    @Column(name = "fullname")
    private  String fullname;

    @NotNull
    @Column(name = "email",unique = true)
    private  String email;

    @NotNull
    @Column(name = "password", length =6)
    private  String password;

    @NotNull
    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private  Gender gender;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private  List<Comment> comments;


}

