package com.algaworks.algalog.commom;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean // Foi preciso criar essa classe com esse método , pois a classe ModelMapper não conseguia ser injetada, porque ela não é do spring
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
}
