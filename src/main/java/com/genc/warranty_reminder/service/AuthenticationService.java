package com.genc.warranty_reminder.service;
import com.genc.warranty_reminder.DTO.LogInResponse;
import com.genc.warranty_reminder.DTO.LoginRequest;
import com.genc.warranty_reminder.DTO.UserDetails;
import com.genc.warranty_reminder.DTO.UserRegistrationResponse;
import com.genc.warranty_reminder.model.UserAuthenticationData;
import com.genc.warranty_reminder.repository.AuthenticationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationRepository userRepository;
    public UserRegistrationResponse createUser(UserAuthenticationData user)
    {
        this.userRepository.save(user);
        return UserRegistrationResponse.builder().id(user.getId()).response("User "+user.getFullName()+ " has been created successfully").build();
    }
    public UserDetails getOneUser(String id)
    {
        Optional<UserAuthenticationData> user= this.userRepository.findById(id);
        if(!user.isPresent())
        {
            throw new NullPointerException("user Not Found");
        }
        return UserDetails.builder().id(user.get().getId()).fullName(user.get().getFullName()).email(user.get().getEmail()).role(user.get().getRole()).build();

    }
    public List<UserDetails>getAlluser()
    {
        List<UserAuthenticationData>userList= this.userRepository.findAll();
        List<UserDetails>userResponseList = new ArrayList<>();
        for(UserAuthenticationData user:userList)
        {
            UserDetails temp=new UserDetails(user.getId(),user.getFullName(),user.getEmail(),user.getRole());
            userResponseList.add(temp);
        }
        return userResponseList;
    }
    public  String deleteOneUser(String id)
    {
        Optional<UserAuthenticationData> user=this.userRepository.findById(id);
        if(user.isPresent())
        {
            this.userRepository.deleteById(id);
            return "user has been deleted ("+id+")";
        }
        return "user was not found ("+id+")";
    }
public UserRegistrationResponse updateUser(UserDetails user)
{
    Optional<UserAuthenticationData>existedUser=this.userRepository.findById(user.getId());
    if(existedUser.isPresent())
    {
        existedUser.get().setFullName(user.getFullName());
        existedUser.get().setEmail(user.getEmail());
        existedUser.get().setRole(user.getRole());
        this.userRepository.save(existedUser.get());

    }
    else {
        return UserRegistrationResponse.builder().id(existedUser.get().getId()).response("User was not found").build();
    }
    return UserRegistrationResponse.builder().id(existedUser.get().getId()).response("User has been Updated Successfully").build();
}

public LogInResponse userSignIn(LoginRequest request)
{
    List<UserAuthenticationData>userList=this.userRepository.findAll();
    for(UserAuthenticationData user:userList)
    {

        if(user.getEmail().equals(request.getEmail()))
        {

            return LogInResponse.builder().allowed(true).fullName(user.getFullName()).response("the LogIn has been successfully done for this "+user.getFullName()).build();
        }
    }
    return LogInResponse.builder().allowed(false).response("Check your email or password").build();
}









}
