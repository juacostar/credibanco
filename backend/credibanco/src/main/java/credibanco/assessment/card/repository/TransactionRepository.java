package credibanco.assessment.card.repository;

import credibanco.assessment.card.model.Card;
import credibanco.assessment.card.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {

    Transaction findTransactionByReferenceAndCard(String reference, Card card);
}
