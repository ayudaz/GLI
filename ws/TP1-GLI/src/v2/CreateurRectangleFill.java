package v2;

public class CreateurRectangleFill extends CreateurDessin {

	@Override
	public Dessin creerDessin() {
		return new FilledRectangle();
	}

}
