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

        Income income = incomeService.getCurrentIncome();

        model.addAttribute("spending", spendingService.getActualSpendingsForCurrentMonth());
        model.addAttribute("income", income.getAmount());
        return "home";
    }

    @PostMapping(value = "/income")
    public String updateIncome(String amount) {
        double amountAsDouble = Double.parseDouble(amount.replaceAll(",", ""));
        incomeService.createOrUpdateIncome(amountAsDouble);
        return "redirect:/";
    }
}
