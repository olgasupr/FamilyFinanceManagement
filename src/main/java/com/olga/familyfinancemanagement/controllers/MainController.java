package com.olga.familyfinancemanagement.controllers;

import com.olga.familyfinancemanagement.models.Income;
import com.olga.familyfinancemanagement.services.IncomeService;
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
    private final IncomeService incomeService;

    @GetMapping
    String getHomePage(Model model) {

        Income income = new Income(); //TODO:  fix to correct one

        model.addAttribute("spending", spendingService.getActualSpendingsForCurrentMonth());
        model.addAttribute("income", income.getAmount());
        return "home";
    }

    @PostMapping(value = "/updateIncome")
    public String updateIncome(double newIncome) {
        //TODO:  call incomeService and update the income
        return "redirect:/";
    }
}
