public class EvaluateExpressionUsingStack{

	public static void main(String[] args) {
		EvaluateExpressionUsingStack rec = new EvaluateExpressionUsingStack();
		String exp = "(2+(3+4))";
		String [] val = exp.split("");
		System.out.println(rec.evaluate(val));
	}
}
