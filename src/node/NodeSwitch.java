package node;

import intermediateCode.*;
import java.util.Iterator;

public final class NodeSwitch extends Node {

	public NodeSwitch(Node e, Node stm) {
		super(e, stm);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		if (!get(0).checksType()) {
			System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
			System.out.println("faillure");
			return false;
		}
		if (!get(1).checksType()) {
			System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
			System.out.println("faillure");
			return false;
		}
		System.out.print("-- result " + this.getClass().getSimpleName() + " : ");
		System.out.println("success");
		return true;
	}

	@Override
	public NodeSwitch clone() {
		return new NodeSwitch((Node) this.getExp().clone(), (Node) this.getStm().clone());
	}

	private Node getStm() {
		return this.get(1);
	}

	private Node getExp() {
		return this.get(0);
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		this.getExp().generateIntermediateCode();
		Name name = (Name) this.getExp().getIntExp();
		Label e = new Label(name.getLabel());
		Stm s = (Stm) this.getStm().generateIntermediateCode();
		return new Seq(e, s);
	}

}
