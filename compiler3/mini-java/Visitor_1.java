import syntaxtree.*;
import visitor.*;
import java.util.*;

public class Visitor_1 extends DepthFirstVisitor{
  HashSet<String> set;

  public Visitor_1(){
    set = new HashSet<String>();
  }

  public HashSet<String> getset(){
    return set;
  }

  /**
      * f0 -> "class"
      * f1 -> Identifier()
      * f2 -> "{"
      * f3 -> ( VarDeclaration() )*
      * f4 -> ( MethodDeclaration() )*
      * f5 -> "}"
      */
  public void visit(ClassDeclaration c){
    if(set.contains(c.f1.f0.toString())){
      String ret = "Class "+c.f1.f0.toString()+" is declared twice!";
      throw new RuntimeException(ret);
    }
    set.add(c.f1.f0.toString());
  }


  /**
  * f0 -> "class"
  * f1 -> Identifier()
  * f2 -> "{"
  * f3 -> "public"
  * f4 -> "static"
  * f5 -> "void"
  * f6 -> "main"
  * f7 -> "("
  * f8 -> "String"
  * f9 -> "["
  * f10 -> "]"
  * f11 -> Identifier()
  * f12 -> ")"
  * f13 -> "{"
  * f14 -> ( VarDeclaration() )*
  * f15 -> ( Statement() )*
  * f16 -> "}"
  * f17 -> "}"
  */
  public void visit(MainClass c){
    if(set.contains(c.f1.f0.toString())){
      String ret = "Class "+c.f1.f0.toString()+" is declared twice!";
      throw new RuntimeException(ret);
    }
    set.add(c.f1.f0.toString());
  }


  /**
  * f0 -> "class"
  * f1 -> Identifier()
  * f2 -> "extends"
  * f3 -> Identifier()
  * f4 -> "{"
  * f5 -> ( VarDeclaration() )*
  * f6 -> ( MethodDeclaration() )*
  * f7 -> "}"
  */
  public void visit(ClassExtendsDeclaration c){
    if(set.contains(c.f1.f0.toString())){
      String ret = "Class "+c.f1.f0.toString()+" is declared twice!";
      throw new RuntimeException(ret);
    }
    if(!set.contains(c.f3.f0.toString())){
      String ret = "Class "+c.f1.f0.toString()+" extends a non-declared class ("+c.f3.f0.toString()+")";
      throw new RuntimeException(ret);
    }
    set.add(c.f1.f0.toString());
  }
}
