package com.example.KantinUnesa.service;

import com.example.KantinUnesa.model.UserProfile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileService {
    private Map<String, UserProfile> userProfiles = new HashMap<>();

    public UserProfile getProfile(String username) {
        return userProfiles.getOrDefault(username, new UserProfile(username, "", ""));
    }

    public void updateProfile(UserProfile profile) {
        userProfiles.put(profile.getUsername(), profile);
    }
}
