package sturla.blockchain.services;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sturla.blockchain.model.Block;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlockService {

    List<Block> blocks;

    @Autowired
    public BlockService blockService;

    public BlockService(){
        this.blocks = new ArrayList<>();
//        String sha256hex = Hashing.sha256()
//                .hashString("HOLA", StandardCharsets.UTF_8)
//                .toString();
    }

    public List<Block> getBlocks(){
        return this.blocks;
    }

    public void insertBlock(Block t){
        t.setDateTime(LocalDateTime.now());
        blocks.add(t);
    }

    public String getLatestHashBlock(){
        if (blocks.size() > 0) {
            return blocks.get(blocks.size()-1).getHash();
        } else{
            return "0";
        }
    }

}
