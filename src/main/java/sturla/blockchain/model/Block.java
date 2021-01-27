package sturla.blockchain.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@Log
@Entity
@Table(name="blocks")
public class Block {
    @Id
    private Integer id;
    private String hash;
    private String previousHash;
    private LocalDateTime dateTime;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "blockID")
    private List<Transaction> transactions;

    public String getNonce() {
        return "nonce";
    }

    public void addTransaction(Transaction t){
        this.transactions.add(t);
    }
}
