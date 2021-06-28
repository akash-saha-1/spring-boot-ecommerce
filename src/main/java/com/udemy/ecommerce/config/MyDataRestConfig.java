package com.udemy.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.udemy.ecommerce.entities.Product;
import com.udemy.ecommerce.entities.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,CorsRegistry cors) {
		HttpMethod[] theUnsupportedActions= {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE}; 
		
		//Disable HTTP methods for Product: PUT, POST AND DELETE
		config.getExposureConfiguration()
			.forDomainType(Product.class)
			.withItemExposure((metData,httpMethods)-> httpMethods.disable(theUnsupportedActions))
			.withCollectionExposure((metData,httpMethods)-> httpMethods.disable(theUnsupportedActions));
		
		//Disable HTTP methods for Product: PUT, POST AND DELETE
				config.getExposureConfiguration()
					.forDomainType(ProductCategory.class)
					.withItemExposure((metData,httpMethods)-> httpMethods.disable(theUnsupportedActions))
					.withCollectionExposure((metData,httpMethods)-> httpMethods.disable(theUnsupportedActions));
		
	}
	
}
