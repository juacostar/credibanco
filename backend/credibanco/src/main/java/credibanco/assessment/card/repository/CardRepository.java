package credibanco.assessment.card.repository;

import credibanco.assessment.card.model.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface CardRepository extends CrudRepository<Card, String> {

    Card findCardByPAN(String P);
}
