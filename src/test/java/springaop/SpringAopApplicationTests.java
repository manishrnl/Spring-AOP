package springaop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springaop.services.ShipmentService;

@SpringBootTest
class SpringAopApplicationTests {
    @Autowired
    private ShipmentService shipmentService;

    @Test
    void orderPackage() {
        shipmentService.orderPackage(1L);
    }

    @Test
    void trackPackage() {
        shipmentService.trackPackage(1L);
    }

}
