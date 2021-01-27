package sturla.blockchain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@Log
@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    private Integer id;
    private LocalDateTime time;
    @OneToOne
    @JoinColumn(name = "transactionID")
    private Vote vote;

}
