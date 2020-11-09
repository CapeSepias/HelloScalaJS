# HelloScalaJS

To start, ensure that you have the [IntelliJ IDEA](https://www.jetbrains.com/idea/download) IDE (simply referred to as "IntelliJ" from here forward) installed on your system. This tutorial will also use Scala (obviously) and sbt. Note that IntelliJ [comes with its own Scala compiler](https://docs.scala-lang.org/getting-started/intellij-track/building-a-scala-project-with-intellij-and-sbt.html), but it might be helpful to install Scala and sbt separately.

Once IntelliJ is started, open it up and you should see a splash screen like so  

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.00.49.png?raw=true)

Click `+ New Project` on the splash screen (or, within the application, `File`, `New`, `Project...` from the menu at the top of the screen). A pop-up window like the following should appear

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.01.02.png?raw=true)

Click to create a new Scala sbt project and click `Next`

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.04.58.png?raw=true)

Place the project wherever you like. I'll be grouping this and later steps in this tutorial together under the `ScalaJSTutorial` directory on my machine.

After you click `Finish`, you should see a project with a basic structure, as shown below. The two important files we'll begin with are `project/build.properties` and `build.sbt` (in the root directory):

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.08.16.png?raw=true)

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.08.12.png?raw=true)

_(We won't actually edit `build.properties`, but we will place additional files into its directory, `project/`.)_

Under the `src/` directory, you should find a `main/` subdirectory, and a `scala/` subdirectory within `main/`. This is a pretty standard project layout:

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.10.10.png?raw=true)

Within the `scala/` directory, create a new package and name it `hello` (this can be whatever you want, but we're going to use `hello` later in this tutorial). Within the `hello` package, create a single file named `World.scala` with the following contents

```scala
package hello

object World {

  def main (args: Array[String]): Unit = {
    println("Hello, World!")
    System.err.println("Whoopsie!")
  }

}
```

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.12.48.png?raw=true)

As you might guess, we're testing the [standard out](https://en.wikipedia.org/wiki/Standard_streams#Standard_output_(stdout)) and [standard error](https://en.wikipedia.org/wiki/Standard_streams#Standard_error_(stderr)) outputs of Scala.js.

_(Again, if you want to change the name of the file and `object` from `World` to something else, that's fine, but we'll be using `World` for the rest of this tutorial.)_

Next, we're going to enable Scala.js in this sbt project. Open `build.sbt` and add the following text below the provided `scalaVersion`

```scala
enablePlugins(ScalaJSPlugin)

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

// start by running World.main()
mainClass in Compile := Some("hello.World")
```

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.14.07.png?raw=true)

These lines tell sbt that we want to use Scala.js, and that we want this project to be executable -- the `main()` method in `hello.World` will be the entry point to our application.

Note that some of the text you enter here will be red -- there's an error. We also need to add the Scala.js plugin to sbt. Create a file `project/plugins.sbt` and add the following line to it

```scala
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.3.0")
```

I'm using `1.3.0` as this is the most up-to-date version currently available on [Maven](https://mvnrepository.com/artifact/org.scala-js/scalajs-library) as of this writing.

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.16.13.png?raw=true)

Click on the "Load sbt changes" button in the tiny modal that pops up (the little red hexagon with blue arrows) once or twice and eventually the errors will be resolved

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.16.42.png?raw=true)

The last thing to do is to create an HTML file where we can run our JavaScript code. Remember that Scala.js compiles to JavaScript, and JavaScript only runs in a browser, within an HTML file. We can create a minimal file by simply including the output `.js` file in the `<head>` HTML element. Something like the following will be fine

```html
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Hello, World!</title>
        <script type="text/javascript" src="./target/scala-2.13/helloscalajs-fastopt.js"></script>
    </head>

    <body>
    </body>

</html>
```

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.19.10.png?raw=true)

When we compile our Scala code to JavaScript code, the output will go to the `target/scala-x.y/` directory in the root project directory, where `x.y` is the Scala version we're using. The name of the output file will be the name of the IntelliJ project, in all lowercase letters, with either `-fastopt.js` or `-opt.js` appended to the end.

`-fastopt` / `-opt` are appended to the output filename to indicate the optimisation strategy used for compiling to JavaScript. In order to run this code, we need to compile it. The sbt command `fastOptJS` will quickly create a less-than-optimal JavaScript output file, but it does it very quickly. You should use `fastOptJS` while developing to iterate quickly

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.19.27.png?raw=true)

Once the code is compiled, you should see a `[success]` message in the IntelliJ sbt shell. If you mouse over the HTML code, you'll get a small modal which presents the browsers installed on your system -- click on one of them and you can view the output in that browser!

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.19.50.png?raw=true)

Right now, our output isn't very exciting...

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.20.18.png?raw=true)

...because we haven't actually added anything to the body of the HTML. What we have done is printed to the console. If you "inspect" the page, you can see the text we've written to `stdout` and `stderr`:

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.20.26.png?raw=true)

Notice that `Hello, World!` is in white text here, while `Whoopsie!` is in red text. This is a subtle difference, but it means that Scala's `System.out.println()` is being compiled to JavaScript's `console.log()`, while `System.err.println()` is being compiled to `console.err()`. We've successfully compiled Scala code to JavaScript!

If you're curious, you can inspect the JavaScript code that is actually being run to generate this output. It's written to the `target/scala-x.y/` directory, as explained above

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.26.14.png?raw=true)

`fastOptJS` very quickly generates JavaScript output so you can iterate and improve your application quickly. The result is a **big** output file. Even for this simple example, we generate nearly 2000 lines of JavaScript:

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.26.29.png?raw=true)

When you're done iterating and ready to publish, you can instead run the sbt task `fullOptJS`, which takes a bit longer, but produces much more compact JavaScript:

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.26.41.png?raw=true)

![](https://github.com/awwsmm/HelloScalaJS/blob/master/resources/Screenshot%202020-11-09%20at%2011.27.48.png?raw=true)

Notice that when we use `fullOptJS` to compile our Scala code, the name of the output file ends with `-opt.js`, not `-fullopt.js` as you might expect. (Also, these `.js` files might not appear in the IntelliJ file browser until you attempt to view the output in the browser.)

In the next step of this tutorial, we'll use Li Haoyi's [ScalaTags](https://www.lihaoyi.com/scalatags/) to quickly mock up some HTML so we get something other than a blank white page in the browser.