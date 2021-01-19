package sturla.blockchain.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sturla.blockchain.model.Proposal;
import sturla.blockchain.services.ProposalService;

import java.util.List;

@RestController
public class ProposalController {

    private ProposalService proposalService;

    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @GetMapping("/proposal")
    public List<Proposal> getTransactions(){
        return proposalService.getProposals();
    }

    @PostMapping("/proposal")
    public void insertTransaction(@RequestBody Proposal proposal){
        proposalService.insertProposal(proposal);
    }
}
