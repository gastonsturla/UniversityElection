package sturla.blockchain.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sturla.blockchain.model.Proposal;
import sturla.blockchain.services.LeaderBoardService;

import java.util.Map;

@RestController
public class LeaderBoardController {

    private LeaderBoardService leaderBoardService;

    public LeaderBoardController(LeaderBoardService leaderBoardService){
        this.leaderBoardService = leaderBoardService;
    }
    @GetMapping("/leaderboard")
    public Map<Integer, Integer> getLeaderBoard() {
        return leaderBoardService.getTable();
    }
}
