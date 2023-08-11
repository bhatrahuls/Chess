package com.example.ChessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.example.ChessApplication",
				"com.example.ChessGameService",
				"com.example.controller",
				"com.example.model"}
)
public class ChessApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);
	}
}