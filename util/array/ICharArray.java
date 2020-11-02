package util.array;

public interface ICharArray {

    /**
     * Determine a first position of the specified element in the source array
     * @param element a character to search for
     * @return zero-based position or -1 if not found
     */
    int indexOf(char element);

    /**
     * Reverse the source array
     * @return a newly created array
     */
    char[] reverse();

    /**
     * Remove a character from the source array at the specified position
     * @param index zero-based position
     * @return a newly created array
     */
    char[] truncate(int index);

}
