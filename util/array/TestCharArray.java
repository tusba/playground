package util.array;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class TestCharArray {

    @Test
    public void tryIndexOf() throws NullArrayException {
        char[] array = new char[] {'Q', 'w', 'e', '1', '2', '3'};
        ICharArray wrapper = new CharArray(array);

        assertEquals(-1, wrapper.indexOf('q'));
        assertEquals(0, wrapper.indexOf('Q'));
        assertEquals(2, wrapper.indexOf('e'));
        assertEquals(5, wrapper.indexOf('3'));
    }

    @Test
    public void tryTruncate() throws NullArrayException {
        char[] array = new char[] {'Q', 'w', 'e', '1', '2', '3'};
        ICharArray wrapper = new CharArray(array);

        assertEquals("Qwe123", new String(wrapper.truncate(-1)));
        assertEquals("we123", new String(wrapper.truncate(0)));
        assertEquals("Qw123", new String(wrapper.truncate(2)));
        assertEquals("Qwe12", new String(wrapper.truncate(5)));
        assertEquals("Qwe123", new String(wrapper.truncate(6)));
    }

}
