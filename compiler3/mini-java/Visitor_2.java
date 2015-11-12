import syntaxtree.*;
import visitor.*;
import java.util.*;
import java.io.*;





public class Visitor_2 extends GJDepthFirst<String,String>{

Visitor_2(Set<String> arg_set){
		table=new SymbolTable();
		type=new String();
		name=new String();
		string1=new String();
		string2=new String();
    set=arg_set;
		set.add("int");
		set.add("int[]");
		set.add("boolean");

	}


	public SymbolTable get_table(){
		return table;
	}

	Set<String> set,typeset;

	public SymbolTable table;
	public String type,name,string1,string2;
/**
 * f0 -> "class"
 * f1 -> Identifier()
 * f2 -> "{"
 * f3 -> ( VarDeclaration() )*
 * f4 -> ( MethodDeclaration() )*
 * f5 -> "}"
 */
public String visit(ClassDeclaration n, String argu) {
  //  System.out.println("classdeclaration");
  	String class_name=n.f1.f0.toString();
		name=class_name;
		type="class";
	 	table.addClass(class_name);
		n.f3.accept(this,class_name);
		n.f4.accept(this,class_name);
   return "dfd";
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
	//System.out.println("methodeclaration");
	String type_of_method=n.f1.accept(this,argu);
	String name_of_method=n.f2.f0.toString();
	table.addMethod(name_of_method,type_of_method,argu);
	//System.out.println(name_of_method);
	//System.out.println("methodeclaration type is "+ type_of_method);
	string1=argu;
	string2=name_of_method;
	n.f4.accept(this,argu);
	type="method";
	n.f7.accept(this,argu);
  //table.overwrite(name_of_method,argu,type_of_method);


	return "sdsd";
}




/**
* f0 -> Type()
* f1 -> Identifier()
*/
public String visit(FormalParameter n, String argu) {
//	System.out.println("formalparameter");
	String type_of_parameter=n.f0.accept(this,argu);
	String name_of_parameter=n.f1.accept(this,argu);
	table.addParameters(name_of_parameter,type_of_parameter,string2,string1);

	return "cdvdv";
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



name=n.f1.f0.toString();
table.addClass( n.f1.f0.toString() );
table.addMethod( "main","void",name);
type="method";
string2="main";
string1=name;
 n.f14.accept(this,name);
//if(n.f15.present()) n.f15.accept(this,argu);
return null;
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

	String class_name=n.f1.f0.toString();
	name=class_name;
	type="class";
	//System.out.println("classextends");
	//System.out.println(name);

	String _ret=null;


	table.addClass(n.f1.f0.toString());
	n.f2.accept(this,argu);
	table.addfather(n.f3.f0.toString(),n.f1.f0.toString());
	n.f4.accept(this,argu);
	n.f5.accept(this,class_name);
	n.f6.accept(this,class_name);
	n.f7.accept(this,argu);
	//System.out.println(n.f1.f0.toString());

	return "dfdfd";
}




/**
* f0 -> <IDENTIFIER>
*/
public String visit(Identifier n, String argu) {
	return n.f0.toString();
}


/**
* f0 -> "int"
* f1 -> "["
* f2 -> "]"
*/
public String visit(ArrayType n, String argu) {
   return "int[]";
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
* f0 -> ArrayType()
*       | BooleanType()
*       | IntegerType()
*       | Identifier()
*/
public String visit(Type n, String argu) {
	String type= n.f0.accept(this, argu);
	if(!set.contains(type)){
		String ret = "Class "+type+" is not declared ";
		throw new RuntimeException(ret);
	}
	return type;
}




/**
* f0 -> Type()
* f1 -> Identifier()
* f2 -> ";"
*/
public String visit(VarDeclaration n, String argu) {

  //System.out.println(name);

	String var_name=n.f1.f0.toString();
	String type_of_var=n.f0.accept(this,argu);

	if (type=="class"){
	  //System.out.println("vazw metavlites stin klassi "+name);
		table.addField(var_name,type_of_var,name);}
	else if(type=="method")
		table.addlocals(var_name,type_of_var,string2,string1);
	//table.addField(String n.f1.toString(),String n.f0.toString(),String argu);
	//System.out.println(argu.toString());
	//System.out.println("metavliti tis klasis "+argu+" "+var_name);
	//System.out.println("me tipo "+type_of_var);
	//.out.println("vardeclaration");
	return var_name;
}


/*public Integer visit(ClassDeclaration n, Integer argu) {
	Integer _ret=10;
	System.out.println("visitor2");
	n.f0.accept(this, argu);
	n.f1.accept(this, argu);
	n.f2.accept(this, argu);
	n.f3.accept(this, argu);
	n.f4.accept(this, argu);
	n.f5.accept(this, argu);
	return 10;
}*/




//public void visit(ClassDeclaration c){
//  if(set.contains(c.f1.f0.toString())){
//    String ret = "Class "+c.f1.f0.toString()+" is declared twice!";
//    throw new RuntimeException(ret);
//  }
//  set.add(c.f1.f0.toString());
//}











}
