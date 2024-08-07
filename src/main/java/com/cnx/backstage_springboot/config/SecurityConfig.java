package com.cnx.backstage_springboot.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.StringUtils;
import com.nimbusds.jose.shaded.gson.internal.LinkedTreeMap;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // @formatter:off
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
                auth -> auth.requestMatchers("/hello").fullyAuthenticated().anyRequest().permitAll())
        .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
    // @formatter:on
    return http.build();
  }

  //Enable this if any customization is required for granted token
  @Bean
  public JwtAuthenticationConverter jwtAuthenticationConverterForKeycloak() {
    Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter =
        jwt -> {
          Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
          Object client = resourceAccess.get("spring-poc-client");
          LinkedTreeMap<String, List<String>> clientRoleMap =
              (LinkedTreeMap<String, List<String>>) client;
          List<String> clientRoles = new ArrayList<>(clientRoleMap.get("roles"));
          return clientRoles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        };

    JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);

    if (StringUtils.hasText("name")) {
      jwtAuthenticationConverter.setPrincipalClaimName("name");
    }

    return jwtAuthenticationConverter;
  }
}
