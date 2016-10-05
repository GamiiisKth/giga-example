http://www.studytonight.com/java/java-io-stream


Byte Stream:        It provides a convenient means for handling input and output of byte.

Character Stream:   It provides a convenient means for handling input and output of characters.
Character stream uses Unicode and therefore can be internationalized.

####################################
Some important Byte stream classes.#
####################################
Byte stream is defined by using two abstract class at the top of hierarchy, they are InputStream and OutputStream

Stream class	 Description

BufferedInputStream	    Used for Buffered Input Stream.
BufferedOutputStream	Used for Buffered Output Stream.
DataInputStream	        Contains method for reading java standard datatype
DataOutputStream	    An output stream that contain method for writing java standard data type
FileInputStream	        Input stream that reads from a file
FileOutputStream	    Output stream that write to a file.
InputStream	            Abstract class that describe stream input.
OutputStream	        Abstract class that describe stream output.
PrintStream	            Output Stream that contain print() and println() method


 These classes define several key methods. Two most important are

    read() :    reads byte of data.
    write():   Writes byte of data.

#########################
Character Stream Classes#
#########################
Character stream is also defined by using two abstract class at the top of hierarchy, they are Reader and Writer.

Some important Charcter stream classes.
*************       *************
Stream class*	    *Description*
*************       *************

BufferedReader	    Handles buffered input stream.
BufferedWriter  	Handles buffered output stream.
FileReader      	Input stream that reads from file.
FileWriter      	Output stream that writes to file.
InputStreamReader	Input stream that translate byte to character
OutputStreamReader	Output stream that translate character to byte.
PrintWriter	        Output Stream that contain print() and println() method.


Reader	            Abstract class that define character stream input
Writer	            Abstract class that define character stream output

