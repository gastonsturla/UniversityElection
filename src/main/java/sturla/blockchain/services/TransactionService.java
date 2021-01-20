package sturla.blockchain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sturla.blockchain.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private List<Transaction> transactions;

    public TransactionService(){
        this.transactions = new ArrayList<>();
        User u = User.builder().userName("Gaston").password("1234").build();
        Proposal p = Proposal.builder().name("Propuesta A").id(1).build();
        Proposal p2 = Proposal.builder().name("Propuesta B").id(2).build();
        Proposal p3 = Proposal.builder().name("Propuesta B").id(3).build();
        Transaction t = Transaction.builder()
                        .id(5)
                        .vote(Vote.builder().user(u).proposal(p).quantity(5).build())
                        .build();
        insertTransaction(t);

        t = Transaction.builder()
                .id(5)
                .vote(Vote.builder().user(u).proposal(p3).quantity(4).build())
                .build();
        insertTransaction(t);

        t = Transaction.builder()
                .id(5)
                .vote(Vote.builder().user(u).proposal(p2).quantity(8).build())
                .build();
        insertTransaction(t);

        t = Transaction.builder()
                .id(5)
                .vote(Vote.builder().user(u).proposal(p).quantity(10).build())
                .build();
        insertTransaction(t);

        t = Transaction.builder()
                .id(5)
                .vote(Vote.builder().user(u).proposal(p3).quantity(5).build())
                .build();
        insertTransaction(t);
    }

    @Autowired
    public TransactionService transactionService;

    public List<Transaction> getPoolTransactions(){
        return this.transactions;
    }

    public void insertTransaction(Transaction t){
        t.setTime(LocalDateTime.now());
        transactions.add(t);
    }

    public void removeByTransactionID(Integer id){
        for (Transaction t: this.transactions) {
            if (t.getId().equals(id)){
                this.transactions.remove(t);
                break;
            }
        }
    }

    public void cleanProcesedTransactions(Block newBlock){
        newBlock.getTransactions().stream().forEach(transaction -> {
            removeByTransactionID(transaction.getId());
        });
    }
}
