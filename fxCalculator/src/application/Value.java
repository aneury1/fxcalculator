package application;

import java.util.ArrayList;

public class Value 
{

	static boolean first = true;
	static type type_last = type.NONE;
	
	
	
	 private enum temp{
		 NONE,SUM,REST,MULT,DIV,IGNORE
	 }
	
	
  public enum type{
	  NUMERIC_VALUE,
	  OPERATION_SYMBOL,
	  EQUAL,
	  NONE
  }

  public enum operators{SUM, DIFERENCES, MULTIPLY,DIVIDE}

  String current_value;
  boolean is_symbol;
  
  public Value(String symbol){
	  
	  if(symbol.equals("+")||symbol.equals("-")||symbol.equals("*")||symbol.equals("/")||symbol.equals("="))
	  {
		  is_symbol = true;
		  ///System.out.println("is  a Valid Value, Symbol"); 
		  current_value = symbol;
		  return;
	  }
	  else
	  {
		  is_symbol = false;
	  }
	  
	  try{
		  
		  Integer integer = Integer.parseInt(symbol);
		  current_value = symbol;
		 /// System.out.println("is a Valid Value,Number"); 
	  }catch(Exception e){
		System.out.println("is not a Valid Value"); 
	  }
  }
  
  public static ArrayList<Value> values_to_calc = new ArrayList<Value>();
  
  public static boolean insert_value(Value v){
	 
		///static boolean first = true;
		///static type type_last = type.NONE;
	  
	  if(v.is_symbol && first ==true)
	  {
		  System.out.printf("Cant enter symbol at first point");
		  return false;
	  }
	 
	  if(v.is_symbol == false &&  first == true)
	  {
		    values_to_calc.add(v);
		    first = false;
		    type_last = type.NUMERIC_VALUE;
		    return true;
	  }
	  
	  if(v.is_symbol == true && type_last == type.NUMERIC_VALUE)
	  {
		  type_last = type.OPERATION_SYMBOL;
		  values_to_calc.add(v);
		  return true;
	  }
	  
	  if(v.is_symbol == false && type_last == type.OPERATION_SYMBOL)
	  {
		  type_last = type.NUMERIC_VALUE;
		  values_to_calc.add(v);
		  return true;
	  }
	  
	  
	  return false;
	  /*
	  if(v.is_symbol == true)
	  {
		///  System.out.println("Is Symbol");
		
		  if(values_to_calc.size() == 0)
		  {
			  return;
		  }
		  
		  int size = values_to_calc.size();
		  System.out.printf("Size =[%d]\n",size);
		 
		  if(values_to_calc.get(size-1).is_symbol == true)
		  {
			  System.out.print("Cant Put operator after another operator");
			  return;
		  }
		  else
		  {
			  values_to_calc.add(v);
		  }
	  }
	  else
	  {
		  values_to_calc.add(v);
	  }*/
  }
  
  public static void calculate()
  {
	  
	  
	  if(values_to_calc.size() < 3)
	  {
		  System.out.println("Cant operate.");
		  return;
	  }
	  else
	  {
		 Integer accum = Integer.parseInt(values_to_calc.get(0).current_value);
		 temp last_operation = temp.NONE;

		 for(int i=1; i<values_to_calc.size();i++)
		 {
		   	 Value val = values_to_calc.get(i);
		   	 if(val.is_symbol)
		   	 {
		   		 if(val.current_value.equals("+"))
		   		 {
		   			 last_operation = temp.SUM; 
		   		 }
		   		 else  if(val.current_value.equals("-"))
			   	 {
			   		 last_operation = temp.REST;	 
			   	 }
		   		 else  if(val.current_value.equals("/"))
			   	 {
			   		 last_operation = temp.DIV;	 
			   	 }
		   		 else  if(val.current_value.equals("*"))
			   	 {
			   		 last_operation = temp.MULT;	 
			   	 }
		   	 }
		   	 else
		   	 {
		   		 switch(last_operation)
		   		 {
				    case NONE:
				   	    accum = Integer.parseInt(val.current_value);
				   	    break;
				     case SUM:
					   	accum += Integer.parseInt(val.current_value);
					  	 
				   	 break; 
				   	 case REST:
				   		accum -= Integer.parseInt(val.current_value);	 
					 break;
					 case MULT:
							accum *= Integer.parseInt(val.current_value);
							break;
					 case DIV: 
							accum /= Integer.parseInt(val.current_value);
						 break; 
				     case IGNORE:
						 break;
		   		 
		   		 }
		   		 
		   	 }
		 }
		  
		 System.out.print("Added Values are "+accum.toString());
		  
		  
	  }
	  
	  
	  
	  
	  
	  
  }
}
