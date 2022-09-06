package krd.kurdestansoft.showin.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Repository
public interface UserRepository  extends PagingAndSortingRepository<User,Long> , JpaSpecificationExecutor<User>{
List <User> findAll(Specification<User> specification);
/*Page<User> findAllBy(Pageable pageable);*/


}
