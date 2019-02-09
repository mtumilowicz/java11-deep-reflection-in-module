import company.Accessor;
import company.Company;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mtumilowicz on 2019-02-09.
 */
public class DeepReflectionTest {
    
    @Test
    public void getPrivateField() throws Exception {
        assertThat(Accessor.get(), is("privateField"));
    }

    @Test
    public void setPrivateField() throws Exception {
        var company = new Company();
        
        Accessor.set("new field value", company);
        
        assertThat(company.getPrivateField(), is("new field value"));
    }
}
