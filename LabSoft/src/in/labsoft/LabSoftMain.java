package in.labsoft;

import java.awt.EventQueue;

public class LabSoftMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new FormMainGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
