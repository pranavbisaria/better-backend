package com.Better;

import com.Better.Config.AppConstants;
import com.Better.Models.Role;
import com.Better.Repository.RoleRepo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableAsync
@OpenAPIDefinition(info = @Info(title = "BETTER: Reshape, Renew, Better You",version = "3.0",description = "Promoting sustainability for all"))
@EnableCaching
public class BetterAppApplication implements CommandLineRunner {
	private final RoleRepo roleRepo;
	public static void main(String[] args) {
		SpringApplication.run(BetterAppApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	@Override
	public void run(String... args){
		try{
			Role role1 = new Role();
			role1.setId(AppConstants.ROLE_ADMIN);
			role1.setName("ROLE_ADMIN");

			Role role2 = new Role();
			role2.setId(AppConstants.ROLE_NORMAL);
			role2.setName("ROLE_NORMAL");

			Role role3 = new Role();
			role3.setId(AppConstants.ROLE_MERCHANT);
			role3.setName("ROLE_MERCHANT");

			List<Role> roles= List.of(role1, role2, role3);
			this.roleRepo.saveAll(roles);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
