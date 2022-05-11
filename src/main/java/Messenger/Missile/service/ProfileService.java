package Messenger.Missile.service;

import Messenger.Missile.domain.User;
import Messenger.Missile.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfileService {
    private final UserDetailsRepo userDetailsRepo;

    @Autowired
    public ProfileService(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
    }

    public User changeSubscriptions(User channel, User subscriber) {
        Set<User> subscribers = channel.getSubscriptions();
        if(subscribers.contains(subscriber)){
            subscribers.remove(subscriber);
        }else{
            subscribers.add(subscriber);
        }
        return userDetailsRepo.save(channel);
    }
}
