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
		.usersByUsernameQuery("select usuario.dni as username,password,enabled from usuario where dni=?")
		.authoritiesByUsernameQuery("select u.dni as username, p.desc_per from Usuario_Perfil up" +
				" inner join Usuario u on u.dni = up.dni " +
				" inner join Perfil p on p.id_perfil = up.id_perfil where u.dni= ?");

	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.authorizeRequests()									//borrar usuario
		.antMatchers("/","/pwd","/registro","/login","/index","/usuario","/verUna","/logout","/css/**","/cal/**","/img/**","/js/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll().defaultSuccessUrl("/index",true);
	}
}
	
	
	