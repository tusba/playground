package util.array;

public class CharArray implements ICharArray {

    private char[] source;

    public CharArray(char[] source) throws NullArrayException {
        if (source == null) {
            throw new NullArrayException();
        }
        this.source = source;
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
    
}
