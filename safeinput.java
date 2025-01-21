import java.util.Scanner;

public class SafeInput {

        public static String getNonZeroLenString(Scanner pipe, String prompt)
        {
            /**
             *
             * @param pipe a Scanner opened to read from System.in
             * @param prompt prompt for the user
             * @return a String response that is not zero length
             */
            String retString = ""; // Set this to zero length. Loop runs until it isn’t
            do
            {
                System.out.print("" +prompt + " ");
                retString = pipe.nextLine();
            }while(retString.length() == 0);
            return retString;
        }

        public static int getInt(Scanner pipe, String prompt)
        {
            /**
             *
             * @param pipe a Scanner opened to read from System.in
             * @param prompt prompt for the user
             * @return an integer response
             */
            int retInt = 0; // default value
            do
            {
                System.out.print("" + prompt + " "); // prompts the user to enter an integer
                retInt = pipe.nextInt();
            }while (retInt == 0);
            return retInt; // returns inputted integer
        }

        public static double getDouble(Scanner pipe, String prompt)
        {
            /**
             *
             * @param pipe a Scanner opened to read from System.in
             * @param prompt prompt for the user
             * @return a double response
             */
            double retDouble = 0; // default value
            do
            {
                System.out.print("" + prompt + " "); // prompts the user to enter a double
                retDouble = pipe.nextDouble();
            }while (retDouble == 0);
            return retDouble; // returns inputted double
        }

        public static int getRangedInt(Scanner pipe, String prompt, int low, int high )
        {
            /**
             *
             * @param pipe a Scanner opened to read from System.in
             * @param prompt prompt for the user
             * @return an integer in the range response
             */
            int retInt = 0;
            do
            {
                System.out.print("" + prompt + " ");
                retInt = pipe.nextInt();
            }while (retInt <= low && retInt >= high );
            return retInt;
        }

        public static double getRangedDouble(Scanner pipe, String prompt, double low, double high )
        {
        /**
         *
         * @param pipe a Scanner opened to read from System.in
         * @param prompt prompt for the user
         * @return an integer in the range response
         */
        double retDouble = 0;
        do
        {
            System.out.print("" + prompt + " ");
            retDouble = pipe.nextDouble();
        }while (retDouble >= low && retDouble <= high );
        return retDouble;
        }

        public static boolean getYNConfirm(Scanner pipe, String prompt)
        {
            boolean Boolean = false;
            String retBoolean = "";
            System.out.print("" + prompt + " ");
            retBoolean = pipe.nextLine();
            Boolean = retBoolean.equalsIgnoreCase("y");
            return Boolean;
        }

        public static String getRegExString(Scanner pipe, String prompt, String regEx)
        {
            String value = "";
            boolean gotAVaule = false;
            do
            {
                System.out.print(prompt + ": ");
                value = pipe.nextLine();
                if(value.matches(regEx))
                {
                    gotAVaule = true;
                }
                else
                {
                    System.out.println("Invalid input: " + value);
                }
            }while (!gotAVaule);
            return value;
        }






}
