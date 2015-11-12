import syntaxtree.*;
import visitor.*;
import java.util.*;
import java.io.*;





public class Optimizator extends GJDepthFirst<String,String>{

Optimizator(String file_name){

 counter=0;
flag_label=0;
call=0;
args="";
file=file_name;

	}
int call;
int counter;
int flag_label;
String global_label;
String args;
PrintWriter writer,var_writer,next_writer,var_move_writer,const_move_writer,var_use_writer,var_def_writer;
LinkedHashMap<String,String> next_array;
LinkedHashMap<String,String> in_to_label;
LinkedHashMap<String,String> label_to_in;
LinkedHashMap<String,String> check_var;
String file;



public String visit(NodeList n, String argu) {
	if (n.size() == 1)
		return n.elementAt(0).accept(this,argu);
		String _ret=null;
	int _count=0;
	for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
		e.nextElement().accept(this,argu);
		_count++;
	}
	return _ret;
}

public String visit(NodeListOptional n, String argu) {
	if ( n.present() ) {
		if (n.size() == 1)
				return n.elementAt(0).accept(this,argu);
				String _ret=null;
		int _count=0;
		for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
				e.nextElement().accept(this,argu);
				_count++;
		}
		return _ret;
	}
	else
		return null;
}

public String visit(NodeOptional n, String argu) {
	if ( n.present() ){
		String test=n.node.accept(this,argu);
		global_label=test;
		flag_label=1;
		//System.out.println(test);
		return test;}
	else
		return null;
}

