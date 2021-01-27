package sturla.blockchain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@AllArgsConstructor
@Log
@Entity
@Table(name="proposals")
public class Proposal {
    @Id
    private Integer id;
    private String name;
    private String description;

}
