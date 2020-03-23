package com.company;

import java.util.Scanner;

public class Main extends CalculationClass {

    // variable to store user name.
    private static String UserName;
    // Scanner for capturing user input.
    private static Scanner input = new Scanner(System.in);

    // Main method this is the first method to be called when user runs application.
    public static void main(String[] args){
        // prints logo to console.
        System.out.print(LogoString());
        // get user name
        GetUserName();
        // prints options and waits for user input this method is called passing it a static method with a return type of int
        UserInputSelection(UserSelection());
    }

    // Check user name is not null and if true gets / sets user name variable.
    private static void GetUserName(){
        if(UserName == null){
            System.out.print("\r\nEnter a user name: ");
            UserName = input.next();
        }
    }

    // LogoSting is an ascii logo that greats the user when application is first run.
    private static StringBuilder LogoString(){
        StringBuilder logo = new StringBuilder();
        logo.append("(       )   (  ____ \\  (  ___ \\ |\\     /|\\__   __/( \\      (  __  \\                                                             \n" +
                "| () () |   | (    \\/  | (   ) )| )   ( |   ) (   | (      | (  \\  )                                                            \n" +
                "| || || |   | |        | (__/ / | |   | |   | |   | |      | |   ) |                                                            \n" +
                "| |(_)| |   | |        |  __ (  | |   | |   | |   | |      | |   | |                                                            \n" +
                "| |   | |   | |        | (  \\ \\ | |   | |   | |   | |      | |   ) |                                                            \n" +
                "| )   ( | _ | (____/\\  | )___) )| (___) |___) (___| (____/\\| (__/  )                                                            \n" +
                "|/     \\|(_)(_______/  |/ \\___/ (_______)\\_______/(_______/(______/                                                             \n" +
                "                                                                                                                                \n" +
                " _______  _______  _______  _          _______  _______  _        _______           _        _______ _________ _______  _______ \n" +
                "(  ____ )(  ___  )(  ___  )( \\        (  ____ \\(  ___  )( \\      (  ____ \\|\\     /|( \\      (  ___  )\\__   __/(  ___  )(  ____ )\n" +
                "| (    )|| (   ) || (   ) || (        | (    \\/| (   ) || (      | (    \\/| )   ( || (      | (   ) |   ) (   | (   ) || (    )|\n" +
                "| (____)|| |   | || |   | || |        | |      | (___) || |      | |      | |   | || |      | (___) |   | |   | |   | || (____)|\n" +
                "|  _____)| |   | || |   | || |        | |      |  ___  || |      | |      | |   | || |      |  ___  |   | |   | |   | ||     __)\n" +
                "| (      | |   | || |   | || |        | |      | (   ) || |      | |      | |   | || |      | (   ) |   | |   | |   | || (\\ (   \n" +
                "| )      | (___) || (___) || (____/\\  | (____/\\| )   ( || (____/\\| (____/\\| (___) || (____/\\| )   ( |   | |   | (___) || ) \\ \\__\n" +
                "|/       (_______)(_______)(_______/  (_______/|/     \\|(_______/(_______/(_______)(_______/|/     \\|   )_(   (_______)|/   \\__/");
        return logo;
    }

    // User Selection is the first menu and sets the shape of the swimming pool
    private static int UserSelection(){
        System.out.println("\r\nSelect the Type of swimming pool you want to calculate" +
                " \r\n1 Rectangle\r\n2 Circular\r\n3 Exit ");

        // stops user entering letters
        try
        {
            int convert = Integer.parseInt(input.next());
            if(convert == 1 || convert == 2 || convert == 3){
                return convert;
            }
        }
        catch(Exception ex){
            // prints input error
            System.out.println("Input error you must enter a number, Try again!");
        }
        return 4;
    }

    // Handel's the user input arguments for pool shape selection
    private static void UserInputSelection(int userInput) {

        if(userInput == 1){
            System.out.println("1 Rectangle");
            RectangleCalc();
            // calls the rectangle method
        }
        if(userInput == 2){
            System.out.println("2 Circular");
            CircularCalc();
            // calls the circular method
        }
        if(userInput == 3){
            System.out.println("3 exit");
            // calls the exit function
            System.exit(0);
        }
        if(userInput == 4){
            UserInputSelection(UserSelection());
        }
    }

