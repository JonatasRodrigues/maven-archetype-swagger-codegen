package ${package}.controller;

import ${package}.UsersApi;
import ${package}.repository.*;
import ${package}.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController implements UsersApi {

    @Autowired
    UserRepository userRepository;

  @Override
  public ResponseEntity<UserResponse> findUserById(String userId) {
      try{
          Optional<${groupId}.model.User> user = userRepository.findById(userId);

          if(!user.isPresent()){
              return new ResponseEntity<UserResponse>(HttpStatus.NOT_FOUND);
          }

          UserResponse response = new UserResponse();
          response.addUserItem(user.get());

          return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
      }catch (Exception e){
          throw e;
      }
  }

    @Override
    public ResponseEntity<ResponseIdUser> addUser(User user) {
        try {
            ${groupId}.model.User inserted = userRepository.insert(user);
            user.setId(null);

            ResponseIdUser response = new ResponseIdUser();
            response.setId(inserted.getId());
            return new ResponseEntity<ResponseIdUser>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            throw e;
        }
    }

  @Override
  public ResponseEntity<Void> deleteUser(String userId) {
    try{

        if(!userRepository.existsById(userId)){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        userRepository.deleteById(userId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }catch (Exception e){
        throw e;
    }
  }

    @Override
    public ResponseEntity<Void> updateUser(String userId, User body) {
        try {
            if (!userRepository.existsById(userId)) {
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }

            body.setId(userId);
            userRepository.save(body);

            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ResponseEntity<UserResponse> findUsers() {
        try {
            List<${groupId}.model.User> users = userRepository.findAll();

            UserResponse response = new UserResponse();
            response.user(users);
            return new ResponseEntity<UserResponse>(response, HttpStatus.OK);

        } catch (Exception e) {
            throw e;
        }
    }
}