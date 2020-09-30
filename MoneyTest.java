import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class MoneyTest{
	@Test
    public void testEquality() {
        assertTrue(new Dollar(5, "USD").equals(new Dollar(5, "USD")));
        assertFalse(new Dollar(5, "USD").equals(new Dollar(6, "USD")));
        assertTrue(new Franc(5, "CHF").equals(new Franc(5, "CHF")));
        assertFalse(new Franc(5, "CHF").equals(new Franc(6, "CHF")));
        assertFalse(new Franc(5, "CHF").equals(new Dollar(5, "USD")));
    }

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }
}
