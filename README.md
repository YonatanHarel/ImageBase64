# ImageBase64
Base64 encoding and decoding an Image.

This is an example using Base64 to encode and decode image files (jpg, png, etc.).
I noticed that there is different between encoding/decoding image and other binary file.
In this exapmle I'm using the following libraries:
- google guava (for Files handling)
- java.util.Base64 (for encoding/decoding using Base64 - not sun.misc.BASE64 which is quite deprecated)

Open Issue:
This is strange but the encoded/decoded file is little bit larger that the original file (in my case it was 34% larger).
"base64 encoding makes file sizes roughly 33% larger than their original binary representations."
Here is useful information regarding this behavior:
http://davidbcalhoun.com/2011/when-to-base64-encode-images-and-when-not-to/
