package com.yan.springframework.aop.framework;

import com.yan.springframework.aop.AdvisedSupport;

/**
 * ProxyFactory
 *
 * @description:
 * @author: yan-yj
 * @time: 2022/1/14 20:50
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    public AopProxy createAopProxy(){
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }

        return new JdkDynamicAopProxy(advisedSupport);
    }
}
