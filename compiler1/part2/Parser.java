
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20141202 (SVN rev 60)
//----------------------------------------------------

import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20141202 (SVN rev 60) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\035\000\002\002\004\000\002\002\004\000\002\002" +
    "\004\000\002\002\002\000\002\003\005\000\002\003\005" +
    "\000\002\010\005\000\002\010\005\000\002\010\005\000" +
    "\002\010\005\000\002\010\005\000\002\010\003\000\002" +
    "\010\003\000\002\010\005\000\002\010\003\000\002\010" +
    "\003\000\002\010\002\000\002\004\005\000\002\004\003" +
    "\000\002\005\005\000\002\005\003\000\002\005\002\000" +
    "\002\007\006\000\002\007\007\000\002\006\007\000\002" +
    "\006\007\000\002\006\007\000\002\011\006\000\002\012" +
    "\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\074\000\006\002\ufffe\027\ufffe\001\002\000\006\002" +
    "\010\027\005\001\002\000\004\013\070\001\002\000\026" +
    "\005\ufff1\006\ufff1\007\ufff1\010\ufff1\011\ufff1\013\016\016" +
    "\ufff1\021\020\026\015\027\012\001\002\000\006\002\uffff" +
    "\027\uffff\001\002\000\004\002\000\001\002\000\006\002" +
    "\001\027\001\001\002\000\034\005\ufff2\006\ufff2\007\ufff2" +
    "\010\ufff2\011\ufff2\013\062\014\ufff2\016\ufff2\017\ufff2\020" +
    "\ufff2\022\ufff2\023\ufff2\024\ufff2\001\002\000\016\005\ufff5" +
    "\006\ufff5\007\ufff5\010\ufff5\011\ufff5\016\ufff5\001\002\000" +
    "\032\005\ufff6\006\ufff6\007\ufff6\010\ufff6\011\ufff6\014\ufff6" +
    "\016\ufff6\017\ufff6\020\ufff6\022\ufff6\023\ufff6\024\ufff6\001" +
    "\002\000\032\005\ufff3\006\ufff3\007\ufff3\010\ufff3\011\ufff3" +
    "\014\ufff3\016\ufff3\017\ufff3\020\ufff3\022\ufff3\023\ufff3\024" +
    "\ufff3\001\002\000\026\005\ufff1\006\ufff1\007\ufff1\010\ufff1" +
    "\011\ufff1\013\016\014\ufff1\021\020\026\015\027\012\001" +
    "\002\000\016\005\027\006\032\007\026\010\033\011\035" +
    "\016\056\001\002\000\006\013\023\021\020\001\002\000" +
    "\004\022\054\001\002\000\026\005\ufff1\006\ufff1\007\ufff1" +
    "\010\ufff1\011\ufff1\013\016\021\020\022\ufff1\026\015\027" +
    "\012\001\002\000\032\005\ufff1\006\ufff1\007\ufff1\010\ufff1" +
    "\011\ufff1\013\016\017\ufff1\021\020\023\ufff1\024\ufff1\026" +
    "\015\027\012\001\002\000\032\005\ufff5\006\ufff5\007\ufff5" +
    "\010\ufff5\011\ufff5\014\ufff5\016\ufff5\017\ufff5\020\ufff5\022" +
    "\ufff5\023\ufff5\024\ufff5\001\002\000\022\005\027\006\032" +
    "\007\026\010\033\011\035\017\031\023\034\024\030\001" +
    "\002\000\042\005\ufff1\006\ufff1\007\ufff1\010\ufff1\011\ufff1" +
    "\013\016\014\ufff1\016\ufff1\017\ufff1\020\ufff1\021\020\022" +
    "\ufff1\023\ufff1\024\ufff1\026\015\027\012\001\002\000\042" +
    "\005\ufff1\006\ufff1\007\ufff1\010\ufff1\011\ufff1\013\016\014" +
    "\ufff1\016\ufff1\017\ufff1\020\ufff1\021\020\022\ufff1\023\ufff1" +
    "\024\ufff1\026\015\027\012\001\002\000\026\005\ufff1\006" +
    "\ufff1\007\ufff1\010\ufff1\011\ufff1\013\016\014\ufff1\021\020" +
    "\026\015\027\012\001\002\000\026\005\ufff1\006\ufff1\007" +
    "\ufff1\010\ufff1\011\ufff1\013\016\014\ufff1\021\020\026\015" +
    "\027\012\001\002\000\042\005\ufff1\006\ufff1\007\ufff1\010" +
    "\ufff1\011\ufff1\013\016\014\ufff1\016\ufff1\017\ufff1\020\ufff1" +
    "\021\020\022\ufff1\023\ufff1\024\ufff1\026\015\027\012\001" +
    "\002\000\042\005\ufff1\006\ufff1\007\ufff1\010\ufff1\011\ufff1" +
    "\013\016\014\ufff1\016\ufff1\017\ufff1\020\ufff1\021\020\022" +
    "\ufff1\023\ufff1\024\ufff1\026\015\027\012\001\002\000\026" +
    "\005\ufff1\006\ufff1\007\ufff1\010\ufff1\011\ufff1\013\016\014" +
    "\ufff1\021\020\026\015\027\012\001\002\000\042\005\ufff1" +
    "\006\ufff1\007\ufff1\010\ufff1\011\ufff1\013\016\014\ufff1\016" +
    "\ufff1\017\ufff1\020\ufff1\021\020\022\ufff1\023\ufff1\024\ufff1" +
    "\026\015\027\012\001\002\000\032\005\ufff9\006\ufff9\007" +
    "\ufff9\010\ufff9\011\ufff9\014\ufff9\016\ufff9\017\ufff9\020\ufff9" +
    "\022\ufff9\023\ufff9\024\ufff9\001\002\000\016\005\027\006" +
    "\032\007\026\010\033\011\035\014\040\001\002\000\026" +
    "\005\uffe8\006\uffe8\007\uffe8\010\uffe8\011\uffe8\013\uffe8\021" +
    "\uffe8\022\uffe8\026\uffe8\027\uffe8\001\002\000\032\005\ufff8" +
    "\006\ufff8\007\ufff8\010\ufff8\011\ufff8\014\ufff8\016\ufff8\017" +
    "\ufff8\020\ufff8\022\ufff8\023\ufff8\024\ufff8\001\002\000\032" +
    "\005\ufffa\006\ufffa\007\026\010\033\011\035\014\ufffa\016" +
    "\ufffa\017\ufffa\020\ufffa\022\ufffa\023\ufffa\024\ufffa\001\002" +
    "\000\016\005\027\006\032\007\026\010\033\011\035\014" +
    "\044\001\002\000\026\005\uffe9\006\uffe9\007\uffe9\010\uffe9" +
    "\011\uffe9\013\uffe9\021\uffe9\022\uffe9\026\uffe9\027\uffe9\001" +
    "\002\000\016\005\027\006\032\007\026\010\033\011\035" +
    "\014\046\001\002\000\026\005\uffe7\006\uffe7\007\uffe7\010" +
    "\uffe7\011\uffe7\013\uffe7\021\uffe7\022\uffe7\026\uffe7\027\uffe7" +
    "\001\002\000\032\005\ufffb\006\ufffb\007\026\010\033\011" +
    "\035\014\ufffb\016\ufffb\017\ufffb\020\ufffb\022\ufffb\023\ufffb" +
    "\024\ufffb\001\002\000\032\005\ufff7\006\ufff7\007\ufff7\010" +
    "\ufff7\011\ufff7\014\ufff7\016\ufff7\017\ufff7\020\ufff7\022\ufff7" +
    "\023\ufff7\024\ufff7\001\002\000\016\005\027\006\032\007" +
    "\026\010\033\011\035\022\052\001\002\000\042\005\ufff1" +
    "\006\ufff1\007\ufff1\010\ufff1\011\ufff1\013\016\014\ufff1\016" +
    "\ufff1\017\ufff1\020\ufff1\021\020\022\ufff1\023\ufff1\024\ufff1" +
    "\026\015\027\012\001\002\000\032\005\027\006\032\007" +
    "\026\010\033\011\035\014\uffea\016\uffea\017\uffea\020\uffea" +
    "\022\uffea\023\uffea\024\uffea\001\002\000\004\021\020\001" +
    "\002\000\032\005\uffeb\006\uffeb\007\uffeb\010\uffeb\011\uffeb" +
    "\014\uffeb\016\uffeb\017\uffeb\020\uffeb\022\uffeb\023\uffeb\024" +
    "\uffeb\001\002\000\006\002\ufffd\027\ufffd\001\002\000\016" +
    "\005\027\006\032\007\026\010\033\011\035\014\060\001" +
    "\002\000\032\005\ufff4\006\ufff4\007\ufff4\010\ufff4\011\ufff4" +
    "\014\ufff4\016\ufff4\017\ufff4\020\ufff4\022\ufff4\023\ufff4\024" +
    "\ufff4\001\002\000\006\002\ufffc\027\ufffc\001\002\000\030" +
    "\005\ufff1\006\ufff1\007\ufff1\010\ufff1\011\ufff1\013\016\014" +
    "\ufff1\020\ufff1\021\020\026\015\027\012\001\002\000\006" +
    "\014\066\020\065\001\002\000\020\005\027\006\032\007" +
    "\026\010\033\011\035\014\uffef\020\uffef\001\002\000\030" +
    "\005\ufff1\006\ufff1\007\ufff1\010\ufff1\011\ufff1\013\016\014" +
    "\ufff1\020\ufff1\021\020\026\015\027\012\001\002\000\036" +
    "\002\uffe6\005\uffe6\006\uffe6\007\uffe6\010\uffe6\011\uffe6\014" +
    "\uffe6\016\uffe6\017\uffe6\020\uffe6\022\uffe6\023\uffe6\024\uffe6" +
    "\027\uffe6\001\002\000\020\005\027\006\032\007\026\010" +
    "\033\011\035\014\ufff0\020\ufff0\001\002\000\032\005\ufff1" +
    "\006\ufff1\007\ufff1\010\ufff1\011\ufff1\013\016\014\ufff1\020" +
    "\ufff1\021\020\025\uffec\026\015\027\072\001\002\000\004" +
    "\025\076\001\002\000\024\005\ufff2\006\ufff2\007\ufff2\010" +
    "\ufff2\011\ufff2\013\062\014\ufff2\020\073\025\uffed\001\002" +
    "\000\006\025\uffec\027\074\001\002\000\006\020\073\025" +
    "\uffed\001\002\000\004\025\uffee\001\002\000\026\005\uffe5" +
    "\006\uffe5\007\uffe5\010\uffe5\011\uffe5\013\uffe5\016\uffe5\021" +
    "\uffe5\026\uffe5\027\uffe5\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\074\000\004\002\003\001\001\000\010\003\010\011" +
    "\006\012\005\001\001\000\002\001\001\000\010\007\012" +
    "\010\016\011\013\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\010\007\023\010" +
    "\056\011\013\001\001\000\002\001\001\000\006\006\021" +
    "\007\020\001\001\000\002\001\001\000\010\007\023\010" +
    "\050\011\013\001\001\000\010\007\023\010\024\011\013" +
    "\001\001\000\002\001\001\000\002\001\001\000\010\007" +
    "\023\010\047\011\013\001\001\000\010\007\023\010\046" +
    "\011\013\001\001\000\010\007\023\010\044\011\013\001" +
    "\001\000\010\007\023\010\042\011\013\001\001\000\010" +
    "\007\023\010\041\011\013\001\001\000\010\007\023\010" +
    "\040\011\013\001\001\000\010\007\023\010\036\011\013" +
    "\001\001\000\010\007\023\010\035\011\013\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\010\007\023\010" +
    "\052\011\013\001\001\000\002\001\001\000\004\007\054" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\012\004\062" +
    "\007\023\010\063\011\013\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\007\023\010\066\011\013\001\001" +
    "\000\002\001\001\000\002\001\001\000\014\004\062\005" +
    "\070\007\023\010\063\011\013\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\005\074\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return s.next_token(); 
    }


    // Connect this parser to a scanner!
    Scanner s;
    Parser(Scanner s){ this.s=s; }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // functionlist ::= functionlist define 
            {
              String RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 System.out.println(i);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("functionlist",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= functionlist EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String start_val = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // functionlist ::= functionlist call 
            {
              String RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 System.out.println(i);
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("functionlist",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // functionlist ::= 
            {
              String RESULT =null;
		 RESULT = "";       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("functionlist",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // define ::= call1 expr RBRACKET 
            {
              String RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT="("+"define "+i+e+")";
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("define",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // define ::= call1 cond RBRACKET 
            {
              String RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT="("+"define "+i+e+")";
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("define",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // expr ::= expr PLUS expr 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = "("+"+"+e1+" "+e2+")";       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expr ::= expr MINUS expr 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = "("+"-"+e1+" "+e2+")";       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // expr ::= expr TIMES expr 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = "("+"*"+e1+" "+e2+")";       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // expr ::= expr DIV expr 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = "("+"/"+e1+" "+e2+")";       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // expr ::= expr MOD expr 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = "("+" modulo "+e1+" "+e2+")";       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // expr ::= call 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = e1;       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // expr ::= cond 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = e1;       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // expr ::= LPAREN expr RPAREN 
            {
              String RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = e;           
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // expr ::= NUMBER 
            {
              String RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = i;           
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // expr ::= ID 
            {
              String RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = i;           
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // expr ::= 
            {
              String RESULT =null;
		RESULT="";  
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // args ::= args COMMA expr 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = e1+" "+e2; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("args",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // args ::= expr 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = " "+e1; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("args",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // args1 ::= ID COMMA args1 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = e1+" "+e2; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("args1",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // args1 ::= ID 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = e1; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("args1",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // args1 ::= 
            {
              String RESULT =null;
		RESULT="";  
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("args1",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // cond ::= IF cond ELSE cond 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = "("+"if"+"("+e1+e2+")";
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("cond",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // cond ::= IF cond_args expr ELSE expr 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int e3left = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e3 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = "("+"if"+e1+e2+e3+")";       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("cond",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // cond_args ::= LPAREN expr EQUAL expr RPAREN 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = "("+"="+" "+e1+" "+e2+") "; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("cond_args",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // cond_args ::= LPAREN expr BIG expr RPAREN 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = ">"+" "+e1+" "+e2; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("cond_args",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // cond_args ::= LPAREN expr SMALL expr RPAREN 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = "<"+" "+e1+" "+e2; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("cond_args",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // call ::= ID LPAREN args RPAREN 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = "("+e1+""+c+")";       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("call",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // call1 ::= ID LPAREN args1 RB 
            {
              String RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = "("+e1+" "+c+")";       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("call1",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
