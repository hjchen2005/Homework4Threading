public class Main {
	public static void main(String args[]) {
		/*
		GuiApp gui = new GuiApp();
		gui.makeGui();
		gui.run();*/
		Thread t1 =new Thread(new GuiApp("1"));
		Thread t2 =new Thread(new GuiApp("2"));
		Thread t3 =new Thread(new GuiApp("3"));
		
		t1.start();
		t2.start();
		t3.start();
	}
}
