package springaop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springaop.services.ShipmentService;

@Slf4j
@SpringBootTest
class SpringAopApplicationTests {
    @Autowired
    private ShipmentService shipmentService;

    @Test
    void orderPackage() {
        String orderString = shipmentService.orderPackage(9L);
        log.info(orderString);
    }

    @Test
    void trackPackage() {
        shipmentService.trackPackage(28L);
    }

}
