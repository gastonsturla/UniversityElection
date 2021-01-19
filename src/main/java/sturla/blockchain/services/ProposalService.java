package sturla.blockchain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sturla.blockchain.model.Proposal;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProposalService {

    private List<Proposal> proposals;

    public ProposalService(){
        this.proposals = new ArrayList<>();
    }

    @Autowired
    public ProposalService proposalService;

    public List<Proposal> getProposals(){
        return this.proposals;
    }

    public void insertProposal(Proposal t){
        proposals.add(t);
    }

}
