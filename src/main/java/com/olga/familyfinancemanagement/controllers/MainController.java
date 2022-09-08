package com.olga.familyfinancemanagement.controllers;

import com.olga.familyfinancemanagement.repositories.ActualSpendingRepo;
import com.olga.familyfinancemanagement.repositories.SpendingCategoryRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private ActualSpendingRepo _actualSpendingRepo;
    private SpendingCategoryRepo _spendingCategoryRepo;

    public MainController() {
        _spendingCategoryRepo = new SpendingCategoryRepo();
        _actualSpendingRepo = new ActualSpendingRepo(_spendingCategoryRepo);
    }

    @GetMapping
    String getHomePage(Model model) {
        model.addAttribute("income", 12345);
        model.addAttribute("spending", _actualSpendingRepo.getLatestSpending());
        return "home";
    }
}
