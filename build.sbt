lazy val root = (project in file(".")).
  enablePlugins(JmhPlugin).
  settings(
    name := "benchmarks",
    version := "1.0",
    scalaVersion := "2.12.8"
  )
