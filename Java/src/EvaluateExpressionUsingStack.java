public class EvaluateExpressionUsingStack{

    public int evaluate(String s){
	        String [] vals = s.split("");
		Stack<Integer> ints = new Stack<Integer>();
		Stack<String> str = new Stack<String>();
		for(String val : vals){
			if(val.equals("(")){  
				//str.push(val);
			}else if(val.equals(")")){
				String op = str.pop();
				if(op.equals("+")) {
					ints.push(ints.pop() + ints.pop());
				}else {
					ints.push(ints.pop() * ints.pop());	
					}
		    }else if(val.equals("+")){
				 str.push(val);
			}else if(val.equals("*")){
			     str.push(val);
			}else{
			     ints.push(Integer.parseInt(val));
			}
		} 
	     return ints.pop();
	}
	
	public static void main(String[] args) {
		EvaluateExpressionUsingStack rec = new EvaluateExpressionUsingStack();
		String exp = "(2+(3+4))";
		System.out.println(rec.evaluate(exp));
	}
}
