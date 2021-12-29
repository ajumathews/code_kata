package org.grace.practice.boot.controller;

import org.grace.practice.boot.model.Account;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(value = "/retrieveBasic/{accountId}", method = RequestMethod.GET)
    public Account retrieveAccount(@PathVariable @NotNull int accountId) {
        return new Account(10);
    }


    @RequestMapping(value = "/retrieveResponseEntity/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<Account> retrieveAccountResponseEntity(@PathVariable @NotNull int accountId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("test", "value");
        //return new ResponseEntity<>(new Account(10),httpHeaders,HttpStatus.ACCEPTED);
        return ResponseEntity.ok().headers(httpHeaders).body(new Account(10));
    }


    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
    public ResponseEntity<String> saveAccount(@RequestBody Account account) {
        return ResponseEntity.ok().body(account.getAccountId() + " saved to database");
    }

    @RequestMapping(value = "/retrieveResponseBody/{accountId}", method = RequestMethod.GET)
    @ResponseBody
    public Account retrieveResponseBody(@PathVariable @NotNull int accountId) {
        return new Account(10);
    }

    @RequestMapping(value = "/retrieveResponseEntityWithExceptionHandler/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<Account> retrieveAccountResponseEntityWithExceptionHandler(@PathVariable @NotNull int accountId) {
        if(accountId ==10) {
            return new ResponseEntity<>(new Account(10), HttpStatus.ACCEPTED);
        }else{
            throw new RuntimeException("Account not found");
        }
    }


}
