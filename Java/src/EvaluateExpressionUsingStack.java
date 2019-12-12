public class EvaluateExpressionUsingStack{

	public int evaluate(String s){
		int result;
	        String [] vals = s.split("");
		Stack<int> ints = new Stack();
		Stack<String> str = new Stack();
		for(String val in vals){
			if(val.eauals"("){
			   
			   	
			}else if(val.equals")"){
			
			}else if(val.equasl"+"){
			
			}else if(val.equasl"*"){
			  str.push(val);
			}else{
			  ints.push(Integer.parseInt(val););
			}
		}
     	
	     return result;
	}
	public static void main(String[] args) {
		EvaluateExpressionUsingStack rec = new EvaluateExpressionUsingStack();
		String exp = "(2+(3+4))";
		System.out.println(rec.evaluate(exp));
	}
}
