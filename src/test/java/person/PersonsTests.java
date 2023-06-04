package person;

import org.example.Man;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonsTests {
    private Woman woman;
    private Man man;
    private Woman woman2;
    private Man man2;
    private String lastName;
    private String lastName2;


    @BeforeMethod
    public void creatingPerson(){
        woman = new Woman("Katya", "Shelud", 61, "UK", null);
        man = new Man("Asa", "Usa", 75, "US", null);
        woman2 = new Woman("Solanica", "Chik", 35, "IT", null);
        man2 = new Man("Kir", "Smuz", 22, "UK", null);

        lastName = woman.getLastName();
        lastName2 = woman2.getLastName();
    }
    @Test
    public void testIsRetired(){
        Assert.assertEquals(man.isRetired(), true, "The status is incorrect");
        Assert.assertEquals(man2.isRetired(), false, "The status is incorrect");
        Assert.assertEquals(woman.isRetired(), true, "The status is incorrect");
        Assert.assertEquals(woman2.isRetired(), false, "The status is incorrect");
    }
    @Test
    public void testRegisterPartnership(){
        woman.registerPartnership(man);
        Assert.assertEquals(woman.getPartner(), man, "The partner is incorrect" );
        Assert.assertEquals(woman.getLastName(), man.getLastName(), "The LastName is incorrect");
        Assert.assertEquals(man.getPartner(), woman, "The partner is incorrect");
        man2.registerPartnership(woman2);
        Assert.assertEquals(man2.getPartner(), woman2,"The partner is incorrect" );
        Assert.assertEquals(woman2.getLastName(), man2.getLastName(),"The LastName is incorrect" );
        Assert.assertEquals(woman2.getPartner(), man2,"The partner is incorrect" );
    }
    @Test
    public void testDeregisterPartnership(){
        woman.deregisterPartnership(true);
        Assert.assertEquals(woman.getPartner(), null, "The partner exists but should not" );
        Assert.assertEquals(woman.getLastName(), lastName, "The LastName is incorrect");
        Assert.assertEquals(man.getPartner(), null, "The partner exists but should not");
        man2.deregisterPartnership();
        Assert.assertEquals(woman2.getPartner(), null, "The partner exists but should not" );
        Assert.assertEquals(woman2.getLastName(), lastName2, "The LastName is incorrect");
        Assert.assertEquals(man2.getPartner(), null, "The partner exists but should not");
    }
}
