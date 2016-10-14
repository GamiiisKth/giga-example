Page 17

For introductory purposes, a stream is a sequence of data items that are conceptually produced one at
a time—a program might read items from an input stream one by one and similarly write items to an output stream.
The output stream of one program could well be the input stream of another.



Unix cat creates a stream by concatenating two files, tr translates the characters in a stream, sort sorts lines in a stream,
 and tail -3 gives the last three lines in a stream. The Unix command line allows such programs to be linked together with pipes (|)
 , giving examples such as

cat file1 file2 | tr "[A-Z]" "[a-z]" | sort | tail -3

which (supposing file1 and file2 contain a single word per line) prints the three words
from the files that appear latest in dictionary order, after first translating them to lowercase.
We say that sort takes a stream of lines[3] as input and produces another stream of lines as output (the latter being sorted)

 Note that in Unix the commands (cat, tr, sort, and tail) are executed concurrently,
 so that sort can be processing the first few lines before cat or tr has finished.

  Java 8 adds a Streams API (note the uppercase S) in java.util.stream based on this idea; Stream<T>
 is a sequence of items of type T. You can think of it as a fancy iterator for now. The Streams API has many
 methods that can be chained to form a complex pipeline just like Unix commands were chained in the previous example.
