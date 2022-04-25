package es.tfg.hospital.modelo.security.configuracion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private DataSource dataSource;
	
	//Cambiado p.nombre por p.descripcion, sino da excepcion
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,password,enabled from Usuarios where username=?")
		.authoritiesByUsernameQuery("select u.username, p.descripcion from Usuario_Perfil up" +
		" inner join Usuarios u on u.username = up.username " +
		" inner join Perfiles p on p.id_perfil = up.id_Perfil where u.username=?");

	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/","/pwd","/registro","/login","/logout","/css/**","/cal/**","/img/**","/js/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll();
	}
}