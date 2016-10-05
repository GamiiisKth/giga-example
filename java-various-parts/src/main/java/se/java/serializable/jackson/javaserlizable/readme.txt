
http://www.studytonight.com/java/serialization-and-deserialization.php


#######################################################################################################
Signature of writeObject() and readObject()

writeObject() method of ObjectOutputStream class serializes an object and send it to the output stream.

public final void writeObject(object x) throws IOException

readObject() method of ObjectInputStream class references object out of stream and deserialize it.

public final Object readObject() throws IOException,ClassNotFoundException
#######################################################################################################

#######################################################################################################
while serializing if you do not want any field to be part of object state then declare it either
*** static or transient
based on your need and it will not be included during java serialization process.
#######################################################################################################