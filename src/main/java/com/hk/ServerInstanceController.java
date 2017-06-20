package com.hk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiaminghui on 2017/6/15 0015.
 */
@RestController
public class ServerInstanceController {
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 查看服务实例信息
     * @param applicationName
     * @return
     */
    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    /**
     * say
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public String say(@PathVariable("name") String name) {
        return "hello client "+ name;
    }
}