public String visit(NodeSequence n, String argu) {
	if (n.size() == 1)
		return n.elementAt(0).accept(this,argu);
		String _ret=null;
	int _count=0;
	for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
		e.nextElement().accept(this,argu);
		_count++;
	}
	return _ret;
}







	/**
	* f0 -> "MAIN"
	* f1 -> StmtList()
	* f2 -> "END"
	* f3 -> ( Procedure() )*
	* f4 -> <EOF>
	*/
	public String visit(Goal n, String argu) {

		try{


		writer= new PrintWriter("iris/datalog-examples/spiglet/facts/instruction.iris");


    var_writer=new  PrintWriter("iris/datalog-examples/spiglet/facts/var.iris");
		next_writer=new PrintWriter("iris/datalog-examples/spiglet/facts/next.iris");


		var_move_writer=new PrintWriter("iris/datalog-examples/spiglet/facts/var_Move.iris");
		const_move_writer=new PrintWriter("iris/datalog-examples/spiglet/facts/constMove.iris");
		var_use_writer=new PrintWriter("iris/datalog-examples/spiglet/facts/varUse.iris");
		var_def_writer=new PrintWriter("iris/datalog-examples/spiglet/facts/varDef.iris");
		String _ret=null;

		n.f0.accept(this, argu);
		n.f1.accept(this, "MAIN");
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		n.f4.accept(this, argu);
		var_def_writer.close();
		var_use_writer.close();
		const_move_writer.close();
		var_move_writer.close();
		next_writer.close();
		writer.close();
		var_writer.close();
		return _ret;
}
		catch(FileNotFoundException ex){
				System.err.println(ex.getMessage());
		}
		return null;
	}


	/**
	* f0 -> "BEGIN"
	* f1 -> StmtList()
	* f2 -> "RETURN"
	* f3 -> SimpleExp()
	* f4 -> "END"
	*/
	public String visit(StmtExp n, String argu) {
		String _ret=null;
		String datalog;

		n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		counter++;
		String simple_expr=n.f3.accept(this, argu);
		datalog="instruction(\""+argu+"\",	"+counter+", \""+"RETURN "+simple_expr+"\").";
		if(simple_expr.startsWith("TEMP"))
		{
			System.out.println("varUse(\""+argu+"\", "+counter+", \""+simple_expr+"\").");
			var_use_writer.println("varUse(\""+argu+"\", "+counter+", \""+simple_expr+"\").");

		}
		//System.out.println(datalog);
		writer.println(datalog);
		n.f4.accept(this, argu);
		return _ret;
	}



	/**
	* f0 -> Label()
	* f1 -> "["
	* f2 -> IntegerLiteral()
	* f3 -> "]"
	* f4 -> StmtExp()
	*/
	public String visit(Procedure n, String argu) {
		String _ret=null;

		counter=0;
		String label=n.f0.accept(this, argu);
		n.f1.accept(this, argu);
		n.f2.accept(this, argu);
		n.f3.accept(this, argu);
		n.f4.accept(this, label);
		return _ret;
	}
	/**
	* f0 -> ( ( Label() )? Stmt() )*
	*/
	public String visit(StmtList n, String argu) {
		next_array=new LinkedHashMap<String,String>() ;
    in_to_label=new LinkedHashMap<String,String>() ;
		label_to_in=new LinkedHashMap<String,String>() ;
    check_var=new LinkedHashMap<String,String>() ;

		String code=n.f0.accept(this, argu);
   if (argu=="MAIN"){

    int size=next_array.size();
		String delete_key=String.valueOf(size);
		next_array.remove(delete_key);

	}
		for ( String key : next_array.keySet() ) {
			//	System.out.println(key+" "+next_array.get(key));
				next_writer.println("next(\""+argu+"\",  "+key+",  "+next_array.get(key)+").");
				}
		for ( String key : in_to_label.keySet() ) {
			//	System.out.println(key+" "+label_to_in.get(in_to_label.get(key)));
				next_writer.println("next(\""+argu+"\",  "+key+",  "+label_to_in.get(in_to_label.get(key))+").");

				}





		return "lala";
	}

	/**
	* f0 -> NoOpStmt()
	*       | ErrorStmt()
	*       | CJumpStmt()
	*       | JumpStmt()
	*       | HStoreStmt()
	*       | HLoadStmt()
	*       | MoveStmt()
	*       | PrintStmt()
	*/
	public String visit(Stmt n, String argu) {
		counter++;
    String counter_s;
		counter_s=String.valueOf(counter);

		String code=n.f0.accept(this, argu);
		String datalog="";
    if (flag_label==1){
			label_to_in.put(global_label,counter_s);
			datalog="instruction(\""+argu+"\",	"+counter+", \""+global_label+"		"+code+"\").";}
		else
	  	datalog="instruction(\""+argu+"\",	"+counter+", \""+code+"\").";

		String next;
		//int j=counter+1;
		//next="next(\""+argu+"\",  "+counter+",  "+j+").";
		//System.out.println(next);

		//	System.out.println(datalog);
			writer.println(datalog);
		flag_label=0;
		return "lalalal";
	}


	/**
	* f0 -> "NOOP"
	*/
	public String visit(NoOpStmt n, String argu) {
		int i=counter;
		int j=i+1;
		String i_s,j_s;
		i_s=String.valueOf(i);
		j_s=String.valueOf(j);
		next_array.put(i_s,j_s);

		return "NOOP";
	}


	/**
	* f0 -> "ERROR"
	*/
	public String visit(ErrorStmt n, String argu) {
		int i=counter;
		int j=i+1;
		String i_s,j_s;
		i_s=String.valueOf(i);
		j_s=String.valueOf(j);
		next_array.put(i_s,j_s);
		return "ERROR";
	}


	/**
	* f0 -> "CJUMP"
	* f1 -> Temp()
	* f2 -> Label()
	*/
	public String visit(CJumpStmt n, String argu) {
		int i=counter;
		int j=i+1;
		String i_s,j_s;
		i_s=String.valueOf(i);
		j_s=String.valueOf(j);
		next_array.put(i_s,j_s);

		String _ret=null;
		String label;
		String temp=n.f1.accept(this, argu);
		_ret="CJUMP "+temp+" ";
		System.out.println("varUse(\""+argu+"\", "+counter+", \""+temp+"\").");
	var_use_writer.println("varUse(\""+argu+"\", "+counter+", \""+temp+"\").");

		label=n.f2.accept(this, argu);
		in_to_label.put(i_s,label);
		_ret=_ret+label;
		return _ret;
	}


	/**
	* f0 -> "JUMP"
	* f1 -> Label()
	*/
	public String visit(JumpStmt n, String argu) {
		int i=counter;
		String i_s;
		i_s=String.valueOf(i);

		String label=n.f1.accept(this, argu);
		in_to_label.put(i_s,label);
		String _ret="JUMP "+label;


		return _ret;
	}

	/**
	* f0 -> "HSTORE"
	* f1 -> Temp()
	* f2 -> IntegerLiteral()
	* f3 -> Temp()
	*/
	public String visit(HStoreStmt n, String argu) {
		int i=counter;
		int j=i+1;
		String i_s,j_s;
		i_s=String.valueOf(i);
		j_s=String.valueOf(j);
		next_array.put(i_s,j_s);
		String temp1=n.f1.accept(this, argu);
		String temp2=n.f2.accept(this, argu);
		String temp3=n.f3.accept(this, argu);
		String _ret="HSTORE "+temp1+" "+temp2+" "+temp3;
		System.out.println("varUse(\""+argu+"\", "+counter+", \""+temp1+"\").");
	var_use_writer.println("varUse(\""+argu+"\", "+counter+", \""+temp1+"\").");

		System.out.println("varUse(\""+argu+"\", "+counter+", \""+temp3+"\").");
	var_use_writer.println("varUse(\""+argu+"\", "+counter+", \""+temp3+"\").");
		return _ret;
	}

	/**
	* f0 -> "HLOAD"
	* f1 -> Temp()
	* f2 -> Temp()
	* f3 -> IntegerLiteral()
	*/
	public String visit(HLoadStmt n, String argu) {
		int i=counter;
		int j=i+1;
		String i_s,j_s;
		i_s=String.valueOf(i);
		j_s=String.valueOf(j);
		next_array.put(i_s,j_s);
		String _ret=null;
		String temp1=n.f1.accept(this, argu);
		String temp2=n.f2.accept(this, argu);
		_ret="HLOAD "+temp1+" "+temp2+" "+n.f3.accept(this, argu);
		System.out.println("varUse(\""+argu+"\", "+counter+", \""+temp2+"\").");
	var_use_writer.println("varUse(\""+argu+"\", "+counter+", \""+temp2+"\").");
	var_def_writer.println("varDef(\""+argu+"\", "+counter+", \""+temp1+"\").");

		return _ret;
	}

	/**
	* f0 -> "MOVE"
	* f1 -> Temp()
	* f2 -> Exp()
	*/
	public String visit(MoveStmt n, String argu) {
		int i=counter;
		int j=i+1;
		String i_s,j_s;
		i_s=String.valueOf(i);
		j_s=String.valueOf(j);
		next_array.put(i_s,j_s);
		String part1,part2;
		part1=n.f1.accept(this, argu);
		part2=n.f2.accept(this, argu);
		if(part2.startsWith("TEMP")){
			 var_move_writer.println("varMove(\""+argu+"\", "+counter+", \""+part1+"\", \""+part2+"\").");
       System.out.println("varUse(\""+argu+"\", "+counter+", \""+part2+"\").");
			var_use_writer.println("varUse(\""+argu+"\", "+counter+", \""+part2+"\").");

}

		var_def_writer.println("varDef(\""+argu+"\", "+counter+", \""+part1+"\").");
		if (Character.isDigit(part2.charAt(0)))
					const_move_writer.println("constMove(\""+argu+"\", "+counter+", \""+part1+"\", "+part2+").");
		String _ret="MOVE "+part1+" "+part2;


		return _ret;
	}


	/**
	* f0 -> "PRINT"
	* f1 -> SimpleExp()
	*/
	public String visit(PrintStmt n, String argu) {
		int i=counter;
		int j=i+1;
		String i_s,j_s;
		String simple_expr;
		i_s=String.valueOf(i);
		j_s=String.valueOf(j);
		next_array.put(i_s,j_s);
		simple_expr=n.f1.accept(this, argu);
		String _ret="PRINT "+simple_expr;
		if(simple_expr.startsWith("TEMP"))
		{
			System.out.println("varUse(\""+argu+"\", "+counter+", \""+simple_expr+"\").");
		  var_use_writer.println("varUse(\""+argu+"\", "+counter+", \""+simple_expr+"\").");


		}


		return _ret;
	}

	/**
	* f0 -> "CALL"
	* f1 -> SimpleExp()
	* f2 -> "("
	* f3 -> ( Temp() )*
	* f4 -> ")"
	*/
