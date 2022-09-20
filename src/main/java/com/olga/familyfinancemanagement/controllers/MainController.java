package com.olga.familyfinancemanagement.controllers;

import com.olga.familyfinancemanagement.models.Income;
import com.olga.familyfinancemanagement.services.AnalysisService;
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
    private final AnalysisService analysisService;

    @GetMapping
    String redirectToHome() {
        return "redirect:/home";
    }

    @GetMapping(value = "/home")
    String getHomePage(
            @RequestParam(value = "yyyymm", required = false) String yyyymm,
            Model model) {

        Date month = addMonthsToModel(yyyymm, model);
        Income income = incomeService.getIncomeForMonth(month);

        model.addAttribute("spending", spendingService.getActualSpendingsForMonth(month));
        model.addAttribute("income", income.getAmount());
        model.addAttribute("analyses", analysisService.getAnalysesForMonth(month));

        return "home";
    }

    @PostMapping(value = "/income")
    public String updateIncome(
            String yyyymm,
            String amount) {

        Date month = getMonthFromYYYYMM(yyyymm);
        double amountAsDouble = parseMoneyField(amount);

        incomeService.createOrUpdateIncome(month, amountAsDouble);
        return "redirect:/home?yyyymm=" + yyyymm;
    }

    @GetMapping(value = "/spending")
    public String getSpending(
            @RequestParam(value = "yyyymm", required = false) String yyyymm,
            Model model) {

        Date month = addMonthsToModel(yyyymm, model);
        Income income = incomeService.getIncomeForMonth(month);

        model.addAttribute("spending", spendingService.getActualSpendingsForMonth(month));
        model.addAttribute("income", income.getAmount());
        model.addAttribute("spendingCategories", spendingService.getAllSpendingCategories());

        return "spending";
    }

    @PostMapping(value = "incomeEditSpendingPage")
    public String updateIncomeEditSpending(
            String yyyymm,
            String amount) {

        Date month = getMonthFromYYYYMM(yyyymm);
        double amountAsDouble = parseMoneyField(amount);

        incomeService.createOrUpdateIncome(month, amountAsDouble);
        return "redirect:/spending?yyyymm=" + yyyymm;
    }

    @PostMapping(value = "/incomeAnalysisPage")
    public String updateIncomeAnalysis(
            String yyyymm,
            String amount) {

        Date month = getMonthFromYYYYMM(yyyymm);
        double amountAsDouble = parseMoneyField(amount);

        incomeService.createOrUpdateIncome(month, amountAsDouble);
        return "redirect:/analysis?yyyymm=" + yyyymm;
    }


    @PostMapping(value = "/addSpending")
    public String addSpending(
            String yyyymm,
            String amount,
            int categoryId,
            Date date) {

        double amountAsDouble = parseMoneyField(amount);

        spendingService.addActualSpending(amountAsDouble, date, categoryId);

        return "redirect:/spending?yyyymm=" + yyyymm;
    }

    @PostMapping(value = "/editSpending")
    public String editSpending(
            String yyyymm,
            String amount,
            int categoryId,
            Date date) {

        double amountAsDouble = parseMoneyField(amount);

        spendingService.updateActualSpending(amountAsDouble, date, categoryId);

        return "redirect:/spending?yyyymm=" + yyyymm;
    }

    @PostMapping(value = "/deleteSpending")
    public String deleteSpending(
            String yyyymm,
            int actualSpendingId,
            Date date) {

        System.out.println("In /deleteSpending, yyyymm = " + yyyymm + ", actualSpendingId = " + actualSpendingId);
        spendingService.deleteActualSpending(actualSpendingId);
        return "redirect:/spending?yyyymm=" + yyyymm;
    }


    @GetMapping(value = "/analysis")
    public String getAnalysis(
            @RequestParam(value = "yyyymm", required = false) String yyyymm,
            Model model) {

        Date month = addMonthsToModel(yyyymm, model);
        Income income = incomeService.getIncomeForMonth(month);

        model.addAttribute("spending", spendingService.getActualSpendingsForMonth(month));
        model.addAttribute("income", income.getAmount());
        model.addAttribute("analyses", analysisService.getAnalysesForMonth(month));

        return "analysis";
    }

    //Adds the thisMonth, lastMonth and nextMonth attributes to the model, obtained from yyyymmdd.
    //Returns thisMonth
    private Date addMonthsToModel(String yyyymm, Model model) {

        Date thisMonth = getMonthFromYYYYMM(yyyymm);
        model.addAttribute("thisMonth", thisMonth);
        model.addAttribute("lastMonth", DateUtils.addMonths(thisMonth, -1));
        model.addAttribute("nextMonth", DateUtils.addMonths(thisMonth, 1));

        return thisMonth;
    }

    private Date getMonthFromYYYYMM(String yyyymm) {
        Date parsedMonth = DateUtils.parseYYYYMM(yyyymm);
        Date month = parsedMonth == null ?
                DateUtils.getFirstDayOfCurrentMonth() :
                parsedMonth;
        return month;
    }

    private double parseMoneyField(String amount) {
        return Double.parseDouble(amount.replaceAll(",", ""));
    }
}
