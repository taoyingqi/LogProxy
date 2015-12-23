package com.lonel.logproxy;

/**
 * Created by lonel on 2015/12/22.
 */
public class Client {
    public static void main(String[] args) {
        LogHandler logHandler = new LogHandler();
        UserManager UserManager = (UserManager) logHandler.bind(new UserManagerImpl());
        String name = UserManager.findUser("0001");
        System.out.println("Client.main() -- " + name);
    }
}
