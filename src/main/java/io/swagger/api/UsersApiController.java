package io.swagger.api;

import io.swagger.AdditionalFeatures;
import io.swagger.database.model.UserDB;
import io.swagger.database.repository.UsersRepository;
import io.swagger.exceptions.BadPasswordExcepiton;
import io.swagger.exceptions.BadUsernameException;
import io.swagger.exceptions.UserNotFoundException;
import io.swagger.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-16T07:28:43.311Z")

@Controller
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    private AdditionalFeatures additionalFeatures = new AdditionalFeatures();



    @Autowired
    private UsersRepository usersRepository;

    @PostConstruct
    public void init(){
        UserDB user = UserDB.builder().id(UUID.fromString("630b053b-c8b7-4460-8cba-6c969f1f0b45")).name("Elon").
        surname("Musk").adressStreet("aleja Piastów").buildingNumber(26).apartmentNumber(118).
        city("Szczecin").zipCode("71-064").email("e_musk@gmail.com").build();
        usersRepository.save(user);
    }


    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<UserListResponse> getAllUsers(UUID postmanToken, String token) {
        additionalFeatures.BasicAuth(token);
        List<User> userList = usersRepository.findAll().stream().map(u-> User.builder().id(u.getId()).
                name(u.getName()).surname(u.getSurname()).adressStreet(u.getAdressStreet()).buildingNumber(u.getBuildingNumber()).
                apartmentNumber(u.getApartmentNumber()).zipCode(u.getZipCode()).city(u.getCity()).email(u.getEmail()).build()).collect(Collectors.toList());
        return ResponseEntity.ok().body(UserListResponse.builder().
                responseHeader(ResponseHeader.builder().responseId(postmanToken).sendDate(new Date()).build()).
                usersList(userList).build());

    }

    @Override
    public ResponseEntity<UserResponse> createUser(CreateRequest body, String token) {
        additionalFeatures.BasicAuth(token);
        User user = body.getUser();
        UserDB userDB = UserDB.builder().id(user.getId()).name(user.getName()).surname(user.getSurname()).adressStreet(user.getAdressStreet()).
                buildingNumber(user.getBuildingNumber()).apartmentNumber(user.getApartmentNumber()).zipCode(user.getZipCode()).
                city(user.getCity()).email(user.getEmail()).build();
        usersRepository.save(userDB);
        return ResponseEntity.ok().body(UserResponse.builder().responseHeader(ResponseHeader.builder().
                responseId(body.getRequestHeader().getRequestId()).sendDate(new Date()).build()).user(user).build());
    }

    @Override
    public ResponseEntity<Void> deleteUser(UUID id, String token) {
        additionalFeatures.BasicAuth(token);
        if(usersRepository.findById(id).orElse(null) == null) throw new UserNotFoundException("User not found. Can't be deleted");
        usersRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(UUID id, UserUpdateRequest body, String token) {
        additionalFeatures.BasicAuth(token);
        User user = body.getUser();
        UserDB foundUser = usersRepository.findById(id).orElse(null);
        if(foundUser == null) throw new UserNotFoundException("User not found. Can't be updated");
        foundUser.setName(user.getName());
        foundUser.setSurname(user.getSurname());
        foundUser.setAdressStreet(user.getAdressStreet());
        foundUser.setBuildingNumber(user.getBuildingNumber());
        foundUser.setApartmentNumber(user.getApartmentNumber());
        foundUser.setZipCode(user.getZipCode());
        foundUser.setCity(user.getCity());
        foundUser.setEmail(user.getEmail());

        usersRepository.save(foundUser);
        return ResponseEntity.ok().body(UserResponse.builder().responseHeader(ResponseHeader.builder().
                responseId(body.getRequestHeader().getRequestId()).sendDate(new Date()).build()).user(user).build());
    }
}
