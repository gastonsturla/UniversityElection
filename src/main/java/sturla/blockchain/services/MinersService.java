package sturla.blockchain.services;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;
import sturla.blockchain.model.Block;
import sturla.blockchain.model.Transaction;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class MinersService {

    private TransactionService transactionService;
    private BlockService blockService;
    public MinersService (TransactionService transactionService, BlockService blockService) {
        this.blockService = blockService;
        this.transactionService = transactionService;
        doMining();
    }

    public void doMining(){
        Runnable runnable = () -> mine();
        //Programming execution of mining blocks
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.MINUTES);
    }

    public void mine(){
        List<Transaction> pendingTransactions = this.transactionService.getPoolTransactions();
        Integer blockSize = blockService.getBlockSize();
        if(pendingTransactions.size() >= blockSize){
            Block newBlock = Block.builder().transactions(new ArrayList<>()).build();
            String hash = Hashing.sha256().hashString(newBlock.getNonce(), StandardCharsets.UTF_8).toString();
            newBlock.setHash(hash);
            for (Transaction t : pendingTransactions) {
                if (newBlock.getTransactions().size() < blockSize) {
                    newBlock.addTransaction(t);
                } else if (newBlock.getTransactions().size() == blockSize){
                    break;
                }
            }
            blockService.insertBlock(newBlock);
        }
    }
}
