package credibanco.assessment.card.service;

import credibanco.assessment.card.dto.*;
import credibanco.assessment.card.model.Card;
import credibanco.assessment.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface CardService {

    CardResponse createCard(CreateCardDTO createCardDTO);

    CardResponse enrollCard(EnrollCardDTO enrollCardDTO);

    getCardResponse getCard(String pan);

    DeleteCardResponse deleteCard(DeleteCardDTO deleteCardDTO);


}
