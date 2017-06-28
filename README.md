
ballerina-benchmark
=========================

---

This repository contains the micro benchmark used to get the performance number for array size in ballerina.

The micro benchmark was built on top of Java Microbenchmark Harness (jmh).

In order to resolve dependencies, you will first have to build ballerina-core found in https://github.com/ballerinalang/ballerina first.

Once done, build the benchmarks and make sure all dependencies are resolved. 

All tests were done for the following benchmark configurations.

1. No. of iterations = 10
2. No. of warmup iterations = 5
3. No. of forks = 2
4. No of concurrent users = {1, 25, 50, 75, 100}




