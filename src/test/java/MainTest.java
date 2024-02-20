import static org.junit.Assert.assertEquals;

import org.example.app.Prospect;
import org.junit.BeforeClass;
import org.junit.Test;

//For this test class we test that the first line is retrievable and that it returns the correct values
public class MainTest {
    private static Prospect prospect;
    @BeforeClass
    public static void testSetup(){
        prospect = new Prospect(1);
        prospect.prospectSetup();
    }
    @Test
    public void testName(){
        String name = prospect.getName();
        assertEquals("The name is not correct", "Juha", name);
    }

    @Test
    public void testLoan(){
        double loan = prospect.getLoan();
        assertEquals("Wrong amount", 1000.0, loan, 0);
    }

    @Test
    public void testYear(){
        int year = prospect.getYears();
        assertEquals("Wrong amount", 2, year);
    }

    @Test
    public void testInterest(){
        double interest = prospect.getInterest();
        assertEquals("Wrong amount", 5.0, interest, 0);
    }

    //This test case checks that mortgage is calculated correctly
    @Test
    public void testMortgage(){
        double mortgage = prospect.getMortgage();
        assertEquals("Wrong amount", 43.8713897340686, mortgage, 0);
    }

}
