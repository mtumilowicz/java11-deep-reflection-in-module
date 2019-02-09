# java11-deep-reflection-in-module

# preview
Referring my other github projects concerning reflection could be
useful:
* https://github.com/mtumilowicz/java-reflection
* https://github.com/mtumilowicz/java11-deep-reflection

# project description
We will show how to get / set private field within module.
1. module
    ```
    module main {
        requires com.google.common;
    }
    ```
1. classes
    * class with private field
        ```
        public class Company {
            private String privateField = "privateField";
        
            public String getPrivateField() {
                return privateField;
            }
        }
        ```
    * accessor (within module)
        ```
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
        ```
1. tests
    * get
        ```
        assertThat(Accessor.get(), is("privateField"));
        ```
    * set
        ```
        var company = new Company();
        
        Accessor.set("new field value", company);
        
        assertThat(company.getPrivateField(), is("new field value"));
        ```