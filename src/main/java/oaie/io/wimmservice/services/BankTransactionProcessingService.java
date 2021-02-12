package oaie.io.wimmservice.services;

import oaie.io.wimmservice.dao.BankCategoryRepository;
import oaie.io.wimmservice.dao.BankTransactionsRepository;
import oaie.io.wimmservice.dto.BankTransactionDTO;
import oaie.io.wimmservice.elasticsearch.BankTransactionRepository;
import oaie.io.wimmservice.entities.BankTransaction;
import oaie.io.wimmservice.entities.BankTransactionCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankTransactionProcessingService {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BankCategoryRepository categoryRepository;

    @Autowired
    private BankTransactionsRepository bankTransactionsRepository;

    @Autowired
    private BankTransactionRepository bankTransactionRepositoryES;


    public BankTransaction convertToBankTransactionEntity(BankTransactionDTO bankTransactionDTO) {


        BankTransaction bankTransaction = modelMapper.map(bankTransactionDTO, BankTransaction.class);

        return bankTransaction;
    }

    public BankTransactionDTO convertToDTO(BankTransaction bankTransaction) {


        BankTransactionDTO bankTransactionDTO = modelMapper.map(bankTransaction, BankTransactionDTO.class);
        return bankTransactionDTO;
    }

    public void setCategoryToBankTransactionEntity(List<BankTransactionDTO> listOfBankTransactions) {
        for (BankTransactionDTO bankTransactionDTO : listOfBankTransactions
        ) {

            BankTransactionCategory categoryToBeReferencedBankTransaction = findOrCreateCategory(bankTransactionDTO.getBankTransactionCategory());
            BankTransaction bankTransaction = modelMapper.map(bankTransactionDTO, BankTransaction.class);
            bankTransaction.setCategory(categoryToBeReferencedBankTransaction);
            BankTransaction bankTransactionCreated = bankTransactionsRepository.save(bankTransaction);
            bankTransactionRepositoryES.save(bankTransactionDTO);

        }
    }

    public BankTransactionCategory findOrCreateCategory(String categoryName) {
        BankTransactionCategory categoryToBeReferencedBankTransaction = categoryRepository.findCategoryByName(categoryName);
        if (categoryToBeReferencedBankTransaction == null) {
            BankTransactionCategory categoryToBeCreated = new BankTransactionCategory();
            categoryToBeCreated.setCategoryName(categoryName.toUpperCase());
            categoryToBeReferencedBankTransaction =categoryRepository.save(categoryToBeCreated);

        }

        return categoryToBeReferencedBankTransaction;

    }
}
