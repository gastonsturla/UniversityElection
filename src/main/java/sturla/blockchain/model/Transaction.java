package sturla.blockchain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@Log
public class Transaction {

    private Integer id;
    private LocalDateTime time;
    private Vote vote;

}
