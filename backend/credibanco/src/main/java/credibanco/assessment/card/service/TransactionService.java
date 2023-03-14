package credibanco.assessment.card.service;

import credibanco.assessment.card.dto.CreateTransactionDTO;
import credibanco.assessment.card.dto.CreateTransactionResponse;
import credibanco.assessment.card.dto.DeleteTransactionDTO;
import credibanco.assessment.card.dto.DeleteTransactionResponse;

public interface TransactionService {

    CreateTransactionResponse createTransaction(CreateTransactionDTO createTransactionDTO);

    DeleteTransactionResponse deleteTransaction(DeleteTransactionDTO deleteTransactionDTO);
}
