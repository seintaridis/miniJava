import syntaxtree.*;
import visitor.*;
import java.io.*;
import java.util.HashSet;


class Main {

    public static void main (String [] args){





    FileInputStream fis = null;

    try{
        //Set<String> set;



        String input = args[0];
 String output = input.substring(0, input.indexOf('.'));

        fis = new FileInputStream(args[0]);
        SpigletParser parser = new SpigletParser(fis);

        Goal root = parser.Goal();
        System.err.println("Program parsed successfully.");

      Optimizator opt = new Optimizator(output);
      String result=root.accept(opt, null);

    }
    catch(ParseException ex){
        System.out.println(ex.getMessage());
    }
    catch(FileNotFoundException ex){
        System.err.println(ex.getMessage());
    }
    finally{
        try{
        if(fis != null) fis.close();
        }
        catch(IOException ex){
        System.err.println(ex.getMessage());
        }
    }


  }
}
