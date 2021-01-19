package sturla.blockchain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sturla.blockchain.model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LeaderBoardService {

    private TransactionService transactionService;

    public LeaderBoardService (TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Autowired
    public LeaderBoardService leaderBoardService;

    public Map<Integer, Integer> getTable() {
        Map<Integer, Integer> table = new HashMap<>();
        List<Transaction> transactions = transactionService.getPoolTransactions();
        transactions.stream().forEach(
                transaction -> {
                    Optional<Integer> item = Optional.ofNullable(table.get(transaction.getVote().getProposal().getId()));
                    if (item.isPresent()) {
                        table.put(transaction.getVote().getProposal().getId(), item.get() + transaction.getVote().getQuantity());
                    } else {
                        table.put(transaction.getVote().getProposal().getId(), transaction.getVote().getQuantity());
                    }
                }
        );

        return table.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
