package br.com.evasion.src.resource;

import br.com.evasion.src.request.CreateUserRequest;
import br.com.evasion.src.request.DeleteUserRequest;
import br.com.evasion.src.response.FindUserResponse;
import br.com.evasion.src.service.UserService;
import br.com.evasion.src.request.AuthUserRequest;
import br.com.evasion.src.utils.BuilderObjectsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;
    @PostMapping("auth/user")
    public String authUser(@RequestBody final AuthUserRequest authUserRequest) {
        return userService.authUser(authUserRequest.getLogin(), authUserRequest.getSenha());
    }

    @PostMapping("create/user")
    public String createUser(@RequestBody final CreateUserRequest createUserRequest) {
        return userService.createUser(BuilderObjectsUtils.buildUserDTO(createUserRequest)).getUserName();
    }

    @PostMapping("delete/user")
    public void deleteUser(@RequestBody final DeleteUserRequest deleteUserRequest) {
        userService.deleteUser(deleteUserRequest.getUserEmail());
    }

    @RequestMapping(value = "all/user", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<FindUserResponse> allUser() {
        return userService.findAllUsers();
    }
}

