//   https://github.com/awwsmm/HelloScalaJS

name := "HelloScalaJS"
version := "0.1"
scalaVersion := "2.13.3"

// This is a ScalaJS project
enablePlugins(ScalaJSPlugin)

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

// Start by running World.main()
mainClass in Compile := Some("hello.World")