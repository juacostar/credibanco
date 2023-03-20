package credibanco.assessment.card.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import credibanco.assessment.card.dto.*;
import credibanco.assessment.card.service.CardService;
import credibanco.assessment.card.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.List;

@Controller
public class ApiController {

    @Autowired
    private CardService cardService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "card/create", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<CardResponse> createCard(@RequestBody CreateCardDTO createCardDTO){
        return ResponseEntity.ok(cardService.createCard(createCardDTO));
    }

    @RequestMapping(value = "card/enroll", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<CardResponse> enrollCard(@RequestBody EnrollCardDTO enrollCardDTO){
        return ResponseEntity.ok(cardService.enrollCard(enrollCardDTO));
    }

    @RequestMapping(value = "/card/{pan}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<getCardResponse> getCard(@PathVariable String pan){
        return ResponseEntity.ok(cardService.getCard(pan));
    }

    @RequestMapping(value = "card/delete", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<DeleteCardResponse> deleteCard(@RequestBody DeleteCardDTO deleteCardDTO){
        return ResponseEntity.ok(cardService.deleteCard(deleteCardDTO));
    }

    @RequestMapping(value = "/transaction/create", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<CreateTransactionResponse> createTransaction(@RequestBody CreateTransactionDTO createTransactionDTO){
        return  ResponseEntity.ok(transactionService.createTransaction(createTransactionDTO));
    }

    @RequestMapping(value = "/transaction/deny", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<DeleteTransactionResponse> denyTransacton(@RequestBody DeleteTransactionDTO deleteTransactionDTO){
        return ResponseEntity.ok(transactionService.deleteTransaction(deleteTransactionDTO));
    }

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<getCardResponse>> getAllCards(){
        return ResponseEntity.ok(cardService.getAllCArds());
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    public  @ResponseBody ResponseEntity<List<GetTransactionResponse>> findAllTransactions(){
        return ResponseEntity.ok(transactionService.findAllTransactions());
    }

}
