package vn.iostar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import vn.iostar.Services.CustomUserDetailsService;
import vn.iostar.Services.UserServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	@Bean 
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		final List<GlobalAuthenticationConfigurerAdapter> configurers = new ArrayList<>(); 
		configurers.add(new GlobalAuthenticationConfigurerAdapter() { 
			@Override 
			public void configure(AuthenticationManagerBuilder auth) throws Exception {
				// auth.doSomething() 
				} 
			
			}
		});
	return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/")
						.hasAnyAuthority("USER", "ADMIN", "EDITOR", "CREATOR").requestMatchers("/new")
						.hasAnyAuthority("ADMIN", "CREATOR").requestMatchers("/edit/**")
						.hasAnyAuthority("ADMIN", "EDITOR").requestMatchers("/delete/**").hasAuthority("ADMIN")
						.requestMatchers(HttpMethod.GET, "/api/**").permitAll().anyRequest().authenticated())
				.httpBasic(withDefaults()).formLogin(login -> login.loginPage("/login").permitAll())
				.logout(logout -> logout.permitAll()).exceptionHandling(handling -> handling.accessDeniedPage("/403"))
				.build();
	}

}
