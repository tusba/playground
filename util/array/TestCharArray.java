package util.array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.commons.annotation.Testable;
import util.annotation.UtilityTest;

@DisplayName("Character array wrapper")
@Testable
class TestCharArray {

    private static final String BASE_TEMPLATE = "Qwe123";

    @DisplayName("Run all available tests")
    @UtilityTest
    void tryRunAll() {
        String target = "Abc789";
        int targetLen = target.length();
        char[] targetChars = target.toCharArray();

        ICharArray wrapper = CharArray.split(target);

        assertAll("for " + (target != null ? "\"" + target + "\"" : "null") + " string",
            () -> {
                assertNotNull(target);
                assertNotEquals("", target);

                // executed only if the previous assertion is valid
                assertAll("the first index of a character",
                    () -> assertEquals(0, wrapper.indexOf(target.charAt(0))),
                    () -> assertEquals(targetLen - 1, wrapper.indexOf(target.charAt(targetLen - 1)))
                );
            },
            () -> {
                assertNotNull(target);
                assertNotEquals("", target);

                // executed only if the previous assertion is valid
                assertAll("remove a character by its index",
                    () -> assertArrayEquals(targetChars, wrapper.truncate(-1)),
                    () -> assertArrayEquals(target.substring(1).toCharArray(), wrapper.truncate(0)),
                    () -> assertArrayEquals(target.substring(0, targetLen - 1).toCharArray(), wrapper.truncate(targetLen - 1)),
                    () -> assertArrayEquals(targetChars, wrapper.truncate(targetLen))
                );
            },
            () -> {
                assertNotNull(target);
                assertNotEquals("", target);

                char[] reverted = wrapper.reverse();
                assertAll("reverse character order",
                    () -> assertEquals(target.charAt(0), reverted[targetLen - 1]),
                    () -> assertEquals(target.charAt(targetLen - 1), reverted[0])
                );
            }
        );
    }

    @DisplayName("Initialize with a null value")
    @UtilityTest
    void tryInitNull() {
        assertDoesNotThrow(new Executable() {

            @Override
            public void execute() throws Throwable {
                CharArray.wrap(null);
            }

        }, () -> "Should resolve to an empty array rather than throw");

        assertDoesNotThrow(
            () -> CharArray.split(null),
            () -> "Should not throw but resolve to an empty array"
        );

        Exception exception = assertThrows(NullArrayException.class,
            () -> CharArray.wrapStrictly(null),
            () -> "Should throw on an empty array"
        );
        assertEquals("The array cannot be null", exception.getMessage());
    }

    @DisplayName("Get the first index of a character")
    @UtilityTest
    void tryIndexOf() {
        char[] array = new char[] {'Q', 'w', 'e', '1', '2', '3'};
        ICharArray wrapper = CharArray.wrap(array);

        assertAll("first index of",
            () -> assertEquals(-1, wrapper.indexOf('q'), "Should not find and result in -1"),
            () -> assertEquals(0, wrapper.indexOf('Q'), "Should be the first array element"),
            () -> assertEquals(2, wrapper.indexOf('e')),
            () -> assertEquals(5, wrapper.indexOf('3'))
        );
    }

    @DisplayName("Reverse the character order")
    @UtilityTest
    void tryReverse() {
        ICharArray wrapper = CharArray.split(BASE_TEMPLATE);
        assertArrayEquals(new char[] {'3', '2', '1', 'e', 'w', 'Q'}, wrapper.reverse());

        wrapper = CharArray.split("");
        assertArrayEquals(new char[0], wrapper.reverse(), () -> "An empty array stays as is");

        char[] palindrome = new char[] {'t', 'e', 'n', 'e', 't'};
        char[] reverted = CharArray.wrap(palindrome).reverse();
        assertArrayEquals(palindrome, reverted);
        assertNotSame(palindrome, reverted, () -> "Should create a new array");
    }

    @DisplayName("Remove a character at the specified index")
    @UtilityTest
    void tryTruncate() {
        char[] array = new char[] {'Q', 'w', 'e', '1', '2', '3'};
        ICharArray wrapper = CharArray.wrap(array);

        assertNotSame(array, wrapper.truncate(-2), "Should create a new array");
        assertEquals("we123", String.valueOf(wrapper.truncate(0)));
        assertEquals("Qw123", String.valueOf(wrapper.truncate(2)));
        assertArrayEquals(new char[] {'Q', 'w', 'e', '2', '3'}, wrapper.truncate(3));
        assertEquals("Qwe12", String.valueOf(wrapper.truncate(5)));
        assertAll("out-of-bounds element",
            () -> assertEquals(BASE_TEMPLATE, String.valueOf(wrapper.truncate(-1)), () -> "Should not remove"),
            () -> assertEquals(BASE_TEMPLATE, String.valueOf(wrapper.truncate(6)), () -> "Should not remove")
        );
    }

}
