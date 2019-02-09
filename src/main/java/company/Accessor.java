package company;

import com.google.common.base.Preconditions;

/**
 * Created by mtumilowicz on 2019-02-09.
 */
public class Accessor {
    public static String get() throws Exception {
        var company = new Company();

        var privateField = company.getClass().getDeclaredField("privateField");

        Preconditions.checkState(!privateField.canAccess(company));

        Preconditions.checkState(privateField.trySetAccessible());

        return (String) privateField.get(company);
    }
    
    public static void set(String newName, Company company) throws Exception {
        var privateField = company.getClass().getDeclaredField("privateField");

        Preconditions.checkState(!privateField.canAccess(company));

        Preconditions.checkState(privateField.trySetAccessible());

        privateField.set(company, newName);
    }
}
