package sturla.blockchain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sturla.blockchain.model.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal,Integer> {
}
