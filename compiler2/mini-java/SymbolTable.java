
import java.util.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

public class SymbolTable {

     SymbolTable(){
		classes=new HashMap<String,ClassTable>();
	}

  public Map<String,ClassTable> classes;

public static class ClassTable{
		ClassTable(){
			fields=new HashMap<String,String>() ;
			methods=new HashMap<String, MethodTable>();
			parent=null;
		}
		public Map<String,String> fields;
		public Map<String,MethodTable> methods;
		public String parent;
	}

public static class MethodTable{
    MethodTable(){
      params=new HashMap<String,String>() ;
      locals=new HashMap<String, String>();
      type=null;
      //parent=null;
    }
    public Map<String,String>params;
    public Map<String,String>locals;
    public String type;
    //public String parent;
  }





  public String addClass(String image) {
		if(classes.get(image)!=null) throw new RuntimeException("class "+image+" already exsits.");
		ClassTable cst=new ClassTable();
	  classes.put(image,cst);
    //System.out.println(classes.values());
		return "lalala";
	}


  public void addfather(String father,String clasz)
  {
    ClassTable t=classes.get(clasz);
    t.parent=father;
  }






  public void addMethod(String methodName,String type, String clazz) {
		ClassTable t=classes.get(clazz);
		if(t.methods.get(methodName)!=null)  throw new RuntimeException("method "+methodName+" already exsits in class "+clazz);
		MethodTable m =new MethodTable();
    m.type=type;
		t.methods.put(methodName, m);
	}


  public void addField(String image,String type,String clazz){
		ClassTable t=classes.get(clazz);
		if(t.fields.get(image)!=null)  throw new RuntimeException("field "+image+" already exsits in class "+clazz);
		t.fields.put(image,type);
	}


  public void addParameters(String image,String type,String methodz,String clazz){
    ClassTable k=classes.get(clazz);
    MethodTable t=k.methods.get(methodz);
    if(t.params.get(image)!=null)  throw new RuntimeException("param "+image+" already exsits in method "+methodz);
    t.params.put(image,type);
  }


  public void addlocals(String image,String type,String methodz,String clazz){
    ClassTable k=classes.get(clazz);
    MethodTable t=k.methods.get(methodz);
    if(t.locals.get(image)!=null)  throw new RuntimeException("local variable "+image+" already exsits in method "+methodz);
    if(t.params.get(image)!=null)  throw new RuntimeException("parameter with name "+image+" already exsits in method "+methodz);
    t.locals.put(image,type);
  }


  public String takeclass(String image){
  if (classes.get(image)!=null)
      return image;
  else
     return null;


}
  public String taketypelocals(String image,String methodz,String clazz)
  {
    System.out.println(clazz);
    System.out.println(methodz);
    System.out.println(image);



    ClassTable k=classes.get(clazz);
    MethodTable t=k.methods.get(methodz);

    if(t.locals.get(image)!=null)
      return t.locals.get(image);
    if(t.params.get(image)!=null)
      return t.params.get(image);
    if(k.fields.get(image)!=null)
      return k.fields.get(image);
    while (k.parent!=null){
      k=classes.get(k.parent);
      if(k.fields.get(image)!=null)
        return k.fields.get(image);
      }
      throw new RuntimeException("variable "+image+" is not defined in class "+ clazz);
  }


  public String taketypemethods(String var_type,String method,String methodz,String clazz)
  {

      ClassTable k=classes.get(var_type);
      MethodTable t;
      if (k.methods.get(method)!=null)
      {
         t=k.methods.get(method);
         return t.type;
      }
      while (k.parent!=null){
         k=classes.get(k.parent);
        if (k.methods.get(method)!=null)
        {
           t=k.methods.get(method);
           return t.type;
        }


      }

throw new RuntimeException(" method "+method+" is not defined");
  }

public String checkarg(String clazz, String methodz,List<String> list){
  System.out.println("checkarg ");

  ClassTable k=classes.get(clazz);
  MethodTable t = k.methods.get(methodz);

  String[] args = t.params.values().toArray(new String[0]);
  String[] call_args = list.toArray(new String[0]);
  if(args.length != call_args.length){
    throw new RuntimeException("wrong number of arguments in method "+ methodz);

  }
  for(int i=0; i<args.length; i++){
    if(!args[i].equals(call_args[i])){
      throw new RuntimeException("wrong type of arguments in method "+ methodz);
    }
  }
  return t.type;
}






public String overwrite(String name_of_method,String clazz,String type_of_method)
{
   ClassTable k=classes.get(clazz);
   MethodTable n = k.methods.get(name_of_method);
   ClassTable fatha;
   MethodTable matha;
   String check=k.parent;
   while (check!=null){
     fatha=classes.get(check);
     matha=fatha.methods.get(name_of_method);
     if (matha.type!=type_of_method)
          throw new RuntimeException("you try overwrite a class");
      String[] nargs = n.params.values().toArray(new String[0]);
      String[] oldargs = matha.params.values().toArray(new String[0]);
      if(oldargs.length != nargs.length){
        throw new RuntimeException("you try overwrite a class");
      }
      for(int i=0; i<nargs.length; i++){
        if(!oldargs[i].equals(nargs[i])){
          throw new RuntimeException("you try overwrite a class");
        }
      }
     check=fatha.parent;
  }
     return null;
}



 public int sizeoftable()
 {

   return classes.size();
 }

  public String PrintClass() {

    return "lallaa";
    }

//public String PrintClass() {

  //return "lalala";
//}








}
