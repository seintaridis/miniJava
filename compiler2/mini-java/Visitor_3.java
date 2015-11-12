import syntaxtree.*;
import visitor.*;
import java.util.*;
import java.io.*;






public class Visitor_3 extends GJDepthFirst<String,String>{



Visitor_3(SymbolTable arg_table){
  table=arg_table;
  System.out.println("constructor visitor 3");
  id_user=new String();
  class_string=new String();
  method_string=new String();
}


List<String> arguments = new ArrayList<String>();
String id_user,class_string,method_string;
SymbolTable table;



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
public String visit(MainClass n, String argu) {
     id_user="name";
     System.out.println("main");
     String class_name=n.f1.f0.toString();
     class_string=class_name;
     method_string="main";
    if(n.f14.present()) n.f14.accept(this,n.f1.f0.toString());
    if(n.f15.present()) n.f15.accept(this,n.f1.f0.toString());
    return null;

}


/**
 * f0 -> "class"
 * f1 -> Identifier()
 * f2 -> "{"
 * f3 -> ( VarDeclaration() )*
 * f4 -> ( MethodDeclaration() )*
 * f5 -> "}"
 */





public String visit(ClassDeclaration n, String argu) {
  id_user="name";
    System.out.println("classdeclaration");
    String class_name=n.f1.f0.toString();
    class_string=class_name;

    //name=class_name;
    //type="class";
     //table.addClass(class_name);
    n.f3.accept(this,class_name);
    n.f4.accept(this,class_name);
   return "dfd";
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
public String visit(ClassExtendsDeclaration n, String argu) {
  id_user="name";
  System.out.println("classdeclaration");
  String class_name=n.f1.f0.toString();
  class_string=class_name;
  n.f5.accept(this,class_name);
  n.f6.accept(this,class_name);
  return null;

}


/**
* f0 -> "public"
* f1 -> Type()
* f2 -> Identifier()
* f3 -> "("
* f4 -> ( FormalParameterList() )?
* f5 -> ")"
* f6 -> "{"
* f7 -> ( VarDeclaration() )*
* f8 -> ( Statement() )*
* f9 -> "return"
* f10 -> Expression()
* f11 -> ";"
* f12 -> "}"
*/
public String visit(MethodDeclaration n, String argu) {
  id_user="name";
  System.out.println("methodeclaration");
  System.out.println(argu);

  String type_of_method=n.f1.accept(this,argu);
  String name_of_method=n.f2.f0.toString();
  method_string=name_of_method;


  String result_of_expr;
  //table.addMethod(name_of_method,type_of_method,argu);
  //System.out.println(name_of_method);
  //System.out.println("methodeclaration type is "+ type_of_method);
  //string1=argu;
  //string2=name_of_method;
  n.f4.accept(this,argu);
  //type="method";
  n.f7.accept(this,argu);
  result_of_expr=n.f10.accept(this,argu);
  if (result_of_expr!=type_of_method)
     result_of_expr=table.taketypelocals(result_of_expr,method_string,class_string);
  if (result_of_expr!=type_of_method)
    throw new RuntimeException("Method "+name_of_method+" must return "+type_of_method+" but return "+ result_of_expr);
  n.f8.accept(this,argu);




  return "sdsd";
}



/**
  * f0 -> ","
  * f1 -> Expression()
  */
 public String visit(ExpressionTerm n, String argu) {
    n.f0.accept(this, argu);
    arguments.add(n.f1.accept(this, argu));
    return n.f0.accept(this, argu);

 }

/**
  * f0 -> Expression()
  * f1 -> ExpressionTail()
  */
 public String visit(ExpressionList n, String argu) {

  arguments.add(n.f0.accept(this, argu));
    n.f1.accept(this, argu);
    return "";
 }



/**
 * f0 -> Identifier()
 * f1 -> "="
 * f2 -> Expression()
 * f3 -> ";"
 */
public String visit(AssignmentStatement n, String argu) {
  System.out.println("assignment!!!");
   String type1=table.taketypelocals(n.f0.accept(this, argu),method_string,class_string);
   String type2=n.f2.accept(this, argu);
   n.f3.accept(this, argu);
   System.out.println(type1);
   System.out.println(type2);
   if (type1!=type2)
      type2=table.taketypelocals(type2,method_string,class_string);
    if (type1!=type2)
   throw new RuntimeException("trying to assign "+type2+" expression to "+type1 );

   return null;
}







/**
 * f0 -> AndExpression()
 *       | CompareExpression()
 *       | PlusExpression()
 *       | MinusExpression()
 *       | TimesExpression()
 *       | ArrayLookup()
 *       | ArrayLength()
 *       | MessageSend()
 *       | Clause()
 */
public String visit(Expression n, String argu) {
  System.out.println("expression");

   return n.f0.accept(this, argu);
}


/**
 * f0 -> PrimaryExpression()
 * f1 -> "."
 * f2 -> Identifier()
 * f3 -> "("
 * f4 -> ( ExpressionList() )?
 * f5 -> ")"
 */


public String visit(MessageSend n, String argu) {
  System.out.println("messagesend");
   String variable = n.f0.accept(this, argu);
   String var_type;
   if (table.takeclass(variable)!=null)
    var_type=variable;
   else
   {

   var_type=table.taketypelocals(variable,method_string,class_string);

   }
   String method = n.f2.accept(this, argu);
   System.out.println(var_type);
   String type_method=table.taketypemethods(var_type,method,method_string,class_string);
   n.f4.accept(this, argu);
   String type = table.checkarg(var_type,method,arguments);
   arguments.clear();



   return type_method;
}




/**
 * f0 -> PrimaryExpression()
 * f1 -> "+"
 * f2 -> PrimaryExpression()
 */
public String visit(PlusExpression n, String argu) {
  System.out.println("plusexpression");
  String type1=n.f0.accept(this, argu);
  if (type1!="int")
    type1=table.taketypelocals(type1,method_string,class_string);
  String type2=n.f2.accept(this, argu);
  if (type2!="int")
    type2=table.taketypelocals(type2,method_string,class_string);


   if (type1!="int"|| type2!="int")
      throw new RuntimeException("expressions on plus must be integer");



   return "int";
}

/**
 * f0 -> Clause()
 * f1 -> "&&"
 * f2 -> Clause()
 */
public String visit(AndExpression n, String argu) {

   System.out.println("endexpression");
   String type1=n.f0.accept(this, argu);
   if (type1!="boolean")
     type1=table.taketypelocals(type1,method_string,class_string);
   String type2=n.f2.accept(this, argu);
   if (type2!="boolean")
     type2=table.taketypelocals(type2,method_string,class_string);


    if (type1!="boolean"|| type2!="boolean")
       throw new RuntimeException("expressions on end expression must be boolean");



    return "boolean";
}

/**
 * f0 -> PrimaryExpression()
 * f1 -> "<"
 * f2 -> PrimaryExpression()
 */
public String visit(CompareExpression n, String argu) {
  System.out.println("compareexpression");
  String type1=n.f0.accept(this, argu);
  if (type1!="int")
    type1=table.taketypelocals(type1,method_string,class_string);
  String type2=n.f2.accept(this, argu);
  if (type2!="int")
    type2=table.taketypelocals(type2,method_string,class_string);


   if (type1!="int"|| type2!="int")
      throw new RuntimeException("expressions on compare expression must be integer");



   return "boolean";

}



/**
 * f0 -> PrimaryExpression()
 * f1 -> "-"
 * f2 -> PrimaryExpression()
 */
public String visit(MinusExpression n, String argu) {
  System.out.println("plusexpression");
  String type1=n.f0.accept(this, argu);
  if (type1!="int")
    type1=table.taketypelocals(type1,method_string,class_string);
  String type2=n.f2.accept(this, argu);
  if (type2!="int")
    type2=table.taketypelocals(type2,method_string,class_string);


   if (type1!="int"|| type2!="int")
      throw new RuntimeException("expressions on plus must be integer");



   return "int";
}

/**
 * f0 -> PrimaryExpression()
 * f1 -> "*"
 * f2 -> PrimaryExpression()
 */
public String visit(TimesExpression n, String argu) {
   System.out.println("plusexpression");
   String type1=n.f0.accept(this, argu);
   if (type1!="int")
     type1=table.taketypelocals(type1,method_string,class_string);
   String type2=n.f2.accept(this, argu);
   if (type2!="int")
     type2=table.taketypelocals(type2,method_string,class_string);


    if (type1!="int"|| type2!="int")
       throw new RuntimeException("expressions on plus must be integer");



    return "int";
}

/**
 * f0 -> PrimaryExpression()
 * f1 -> "["
 * f2 -> PrimaryExpression()
 * f3 -> "]"
 */
public String visit(ArrayLookup n, String argu) {
   System.out.println("arraylookup");
   String type1=n.f0.accept(this, argu);
   if (type1!="int[]")
     type1=table.taketypelocals(type1,method_string,class_string);
  String type2=n.f2.accept(this, argu);
  if (type2!="int")
    type2=table.taketypelocals(type2,method_string,class_string);
  if (type1!="int[]"|| type2!="int")
     throw new RuntimeException("your array must be integer and arguments be integer too");



   return "int";
}

/**
  * f0 -> Identifier()
  * f1 -> "["
  * f2 -> Expression()
  * f3 -> "]"
  * f4 -> "="
  * f5 -> Expression()
  * f6 -> ";"
  */
 public String visit(ArrayAssignmentStatement n, String argu) {
   String var=n.f0.accept(this, argu);
   String type1=table.taketypelocals(var,method_string,class_string);
   if (type1!="int[]")
    throw new RuntimeException("your array must be integer and arguments be integer too");
   String type2=n.f2.accept(this, argu);
   if (type2!="int")
     type2=table.taketypelocals(type2,method_string,class_string);
   String type3=n.f5.accept(this, argu);
   if (type3!="int")
     type3=table.taketypelocals(type2,method_string,class_string);
   if (type2!="int"|| type3!="int")
      throw new RuntimeException("your array must be integer and arguments be integer too");

  return"";
 }




/**
 * f0 -> PrimaryExpression()
 * f1 -> "."
 * f2 -> "length"
 */
public String visit(ArrayLength n, String argu) {
   System.out.println("arraylength");
   String type1 = n.f0.accept(this, argu);
   if (type1!="int[]")
     type1=table.taketypelocals(type1,method_string,class_string);
    if (type1!="int[]")
      throw new RuntimeException("you can use length only with array");

   return "int";
}

/**
 * f0 -> PrimaryExpression()
 * f1 -> "."
 * f2 -> Identifier()
 * f3 -> "("
 * f4 -> ( ExpressionList() )?
 * f5 -> ")"
 */
//public String visit(MessageSend n, String argu) {

  // return "ton tipo tis methodou";
//}


/**
 * f0 -> NotExpression()
 *       | PrimaryExpression()
 */
public String visit(Clause n, String argu) {
  System.out.println("clause");

   return n.f0.accept(this, argu);
}





/**
 * f0 -> IntegerLiteral()
 *       | TrueLiteral()
 *       | FalseLiteral()
 *       | Identifier()
 *       | ThisExpression()
 *       | ArrayAllocationExpression()
 *       | AllocationExpression()
 *       | BracketExpression()
 */
public String visit(PrimaryExpression n, String argu) {
   System.out.println("primary");
   return n.f0.accept(this, argu);

}

/**
 * f0 -> <INTEGER_LITERAL>
 */
public String visit(IntegerLiteral n, String argu) {
   return "int";
}



public String visit(TrueLiteral n, String argu) {
   return "boolean";
}

/**
 * f0 -> "false"
 */
public String visit(FalseLiteral n, String argu) {
   return "boolean";
}

/**
* f0 -> <IDENTIFIER>
*/
public String visit(Identifier n, String argu) {
  //if (id_user=="name")
    return n.f0.toString();


}


/**
* f0 -> "int"
* f1 -> "["
* f2 -> "]"
*/
public String visit(ArrayType n, String argu) {
   return "int[] ";
}

/**
* f0 -> "boolean"
*/
public String visit(BooleanType n, String argu) {
  return "boolean";
}

/**
* f0 -> "int"
*/
public String visit(IntegerType n, String argu) {
  return "int";
}

/**
* f0 -> "new"
* f1 -> Identifier()
* f2 -> "("
* f3 -> ")"
*/
public String visit(AllocationExpression n, String argu) {
  n.f0.accept(this, argu);
  String image = n.f1.accept(this, argu);
  String bla=table.takeclass(image);

  if (bla==null)
    throw new RuntimeException("class "+image+ "is not defined");
  return bla;

}

/**
 * f0 -> "this"
 */
public String visit(ThisExpression n, String argu) {
   return class_string;
}



/**
 * f0 -> "("
 * f1 -> Expression()
 * f2 -> ")"
 */
public String visit(BracketExpression n, String argu) {

   return n.f1.accept(this, argu);
}



/**
  * f0 -> "new"
  * f1 -> "int"
  * f2 -> "["
  * f3 -> Expression()
  * f4 -> "]"
  */
public String visit(ArrayAllocationExpression n, String arg) {

    String onoma = n.f3.accept(this, arg);
    if(onoma!="int"){
      throw new RuntimeException("array must have int between []");
    }

    return "int[]";
}






/**
* f0 -> ArrayType()
*       | BooleanType()
*       | IntegerType()
*       | Identifier()
*/
public String visit(Type n, String argu) {
  String type= n.f0.accept(this, argu);

  return type;
}



/**
  * f0 -> "System.out.n"
  * f1 -> "("
  * f2 -> Expression()
  * f3 -> ")"
  * f4 -> ";"
  */
 public String visit(PrintStatement n, String arg) {


    String expr = n.f2.accept(this, arg);
    if (expr=="int"||expr=="boolean")
      return "";
    else
      throw new RuntimeException("System.out.n only prints int or boolean");


 }





}
