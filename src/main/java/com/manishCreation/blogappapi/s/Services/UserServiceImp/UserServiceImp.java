package com.manishCreation.blogappapi.s.Services.UserServiceImp;

import com.manishCreation.blogappapi.s.Exceptions.ResourceNotFoundException;
import com.manishCreation.blogappapi.s.Modules.User;
import com.manishCreation.blogappapi.s.Payload.UserDto;
import com.manishCreation.blogappapi.s.Repository.UserRepository;
import com.manishCreation.blogappapi.s.Services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public UserDto getUserById(Long userId) {

        User user = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","userId",userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> users = this.userRepository.findAll();

        List<UserDto> userDto = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

        return userDto;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user =this.DtoToUser(userDto);
        User savedUser = this.userRepository.save(user);

        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {

        User user = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","userId",userId));


        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User savedUser = userRepository.save(user);

        return this.userToDto(savedUser);
    }

    @Override
    public void deleteUserById(Long userId) {

        User user = this.userRepository
                .findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId",userId));

        userRepository.delete(user);
    }

    public User DtoToUser(UserDto userDto)
    {
        User user =modelMapper.map(userDto,User.class);
        return user;

//    this is manual work

//        user.setUserId(userDto.getUserId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());


    }

    public UserDto userToDto(User user)
    {
        UserDto userDto =modelMapper.map(user,UserDto.class);
        return userDto;
    }
}
