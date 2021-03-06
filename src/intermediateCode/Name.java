package intermediateCode;

public class Name extends Exp {
	private LabelLocation label;

	public Name(LabelLocation label) {
		super();
		this.label = label;
	}

	public LabelLocation getLabel() {
		return this.label;
	}

	public String toString() {
		return "NAME(" + label.toString() + ")";
	}

}
