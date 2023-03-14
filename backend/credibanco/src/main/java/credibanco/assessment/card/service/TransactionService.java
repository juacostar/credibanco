package credibanco.assessment.card.service;

import credibanco.assessment.card.dto.CreateTransactionDTO;

public interface TransactionService {

    Boolean createTransaction(CreateTransactionDTO createTransactionDTO);

    Boolean deleteTransaction();
}
