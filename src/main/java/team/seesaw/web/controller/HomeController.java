package team.seesaw.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.seesaw.common.service.MovieServiceImpl;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final MovieServiceImpl movieService;

    @GetMapping
    public String showMainHome(Model model){

        return "web/home";
    }



}
