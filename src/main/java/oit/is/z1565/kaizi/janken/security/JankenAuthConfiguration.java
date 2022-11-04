package oit.is.z1565.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class JankenAuthConfiguration {

  @Bean
  public InMemoryUserDetailsManager userDtailsService() {
    UserBuilder users = User.builder();

    UserDetails user1 = users
        .username("user1")
        .password("$2y$10$sb69jYweMBnEObEvlz0m8OGylxcB3oD.oSzxwjXFvSKmHdPt5r6QS")
        .roles("USER")
        .build();
    UserDetails user2 = users
        .username("user2")
        .password("$2y$10$mBOeAjzP8BemBZla4DhjReuWvGdptU.uh9SH1BKoLL7Xhck40JJgG")
        .roles("USER")
        .build();
    UserDetails user3 = users
        .username("ほんだ")
        .password("$2y$10$eZXzt49tjBYvAZnhvjKT1.CqtjiABm374Oyhqb/Cr51hebN/Q24le")
        .roles("USER")
        .build();
    UserDetails user4 = users
        .username("いがき")
        .password("$2y$10$uOvWJu3aVlv9vBTVfyTqVO9x3fQs6EtpUSl79Wn4cTxdNnAWhDt4C")
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(user1, user2, user3, user4);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin();

    http.authorizeHttpRequests()
        .mvcMatchers("/janken/**").authenticated();

    http.logout().logoutSuccessUrl("/");

    http.csrf().disable();
    http.headers().frameOptions().disable();
    // ↑2行は実装時にコメントアウトする必要がある
    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
