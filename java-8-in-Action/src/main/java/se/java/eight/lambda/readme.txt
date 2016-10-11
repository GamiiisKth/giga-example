So the designers of Java 8 decided to allow methods to be values—to make it easier for you to program


The first new Java 8 feature we introduce is that of method references

*****
Page 24
*****

File[] hiddenFiles = new File(".").listFiles(new FileFilter ){
public boolean accept(File file){
return file.isHidden();}
}


But written the same code in java 8
File[] hiddenFiles = new File(".").listFiles(File::isHidden);

Wow! Isn’t that cool? You already have the function isHidden available, so you just pass it to the listFiles
method using the Java 8 method reference :: syntax (meaning “use this method as a value”);

Here’s a taste of what’s coming: methods are no longer second-class values. Analogously to using an object reference
when you pass an object around (and object references are created by new), in Java 8 when you write File::isHidden
you create a method reference, which can similarly be passed around. This concept is discussed in detail in chapter 3.

!!
Lambdas—anonymous functions
As well as allowing (named) methods to be first-class values, Java 8 allows a richer idea of functions as values,
including lambdas[4] (or anonymous functions). For example, you can now write (int x) -> x + 1 to mean “the function that,
when called with argument x, returns the value x + 1.” You might wonder why this is necessary because you could define a
method add1 inside a class MyMathsUtils and then write MyMaths-Utils::add1! Yes, you could, but the new lambda syntax is
more concise for cases where you don’t have a convenient method and class available.

. Programs using these concepts are said to be written in functional-programming style—this phrase means “writing programs
 that pass functions around as first-class values.”