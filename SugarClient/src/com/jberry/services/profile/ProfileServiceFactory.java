package com.jberry.services.profile;

/**
 * Created by Krissi on 5.8.2014.
 */
public class ProfileServiceFactory {
    public static ProfileService getProfileService() {
        Class c = null;
        try {
            c = Class.forName("com.jberry.services.profile.ProfileService");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ProfileService profileServiceInstance = null;
        try {
            profileServiceInstance = (ProfileService) c.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return profileServiceInstance;
    }
}
