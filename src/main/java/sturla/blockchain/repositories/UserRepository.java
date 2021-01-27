package sturla.blockchain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sturla.blockchain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
