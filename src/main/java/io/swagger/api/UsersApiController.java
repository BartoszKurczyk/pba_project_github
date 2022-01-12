package io.swagger.api;

import io.swagger.AdditionalFeatures;
import io.swagger.database.model.UserDB;
import io.swagger.database.repository.UsersRepository;
import io.swagger.exceptions.BadPasswordExcepiton;
import io.swagger.exceptions.BadUsernameException;
import io.swagger.model.ResponseHeader;
import io.swagger.model.User;
import io.swagger.model.UserListResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        AdditionalFeatures additionalFeatures = new AdditionalFeatures();
        additionalFeatures.BasicAuth(token);
        List<User> userList = usersRepository.findAll().stream().map(u-> User.builder().id(u.getId()).
                name(u.getName()).surname(u.getSurname()).adressStreet(u.getAdressStreet()).buildingNumber(u.getBuildingNumber()).
                apartmentNumber(u.getApartmentNumber()).zipCode(u.getZipCode()).city(u.getCity()).email(u.getEmail()).build()).collect(Collectors.toList());
        return ResponseEntity.ok().body(UserListResponse.builder().
                responseHeader(ResponseHeader.builder().responseId(postmanToken).sendDate(new Date()).build()).
                usersList(userList).build());

    }

}
