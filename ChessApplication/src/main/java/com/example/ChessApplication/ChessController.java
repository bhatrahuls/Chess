package com.example.ChessApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ChessController {
    @RequestMapping("chess")
    public String chess() {
        return "chess.jsp";

    }


    @PostMapping("/move")
    public String postMapping() {
        return "chess.jsp";
    }

}




