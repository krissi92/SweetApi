package com.jberry.services.profile;

<<<<<<< HEAD
import com.jberry.dto.Profile;

import java.io.IOException;

=======
>>>>>>> 05e25c3766e77b56f6aef6c8631ae1fe671cbb06
/**
 * Created by Krissi on 5.8.2014.
 */
public interface ProfileService {

    Profile getUserProfile(String userId);
    Profile postUpdatedProfile(Profile user) throws IOException;

}