    // Gets user input and calculates the area and volume of a circular swimming pool
    private static void CircularCalc() {
        if (YerOrNO("Does this pool have a shallow and deep end?")) {
            System.out.println("Enter pool depth shallow end");
            double depthS = input.nextDouble();
            System.out.println("Enter pool depth deep end");
            double depthD = input.nextDouble();
            System.out.println("Enter pool Radius");
            double radius = input.nextDouble();

            String volume =
                    CalculationClass.CalculateVolumePieGrad(depthD,depthS, radius) + " m³";

            String surface =
                    CalculationClass.CalculateSurfaceAreaPieGrad(depthD,depthD,radius) + " m²";

            FinalOutputCircular(volume,surface, LevelDepth(depthD,depthS),radius);
        }
        else {
            System.out.println("Enter pool depth");
            double depthD = input.nextDouble();
            System.out.println("Enter pool Radius");
            double radius = input.nextDouble();

            String volume =
                    CalculationClass.CalculateVolumePie(depthD, radius) + " m³";

            String surface =
                    CalculationClass.CalculateSurfaceAreaPie(depthD, radius) + " m²";

            FinalOutputCircular(volume,surface, depthD,radius);

        }
    }

    // Final out put for calculating a circular swimming pool
    private static void FinalOutputCircular(String volume, String area, double depth, double radius){

        String[] output = new String[6];

        output[0] = "++++++++++++++++++++++++++++++++++++++++++++++";
        output[1] = "+\tUser : "+ UserName +" Calculated Circular Pool";
        output[2] = "+\t"+volume + " : Volume";
        output[3] = "+\t"+area + " : Area";
        output[4] = "+\t"+depth+" m : Depth";
        output[5] = "+\t"+radius+" m : Radius";

        for (String x:output) {
            System.out.println(fixedLengthString(x,45));
        }

        if(YerOrNO("Do You want to calculate another pool?")){
            UserInputSelection(UserSelection());
        }
        System.exit(0);
    }

    // Get user input and calculates the area and volume of a Rectangular swimming pool
    private static void RectangleCalc() {

        if(YerOrNO("Does this pool have a shallow and deep end?")) {
            System.out.println("Enter pool dimensions in meters i.e. 1.5m or 25m\r\nEnter pool depth shallow end");
            double depthS = input.nextDouble();
            System.out.println("Enter pool depth deep end");
            double depthDeep = input.nextDouble();
            System.out.println("Enter pool Length");
            double Length = input.nextDouble();
            System.out.println("Enter pool Width");
            double Width = input.nextDouble();

            String volume =
                    CalculationClass.CalculateVolume(LevelDepth(depthDeep,depthS), Length, Width) + " m³";

            String surface =
                    CalculationClass.CalculateInternalSurface(LevelDepth(depthDeep,depthS), Length, Width) + " m²";

            FinalOutputRectangle(volume,surface, LevelDepth(depthDeep,depthS),Length,Width);

        }
        else{
            System.out.println("Enter pool dimensions in meters i.e. 1.5m or 25m\r\nEnter pool depth");
            double depth = input.nextDouble();
            System.out.println("Enter pool Length" );
            double Length = input.nextDouble();
            System.out.println("Enter pool Width");
            double Width = input.nextDouble();

            String volume =
                    CalculationClass.CalculateVolume(depth, Length, Width) + " m³";

            String surface =
                    CalculationClass.CalculateInternalSurface(depth, Length, Width) + " m²";

            FinalOutputRectangle(volume,surface, depth,Length,Width);
        }
    }

    // Final out put for calculating a Rectangular swimming pool
    private static void FinalOutputRectangle(String volume, String area, double depth, double length, double width){

        String[] output = new String[7];

        output[0] = "++++++++++++++++++++++++++++++++++++++++++++++";
        output[1] = "+\tUser : "+UserName +" Calculated Rectangular Pool";
        output[2] = "+\t"+volume + " : Volume";
        output[3] = "+\t"+area + " : Area";
        output[4] = "+\t"+depth+" m : Depth";
        output[5] = "+\t"+length+" m : Length";
        output[6] = "+\t"+width+" m : Width";

        for (String x:output) {
            System.out.println(fixedLengthString(x,45));
        }

        if(YerOrNO("Do You want to calculate another pool?")){
            UserInputSelection(UserSelection());
        }
        System.exit(0);
    }

    // appends a + to the end of a string at the input length
    public static String fixedLengthString(String string, int length) {
        int x = length - string.length();
        return String.format(string+"%1$"+x+"s", "+");
    }

    /*
     *   This boolean method check the user selection to see if the swimming pool has a deep end or not,
     *   it is also called when the application has finished with a calculation to rerun or exit.
     */
    private static boolean YerOrNO(String message){
        System.out.print(message + " Y/N! : ");
        String yesNo = input.next();
        if(yesNo.contains("y")||(yesNo.contains("Y")||(yesNo.contains("n")||(yesNo.contains("N"))))){
            return yesNo.contains("y") || (yesNo.contains("Y"));
        }
        return YerOrNO(message);
    }

}
