import java.awt.Dimension;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GuiApp implements Runnable{
	ImagePanel img1;
	ImagePanel img2;
	ImagePanel img3;
	
	private static Log log=LogFactory.getLog(GuiApp.class);
	
	String name;
	long time;
	Random r=new Random();
	
	public GuiApp(String x){
		name=x;
		time=r.nextInt(1000);
	}
	
	public void makeGui()
	{
		// Create the window.
		JFrame frame = new JFrame("Multi-threaded animations!");
		// Set the window size.
		frame.setMinimumSize(new Dimension(800, 400));
		// Close when you click the X.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
		//Stack our components vertically.
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		// Create 3 image panels.
		img1 = new ImagePanel();
		img2 = new ImagePanel();
		img3 = new ImagePanel();
		
		// Add them to our window.
		frame.add(img1);
		frame.add(img2);
		frame.add(img3);
		
		// Show our window.
		frame.setVisible(true);
	}
	
	public void run() {
		// TODO:
		// We want 3 threads.
		// 1 thread for each image panel.
		// Each thread should update its image at a different interval.
		
		if(!Thread.currentThread().isInterrupted()){
			try{
				System.out.println("my thread created");
				img1.setPath("EmpireState.jpg");
				img2.setPath("LowerManhattan.jpg");
				img3.setPath("TimesSquare.jpg");
				Thread.sleep(time);
			}
			catch(Exception e){
				log.error("UnExpected Exception caught while running", e);
			}
		}
	}
}
