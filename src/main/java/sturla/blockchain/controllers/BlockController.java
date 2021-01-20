package sturla.blockchain.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sturla.blockchain.model.Block;
import sturla.blockchain.services.BlockService;

import java.util.List;

@RestController
public class BlockController {

    private BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @GetMapping("/block")
    public List<Block> getBlocks(){
        return blockService.getBlocks();
    }

    @PostMapping("/block")
    public void insertBlock(@RequestBody Block block){
        blockService.insertBlock(block);
    }

}
