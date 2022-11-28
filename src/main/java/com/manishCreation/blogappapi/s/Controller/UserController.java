package com.manishCreation.blogappapi.s.Controller;

import com.manishCreation.blogappapi.s.Payload.ApiResponse;
import com.manishCreation.blogappapi.s.Payload.UserDto;
import com.manishCreation.blogappapi.s.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser( @Valid  @RequestBody UserDto userDto)
    {
       UserDto createUserDto = userService.createUser(userDto);
       return new ResponseEntity<>(createUserDto , HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto , @PathVariable Long userId)
    {
        UserDto userDto1 = userService.updateUser(userDto,userId);

        return ResponseEntity.ok(userDto1);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUserById(@PathVariable Long userId)
    {
        userService.deleteUserById(userId);

        return new ResponseEntity<>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId)
    {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUserById()
    {
        return ResponseEntity.ok(this.userService.getAllUser());
    }



}
