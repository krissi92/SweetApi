package com.jberry.services.profile;

public class ProfileServiceFactory {
    public static ProfileService getProfileService() {
        Class c = null;
        try {
            c = Class.forName("com.jberry.services.profile.ProfileServiceImpl");
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
