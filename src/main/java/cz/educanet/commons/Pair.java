package cz.educanet.commons;

/**
 * A generic wrapper for a pair of arbitrary values
 * @param first first value
 * @param second second value
 * @param <A> generics of the first value
 * @param <B> generics of the second value
 */
public record Pair<A, B>(A first, B second) {
}
