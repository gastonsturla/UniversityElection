package sturla.blockchain.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sturla.blockchain.model.Transaction;
import sturla.blockchain.services.TransactionService;

import java.util.List;

@RestController
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transaction")
    public List<Transaction> getTransactions(){
        return transactionService.getPoolTransactions();
    }

    @PostMapping("/transaction")
    public void insertTransaction(@RequestBody Transaction transaction){
        transactionService.insertTransaction(transaction);
    }

}
