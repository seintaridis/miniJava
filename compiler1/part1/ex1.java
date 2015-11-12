

import java.io.InputStream;
import java.io.IOException;

class TernaryOperatorParser {

    private int lookaheadToken;

    private InputStream in;

    public TernaryOperatorParser(InputStream in) throws IOException {
	this.in = in;
	lookaheadToken = in.read();
	while (lookaheadToken==' ')
		lookaheadToken = in.read();
    }

    private void consume(int symbol) throws IOException, ParseError {
	if (lookaheadToken != symbol)
	{	System.out.print("consume");
	    throw new ParseError();
	    }
	lookaheadToken = in.read();
	while (lookaheadToken==' ')
		lookaheadToken = in.read();
	
    }

    private String goal() throws IOException, ParseError {
    	//System.out.println("goal");
    	if((lookaheadToken < '0' || lookaheadToken > '9') && lookaheadToken != '(')
    	{
    		//System.out.print("goal");
    	    throw new ParseError();
    	    
    	}
    	//System.out.print("goal");
    	//consume(lookaheadToken);
    	return exp();
        }
    
    
    private String exp() throws IOException, ParseError {
    	//System.out.println("exp");
    	if((lookaheadToken < '0' || lookaheadToken > '9') && lookaheadToken != '(')
    	{
    		//System.out.print("exp");
    	    throw new ParseError();
    	}
    	String x,y;
    	x=term();
    	y=exp2(x);
    	
    	return y;
	
    	
    }
    
    private String exp2(String word) throws IOException, ParseError
    {
    	//System.out.println("exp2");
    	if(lookaheadToken == ')' || lookaheadToken == '\n'|| lookaheadToken == -1)
    	{
    		
    		return word;
    	
    	}
    	if(lookaheadToken != '+' && lookaheadToken != '-')
    	{
    		//System.out.print("exp2");
    		throw new ParseError();
    	}
    	//System.out.print(lookaheadToken);
    	String prosimo=Character.toString ((char) lookaheadToken);
    	
    	consume(lookaheadToken);
    	String x,y;
    	x=term();
    	String k="("+prosimo+word+x+")";
    	y=exp2(k);
    	
    	return y;
    	
    	
    	
    }
    
    private String term() throws IOException, ParseError
    {
    	//System.out.println("term");

    	if((lookaheadToken < '0' || lookaheadToken > '9') && lookaheadToken != '(')
    	{
    		//System.out.print(lookaheadToken);
    		//System.out.print("term");
    		throw new ParseError();
    	}
    	//System.out.print(lookaheadToken);
    
    	String x,y;
    	x=factor();
    	y=term2(x);
    	
    	return y;
    		
    	
    }
    
    private String term2(String word) throws IOException, ParseError
    {
    	
    	//System.out.println("term2");
    	if (lookaheadToken=='\n' || lookaheadToken==')' || lookaheadToken == -1 || lookaheadToken == '+' || lookaheadToken == '-')
    		return word;
    	if(lookaheadToken != '*' && lookaheadToken != '/')
    	{
    		//System.out.print("term2");
    		throw new ParseError();
    	}	
    	String prosimo=Character.toString ((char) lookaheadToken);
    	consume(lookaheadToken);
    	
    	
    	
    	String x,y;
    	x=factor();
    	String k="("+prosimo+word+x+")";
    	y=term2(k);
    	return y;
    	
    }
    
    
    private int evalDigit(int digit){
    	return digit - '0';
        }
    
    private String factor() throws IOException, ParseError
    {
    	
    	//System.out.println("factor");
    	if((lookaheadToken < '0' || lookaheadToken > '9') && lookaheadToken != '(')
    	{
    		//System.out.print("factor");
    		throw new ParseError();
    	}
    	
    	//System.out.print(evalDigit(lookaheadToken));
    	if (lookaheadToken=='(')
    	{
    		consume(lookaheadToken);
    		String z=exp();
    		if (lookaheadToken!=')')
    			throw new ParseError();
    		consume(lookaheadToken);
    		return z;
    	}
    	else{
    		int x=evalDigit(lookaheadToken);
    		consume(lookaheadToken);
    		return String.valueOf(x);
    	}
    }
    
    
    
    

    public void parse() throws IOException, ParseError {
    	System.out.println(goal());
    	//System.println(goal());
    	//goal();
    	if (lookaheadToken != '\n' && lookaheadToken != -1)
    		throw new ParseError();
    }

    public static void main(String[] args) {
    
    	
	try {
	    TernaryOperatorParser parser = new TernaryOperatorParser(System.in);
	    parser.parse();
	}
	catch (IOException e) {
	    System.err.println(e.getMessage());
	}
	catch(ParseError err){
	    System.err.println(err.getMessage());
	}
    }
}
