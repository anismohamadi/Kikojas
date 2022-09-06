package krd.kurdestansoft.showin.user;

import krd.kurdestansoft.showin.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    public final UserRepository repository;

    @Override
    public User save(User user) {

        return repository.save(user);
    }

    @Override
    public User update(User user) {
        User lastSaveUser = getById(user.getId());
        lastSaveUser.setFullname(user.getFullname());
        lastSaveUser.setEmail(user.getEmail());
        lastSaveUser.setPassword(user.getPassword());
        lastSaveUser.setGender(user.getGender());
        return repository.save(lastSaveUser);
    }

    @Override
    public void delete(Long id) {
        User user = getById(id);
        repository.delete(user);
    }


    @Override
    public User getById(Long id) {
        Optional<User> optionalUser = repository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("Not Found ");
        }
        return optionalUser.get();
    }
/*
    @Override
    public Page<User> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }
*/

    @Override
    public List<User> getAll() {

        return (List<User>) repository.findAll();
    }

    @Override
    public List<User> search(List<SearchCriteria> searchCriteria) {
        UserSpecification userSpecification = new UserSpecification();
        searchCriteria.forEach(criteria -> userSpecification.add(criteria));
        return repository.findAll(userSpecification);
    }
}

