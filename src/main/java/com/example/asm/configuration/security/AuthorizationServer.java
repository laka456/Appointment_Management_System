package com.example.asm.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

        configurer
                .inMemory()
                .withClient("asm")
                .secret(encoder.encode("asm"))
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
                .scopes("read", "write", "trust")
                .accessTokenValiditySeconds((1 * 60 * 60)).
                refreshTokenValiditySeconds((6 * 60 * 60));
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStoreNew())
                .authenticationManager(authenticationManager)
                .accessTokenConverter(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("as466gfsdfsdf");
        return converter;
    }

    @Bean
    public TokenStore tokenStoreNew() {
        return new JwtTokenStore(accessTokenConverter());
    }
}