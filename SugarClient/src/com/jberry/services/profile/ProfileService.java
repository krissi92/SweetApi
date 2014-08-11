package com.jberry.services.profile;

import com.jberry.dto.Profile;

import java.io.IOException;

/**
 * Created by Krissi on 5.8.2014.
 */
public interface ProfileService {

    Profile getUserProfile(String userId);
    Profile postUpdatedProfile(Profile user) throws IOException;

}
