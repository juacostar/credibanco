package credibanco.assessment.card.service;

import credibanco.assessment.card.dto.*;

import java.util.List;

public interface TransactionService {

    CreateTransactionResponse createTransaction(CreateTransactionDTO createTransactionDTO);

    DeleteTransactionResponse deleteTransaction(DeleteTransactionDTO deleteTransactionDTO);

    List<GetTransactionResponse> findAllTransactions();
}
