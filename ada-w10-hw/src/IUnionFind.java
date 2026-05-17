
public interface IUnionFind {

    /**
     * Initializes a union-find data structure with N elements.
     * Elements are 0 ..  N-1. Initially, each element is in its own set.
     * @param N - initial number of elements
     */
    void init(int N);


    /**
     * @param p - an element between 0 .. N-1
     * @return the representative element of the set containing p
     */
    int find(int p) ;

    /**
     * Merges the set containing element p with the set  containing element q
     * @param p - one random element of first set
     * @param q - one random element of second set
     */
    void union(int p, int q) ;


    /**
     *
     * @return the number of sets
     */
    int count() ;

}
