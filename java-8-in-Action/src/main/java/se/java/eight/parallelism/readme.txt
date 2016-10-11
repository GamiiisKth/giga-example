1.1.4. Parallelism and shared mutable data

The third programming concept is rather more implicit and arises from the phrase “parallelism almost for free”
in our previous discussion on stream processing. What do you have to give up?
You may have to make some small changes in the way you code the behavior passed to stream methods.

 You must provide behavior that is safe to execute concurrently on different pieces of the input.
 Typically this means writing code that doesn’t access shared mutable data to do its job

 The previous parallelism arises only by assuming that multiple copies of your piece of code can work independently

 If there’s a shared variable or object, which is written to, then things no longer work:

 Java 8 streams exploit parallelism more easily than Java’s existing Threads API,
 so although it’s possible to use synchronized to break the no-shared-mutable-data rule