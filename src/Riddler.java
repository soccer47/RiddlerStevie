/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: YOUR NAME HERE
 */
public class Riddler {

    public String decryptOne(String encrypted) {
        // Empty string to be returned
        String decrypted = "";
        // Traverses through each character in the encoded String
        for (int i = 0; i < encrypted.length(); i++) {
            int charVal = encrypted.charAt(i);
            // If character isn't a letter, don't change its value
            if (charVal <= 64 || (charVal >= 91 && charVal <= 96)) {
                charVal += 0;
            }
            // If the character is upper case, perform caesar shift on letter value (+9)
            else if (charVal <= 90) {
                charVal = (charVal - 'A' + 9)%26 + 'A';
            }
            // If the character is lower case, perform caesar shift on letter value (+9)
            else if (charVal <= 122){
                charVal = (charVal - 'a' + 9)%26 + 'a';
            }
            // Add the ASCII value of the int to the message to be returned
            decrypted += (char)charVal;
        }

        // Print the decoded message
        System.out.print(decrypted);
        // Return the decoded message
        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        // String to be returned starts as empty string
        String decrypted = "";
        // String that will hold the characters that are individually added
        String value = "";
        // Traverses through each character of the encoded message
        for (int i = 0; i < encrypted.length(); i++) {
            // If the end of the number is reached, add the ascii value of the number to the return string
            if (encrypted.substring(i, i + 1).equals(" ")) {
                decrypted += (char)(Integer.parseInt(value));
                // Reset the value of the string that holds the characters that are individually added
                value = "";
            }
            else {
                // Otherwise add the given character to the temporary String
                value += encrypted.charAt(i);
            }
        }

        // Print the decoded message
        System.out.print(decrypted);
        // Return the decoded message
        return decrypted;
    }

    public String decryptThree(String encrypted) {
        // String to be returned starts as empty string
        String decrypted = "";
        // String that will hold added chars until length is 8
        String binaryVal = "";
        // Traverses through each character of the encoded message
        for (int i = 0; i < encrypted.length(); i++) {
            binaryVal += encrypted.charAt(i);
            // If the length of value is 8, get the char from the value of the 8-bit int
            if ((i + 1) % 8 == 0) {
                int decVal = Integer.parseInt(binaryVal, 2);
                // Add the resulting char to the String to be returned
                decrypted += (char)decVal;
                // Reset the String that holds the characters added individually
                binaryVal = "";
            }

        }

        // Print the decoded message
        System.out.print(decrypted);
        // Return the decoded message
        return decrypted;
    }

    public String decryptFour(String encrypted) {
        // String to be returned starts as empty string
        String decrypted = "";
        // Traverses through each character of the encoded message
        for (int i = 0; i < encrypted.length(); i++) {
            // If the character is a truck, add a space to the message
            if (encrypted.charAt(i) == '⛟') {
                decrypted += " ";
            }
            else {
                // Otherwise, add the ascii value for the shifted value of the character in unicode to the return string
                // *unicode value of the char - distance from start of dingbats in unicode to capital A in unicode
                decrypted += Character.toString((char)(encrypted.codePointAt(i) - 9919));
            }
        }

        // Print the decoded message
        System.out.print(decrypted);
        // Return the decoded message
        return decrypted;
    }
}
