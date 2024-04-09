package customMeals.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import customMeals.beans.Appetizer;
import customMeals.beans.Entree;
import customMeals.beans.Ingredient;
import customMeals.beans.Meal;
import customMeals.beans.Side;

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
	
	@Bean
	Side side() {
		Side bean = new Side();
		return bean;
	}
	
	@Bean
	Appetizer appetizer() {
		Appetizer bean = new Appetizer();
		return bean;
	}
	
	@Bean
	Meal meal() {
		Meal bean = new Meal();
		return bean;
	}
	
}
