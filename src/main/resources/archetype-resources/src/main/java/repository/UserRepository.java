package ${package}.repository;

import ${package}.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class UserRepository {

  public User save(User user){
    return null;
  }

  public User insert(User user){
    return null;
  }

  public boolean existsById(String userId){
    return false;
  }

  public List<User>findAll(){
    return new ArrayList<>();
  }

  public void deleteById(String userId){}

  public Optional<User> findById(String userId){return null;}
}
