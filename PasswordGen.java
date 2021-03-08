import java.util.Random;
import java.util.Scanner;

public class PasswordGen
{
//This project is a Password Generator in Java
    public static void main(String[] args)
    {
     Scanner lengthInput = new Scanner(System.in); //Creates new scanner obj to intake user input
     System.out.println("Input length of required/desired  letters in password(Must be 15 or less. Must also be greater than 3 characters long.):");
     int passwordLengthInput = lengthInput.nextInt();
     System.out.println("Input length of required/desired numbers in password: (Must be less than 6.)");
     int passwordNumInput = lengthInput.nextInt();
     System.out.println(passwordAlpha(passwordLengthInput)+passwordNum(passwordNumInput));
     lengthInput.close();
    }
    
    private static int passwordNum(int length) //This method passes a length int and creates a random number with the desired length value. 
    {
        while (length > 6)
        {
            length--;
        }
        int randomNumbers = (int) Math.pow(10, length - 1);
        return randomNumbers + new Random().nextInt(9 * randomNumbers);
        
    }

    private static String passwordAlpha(int length) //This method passes a length int and creates a random charactered string with the length value. 
    {
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpper = alphabetLower.toUpperCase();
        String alphabet = alphabetUpper + alphabetLower;
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        boolean lengthCheck = length>15 || length < 3;
        if (lengthCheck) // This is to make sure user does not try to create a super long or short string.
        {
            System.out.println ("Your input does not meet the length requirement or is too long. Length set to 6. ");
            length = 6;

        }

        for(int i = 0; i < length; i++)
         {
            int index = r.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
          }
      
          String randomString = sb.toString();
          return randomString;  
    }
}