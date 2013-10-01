package v2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonListener implements ActionListener {
	
	private CreateurDessin cd;
	private ZoneDeDessin zdd;

	public MyButtonListener(ZoneDeDessin zdd, CreateurDessin cd){
		this.zdd = zdd;
		this.cd = cd;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		zdd.setCD(cd);
	}

}
