package com.example.ChessApplication;
import com.example.model.Board;
import com.example.ChessGameService.Helper;
import com.example.model.Piece;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

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