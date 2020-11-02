package util.array;

public class CharArray implements ICharArray {

    private char[] source;

    private CharArray(char[] source) {
        this.source = source == null ? new char[0] : source;
    }

    private CharArray(char[] source, boolean throwOnNull) throws NullArrayException {
        this(source);
        if (source == null && throwOnNull) {
            throw new NullArrayException();
        }
    }

    @Override
    public int indexOf(char element) {
        for (int i = 0; i < source.length; i++)
            if (source[i] == element)
                return i;
        return -1;
    }

    @Override
    public char[] truncate(int index) {
        if (index < 0 || index >= source.length)
            return source.clone();

        char[] result = new char[source.length == 0 ? 0 : source.length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = source[i >= index ? i + 1 : i];
        }
        return result;
    }

    /**
     * Character array based factory
     */
    public static CharArray wrap(char[] source) {
        try {
            return new CharArray(source, true);
        } catch (NullArrayException e) {
            return new CharArray(source);
        }
    }

    /**
     * String based factory
     */
    public static CharArray split(String source) {
        return wrap(source != null ? source.toCharArray() : null);
    }
}
