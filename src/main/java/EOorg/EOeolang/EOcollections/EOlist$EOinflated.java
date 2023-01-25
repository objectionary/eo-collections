/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2021-2022 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/*
 * @checkstyle PackageNameCheck (4 lines)
 */
package EOorg.EOeolang.EOcollections;

import org.eolang.*;

/**
 * List inflating.
 *
 * @checkstyle TypeNameCheck (5 lines)
 * @since 1.0
 */
@SuppressWarnings("PMD.AvoidDollarSigns")
public class EOlist$EOinflated extends PhDefault {

    /**
     * Ctor.
     *
     * @param sigma Sigma.
     */
    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EOlist$EOinflated(final Phi sigma) {
        super(sigma);
        this.add("f", new AtFree());
        this.add("φ", new AtComposite(this, rho -> {
            Phi[] array = new Param(rho).strong(Phi[].class);
            for (int idx = 0; ; ++idx) {
                final Phi function = rho.attr("f").get().copy();
                function.attr(0).put(new Data.ToPhi(array));
                function.attr(1).put(new Data.ToPhi((long) idx));

                System.out.println(idx);

                Phi[] result = new Dataized(function).take(Phi[].class);
                if (result.length == 0) {
                    break;
                }
                // todo maybe copy here
                array = result;

                ++idx;
            }
            return new Data.ToPhi(array);
        }));
    }

}