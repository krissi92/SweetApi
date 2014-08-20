package com.jberry.services.profile;

import com.jberry.dto.Profile;
import java.io.IOException;

public interface ProfileService {

    Profile getUserProfile(String userId) throws IOException;
    boolean postUpdatedProfile(Profile user) throws IOException;

}
