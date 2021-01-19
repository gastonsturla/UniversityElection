package sturla.blockchain.model;

import jdk.jfr.Label;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@Log

public class Block {

    private String hash;
    private String previousHash;
    private LocalDateTime dateTime;
    private List<Transaction> transactions;

}
