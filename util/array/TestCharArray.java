package util.array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.commons.annotation.Testable;
import util.annotation.UtilityTest;

@DisplayName("Character array wrapper")
@Testable
class TestCharArray {

    @DisplayName("Initialize with a null value")
    @UtilityTest
    void tryInitNull() {
        assertDoesNotThrow(new Executable() {

            @Override
            public void execute() throws Throwable {
                CharArray.wrap(null);
            }

        });
    }

    @DisplayName("Get the first index of a character")
    @UtilityTest
    void tryIndexOf() {
        char[] array = new char[] {'Q', 'w', 'e', '1', '2', '3'};
        ICharArray wrapper = CharArray.wrap(array);

        assertEquals(-1, wrapper.indexOf('q'));
        assertEquals(0, wrapper.indexOf('Q'));
        assertEquals(2, wrapper.indexOf('e'));
        assertEquals(5, wrapper.indexOf('3'));
    }

    @DisplayName("Remove a character at the specified index")
    @UtilityTest
    void tryTruncate() {
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
