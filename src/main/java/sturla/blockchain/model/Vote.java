package sturla.blockchain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Vote {

    private User user;
    private Proposal proposal;
    private Integer quantity;

}
