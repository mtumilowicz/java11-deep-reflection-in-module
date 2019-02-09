import company.Accessor;
import company.Company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by mtumilowicz on 2019-02-09.
 */
class DeepReflectionTest {

    @Test
    void getPrivateField() throws Exception {
        assertEquals("privateField", Accessor.get());
    }

    @Test
    void setPrivateField() throws Exception {
        var company = new Company();

        Accessor.set("new field value", company);

        assertEquals("new field value", company.getPrivateField());
    }
}
