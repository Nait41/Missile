package Messenger.Missile.controller;

import Messenger.Missile.domain.User;
import Messenger.Missile.domain.Views;
import Messenger.Missile.service.ProfileService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return profileService.getProfile(user);
    }
}
