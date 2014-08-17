package com.jberry.services.tools;

public class ToolServiceFactory {
    public static ToolService getToolService() {
        Class c = null;
        try {
            c = Class.forName("com.jberry.services.tools.ToolService");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ToolService ToolServiceInstance = null;
        try {
            ToolServiceInstance = (ToolService) c.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return ToolServiceInstance;
    }
}
