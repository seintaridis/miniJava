
import java.util.*;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

public class SymbolTable {

     SymbolTable(){
		classes=new LinkedHashMap<String,ClassTable>();
	}

  public Map<String,ClassTable> classes;

public static class ClassTable{
		ClassTable(){
			fields=new LinkedHashMap<String,String>() ;
			methods=new LinkedHashMap<String, MethodTable>();
			parent=null;
		}
		public Map<String,String> fields;
		public Map<String,MethodTable> methods;
		public String parent;
	}

public static class MethodTable{
    MethodTable(){
      params=new LinkedHashMap<String,String>() ;
      locals=new LinkedHashMap<String, String>();
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

public int search_kind(String clasz,String methodz,String id)
{
  ClassTable t=classes.get(clasz);
  MethodTable m=t.methods.get(methodz);
  if (t==null ||m==null)
    return 0;
  int i=1;
  for ( String key : m.params.keySet() ) {
    //System.out.println( key );
    if (key==id)
      return i;
    i++;
    //System.out.println( key );
}
return 0;

}

 public int number_of_parameters(String clasz,String methodz)
 {
   ClassTable t=classes.get(clasz);
   MethodTable m=t.methods.get(methodz);
   int x = m.params.size();
   //System.out.println(x);
   return x;
 }

public int number_of_methods(String clasz)
{
  String mother;
  ClassTable t=classes.get(clasz);
  int x = t.methods.size();
  mother=t.parent;
  while (mother!=null)
  {
    t=classes.get(mother);
    x=x+t.methods.size();
    mother=t.parent;
  }
  return x;
}

public int offset_of_method(String clasz,String methodz)
{
  ArrayList<String> lista = new ArrayList<String>();
  ArrayList<String> lista1 = new ArrayList<String>();
  LinkedHashMap<String,String> methods=new LinkedHashMap<String,String>() ;
  ClassTable t=classes.get(clasz);
  String mother=t.parent;
  lista.add(clasz);

  while (mother!=null)
  {
    //System.out.println(mother);
    lista.add(mother);
    t=classes.get(mother);
    mother=t.parent;

  }
  Collections.reverse(lista);
  int i=0;
  String clas;
  for (i=0;i<lista.size();i++)
  {
    clas=lista.get(i);
    t=classes.get(clas);
    for ( String key : t.methods.keySet() ) {
        methods.put(key,clas);


    }
  }
  int la=0;
  for ( String key : methods.keySet() ) {

      if (key==methodz)
        return la;
      la=la+4;
}
   return la;


 }


public int offset_of_field(String clasz,String fieldz)
{
  ArrayList<String> lista = new ArrayList<String>();
  ArrayList<String> lista1 = new ArrayList<String>();
  LinkedHashMap<String,String> field=new LinkedHashMap<String,String>() ;
  ClassTable t=classes.get(clasz);
  if (t==null)
   return -1;
  String mother=t.parent;
  lista.add(clasz);

  while (mother!=null)
  {
    //System.out.println(mother);
    lista.add(mother);
    t=classes.get(mother);
    mother=t.parent;

  }
  Collections.reverse(lista);
  int i=0;
  String clas;
  for (i=0;i<lista.size();i++)
  {
    clas=lista.get(i);
    t=classes.get(clas);
    for ( String key : t.fields.keySet() ) {
        field.put(key,clas);


    }
  }
  int la=4;
  for ( String key : field.keySet() ) {

      if (key==fieldz)
        return la;
      la=la+4;
}
    return -1;

 }

public int number_of_fields(String clasz)
{
  String mother;
  ClassTable t=classes.get(clasz);
  int x = t.fields.size();
  mother=t.parent;
  while (mother!=null)
  {
    t=classes.get(mother);
    x=x+t.fields.size();
    mother=t.parent;
  }
  return x;
}

public LinkedHashMap<String,String> load_method(String clasz)
{
  ArrayList<String> lista = new ArrayList<String>();
  ArrayList<String> lista1 = new ArrayList<String>();
  LinkedHashMap<String,String> methods=new LinkedHashMap<String,String>() ;
  ClassTable t=classes.get(clasz);
  String mother=t.parent;
  lista.add(clasz);

  while (mother!=null)
  {
    //System.out.println(mother);
    lista.add(mother);
    t=classes.get(mother);
    mother=t.parent;

  }
  Collections.reverse(lista);
  int i=0;
  String clas;
  for (i=0;i<lista.size();i++)
  {
    clas=lista.get(i);
    t=classes.get(clas);
    for ( String key : t.methods.keySet() ) {
        methods.put(key,clas);


    }
  }


  return methods;

}


public LinkedHashMap<String,String> load_field(String clasz)
{
  ArrayList<String> lista = new ArrayList<String>();
  ArrayList<String> lista1 = new ArrayList<String>();
  LinkedHashMap<String,String> fields=new LinkedHashMap<String,String>() ;
  ClassTable t=classes.get(clasz);
  String mother=t.parent;
  lista.add(clasz);
  while (mother!=null)
  {
    lista.add(mother);
    t=classes.get(mother);
    mother=t.parent;
  }
  Collections.reverse(lista);
  int i=0;
  String clas;
  for (i=0;i<lista.size();i++)
  {
    clas=lista.get(i);
    t=classes.get(clas);
    for ( String key : t.fields.keySet() ) {
        fields.put(key,clas);


    }
  }


  return fields;

}


public String[] name_method(String clasz,int num_of_methods)
{
  String[] myList = new String[num_of_methods];
  int i=0;
  ClassTable t=classes.get(clasz);
  String mother=clasz;

  while (mother!=null)
  {
  for ( String key : t.methods.keySet() ) {
    myList[i]=mother+"_"+key;
    i++;
    //System.out.println( key );
  }
  mother=t.parent;




}

  return myList;

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

  public String get_type_field(String image,String clazz){
    ClassTable t=classes.get(clazz);
    String ret=t.fields.get(image);
    String mother=t.parent;

    while (mother!=null){
      if (ret==null)
        ret=t.fields.get(image);
      t=classes.get(mother);
      mother=t.parent;



    }



    return ret;
  }

public String get_type_param(String image,String clazz,String methodz){
  ClassTable k=classes.get(clazz);
  MethodTable t=k.methods.get(methodz);
  String ret=t.params.get(image);
  return ret;
}

public String get_type_local(String image,String clazz,String methodz){
String ret=null;
MethodTable t=null;
ClassTable k=null;
 k=classes.get(clazz);
  if (k!=null)
  t=k.methods.get(methodz);
  if (t!=null)
   ret=t.locals.get(image);
  return ret;
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
    //System.out.println(clazz);
    //System.out.println(methodz);
    //System.out.println(image);



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
  //System.out.println("checkarg ");

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
