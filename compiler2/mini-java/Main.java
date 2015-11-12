import syntaxtree.*;
import visitor.*;
import java.io.*;
import java.util.HashSet;


class Main {

    public static void main (String [] args){
    if(args.length != 1){
        System.err.println("Usage: java Driver <inputFile>");
        System.exit(1);
    }
    FileInputStream fis = null;
    //Set<String> set= new HashSet<String>();
    HashSet<String> set= new HashSet<String>();
    SymbolTable table = new SymbolTable();
    try{
        //Set<String> set;





        fis = new FileInputStream(args[0]);
        MiniJavaParser parser = new MiniJavaParser(fis);
        Visitor_1 visitor1 = new Visitor_1();
        set=visitor1.getset();
        Visitor_2 visitor2 = new Visitor_2(set);

        Goal root = parser.Goal();
        System.err.println("Program parsed successfully.");
        root.accept(visitor1);
      //  Visitor_2 visitor2 = new Visitor_2();
        //EvalVisitor eval = new EvalVisitor();
       root.accept(visitor2, null);
       table=visitor2.get_table();
       //System.out.println("the size of table is "+table.sizeoftable());
       //table.addClass("BT");
       //table.addMethod("2","int","BT");
       //table.addlocals("3","int","2","BT");
      // table.taketypelocals("3","2","BT");
       //System.out.println("o tipes tis metavlitis einai  "+table.taketypelocals("3","2","BT"));
       //table.addlocals("4","int","start","BT");
      Visitor_3 visitor3 = new Visitor_3(table);
      root.accept(visitor3, null);

      //  System.out.println(root.accept(evl));
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
