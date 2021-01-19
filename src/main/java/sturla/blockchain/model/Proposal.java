package sturla.blockchain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

@Builder
@Data
@AllArgsConstructor
@Log
public class Proposal {

    private Integer id;
    private String name;
    private String description;

}
