package krd.kurdestansoft.showin.user;

import krd.kurdestansoft.showin.common.SearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;


public interface UserService {

    User save(User user);
    User update(User user);
    void delete(Long id);
    User getById(Long id);
    List<User> getAll();
    /*Page<User> paging(Integer page, Integer size);*/
    List<User> search(List<SearchCriteria> searchCriteria);


}
