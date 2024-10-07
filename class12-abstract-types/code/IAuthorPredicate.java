
interface IAuthorPredicate {
	boolean satisfiedBy(Author a);
}

class BornAfter1940 implements IAuthorPredicate {

	public boolean satisfiedBy(Author a) {
		return a.yob > 1940;
	}
	
}
