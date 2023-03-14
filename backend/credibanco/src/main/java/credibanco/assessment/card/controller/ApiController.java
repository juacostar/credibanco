package credibanco.assessment.card.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import credibanco.assessment.card.dto.CardResponse;
import credibanco.assessment.card.dto.CreateCardDTO;
import credibanco.assessment.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

@Controller
public class ApiController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "card/create", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<CardResponse> createCard(@RequestBody CreateCardDTO createCardDTO){
        System.out.println(createCardDTO.getPan());
        return ResponseEntity.ok(cardService.createCard(createCardDTO));
    }
}
