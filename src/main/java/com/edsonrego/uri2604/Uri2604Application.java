package com.edsonrego.uri2604;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edsonrego.uri2604.dto.ProductMinDTO;
import com.edsonrego.uri2604.projections.ProductMinProjection;
import com.edsonrego.uri2604.repositories.ProductRepository;

@SpringBootApplication
public class Uri2604Application implements CommandLineRunner{
	
	@Autowired
	public ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2604Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<ProductMinProjection> list = repository.search1(1.0);
		List<ProductMinDTO> result1 = list.stream().map(x -> new ProductMinDTO(x)).collect(Collectors.toList());
		
		System.out.println("\n*** RESULTADO SQL RAIZ:");
		for (ProductMinDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println("\n\n");	
	}
}
