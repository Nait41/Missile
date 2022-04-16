package Messenger.Missile.repo;

import Messenger.Missile.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User,String> {

}
