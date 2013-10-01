package v2;

public class CreateurEllipseFill extends CreateurDessin {

	@Override
	public Dessin creerDessin() {
		return new FilledEllipse();
	}

}
