package credibanco.assessment.card.service.impl;

import credibanco.assessment.card.dto.*;
import credibanco.assessment.card.model.Card;
import credibanco.assessment.card.model.Transaction;
import credibanco.assessment.card.repository.CardRepository;
import credibanco.assessment.card.repository.TransactionRepository;
import credibanco.assessment.card.service.TransactionService;
import credibanco.assessment.card.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardRepository cardRepository;

    @Override
    public CreateTransactionResponse createTransaction(CreateTransactionDTO createTransactionDTO) {
        CreateTransactionResponse response = new CreateTransactionResponse();

        try{
            Transaction transaction = new Transaction();

            if(createTransactionDTO.getReference().length() != 6) throw new Exception();
            else{
                transaction.setReference(createTransactionDTO.getReference());
                transaction.setAmount(createTransactionDTO.getAmount());
                transaction.setAddress(createTransactionDTO.getAddress());
                transaction.setState(Constants.APPROVED.getMessage());
                transaction.setDate(new Date());

                Card card = cardRepository.findCardByPAN(createTransactionDTO.getPAN());
                transaction.setCard(card);

                transactionRepository.save(transaction);
                response.setState(Constants.APPROVED.getMessage());
                response.setCode(Constants.CODE_SUCCESS.getMessage());
                response.setMessage(Constants.SUCCESS.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
            response.setMessage(Constants.FAILED.getMessage());
            response.setCode(Constants.CODE_FAILED.getMessage());
            response.setState(Constants.REJECTED.getMessage());
        }

        return response;
    }

    @Override
    public DeleteTransactionResponse deleteTransaction(DeleteTransactionDTO deleteTransactionDTO) {

        DeleteTransactionResponse response = new DeleteTransactionResponse();

        try{
            Card card = cardRepository.findCardByPAN(deleteTransactionDTO.getPAN());
            Transaction transaction = transactionRepository.findTransactionByReferenceAndCard(deleteTransactionDTO.getReference(), card);

            if(minutesDiff(transaction.getDate())){
                transaction.setState(Constants.REJECTED.getMessage());
                transactionRepository.save(transaction);
                response.setReferenceNumber(deleteTransactionDTO.getReference());
                response.setCode(Constants.CODE_SUCCESS.getMessage());
                response.setMessage(Constants.BUY_DELETED.getMessage());
            }else{
                response.setCode(Constants.CODE_FAILED.getMessage());
                response.setMessage(Constants.CANNOT_DELETE_TRANSACTION.getMessage());
            }
        }catch (Exception e){
            response.setCode(Constants.BAD_REFERENCE.getMessage());
            response.setMessage(Constants.BAD_REFERENCE_MESSAGE.getMessage());
        }

        return response;
    }

    @Override
    public List<GetTransactionResponse> findAllTransactions() {

        List<GetTransactionResponse> response = new ArrayList<>(); // Liskov Substitution
        List<Transaction> transactions = (List<Transaction>) transactionRepository.findAll();

        for(Transaction transaction: transactions){
            GetTransactionResponse getTransactionResponse = new GetTransactionResponse();
            getTransactionResponse.setCardPan(transaction.getCard().getPAN());
            getTransactionResponse.setAmount(transaction.getAmount());
            getTransactionResponse.setDate(transaction.getDate());
            getTransactionResponse.setState(transaction.getState());
            getTransactionResponse.setReference(transaction.getReference());
            getTransactionResponse.setAddress(transaction.getAddress());

            response.add(getTransactionResponse);
        }

        return response;
    }

    public boolean minutesDiff(Date transactionDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                Locale.ENGLISH);

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(transactionDate.toString());
            d2 = sdf.parse(new Date().toString());
            d2 = format.parse(d2.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diff = d2.getTime() - d1.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;

        return diffMinutes < 5;
    }


}
