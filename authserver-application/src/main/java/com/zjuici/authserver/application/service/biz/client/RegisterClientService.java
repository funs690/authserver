package com.zjuici.authserver.application.service.biz.client;

/**
 * @author fuzeqiang
 * @projectName authserver
 * @title: RegisterCilentServer
 * @date 2022/1/7 10:27
 */
public interface RegisterClientService {


    /**
     * 注册client
     * @param name
     * @param clientId
     * @param clientSecret
     * @param redirectUri
     */
    void registerClient(String name, String clientId, String clientSecret, String... redirectUri);

}
