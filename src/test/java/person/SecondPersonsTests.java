package person;

import org.example.Man;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondPersonsTests {
    private Woman woman;
    private Man man;

    @BeforeTest
    public void creatingPerson(){
        man = new Man("Asa", "Usa", 70,"IT",null);
        woman = new Woman("Katya", "Shelud", 61,"HR",null);
        man.registerPartnership(woman);
    }
    @Test
    public void testManFirstName(){
        Assert.assertEquals(man.getFirstName(), "Asa", "Method getFirstName doesn't work");
        man.setFirstName("Kir");
        Assert.assertEquals(man.getFirstName(), "Kir", "Method setFirstName doesn't work");
    }
    @Test
    public void testManLastName(){
        Assert.assertEquals(man.getLastName(), "Usa", "Method getLastName doesn't work");
        man.setLastName("Smuz");
        Assert.assertEquals(man.getLastName(), "Smuz", "Method setLastName doesn't work");
    }
    @Test
    public void testManAge(){
        Assert.assertEquals(man.getAge(), 70, "Method getAge doesn't work");
        man.setAge(75);
        Assert.assertEquals(man.getAge(), 75,"Method setAge doesn't work");
    }
    @Test
    public void testWomanFirstName(){
        Assert.assertEquals(woman.getFirstName(), "Katya", "The first name is incorrect");
    }
    @Test
    public void testWomanLastName(){
        Assert.assertEquals(woman.getLastName(), "Shelud", "The last name is incorrect");
    }
    @Test
    public void testWomanAge(){
        Assert.assertEquals(woman.getAge(), 61, "The age is incorrect");
    }
    @Test
    public void testManPartner(){
        Assert.assertEquals(man.getPartner(), woman, "The partner is incorrect");
    }
    @Test
    public void testWomanPartner(){
        Assert.assertEquals(woman.getPartner(), man, "The partner is incorrect");
    }
}