package krd.kurdestansoft.showin.user;


import krd.kurdestansoft.showin.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/User")
@AllArgsConstructor
public class UserConteroller {

    public final UserService service;
    public final UserMapper mapper;


    @PostMapping(value = "/v1")
    public ResponseEntity<Void> save(@RequestBody UserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody UserDTO userDTO) {

        User user = mapper.toUser(userDTO);
        service.save(user);
        return ResponseEntity.ok().build();
}

    @GetMapping(value = "/v1")
    public ResponseEntity<List<UserDTO>> getAll()
    {
        List<User> users = service.getAll();
        List<UserDTO> usersDTO = mapper.toUserDTOS(users);
        return ResponseEntity.ok(usersDTO);
    }



    @PostMapping(value = "/v1/search")
    public ResponseEntity<List<UserDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<User> users= service.search(searchCriteria);
        List<UserDTO> userDTOS = mapper.toUserDTOS(users);
        return ResponseEntity.ok(userDTOS);
    }

}
