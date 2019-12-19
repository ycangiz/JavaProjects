package project;

public class CPU {

	private int accum, pCounter, memBase;

	public int getAccum() {
		return accum;
	}

	public int getpCounter() {
		return pCounter;
	}

	public int getMemBase() {
		return memBase;
	}

	public void incrPC(){
		pCounter++;
	}

	public void setAccum(int accumulator) {
		this.accum = accumulator;
	}

	public void setpCounter(int pCounter) {
		this.pCounter = pCounter;
	}

	public void setMemBase(int memBase) {
		this.memBase = memBase;
	}

}
