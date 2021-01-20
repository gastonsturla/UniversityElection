package sturla.blockchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sturla.blockchain.services.MinersService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class BlockchainApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlockchainApplication.class, args);

    }
}
