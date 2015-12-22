package com.lonel.logproxy;

import java.util.logging.Logger;

/**
 * Created by lonel on 2015/12/22.
 */
public class UserManagerImpl implements UserManager {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void addUser(String userId, String userName) {
        try {
            logger.info(userId + "-" + userName);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void delUser(String userId) {
        logger.info(userId);
    }

    @Override
    public String findUser(String userId) {
        logger.info(userId);
        return "张三";
    }

    @Override
    public void modifyUser(String userId, String userName) {
        logger.info(userId + "-" + userName);
    }
}
