package com.olga.familyfinancemanagement.controllers;

import com.olga.familyfinancemanagement.services.SpendingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class MainController {

    private final SpendingService spendingService;

    @GetMapping
    String getHomePage(Model model) {
        model.addAttribute("spending", spendingService.getActualSpendingsForCurrentMonth());
        return "home";
    }

    @PostMapping(value = "/updateIncome")
    public String updateIncome(double newIncome) {
        return "redirect:/";
    }
}
