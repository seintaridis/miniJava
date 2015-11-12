import syntaxtree.*;
import visitor.*;
import java.util.*;
import java.io.*;



public class Generator extends GJDepthFirst<String,String>{


Generator(SymbolTable arg_table){
  table=arg_table;
  System.out.println("Generator");

}

  SymbolTable table;


}
