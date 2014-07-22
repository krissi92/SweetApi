package com.jberry.services.calendar;

public class CalendarServiceFactory {
    public static CalendarService getCalanderService() {
        Class c = null;
        try {
            c = Class.forName("com.jberry.services.calendar.CalendarServiceImpl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CalendarService calendarServiceInstance = null;
        try {
            calendarServiceInstance = (CalendarService) c.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return calendarServiceInstance;
    }
}
