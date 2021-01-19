package sturla.blockchain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

@Builder
@AllArgsConstructor
@Data
@Log
public class User {

    private Integer id;
    private String userName;
    private String password;

}
