package sturla.blockchain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sturla.blockchain.model.Block;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlockService {

    @Value("${blockSize}")
    private Integer blockSize;
    private TransactionService transactionService;
    List<Block> blocks;

    @Autowired
    public BlockService blockService;

    public BlockService(TransactionService transactionService){
        this.transactionService = transactionService;
        this.blocks = new ArrayList<>();
    }

    public List<Block> getBlocks(){
        return this.blocks;
    }

    public void insertBlock(Block block){
        //set the day and hour of the new block
        block.setDateTime(LocalDateTime.now());
        //link with the previous block
        block.setPreviousHash(this.getLatestHashBlock());
        //clean the pool of pending transactions
        transactionService.cleanProcesedTransactions(block);
        blocks.add(block);
    }

    private String getLatestHashBlock(){
        if (blocks.size() > 0) {
            return blocks.get(blocks.size()-1).getHash();
        } else{
            return "GeNeSiSbLoCk";
        }
    }

    public Integer getBlockSize(){
        return this.blockSize;
    }

}
