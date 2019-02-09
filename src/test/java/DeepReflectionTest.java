import company.Company;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by mtumilowicz on 2019-02-09.
 */
public class DeepReflectionTest {
    
    @Test
    public void getPrivateField() throws Exception {
        var company = new Company();

        var privateField = company.getClass().getDeclaredField("privateField");
        
        assertFalse(privateField.canAccess(company));

        assertTrue(privateField.trySetAccessible());
        
        assertThat(privateField.get(company), is("privateField"));
    }

    @Test
    public void setPrivateField() throws Exception {
        var company = new Company();

        var privateField = company.getClass().getDeclaredField("privateField");

        assertFalse(privateField.canAccess(company));

        assertTrue(privateField.trySetAccessible());

        privateField.set(company, "new field value");
        
        assertThat(privateField.get(company), is("new field value"));
    }
}
