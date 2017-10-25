package hometask4.t04;

import org.junit.jupiter.api.Test;
import org.junit.Assert;


class SerializerTest {
    private Service service = new Service();
    private Serializer serializer = new Serializer();

    @Test
    void serializationTest() {
        Actor pitt = new Actor("Brad Pitt");
        Actor damon = new Actor("Matt Damon");
        Actor clooney = new Actor("George Clooney");
        Film ocean11 = new Film("Ocean's Eleven");
        Film se7en = new Film("Se7en");
        service.addActor(ocean11, pitt);
        service.addActor(ocean11, clooney);
        service.addActor(ocean11, damon);
        service.addActor(se7en, pitt);
        String path = "src/main/resources/films.txt";
        serializer.serialize(service, path);
        Service deserializedService = (Service) serializer.deSerialize(path);
        Assert.assertEquals(service, deserializedService);
        Assert.assertEquals(2, service.getFilmsByActor(pitt).size());
    }

}
