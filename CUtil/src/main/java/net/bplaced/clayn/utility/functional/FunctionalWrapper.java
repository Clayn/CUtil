/*
 * The MIT License
 *
 * Copyright 2017 Clayn <clayn_osmato@gmx.de>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.bplaced.clayn.utility.functional;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * The Functional Wrapper wraps the trying versions of
 * {@link java.util.function functional} interfaces to their original versions.
 * This can be used in places where the original interface is required but you
 * want to use a method that may throw an exception. <br>
 * It's recommended to import the methods of this class directly using
 * {@code import static net.bplaced.clayn.cfs.ext.functional.FunctionalWrapper.*;}
 *
 * @author Clayn <clayn_osmato@gmx.de>
 * @since 0.3.0
 */
public final class FunctionalWrapper
{

    private FunctionalWrapper() throws IllegalAccessException
    {
        throw new IllegalAccessException("No Wrapper for you!");
    }

    /**
     * Explicit converts the given trying function into a normal one. This can
     * be used when you want to use a method that throws an exception in placed
     * a normal function is required. This method simply returns the given
     * instance.
     *
     * @param <T> the type for the functions argument
     * @param <R> the type of the functions result
     * @param orig the function to convert
     * @return {@code orig}
     * @since 0.3.0
     */
    public static <T, R> Function<T, R> function(TryingFunction<T, R> orig)
    {
        return orig;
    }

    /**
     * Explicit converts the given trying predicate into a normal one. This can
     * be used when you want to use a method that throws an exception in placed
     * a normal predicate is required. This method simply returns the given
     * instance.
     *
     * @param <T> the type for the object to check
     * @param orig the predicate to convert
     * @return {@code orig}
     * @since 0.3.0
     */
    public static <T> Predicate<T> predicate(TryingPredicate<T> orig)
    {
        return orig;
    }

    /**
     * Explicit converts the given trying supplier into a normal one. This can
     * be used when you want to use a method that throws an exception in placed
     * a normal supplier is required. This method simply returns the given
     * instance.
     *
     * @param <T> the type for the suppliers returned object
     * @param orig the predicate to convert
     * @return {@code orig}
     * @since 0.3.0
     */
    public static <T> Supplier<T> supply(TryingSupplier<T> orig)
    {
        return orig;
    }

    /**
     * Explicit converts the given trying unaryoperator into a normal one. This
     * can be used when you want to use a method that throws an exception in
     * placed a normal unaryoperator is required. This method simply returns the
     * given instance.
     *
     * @param <T> the type for the operators argument
     * @param orig the unaryoperator to convert
     * @return {@code orig}
     * @since 0.3.0
     */
    public static <T> UnaryOperator<T> operate(TryingUnaryOperator<T> orig)
    {
        return orig;
    }
}
