package credibanco.assessment.card.service.impl;

import credibanco.assessment.card.dto.*;
import credibanco.assessment.card.model.Card;
import credibanco.assessment.card.repository.CardRepository;
import credibanco.assessment.card.service.CardService;
import credibanco.assessment.card.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl  implements CardService {

    @Autowired
    private CardRepository cardRepository;



    @Override
    public CardResponse createCard(CreateCardDTO createCardDTO) {
        CardResponse response = new CardResponse();

        try{
            Card card = new Card();
            card.setPAN(createCardDTO.getPan());
            card.setValidationNumber(generateValidationNumber());
            card.setOwner(createCardDTO.getOwner());
            card.setUserId(createCardDTO.getUserID());
            card.setType(createCardDTO.getType());
            card.setPhone(createCardDTO.getPhone());
            card.setMoney(0.0);
            card.setState(false);

            Card newCard = cardRepository.save(card);

            response.setCode(Constants.CODE_SUCCESS.getMessage());
            response.setMessage(Constants.SUCCESS.getMessage());
            response.setPAN(maskPan(newCard.getPAN()));
        }catch (Exception e){
            e.printStackTrace();
            response.setMessage(Constants.FAILED.getMessage());
            response.setCode(Constants.CODE_FAILED.getMessage());
        }

        return response;

    }


    public String maskPan(String PAN){
        String astherics = "";
        String first = PAN.substring(0, 4);
        String last = PAN.substring(PAN.length() - 4, PAN.length());
        for(int i = 4; i<PAN.length() - 4; i++){
            astherics += "*";
        }

        return  first + astherics + last;
    }
    public Integer generateValidationNumber(){
        return (int)(Math.random() * 99 +1);
    }

    @Override
    public CardResponse enrollCard(EnrollCardDTO enrollCardDTO) {
        return null;
    }

    @Override
    public getCardResponse getCard(GetCardDTO getCardDTO) {
        return null;
    }

    @Override
    public DeleteCardDTO deleteCard(DeleteCardDTO deleteCardDTO) {
        return null;
    }
}
