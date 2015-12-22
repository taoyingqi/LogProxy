package com.lonel.logproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

/**
 * Created by lonel on 2015/12/22.
 */
public class LogHandler implements InvocationHandler {

    private Object delegate;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(), this);
    }

    /**
     * @proxy:表示代理类
     * @method：表示需要代理的方法
     * @args:表示代理方法的参数数组
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("start-->>" + method.getName());
        for (int i = 0; i < args.length; i++) {
            logger.info(args[i].toString());
        }
        Object ret = null;
        try {
            //调用目标方法
            ret = method.invoke(delegate, args);
            logger.info("success-->>" + method.getName());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("error-->>" + method.getName());
            throw e;
        }
        return ret;
    }
}
