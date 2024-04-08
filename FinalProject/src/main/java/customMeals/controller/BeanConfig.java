package customMeals.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import customMeals.beans.Entree;
import customMeals.beans.Ingredient;

@Configuration
public class BeanConfig {

	@Bean
	Ingredient ingredient() {
		Ingredient bean = new Ingredient();
		return bean;
	}
	
	@Bean
	Entree entree() {
		Entree bean = new Entree();
		return bean;
	}
	
}
