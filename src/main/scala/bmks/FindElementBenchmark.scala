package bmks

import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations.{Benchmark, OutputTimeUnit, Scope, State}

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
class FindElementBenchmark {

  val dict: Map[String, Any] =
    (0 to 100).foldLeft(Map.empty[String, Any])((m, i) => m + (s"key$i" ->s"value$i"))

  val e: String = "key99"

  // First using normal dictionary lookup
  @Benchmark
  def findElementDict: Option[Any] =
    dict.get(e)

  // Second using Partial function
  @Benchmark
  def findElementPF: Option[Any] =
    dict
      .find { case (k, v) => k == e }
      .map(_._2)
}
