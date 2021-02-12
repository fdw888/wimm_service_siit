package oaie.io.wimmservice.controller;

import oaie.io.wimmservice.dao.BankTransactionsRepository;
import oaie.io.wimmservice.dto.BankTransactionDTO;
import oaie.io.wimmservice.entities.BankTransaction;
import oaie.io.wimmservice.services.BankTransactionProcessingService;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankTransactionRESTController {


    private static Logger logger = LoggerFactory.getLogger(BankTransactionRESTController.class);


    @Autowired
    private BankTransactionProcessingService bankTransactionProcessingService;

    @Autowired
    private ModelMapper modelMapper;


    private final BankTransactionsRepository repository;

    public BankTransactionRESTController(BankTransactionsRepository repository) {
        this.repository = repository;
    }

    // GET all existing transactions
    @GetMapping("/transactions")
    List<BankTransaction> all() {
        return repository.findAll();
    }

    //GET transactions by Iban
    @GetMapping("/transactions/iban/{iban}")
    @ResponseBody
    List<BankTransaction> ListOfTransactionsByIban(@PathVariable String iban) {

        return repository.findBankTransactionByIban(iban);

    }

    //GET transactions by Category
    @GetMapping("/transactions/category/{categoryName}")
    @ResponseBody
    List<BankTransaction> ListOfTransactionsByCategory(@PathVariable String categoryName) {
        return repository.findTransactionsByCategoryName(categoryName);
    }

    @PostMapping("/transactions")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String createBankTransaction(@RequestBody List<BankTransactionDTO> listOfBankTransactions) {
        try {
            bankTransactionProcessingService.setCategoryToBankTransactionEntity(listOfBankTransactions);

            return listOfBankTransactions.size() + " successfully created!";
        } catch (MappingException me) {
            logger.error(me.getMessage(), me);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, me.getMessage());

        } catch (DataAccessResourceFailureException darfe) {
            logger.error(darfe.getMessage(), darfe);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database not available");
        } catch (DataIntegrityViolationException dive) {
            logger.error(dive.getMessage(), dive);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Sent request does not respect DB constraints");
        }

    }

}
