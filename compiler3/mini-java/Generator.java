import syntaxtree.*;
import visitor.*;
import java.util.*;
import java.io.*;



public class Generator extends GJDepthFirst<String,String>{


Generator(SymbolTable arg_table){
  table=arg_table;
  //System.out.println("Generator");
  code=new String();
  name_of_class=null;
  patenta=null;
  label_counter=0;
  temp_counter=0;
  global_offset=0;
  eisai_field="no";
  global_var="no_assign";
  to=0;

  global_map=new HashMap<String,String>();
  globo=new LinkedHashMap<String,String>();
  globo_field=new LinkedHashMap<String,String>();
}
  List<String> arguments = new ArrayList<String>();
  SymbolTable table;
  String code;
  String patenta;
  int label_counter;
  int global_offset;
  int temp_counter;
  String name_of_class;
  String name_of_method;
  HashMap<String,String> global_map;
  LinkedHashMap<String,String> globo;
  LinkedHashMap<String,String> globo_field;
  String global_var;
  String eisai_field;
 int to;
public String get_label()
{
  String label="L";
  label_counter++;
  return label+label_counter;
}


public String get_temp(int max)
{
  String temp="TEMP";
  if (temp_counter<max)
    temp_counter=max;

  temp_counter++;
  return temp+" "+temp_counter;
}

/**
 * f0 -> MainClass()
 * f1 -> ( TypeDeclaration() )*
 * f2 -> <EOF>
 */
public String visit(Goal n, String argu) {
  // code="MAIN\n";
   String result;
   String _ret=null;
   String main_String=n.f0.accept(this, argu);
   //System.out.println(test);
   //code=code+"END\n";
   String type_declaration_String=n.f1.accept(this, argu);
   n.f2.accept(this, argu);

//  System.out.println(code);

   return code;
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
public String visit(MainClass n, String argu) {

   code="MAIN\n";
   n.f0.accept(this, argu);
   n.f1.accept(this, argu);
   n.f2.accept(this, argu);
   n.f3.accept(this, argu);
   n.f4.accept(this, argu);
   n.f5.accept(this, argu);
   n.f6.accept(this, argu);
   n.f7.accept(this, argu);
   n.f8.accept(this, argu);
   n.f9.accept(this, argu);
   n.f10.accept(this, argu);
   n.f11.accept(this, argu);
   n.f12.accept(this, argu);
   n.f13.accept(this, argu);
   n.f14.accept(this, argu);
   String statement=n.f15.accept(this, argu);
   n.f16.accept(this, argu);
   n.f17.accept(this, argu);
   code=code+"END\n";
   //System.out.println(code);
   return code;
}



/**
 * f0 -> Block()
 *       | AssignmentStatement()
 *       | ArrayAssignmentStatement()
 *       | IfStatement()
 *       | WhileStatement()
 *       | PrintStatement()
 */
public String visit(Statement n, String argu) {

   return n.f0.accept(this, argu);
}


/**
 * f0 -> "System.out.println"
 * f1 -> "("
 * f2 -> Expression()
 * f3 -> ")"
 * f4 -> ";"
 */
public String visit(PrintStatement n, String argu) {

   n.f0.accept(this, argu);
   n.f1.accept(this, argu);

   String x=n.f2.accept(this, argu);
   code=code+"PRINT "+x+"\n";
   n.f3.accept(this, argu);
   n.f4.accept(this, argu);
   return "lalal";
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
  //System.out.println("expression "+n.f0.accept(this, argu));

   String kala= n.f0.accept(this, argu);
   //eisai_field="no";
   return kala;
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
   HashMap<String,String> map=new HashMap<String,String>() ;
   String object_address;



   global_var="yes_assign";

   object_address=n.f0.accept(this,argu);






   String onoma=globo.get(object_address);

   global_var="no_assign";
   String temp=get_temp(30);
   code=code+"MOVE "+temp+" "+object_address+"\n";
   String new_object_address=temp;
   map.put("object",temp);
   temp=get_temp(30);

   code=code+"HLOAD "+temp+" "+new_object_address+" 0"+"\n";
   map.put("v_address",temp);
   //System.out.println(onoma);
   int offset=0;
   if (onoma!=null){
     offset=table.offset_of_method(onoma,n.f2.f0.toString());

     }
   else{
     System.out.println(name_of_class);
     if (name_of_class==null)
        offset=table.offset_of_method(patenta,n.f2.f0.toString());
      else
        offset=table.offset_of_method(name_of_class,n.f2.f0.toString());

}
   temp=get_temp(30);
   map.put(n.f2.f0.toString(),temp);
   code=code+"HLOAD "+temp+" "+map.get("v_address")+" "+offset+"\n";


   n.f1.accept(this, argu);
   global_var="yes_assign";

   n.f2.accept(this, argu);

   global_var="no_assign";
   n.f3.accept(this, argu);
   n.f4.accept(this, argu);
   int i=0;

   String arg_list="";
   for (i=0;i<arguments.size();i++)
   {
     arg_list=arg_list+" "+arguments.get(i);
   }
   temp=get_temp(30);
   map.put("result",temp);
   //map.get(myList[i]);
   code=code+"MOVE "+temp+" CALL "+map.get(n.f2.f0.toString())+"( "+map.get("object")+" "+arg_list+" )\n";
   n.f5.accept(this, argu);
   //MOVE TEMP 32 CALL TEMP 22( TEMP 23 TEMP 31 )

   arguments.clear();
   return map.get("result");
}


   /**
    * f0 -> "("
    * f1 -> Expression()
    * f2 -> ")"
    */
   public String visit(BracketExpression n, String argu) {

      n.f0.accept(this, argu);

      n.f2.accept(this, argu);
      return n.f1.accept(this, argu);
   }

/**
  * f0 -> ","
  * f1 -> Expression()
  */
 public String visit(ExpressionTerm n, String argu) {

    arguments.add(n.f1.accept(this, argu));
    return n.f0.accept(this, argu);

 }

/**
  * f0 -> Expression()
  * f1 -> ExpressionTail()
  */
 public String visit(ExpressionList n, String argu) {

  arguments.add(n.f0.accept(this, argu));
    //n.f1.accept(this, argu);
    return n.f1.accept(this, argu);
 }
/**
 * f0 -> NotExpression()
 *       | PrimaryExpression()
 */
public String visit(Clause n, String argu) {

    //System.out.println("primary expression "+code);
    return n.f0.accept(this, argu);
}






/**
 * f0 -> "new"
 * f1 -> Identifier()
 * f2 -> "("
 * f3 -> ")"
 */
public String visit(AllocationExpression n, String argu) {

   String name_of_class=n.f1.f0.toString();
   patenta=name_of_class;
   HashMap<String,String> map=new HashMap<String,String>() ;

   int name_of_methods;

   LinkedHashMap methods=new LinkedHashMap<String,String>() ;
   LinkedHashMap fields=new LinkedHashMap<String,String>() ;

   methods=table.load_method(name_of_class);

   fields=table.load_field(name_of_class);

   int num_of_fields=fields.size();




   int method_offset=4*methods.size();
   int field_offset=4*(num_of_fields+1);
   String temp=get_temp(30);
   map.put("v_address",temp);
   code=code+"MOVE "+temp+" "+"HALLOCATE "+method_offset+"\n";
   temp=get_temp(30);
   map.put("o_address",temp);

   code=code+"MOVE "+temp+" "+"HALLOCATE "+field_offset+"\n";
   int i;
      //System.out.println(methods.size());
      // Get a set of the entries
      Set set = methods.entrySet();
      // Get an iterator
      Iterator k = set.iterator();
      // Display elements
      while(k.hasNext()) {
        temp=get_temp(30);
         Map.Entry me = (Map.Entry)k.next();
        // System.out.print(me.getKey() + ": ");
         //System.out.println(me.getValue());
         code=code+"MOVE "+temp+" "+me.getValue()+"_"+me.getKey()+"\n";
         map.put(me.getValue()+"_"+me.getKey(),temp);

      }



      temp=get_temp(30);
      if (fields.size()>0)
      {
        code=code+"MOVE "+temp+" "+"0\n";

      }
      for (i=0;i<fields.size();i++)
      {

          code=code+"HSTORE "+map.get("o_address")+" "+(i+1)*4+" "+temp+"\n";
      }


      int offset=0;
      String v_address=map.get("v_address");
      String o_address=map.get("o_address");
      String temp_for_method;
  // Get a set of the entries
  set = methods.entrySet();
  // Get an iterator
  k = set.iterator();
  // Display elements
  while(k.hasNext()) {

     Map.Entry me = (Map.Entry)k.next();
    // System.out.print(me.getKey() + ": ");
     //System.out.println(me.getValue());
     temp_for_method=map.get(me.getValue()+"_"+me.getKey());
     code=code+"HSTORE "+v_address+" "+offset+" "+temp_for_method+"\n";
     offset=offset+4;

  }

   code=code+"HSTORE "+o_address+" "+"0"+" "+v_address+"\n";

   //String arrayRefVar = new String[10];
   //myStrings[1]="lalala";

   n.f0.accept(this, argu);

   n.f1.accept(this, argu);
   n.f2.accept(this, argu);
   n.f3.accept(this, argu);
   //System.out.println(code);
   //System.out.println(o_address+n.f1.f0.toString());
   globo.put(o_address,n.f1.f0.toString());
   return o_address;
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

   String table=n.f0.accept(this, argu);

   n.f1.accept(this, argu);
   String value=n.f2.accept(this, argu);
   String condition=get_temp(30);
   String label=get_label();
   code=code+"MOVE "+condition+" LT "+value+" 0\n";
   code=code+"CJUMP "+condition+" "+label+"\n";
   code=code+"ERROR \n";
   code=code+label+"\n";
   String size=get_temp(30);
  // MOVE TEMP 1 TEMP 2
  // MOVE TEMP 23 10
//   MOVE TEMP 24 LT TEMP 23 0
   //CJUMP TEMP 24 L5
   //ERROR
 //L5
 code=code+"HLOAD "+size+" "+table+" 0 \n";
 //HLOAD TEMP 4 TEMP 1 0
 String temp=get_temp(30);
 code=code+"MOVE "+temp+" 1 \n";
 //MOVE TEMP 25 1
 //MOVE TEMP 26 10
 String new_temp=get_temp(30);
 code=code+"MOVE "+new_temp+" LT "+temp+" "+table+"\n";
 //MOVE TEMP 27 LT TEMP 26 TEMP 4
 String temp1=get_temp(30);
 code=code+"MOVE "+temp1+" MINUS "+temp+" "+new_temp+"\n";
 label=get_label();
 //MOVE TEMP 28 MINUS TEMP 25 TEMP 27
 code=code+"CJUMP "+temp1+" "+label+"\n";
// CJUMP TEMP 28 L6
code=code+"ERROR \n";
code=code+label+"\n";




   n.f3.accept(this, argu);
   n.f4.accept(this, argu);
   String put_var=n.f5.accept(this, argu);
   n.f6.accept(this, argu);

   String offset=get_temp(30);
   code=code+"MOVE "+offset+" TIMES "+value+" 4 \n";
   //MOVE TEMP 29 10
   //MOVE TEMP 30 TIMES TEMP 29 4
   String offset1=get_temp(30);
   code=code+"MOVE "+offset1+" PLUS "+offset+" 4 \n";
   //MOVE TEMP 31 PLUS TEMP 30 4
   String offset2=get_temp(30);
   code=code+"MOVE "+offset2+" PLUS "+table+" "+offset1+"\n";
   //MOVE TEMP 32 PLUS TEMP 1 TEMP 31


   code=code+"HSTORE "+offset2+" "+"0"+" "+put_var+"\n";

   return offset2;
}

/**
 * f0 -> PrimaryExpression()
 * f1 -> "."
 * f2 -> "length"
 */
public String visit(ArrayLength n, String argu) {
   String temp=n.f0.accept(this, argu);
   String result=get_temp(30);
   code=code+"HLOAD "+result+" "+temp+" 0 \n";


   n.f1.accept(this, argu);
   n.f2.accept(this, argu);
   return result;
}

/**
 * f0 -> "new"
 * f1 -> "int"
 * f2 -> "["
 * f3 -> Expression()
 * f4 -> "]"
 */
public String visit(ArrayAllocationExpression n, String argu) {
  //MOVE TEMP 11 20
  //MOVE TEMP 12 LT TEMP 11 0
  //CJUMP TEMP 12 L2
  //ERROR
   String size=get_temp(30);
   n.f0.accept(this, argu);
   n.f1.accept(this, argu);
   n.f2.accept(this, argu);
   String expr_temp=n.f3.accept(this, argu);
   code=code+"MOVE "+size+" "+expr_temp+"\n";
   String check_size=get_temp(30);
   code=code+"MOVE "+check_size+" LT "+size+" 0 \n";
   String label=get_label();
   code=code+"CJUMP "+check_size+" "+label+"\n";
   code=code+"ERROR\n";
   code=code+label+"\n";
   String size_length=get_temp(30);
   code=code+"MOVE "+size_length+" PLUS "+size+" 1\n";
   String size_bytes=get_temp(30);
   code=code+"MOVE "+size_bytes+" TIMES "+size_length+" 4\n";
   String address_array=get_temp(30);
   code=code+"MOVE "+address_array+" HALLOCATE "+size_bytes+"\n";
   //MOVE TEMP 13 20
   //MOVE TEMP 14 PLUS TEMP 13 1
   //MOVE TEMP 15 TIMES TEMP 14 4
   //MOVE TEMP 2 HALLOCATE TEMP 15
   //MOVE TEMP 3 4
   String offset=get_temp(30);
   code=code+"MOVE "+offset+" 4\n";
   label=get_label();
   String new_label=get_label();
   code=code+label+"\n";
  // MOVE TEMP 3 4
 //L3

  // MOVE TEMP 16 20
   //MOVE TEMP 17 PLUS TEMP 16 1
   //MOVE TEMP 18 TIMES TEMP 17 4
   String condition=get_temp(30);
   code=code+"MOVE "+condition+" LT "+offset+" "+size_bytes+"\n";
  // MOVE TEMP 19 LT TEMP 3 TEMP 18
   code=code+"CJUMP "+condition+" "+new_label+"\n";
   //CJUMP TEMP 19 L4
   String init=get_temp(30);
   code=code+"MOVE "+init+" PLUS "+address_array+" "+offset+"\n";
  // MOVE TEMP 20 PLUS TEMP 2 TEMP 3
   String init_value=get_temp(30);
   code=code+"MOVE "+init_value+" 0\n";
  // MOVE TEMP 21 0
  code=code+"HSTORE "+init+" 0 "+init_value+"\n";
   //HSTORE TEMP 20 0 TEMP 21
   code=code+"MOVE "+offset+" PLUS "+offset+" 4\n";
  // MOVE TEMP 3 PLUS TEMP 3 4
  code=code+"JUMP "+label+"\n";
  // JUMP L3
  code=code+new_label+"\n";
 //L4
  code=code+"HSTORE "+address_array+" 0 "+size+"\n";
 //MOVE TEMP 22 20
 //HSTORE TEMP 2 0 TEMP 22
   n.f4.accept(this, argu);
   return address_array;
}


/**
 * f0 -> PrimaryExpression()
 * f1 -> "["
 * f2 -> PrimaryExpression()
 * f3 -> "]"
 */
public String visit(ArrayLookup n, String argu) {

   String table=n.f0.accept(this, argu);
   String value= n.f2.accept(this, argu);
   String condition=get_temp(30);
   String label=get_label();
   code=code+"MOVE "+condition+" LT "+value+" 0\n";
   code=code+"CJUMP "+condition+" "+label+"\n";
   code=code+"ERROR \n";
   code=code+label+"\n";
   String size=get_temp(30);
  // MOVE TEMP 1 TEMP 2
  // MOVE TEMP 23 10
//   MOVE TEMP 24 LT TEMP 23 0
   //CJUMP TEMP 24 L5
   //ERROR
 //L5
 code=code+"HLOAD "+size+" "+table+" 0 \n";
 //HLOAD TEMP 4 TEMP 1 0
 String temp=get_temp(30);
 code=code+"MOVE "+temp+" 1 \n";
 //MOVE TEMP 25 1
 //MOVE TEMP 26 10
 String new_temp=get_temp(30);
 code=code+"MOVE "+new_temp+" LT "+temp+" "+table+"\n";
 //MOVE TEMP 27 LT TEMP 26 TEMP 4
 String temp1=get_temp(30);
 code=code+"MOVE "+temp1+" MINUS "+temp+" "+new_temp+"\n";
 label=get_label();
 //MOVE TEMP 28 MINUS TEMP 25 TEMP 27
 code=code+"CJUMP "+temp1+" "+label+"\n";
// CJUMP TEMP 28 L6
code=code+"ERROR \n";
code=code+label+"\n";
 //ERROR
//L6
String offset=get_temp(30);
code=code+"MOVE "+offset+" TIMES "+value+" 4 \n";
//MOVE TEMP 29 10
//MOVE TEMP 30 TIMES TEMP 29 4
String offset1=get_temp(30);
code=code+"MOVE "+offset1+" PLUS "+offset+" 4 \n";
//MOVE TEMP 31 PLUS TEMP 30 4
String offset2=get_temp(30);
code=code+"MOVE "+offset2+" PLUS "+table+" "+offset1+"\n";
//MOVE TEMP 32 PLUS TEMP 1 TEMP 31
String return_value=get_temp(30);
code=code+"HLOAD "+return_value+" "+offset2+" 0 \n";
//HLOAD TEMP 4 TEMP 32 0
//PRINT TEMP 4
eisai_field="no";
   return return_value;
}


/**
 * f0 -> ClassDeclaration()
 *       | ClassExtendsDeclaration()
 */
public String visit(TypeDeclaration n, String argu) {
   return n.f0.accept(this, argu);
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
   String _ret=null;
   String class_name=n.f1.f0.toString();
   name_of_class=class_name;
    global_var="lala";
    to=1;
    n.f1.accept(this, argu);
   to=0;
    n.f2.accept(this, argu);

    n.f3.accept(this, argu);
    global_var="no_assign";
   _ret=n.f4.accept(this,class_name);
   //n.f5.accept(this, argu);
   return _ret;
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
   String _ret=null;
   String class_name=n.f1.f0.toString();
   name_of_class=class_name;
   to=1;
   n.f0.accept(this, argu);
   to=0;
   n.f1.accept(this, argu);
   n.f2.accept(this, argu);
   n.f3.accept(this, argu);
   n.f4.accept(this, argu);
   n.f5.accept(this, argu);
   n.f6.accept(this, class_name);
   n.f7.accept(this, argu);
   return _ret;
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

   String class_name=argu;
   String method_name=n.f2.f0.toString();
   name_of_method=method_name;
   int number=table.number_of_parameters(class_name,method_name)+1;
   code=code+class_name+"_"+method_name+"["+number+"]\n";
   argu=class_name+"."+method_name;
   code=code+"BEGIN\n";



   n.f0.accept(this, argu);
   n.f1.accept(this, argu);
   n.f2.accept(this, argu);
   n.f3.accept(this, argu);
   n.f4.accept(this, argu);
   n.f5.accept(this, argu);
   n.f6.accept(this, argu);
   n.f7.accept(this, argu);
   n.f8.accept(this, argu);
   n.f9.accept(this, argu);

String pf=n.f10.accept(this, argu);
code=code+"RETURN\n";

code=code+pf+"\n";
code=code+"END\n";
   n.f11.accept(this, argu);
   n.f12.accept(this, argu);


   return "";
}

/**
 * f0 -> Type()
 * f1 -> Identifier()
 * f2 -> ";"
 */
public String visit(VarDeclaration n, String argu) {
   String temp=get_temp(30);
   global_map.put(argu+"."+n.f1.f0.toString(),temp);
   to=1;


  //System.out.println(n.f1.f0.toString()+"xaxa");
//
   n.f0.accept(this, argu);

   n.f1.accept(this, argu);

   n.f2.accept(this, argu);
   to=0;

   return temp;
}




/**
 * f0 -> "if"
 * f1 -> "("
 * f2 -> Expression()
 * f3 -> ")"
 * f4 -> Statement()
 * f5 -> "else"
 * f6 -> Statement()
 */
public String visit(IfStatement n, String argu) {
  String result_of_condition;//=get_temp(30);
  String label1=get_label();
  String label2=get_label();
   //System.out.println(argu);
   String _ret=null;
   n.f0.accept(this, argu);
   n.f1.accept(this, argu);

   result_of_condition=n.f2.accept(this, argu);

   n.f3.accept(this, argu);
   code=code+"CJUMP "+result_of_condition+" "+label1+"\n";
   n.f4.accept(this, argu);
   code=code+"JUMP "+label2+"\n";

   code=code+label1+" "+"NOOP\n";
   n.f5.accept(this, argu);
   n.f6.accept(this, argu);
   code=code+label2+" "+"NOOP\n";
   return _ret;
}

/**
 * f0 -> "while"
 * f1 -> "("
 * f2 -> Expression()
 * f3 -> ")"
 * f4 -> Statement()
 */
public String visit(WhileStatement n, String argu) {
  String result_of_condition;//=get_temp(30);
  String label1=get_label();
  String label2=get_label();
   String _ret=null;
   code=code+label1+" "+"\n";
   n.f0.accept(this, argu);

   n.f1.accept(this, argu);

   result_of_condition=n.f2.accept(this, argu);

   n.f3.accept(this, argu);

   code=code+"CJUMP "+result_of_condition+" "+label2+"\n";

   n.f4.accept(this, argu);
   code=code+"JUMP "+" "+label1+" "+"\n";
   code=code+label2+" NOOP \n";
   return _ret;



}
/**
 * f0 -> PrimaryExpression()
 * f1 -> "<"
 * f2 -> PrimaryExpression()
 */
public String visit(CompareExpression n, String argu) {
   String _ret=null;
   //MOVE TEMP 34 LT TEMP 1 TEMP 33

   String temp=get_temp(30);
   String temp1=n.f0.accept(this, argu);
   n.f1.accept(this, argu);
   String temp2=n.f2.accept(this, argu);
   code=code+"MOVE "+temp+" "+"LT "+temp1+" "+temp2+"\n";
   //eisai_field="no";
   return temp;
}


/**
 * f0 -> PrimaryExpression()
 * f1 -> "-"
 * f2 -> PrimaryExpression()
 */
public String visit(MinusExpression n, String argu) {
   String _ret=null;
   //MOVE TEMP 34 LT TEMP 1 TEMP 33

   String temp=get_temp(30);
   String temp1=n.f0.accept(this, argu);
   n.f1.accept(this, argu);
   String temp2=n.f2.accept(this, argu);
   code=code+"MOVE "+temp+" "+"MINUS "+temp1+" "+temp2+"\n";
   eisai_field="no";
   return temp;
}


/**
 * f0 -> PrimaryExpression()
 * f1 -> "+"
 * f2 -> PrimaryExpression()
 */
public String visit(PlusExpression n, String argu) {
   String _ret=null;
   //MOVE TEMP 34 LT TEMP 1 TEMP 33

   String temp=get_temp(30);
   String temp1=n.f0.accept(this, argu);
   n.f1.accept(this, argu);
   String temp2=n.f2.accept(this, argu);
   code=code+"MOVE "+temp+" "+"PLUS "+temp1+" "+temp2+"\n";
   //eisai_field="no";
   return temp;
}


/**
 * f0 -> PrimaryExpression()
 * f1 -> "*"
 * f2 -> PrimaryExpression()
 */
public String visit(TimesExpression n, String argu) {
   String _ret=null;
   //MOVE TEMP 34 LT TEMP 1 TEMP 33

   String temp=get_temp(30);
   String temp1=n.f0.accept(this, argu);
   n.f1.accept(this, argu);
   String temp2=n.f2.accept(this, argu);
   code=code+"MOVE "+temp+" "+"TIMES "+temp1+" "+temp2+"\n";
   //eisai_field="no";
   return temp;
}


/**
 * f0 -> Clause()
 * f1 -> "&&"
 * f2 -> Clause()
 */
public String visit(AndExpression n, String argu) {

   String temp1=n.f0.accept(this, argu);
   n.f1.accept(this, argu);
   String temp2=n.f2.accept(this, argu);
   String temp = get_temp(30);
   String lab1 = get_label();
   code=code+"MOVE "+temp+" "+temp1+"\n";
   code=code+"CJUMP "+temp+" "+lab1+"\n";
   code=code+"MOVE "+temp+" "+temp2+"\n";
   code=code+lab1+" NOOP\n";


   return temp;
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

   //System.out.println("primary expression "+code);
   return n.f0.accept(this, argu);
}

/**
 * f0 -> <INTEGER_LITERAL>
 */
public String visit(IntegerLiteral n, String argu) {
  String temp=get_temp(30);

  //  MOVE TEMP 33 1
    code=code+"MOVE "+temp+" "+n.f0.toString()+"\n";
   return temp;
}


/**
 * f0 -> "true"
 */
public String visit(TrueLiteral n, String argu) {
   String temp=get_temp(30);

   //  MOVE TEMP 33 1
     code=code+"MOVE "+temp+" "+"1"+"\n";
    return temp;
}

/**
 * f0 -> "false"
 */
public String visit(FalseLiteral n, String argu) {
   String temp=get_temp(30);

   //  MOVE TEMP 33 1
     code=code+"MOVE "+temp+" "+"0"+"\n";
    return temp;
}



/**
 * f0 -> <IDENTIFIER>
 */
public String visit(Identifier n, String argu) {
    int x=0;
    String temp;
    int offset;
    if (name_of_class!=null && name_of_method!=null)
        x=table.search_kind(name_of_class,name_of_method,n.f0.toString());
    if (x!=0){
      temp ="TEMP "+x;
      String lalaki=table.get_type_param(n.f0.toString(),name_of_class,name_of_method);
      globo.put(temp,lalaki);
      return temp;}
    else{
      //String lolaki=table.get_type_local(n.f0.toString(),name_of_class,name_of_method);

      temp=global_map.get(argu+"."+n.f0.toString());
    //  globo.put(temp,lolaki);
}
    if (temp==null )
    {

      temp=get_temp(30);
      offset=table.offset_of_field(name_of_class,n.f0.toString());

    // System.out.println(name_of_class+" "+n.f0.toString()+" "+offset);


      if(offset>0 && to==1)
      {
        global_offset=offset;

        return "field";
      }

      if (offset>0 && to!=1 ){
        String xamos=table.get_type_field(n.f0.toString(),name_of_class);
        //global_offset=offset;
       code=code+"HLOAD "+temp+" TEMP 0 "+offset+"\n";

      globo.put(temp,xamos);
       }

    }


   return temp;
}

/**
 * f0 -> Identifier()
 * f1 -> "="
 * f2 -> Expression()
 * f3 -> ";"
 */
public String visit(AssignmentStatement n, String argu) {
  int offset;
  eisai_field="no";
   global_var="yes_assign";
   int tsou=0;
   to=1;
   String temp1=n.f0.accept(this,argu);
   to=0;
   String mana=globo.get(temp1);

   global_var="no_assign";
   String temp2=n.f2.accept(this, argu);
   String lala=globo.get(temp2);
   globo.put(temp1,lala);

    if (temp1=="field")
      code=code+"HSTORE TEMP 0 "+global_offset+" "+temp2+"\n";
    else
      code=code+"MOVE "+temp1+" "+temp2+"\n";


   return temp1;
}

/**
 * f0 -> "this"
 */
public String visit(ThisExpression n, String argu) {
   return "TEMP 0";
}


/**
 * f0 -> "!"
 * f1 -> Clause()
 */
public String visit(NotExpression n, String argu) {
   String temp1=get_temp(30);
   String temp2=get_temp(30);
   String result=n.f1.accept(this, argu);
   code=code+"MOVE "+temp1+" 1\n";
   code=code+"MOVE "+temp2+" MINUS "+temp1+" "+result+"\n";
   return temp2;
}




}