public String visit(Call n, String argu) {
	int i=counter;
	int j=i+1;
	String i_s,j_s;
	i_s=String.valueOf(i);
	j_s=String.valueOf(j);
	next_array.put(i_s,j_s);

String simple_expr=n.f1.accept(this, argu);
		String _ret="CALL "+simple_expr;
		if(simple_expr.startsWith("TEMP"))
		{
			System.out.println("varUse(\""+argu+"\", "+counter+", \""+simple_expr+"\").");
			var_use_writer.println("varUse(\""+argu+"\", "+counter+", \""+simple_expr+"\").");


		}
		call=1;
		n.f3.accept(this, argu);
		_ret=_ret+" ( "+args+" )";
	//	System.out.println(args);
   call=0;
	args="";
		return _ret;
}


/**
* f0 -> "HALLOCATE"
* f1 -> SimpleExp()
*/
public String visit(HAllocate n, String argu) {
	int i=counter;
	int j=i+1;
	String i_s,j_s;
	i_s=String.valueOf(i);
	j_s=String.valueOf(j);
	next_array.put(i_s,j_s);
	String simple_expr=n.f1.accept(this, argu);
	String _ret="HALLOCATE "+simple_expr;
	if(simple_expr.startsWith("TEMP"))
	{
		System.out.println("varUse(\""+argu+"\", "+counter+", \""+simple_expr+"\").");
		var_use_writer.println("varUse(\""+argu+"\", "+counter+", \""+simple_expr+"\").");


	}

	return _ret;
}




