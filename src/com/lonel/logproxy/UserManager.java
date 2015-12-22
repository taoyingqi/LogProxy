package com.lonel.logproxy;

/**
 * Created by lonel on 2015/12/22.
 */
public interface UserManager {
    void addUser(String userId, String userName);

    void delUser(String userId);

    String findUser(String userId);

    void modifyUser(String userId, String userName);
}
