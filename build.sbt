
name := "HelloScalaJS"

version := "0.1"

scalaVersion := "2.13.3"

enablePlugins(ScalaJSPlugin)

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

// start by running World.main()
mainClass in Compile := Some("hello.World")