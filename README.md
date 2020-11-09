# HelloScalaJS

A minimal introduction to working with Scala.js with sbt in IntelliJ.

_(Not endorsed by or in any way affiliated with Lightbend or EPFL.)_

## What is Scala.js?

**Scala.js<sup>[1](#fn01)</sup> is a Scala-to-JavaScript compiler.** It allows you to write type-safe, statically-checked Scala code in your favourite IDE, and compile it to optimised JavaScript which you can run in your browser.

**Scala.js is _not_ "Scala lite".** "Scala.js syntax" is identical to Scala syntax, because Scala.js _is_ Scala. Scala.js just compiles your Scala code to JavaScript instead of Java bytecode.

**Scala.js gives you the best of _both_ Scala and JavaScript.**  Many popular Scala libraries and extensions are fully supported in Scala.js, including Scalactic / ScalaTest<sup>[2](#fn02)</sup>, Cats<sup>[3](#fn03)</sup>, Akka<sup>[4](#fn04)</sup>, Play<sup>[5](#fn05)</sup>, and more. In addition, Scala.js facades<sup>[6](#fn06)</sup> have been implemented for popular JavaScript libraries and frameworks like jQuery, Plotly, React, Angular, and Vue, among many others.

## What is this tutorial?

This is the first step in a series of tutorials which explain how to use Scala.js in an [IntelliJ](https://www.jetbrains.com/idea/download/) sbt project.

In this step, we will create a Scala.js project from scratch, adding the required libraries and dependencies, and will send some output to the browser console.

Open [TUTORIAL.md](TUTORIAL.md) for the step-by-step tutorial.

---

### Sources

<a name="fn01">[1]</a> https://www.scala-js.org/

<a name="fn02">[2]</a> https://www.scalatest.org/release_notes/3.0.0

<a name="fn03">[3]</a> https://typelevel.org/cats/

<a name="fn04">[4]</a> https://github.com/akka-js/akka.js/

<a name="fn05">[5]</a> https://www.scala-js.org/libraries/skeletons.html

<a name="fn06">[6]</a> https://www.scala-js.org/libraries/facades.html
