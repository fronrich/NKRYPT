<h1>"NCRYPT" - Created by Fronrich Puno</h1>

Start Date: July 15, 2019

<h2>DESCRIPTION:</h2>

This is the first prototype of an encryption / decryption algorithm which
utilizes periodic noisy bit expansion and salting.

These encryption methods work as follows:

* *Bit expansion*: expanding a single bit into a larger number of bits

	* This program uses noisy bit expansion, which turns one bit into a
	seemingly random string of bits. The length of this bit string is determined
	by a 256-bit key (**KEY_X**). Each "1" within **KEY_X** is summed up. The
	sum is the length of each expanded bit.

	The bits within the expanded bit, although they appear random, are determined
	by the original bit. An expanded bit string with more "1s" than "0s" will decrypt
	to a 1, and vice versa. The location of "1s" and "0s" in the expanded bit
	are arbitrary.
	

	* <h3>Here Is An Example:</h3>

		KEY_X (base 10) | Original bit(s) | Possible Expaned bit(s)
		----------------|-----------------|-
		4 | 1_0_1 | 0111_0100_1101
		5 | 0_0_1_1 | 01001_10100_11001_01110
		6 | 1_0	| 010111_010010
		7 | 1_1_0 | 1011010_0010111_1100010
		8 | 0_1 | 00110001_11000111
		9 | 0_0	| 101001010_000101111

* *Salting*: Adding a random string of characters to the end of a string.

	* This program uses periodic salting, which adds random strings
	in between the encrypted data at set intervals. The nature of these
	Strings is determined by three 32-bit keys (**KEY_A** and **KEY_B**). Correctly
	entering these keys will allow a client to successfully decrypt a file.

	* The first key (**KEY_A**) is an int which will determine the periodic positioning
	of salts in relation to the bits of an unencrypted file. For example, if the
	int for **KEY_A** was "3" (in base 10), every 3 bits in the original file, there would
	be a salt.
	
	* <h3>Here Is An Example:</h3>
	
		POSITION: | 1 | 2 | 3 |  | 4 | 5 | 6 |   | 7 | 8 |
		--------- | - | - | - | - | - | - | - | - | - | - |
		ORIGINAL BIT: | 1 | 1 | 0 | SALT | 0 | 1 | 1 | SALT | 0 | 1 |

	* **KEY_B** is an int which will determine the length in characters of each salt.
	The characters in the salt are completely random.

	* <h3>Here Is An Example:</h3>
		
		KEY_B (base 10)	| Possible Salt (as 8-bit characters)
		----------------|-
		1 | #
		2 | gE
		3 | H9
		10 | @&8UH7d(FN
		20 | iIoOKNBu( B&^ Yn,:{]

	* The strings themselves are also encrypted with noisy bit expansion.
	Their factor of expansion is dependent upon the value of **KEY_C**.
	By having a separate bit expansion factor for the salts,when an encrypted file
	is attempted to be read in an encoding scheme of consistent bit length,
	even though the bit length of that encoding scheme may match the bit length of the
	expanded bits, all bits after the first salt will mismatch, preventing hackers from
	using language based frequency analysis.

Upon encrypting, this program will give the client a String which contains all 4 keys.
This String can be used to decrypt the encrypted message. The keys are randomly generated
and are unique to each file.

<h2>Purpose:</h2>

Being a learning software developer / philosopher, and I am developing this open-source
project as a way for the general public to protect confidential information from malicious
parties. I hope that the techniques in this encryption / decryption program can be
implemented with people seen as ends rather than means, as they are in Kantian philosophy.

I believe that the respect of an individuals privacy is a categorical imperative, so long as
what the individual holds private does not compromise the well being of other individuals.
I hope that this is kept in mind to the users of this software.
