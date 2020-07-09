package MachinePack;

public class Display extends ObserverMachine{

	
	
	public Display(MachineSubject message) {
		this.MachineSubject = message;
		this.MachineSubject.attach(this);
	}
	
	
	@Override
	public void update() {
		System.out.println("Your message from " + MachineSubject.getMessage());
		
	}

}
