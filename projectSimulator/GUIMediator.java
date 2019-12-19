package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUIMediator extends Observable{
	private MachineModel model;
	private FilesMgr filesMgr;
	private StepControl stepControl;
	private JFrame frame;

	private CodeViewPanel codeViewPanel;
	private MemoryViewPanel memoryViewPanel1;
	private MemoryViewPanel memoryViewPanel2;
	private MemoryViewPanel memoryViewPanel3;
	private ControlPanel controlPanel; // Project Part 1?
	private ProcessorViewPanel processorPanel; // Project Part 1?
	private MenuBarBuilder menuBuilder; // Project Part 12

	private void createAndShowGUI(){
		 stepControl = new StepControl(this);
		 filesMgr = new FilesMgr(this);
		filesMgr.initialize();
		 codeViewPanel = new CodeViewPanel(this,model);
		 memoryViewPanel1 = new MemoryViewPanel(this, model, 0, 240);
		 memoryViewPanel2 = new MemoryViewPanel(this, model, 240, Memory.DATA_SIZE/2);
		 memoryViewPanel3 = new MemoryViewPanel(this, model, Memory.DATA_SIZE/2, Memory.DATA_SIZE);

		controlPanel  = new ControlPanel(this);
		processorPanel = new ProcessorViewPanel(this,model);
		 menuBuilder  = new  MenuBarBuilder(this);
		JFrame frame = new JFrame("Simulator");

		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		bar.add(menuBuilder.createFileMenu());
		bar.add(menuBuilder.createExecuteMenu());
		bar.add(menuBuilder.createJobsMenu());

		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout(1,1));
		content.setBackground(Color.BLACK);
		frame.setSize(1200, 600);

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 3));

		frame.add(codeViewPanel.createCodeDisplay(),BorderLayout.LINE_START);
		frame.add(processorPanel.createProcessorDisplay(),BorderLayout.PAGE_START);
		center.add(memoryViewPanel1.createMemoryDisplay());
		center.add(memoryViewPanel2.createMemoryDisplay());
		center.add(memoryViewPanel3.createMemoryDisplay());

		frame.add(center,BorderLayout.CENTER);
		frame.add(controlPanel.createControlDisplay(),BorderLayout.PAGE_END);
		// return HERE for the other GUI components
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(WindowListenerFactory.windowClosingFactory(e -> exit()));
		frame.setLocationRelativeTo(null);
		model.setCurrentState(States.NOTHING_LOADED);
		stepControl.start();
		model.getCurrentState().enter();
		setChanged();
		notifyObservers();

		// return HERE for other setup details
		frame.setVisible(true);
	}

	public void step(){
		if(model.getCurrentState()!=States.PROGRAM_HALTED &&
				model.getCurrentState()!=States.NOTHING_LOADED){
			try{
				model.step();
			} catch (CodeAccessException e) {
				JOptionPane.showMessageDialog(
						frame,
						"Illegal access to code from line " + model.getpCounter() + "\n"
						+ "Exception message: " + e.getMessage(),
						"Run time error",
						JOptionPane.OK_OPTION);
			} catch (ArrayIndexOutOfBoundsException e){
				JOptionPane.showMessageDialog(
						frame,
						"Illegal access to data" + "\n"
						+ "Exception message: " + e.getMessage(),
						"Run time error",
						JOptionPane.OK_OPTION);
			} catch (NullPointerException e){
				JOptionPane.showMessageDialog(
						frame,
						"Illegal access to code from line " + model.getpCounter() + "\n"
						+ "Exception message: " + e.getMessage(),
						"NullPointerException",
						JOptionPane.OK_OPTION);
			} catch (IllegalArgumentException e){
				JOptionPane.showMessageDialog(
						frame,
						"Illegal access to code from line " + model.getpCounter() + "\n"
						+ "Exception message: " + e.getMessage(),
						"Program error",
						JOptionPane.OK_OPTION);
			} catch (DivideByZeroException e){
				JOptionPane.showMessageDialog(
						frame,
						"Illegal access to code from line " + model.getpCounter() + "\n"
						+ "Exception message: " + e.getMessage(),
						"Divide by zero error",
						JOptionPane.OK_OPTION);
			}
			setChanged();
			notifyObservers();
		}
	}

	public void execute(){
		while(model.getCurrentState()!=States.PROGRAM_HALTED &&
				model.getCurrentState()!=States.NOTHING_LOADED){
			try{
				model.step();
				System.out.println(model.getCurrentState().toString());
			} catch (CodeAccessException e) {
				JOptionPane.showMessageDialog(
						frame,
						"Illegal access to code from line " + model.getpCounter() + "\n"
						+ "Exception message: " + e.getMessage(),
						"Run time error",
						JOptionPane.OK_OPTION);
			} catch (ArrayIndexOutOfBoundsException e){
				JOptionPane.showMessageDialog(
						frame,
						"Illegal access to data" + "\n"
						+ "Exception message: " + e.getMessage(),
						"Run time error",
						JOptionPane.OK_OPTION);
			} catch (NullPointerException e){
				JOptionPane.showMessageDialog(
						frame,
						"Illegal access to code from line " + model.getpCounter() + "\n"
						+ "Exception message: " + e.getMessage(),
						"NullPointerException",
						JOptionPane.OK_OPTION);
			} catch (IllegalArgumentException e){
				JOptionPane.showMessageDialog(
						frame,
						"Illegal access to code from line " + model.getpCounter() + "\n"
						+ "Exception message: " + e.getMessage(),
						"Program error",
						JOptionPane.OK_OPTION);
			} catch (DivideByZeroException e){
				JOptionPane.showMessageDialog(
						frame,
						"Illegal access to code from line " + model.getpCounter() + "\n"
						+ "Exception message: " + e.getMessage(),
						"Divide by zero error",
						JOptionPane.OK_OPTION);
			}


		}

		setChanged();
		notifyObservers();


		System.out.println("*");
	}

	public MachineModel getModel() {
		return model;
	}
	public void setModel(MachineModel model) {
		this.model = model;
	}
	public JFrame getFrame(){
		return frame;
	}

	public States getCurrentState(){
		return model.getCurrentState();
	}

	public void setCurrentState(States s){
		if(s==States.PROGRAM_HALTED){
			stepControl.setAutoStepOn(false);
		}
		model.setCurrentState(s);
		//Three lines that always follow a change of state
		model.getCurrentState().enter();
		setChanged();
		notifyObservers();
	}

	public void exit() { // method executed when user exits the program
		int decision = JOptionPane.showConfirmDialog(
				frame, "Do you really wish to exit?",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		if (decision == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void clearJob(){

		int codeSize = model.getCurrentJob().getCodeSize();

		model.clearJob();
		model.setCurrentState(States.NOTHING_LOADED);
		model.getCurrentState().enter();
		setChanged();
		//notifyObservers("Clear");
		notifyObservers("Clear " + codeSize); // NOTE the space in "Clear "
	}

	public void makeReady(String s){
		stepControl.setAutoStepOn(false);
		model.setCurrentState(States.PROGRAM_LOADED_NOT_AUTOSTEPPING);
		model.getCurrentState().enter();
		setChanged();
		notifyObservers(s);
	}

	public void toggleAutoStep(){
		stepControl.toggleAutoStep();
		if(stepControl.isAutoStepOn()){
			model.setCurrentState(States.AUTO_STEPPING);
		}else{
			model.setCurrentState(States.PROGRAM_LOADED_NOT_AUTOSTEPPING);
		}
		model.getCurrentState().enter();
		setChanged();
		notifyObservers();
	}

	public void reload() {
		stepControl.setAutoStepOn(false);
		clearJob();
		filesMgr.finalLoad_ReloadStep(model.getCurrentJob());
	}

	public void changeToJob(int i) {
		model.changeToJob(i);
		if(model.getCurrentState()!=null){
			model.getCurrentState().enter();
			setChanged();
			notifyObservers();
		}
	}

	public void setPeriod(int period) {
		stepControl.setPeriod(period);
	}

	public void assembleFile() {
		filesMgr.assembleFile();
	}

	public void loadFile() {
		filesMgr.loadFile(model.getCurrentJob());
	}

	public static void main(String[] args) {
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            GUIMediator organizer = new GUIMediator();
	            MachineModel model = new MachineModel(
	            ()
	            -> organizer.setCurrentState(States.PROGRAM_HALTED)
	            );
	            organizer.setModel(model);
	            organizer.createAndShowGUI();
	        }
	    });
	}



}
