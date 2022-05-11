package Messenger.Missile.controller;

import Messenger.Missile.domain.User;
import Messenger.Missile.domain.Views;
import Messenger.Missile.service.ProfileService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profile")
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("id")
    @JsonView(Views.IdName.class)
    public User get(@PathVariable("id") User user){
        return user;
    }

    @PostMapping("change-subscription/{changeId}")
    @JsonView(Views.IdName.class)
    public User changeSubscription(
            @AuthenticationPrincipal User subscriber,
            @PathVariable("changeId") User channel
    ){
        if(subscriber.equals(channel)){
            return channel;
        }
        else
        {
            return profileService.changeSubscriptions(channel, subscriber);
        }
    }
}
