/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.ballerinalang.benchmark;

import org.ballerinalang.launcher.BProgmRunner;
import org.ballerinalang.launcher.BallerinaLauncher;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

public class MicroBenchmark {


    @State(Scope.Benchmark)
    public static class BallerinaMultple10 {
        static BallerinaLauncher ballerinaLauncher = new BallerinaLauncher("src/ballerina/multipleArr10.bal");
    }
    //
    @State(Scope.Benchmark)
    public static class BallerinaMultple100 {
        static BallerinaLauncher ballerinaLauncher = new BallerinaLauncher("src/ballerina/multipleArr100.bal");
    }

    @State(Scope.Benchmark)
    public static class BallerinaMultple1000 {
        static BallerinaLauncher ballerinaLauncher = new BallerinaLauncher("src/ballerina/multipleArr1000.bal");
    }


    @Benchmark
    public void ballerinaMultple10(BallerinaMultple10 bal1) {
        BProgmRunner.runProgram();
    }

    @Benchmark
    public void ballerinaMultple100(BallerinaMultple100 bal1) {
        BProgmRunner.runProgram();
    }


    @Benchmark
    public void ballerinaMultple1000(BallerinaMultple1000 bal1) {
        BProgmRunner.runProgram();
    }




}
