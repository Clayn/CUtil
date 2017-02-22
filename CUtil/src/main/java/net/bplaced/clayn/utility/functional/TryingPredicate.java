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

import java.util.function.Predicate;

/**
 * An interface similar to {@link Predicate} to allow methods that may throw an
 * exception to be referenced.
 *
 * @author Clayn
 * @param <T> the type of the objects to check
 * @ext
 * @since 0.1.0
 */
@FunctionalInterface
public interface TryingPredicate<T> extends Predicate<T>
{

    /**
     * Tries to evaluate this predicate on the given argument. This may throw an
     * exception.
     *
     * @param val the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     * @throws Exception if the evaluation fails.
     * @see #test(java.lang.Object)
     * @since 0.1.0
     */
    public boolean tryTest(T val) throws Exception;

    @Override
    public default boolean test(T t)
    {
        try
        {
            return tryTest(t);
        } catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }

}
