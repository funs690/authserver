package com.zjuici.authserver.application.service.biz.client.impl;

import com.zjuici.authserver.application.service.biz.client.RegisterClientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.ClientSettings;
import org.springframework.security.oauth2.server.authorization.config.TokenSettings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author fuzeqiang
 * @projectName authserver
 * @title: RegisterCilentServerImpl
 * @date 2022/1/7 10:27
 */
@Log4j2
@Service
public class RegisterClientServiceImpl implements RegisterClientService {


    /**
     * 密码加密工具
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 注册服务
     */
    @Autowired
    private RegisteredClientRepository registeredClientRepository;

    /**
     * 注册client
     *
     * @param clientId
     * @param clientSecret
     */
    @Transactional
    @Override
    public void registerClient(String name, String clientId, String clientSecret, String... redirectUri) {
        //配置register client
        RegisteredClient client = RegisteredClient
                // 设置id
                .withId(UUID.randomUUID().toString().replace("-", ""))
                // 设置名称
                .clientName(name)
                // 设置client_id
                .clientId(clientId)
                // 设置client_secret
                .clientSecret(passwordEncoder.encode(clientSecret))
                // 设置client的认证方式
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                // 设置服务支持认证类型
                .authorizationGrantTypes(authorizationGrantTypes -> {
                    authorizationGrantTypes.add(AuthorizationGrantType.AUTHORIZATION_CODE);
                    authorizationGrantTypes.add(AuthorizationGrantType.CLIENT_CREDENTIALS);
                    authorizationGrantTypes.add(AuthorizationGrantType.PASSWORD);
                    authorizationGrantTypes.add(AuthorizationGrantType.REFRESH_TOKEN);
                })
                // 设置服务的重定向url
                .redirectUris(redirectUris -> redirectUris.addAll(Arrays.asList(redirectUri)))
                // 设置允许获得的权限信息
                .scopes(scopes -> {
                    scopes.add(OidcScopes.OPENID);
                    scopes.add(OidcScopes.PHONE);
                    scopes.add(OidcScopes.EMAIL);
                })
                // 设置是否需要用户确认提权
                .clientSettings(ClientSettings.builder()
                        .requireAuthorizationConsent(true)
                        .build()
                )
                // 设置token过期时间
                .tokenSettings(TokenSettings.builder()
                        .accessTokenTimeToLive(Duration.ofHours(1))
                        .refreshTokenTimeToLive(Duration.ofDays(1))
                        .build()
                )
                .build();
        // 保存register client
        registeredClientRepository.save(client);
    }
}
