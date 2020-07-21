//236. Lowest Common Ancestor of a Binary Tree

class GraphYoungestCommonAncestor{


public static AncestralTree getYoungestCommonAncestor(
      AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {

		Set<AncestralTree> visited = new HashSet<>();
		
		if(descendantOne == null || descendantTwo == null){
	  	return topAncestor; 
		}

		while(descendantOne.name != topAncestor.name ){
			visited.add(descendantOne);
			descendantOne = descendantOne.ancestor;
		}
		
		while(descendantTwo.name != topAncestor.name){
			if(visited.contains(descendantTwo)){
				return descendantTwo; 
			}
			descendantTwo = descendantTwo.ancestor;		
		}
		return topAncestor;
  }

  static class AncestralTree {
    public char name;
    public AncestralTree ancestor;

    AncestralTree(char name) {
      this.name = name;
      this.ancestor = null;
    }


}
