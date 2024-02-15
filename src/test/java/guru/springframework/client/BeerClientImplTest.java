package guru.springframework.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClient client;

    @Test
    void listBeers() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        client.listBeer().subscribe(response -> {
            System.out.println(response);
            atomicBoolean.set(true);
        });
        await().untilTrue(atomicBoolean);
    }

    @Test
    void testGetMap() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        client.listBeerMap().subscribe(response ->  {
            System.out.println(response.toString());
            atomicBoolean.set(true);
        });
        await().untilTrue(atomicBoolean);
    }

    @Test
    void testGetBeerJson() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        client.listBeersJsonNode().subscribe(response ->  {
            System.out.println(response.toPrettyString());
            atomicBoolean.set(true);
        });
        await().untilTrue(atomicBoolean);
    }

    @Test
    void testGetBeerDto() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        client.listBeerDtos().subscribe(dto ->  {
            System.out.println(dto.getBeerName());
            atomicBoolean.set(true);
        });
        await().untilTrue(atomicBoolean);
    }

}