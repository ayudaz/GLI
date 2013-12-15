package retroaction.decorator;

public abstract class RetroActionDecorator implements RetroAction {
	
	private final RetroAction retroActionDecoree;
	
	public RetroActionDecorator(RetroAction retroActionDecoree){
		this.retroActionDecoree = retroActionDecoree;
	}

	@Override
	public void faireRetroAction() {
		retroActionDecoree.faireRetroAction();
	}

}
