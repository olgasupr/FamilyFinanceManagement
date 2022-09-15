package com.olga.familyfinancemanagement.controllers;

import com.olga.familyfinancemanagement.models.Income;
import com.olga.familyfinancemanagement.services.IncomeService;
import com.olga.familyfinancemanagement.services.SpendingService;
import com.olga.familyfinancemanagement.utils.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

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

    @GetMapping(value = "/spending")
    public String getSpending(Model model) {

        Income income = incomeService.getCurrentIncome();

        model.addAttribute("spending", spendingService.getActualSpendingsForCurrentMonth());
        model.addAttribute("income", income.getAmount());
        return "spending";
    }

    @GetMapping(value = "/analysis")
    public String getAnalysis(Model model) {

        Income income = incomeService.getCurrentIncome();

        model.addAttribute("spending", spendingService.getActualSpendingsForCurrentMonth());
        model.addAttribute("income", income.getAmount());
        return "analysis";
    }

    @GetMapping(value = "/month")
    public String dummyMonthSelector(
            @RequestParam(value = "yyyymm", required = false) String yyyymm,
            Model model) {

        addInputMonthToModel(yyyymm, model);
        return "month";
    }


    private void addInputMonthToModel(String yyyymm, Model model) {

        Date parsedMonth = DateUtils.parseYYYYMM(yyyymm);
        Date thisMonth = parsedMonth == null ?
                DateUtils.getFirstDayOfCurrentMonth() :
                parsedMonth;

        model.addAttribute("thisMonth", thisMonth);
        model.addAttribute("lastMonth", DateUtils.addMonths(thisMonth, -1));
        model.addAttribute("nextMonth", DateUtils.addMonths(thisMonth, 1));
    }
}
