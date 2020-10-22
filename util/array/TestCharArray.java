package util.array;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class TestCharArray {

    @Test
    public void tryIndexOf() {
        char[] array = new char[] {'Q', 'w', 'e', '1', '2', '3'};
        ICharArray wrapper = CharArray.wrap(array);

        assertEquals(-1, wrapper.indexOf('q'));
        assertEquals(0, wrapper.indexOf('Q'));
        assertEquals(2, wrapper.indexOf('e'));
        assertEquals(5, wrapper.indexOf('3'));
    }

    @Test
    public void tryTruncate() {
        char[] array = new char[] {'Q', 'w', 'e', '1', '2', '3'};
        ICharArray wrapper = CharArray.wrap(array);

        assertNotSame(array, wrapper.truncate(-2));
        assertEquals("Qwe123", String.valueOf(wrapper.truncate(-1)));
        assertEquals("we123", String.valueOf(wrapper.truncate(0)));
        assertEquals("Qw123", String.valueOf(wrapper.truncate(2)));
        assertArrayEquals(new char[] {'Q', 'w', 'e', '2', '3'}, wrapper.truncate(3));
        assertEquals("Qwe12", String.valueOf(wrapper.truncate(5)));
        assertEquals("Qwe123", String.valueOf(wrapper.truncate(6)));
    }

}
