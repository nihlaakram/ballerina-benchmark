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
    public static class Bal100 {
        static BallerinaLauncher ballerinaLauncher = new BallerinaLauncher("src/ballerina/Arr100.bal");
    }
//
    @State(Scope.Benchmark)
    public static class Bal101 {
        static BallerinaLauncher ballerinaLauncher = new BallerinaLauncher("src/ballerina/Arr101.bal");
    }

    @State(Scope.Benchmark)
    public static class Bal1000 {
        static BallerinaLauncher ballerinaLauncher = new BallerinaLauncher("src/ballerina/Arr1000.bal");
    }

    @State(Scope.Benchmark)
    public static class Bal1001 {
        static BallerinaLauncher ballerinaLauncher = new BallerinaLauncher("src/ballerina/Arr1001.bal");
    }

    @Benchmark
    public void balMethod100(Bal100 bal1) {
        BProgmRunner.runProgram();
    }

    @Benchmark
    public void javaMethod100(Blackhole blackhole) {
        int [] array = new int[100];
        array[99] = 0;
        blackhole.consume(array);
    }

    @Benchmark
    public void balMethod101(Bal101 bal1) {
        BProgmRunner.runProgram();
    }

//    @Benchmark
//    public void javaMethod101(Blackhole blackhole) {
//        int [] array = new int[1000];
//        array[101] = 0;
//        blackhole.consume(array);
//    }

    @Benchmark
    public void balMethod1000(Bal1000 bal1) {
        BProgmRunner.runProgram();
    }

//    @Benchmark
//    public void javaMethod1000(Blackhole blackhole) {
//        int [] array = new int[1000];
//        array[999] = 0;
//        blackhole.consume(array);
//    }

    @Benchmark
    public void balMethod1001(Bal1001 bal1) {
        BProgmRunner.runProgram();
    }

//    @Benchmark
//    public void javaMethod1001(Blackhole blackhole) {
//        int [] array = new int[1100];
//        array[1001] = 0;
//        blackhole.consume(array);
//    }

}
