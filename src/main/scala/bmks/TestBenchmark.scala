package bmks

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations.{Benchmark, OutputTimeUnit}

@OutputTimeUnit(TimeUnit.MILLISECONDS)
class TestBenchmark {

  @Benchmark
  def seq(): Seq[String] =
    Seq.fill(1234567)("foo")

  @Benchmark
  def list(): Seq[String] =
    List.fill(1234567)("foo")
}