/**
* f0 -> "TEMP"
* f1 -> IntegerLiteral()
*/
public String visit(Temp n, String argu) {
	String _ret="TEMP "+n.f1.accept(this, argu);;
  if (call==1){
		System.out.println("varUse(\""+argu+"\", "+counter+", \""+_ret+"\").");
	var_use_writer.println("varUse(\""+argu+"\", "+counter+", \""+_ret+"\").");
		args=args+" "+_ret;

		}
  if (check_var.get(_ret)==null){
  String datalog="var(\""+argu+"\", \""+_ret+"\").";
	//System.out.println("var(\""+argu+"\", \""+_ret+"\").");
//	writer.println(datalog);
  var_writer.println(datalog);}
  check_var.put(_ret,argu);
	return _ret;
}



/**
* f0 -> Operator()
* f1 -> Temp()
* f2 -> SimpleExp()
*/
public String visit(BinOp n, String argu) {
	String temp1=n.f1.accept(this, argu);
	String simple_expr=n.f2.accept(this, argu);

	String _ret=n.f0.accept(this, argu)+" "+temp1+" "+simple_expr;
	System.out.println("varUse(\""+argu+"\", "+counter+", \""+temp1+"\").");
	var_use_writer.println("varUse(\""+argu+"\", "+counter+", \""+temp1+"\").");
	if(simple_expr.startsWith("TEMP"))
	{
		System.out.println("varUse(\""+argu+"\", "+counter+", \""+simple_expr+"\").");
		var_use_writer.println("varUse(\""+argu+"\", "+counter+", \""+simple_expr+"\").");

	}

	return _ret;
}

/**
* f0 -> "LT"
*       | "PLUS"
*       | "MINUS"
*       | "TIMES"
*/
public String visit(Operator n, String argu) {
	String op=n.f0.choice.toString();
	return op;
}

/**
* f0 -> <INTEGER_LITERAL>
*/
public String visit(IntegerLiteral n, String argu) {
	String number=n.f0.toString();
	return number;
}


	/**
	* f0 -> <IDENTIFIER>
	*/
public String visit(Label n, String argu) {

	  String label=n.f0.toString();

		return label;
}

  }
