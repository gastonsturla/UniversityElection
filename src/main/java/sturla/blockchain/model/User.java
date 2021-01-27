package sturla.blockchain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@Data
@Log
@Entity
@Table(name="users")
public class User {
    @Id
    private Integer id;
    private String userName;
    private String password;

}
