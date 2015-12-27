package com.yourbank.web.controller;

import com.yourbank.data.model.bank.Credit;
import com.yourbank.service.bank.CreditService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author admin.
 */
@Controller
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    CreditService creditService;

    @RequestMapping(value = "/layout", method = RequestMethod.GET)
    public String creditLayout() {
        return "private/credit";
    }

    @RequestMapping(value = "/add_credit", method = RequestMethod.GET)
    public Credit add() {
        Credit credit = new Credit();
//        model.put("creditForm", credit);
//        model.put("currency", Credit.CurrencyCode.values());
        return credit;
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Credit> add(Credit credit) {
        creditService.add(credit);
        return creditService.getAll();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Credit> credits() {
        return creditService.getAll();
    }

    @RequestMapping(value = "/{creditID}", method = RequestMethod.GET)
    @ResponseBody
    public Credit detail(@PathVariable long creditID) {
        return creditService.get(creditID);
    }
}
