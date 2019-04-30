package node;
import intermediateCode.*;

public final class NodeCase extends Node {

	private String nameValue;
	private boolean defaultValue;
	
	public NodeCase(String nameValue, Node stm) {
		super(stm);
		this.nameValue = nameValue;
		this.defaultValue = false;
	}

	public NodeCase(Node stm) {
		this(null, stm);
		this.defaultValue = true;
	}

	@Override
	public boolean checksType() {
		super.checksType();
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		System.out.println("success");
		return true;
	}

	@Override
	public NodeCase clone() {
		return new NodeCase(nameValue, (Node) this.getStm().clone());
	}

	private Node getStm() {
		return super.get(0);
	}

	public boolean isDefaultValue() {
		return defaultValue;
	}
	@Override
	public IntermediateCode generateIntermediateCode()  {
		Name caseName = new Name(new LabelLocation(this.nameValue));
		IntermediateCode stm = this.getStm().generateIntermediateCode();
		//veut stm et pas stmList faut récuperer tete
		//Eseq eseq = new Eseq(stm, caseName);
		return null;
	}

}
