package sturla.blockchain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sturla.blockchain.model.Block;

@Repository
public interface BlockRepository extends JpaRepository<Block, Integer> {
}
