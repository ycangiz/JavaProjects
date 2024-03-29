package project;

import java.util.Map;
import java.util.TreeMap;

public class MachineModel {
	public final Map<Integer, Instruction> IMAP = new TreeMap<>();
	private CPU cpu = new CPU();
	private Memory memory = new Memory();
	private HaltCallback callback;
	Code code = new Code();
	private Job[] jobs = new Job[4];
	private Job currentJob;

	public MachineModel() {
		this(() -> System.exit(0));
	}

	public MachineModel(HaltCallback h) {


		//ADD
		IMAP.put(0x3, (arg, level) -> {
		if(level < 0 || level > 2) {
		throw new IllegalArgumentException(
		"Illegal indirection level in ADD instruction");
		}
		if(level > 0) {
		IMAP.get(0x3).execute(memory.getData(cpu.getMemBase()+arg), level-1);
		} else {
		cpu.setAccum(cpu.getAccum() + arg);
		cpu.incrPC();
		}
		});

		// ADDI
			/*	IMAP.put(0x3,  (arg, level) -> {
					if(level !=0 ) {
						throw new IllegalArgumentException(
						"Illegal indirection level in ADDI instruction");
						}else{
					cpu.setAccum(cpu.getAccum() + arg);
					cpu.incrPC();
						}
				});*/

				//SUB
				IMAP.put(0x4,(arg, level) -> {
		            if(level < 0 || level > 2) {
		                throw new IllegalArgumentException("Illegal indirection level in SUB instruction");
		            }
		            if (level > 0) {
		            	IMAP.get(0x4).execute(memory.getData(arg), level-1);
		            } else {
		            	cpu.setAccum(cpu.getAccum() - arg);
						cpu.incrPC();
		            }
		        });

				// SUBI
			/*	IMAP.put(0x4,  (arg, level) -> {
					if(level != 0) {
		                throw new IllegalArgumentException("Illegal indirection level in SUBI instruction");
		            }else{
					cpu.setAccum(cpu.getAccum() - arg);
					cpu.incrPC();
		            }
				});*/


				//MUL
				IMAP.put(0x5,(arg, level) -> {
		            if(level < 0 || level > 2) {
		                throw new IllegalArgumentException("Illegal indirection level in MUL instruction");
		            }
		            if (level > 0) {
		            	IMAP.get(0x5).execute(memory.getData(arg), level-1);
		            } else {
		            	cpu.setAccum(cpu.getAccum() * arg);
						cpu.incrPC();
		            }
		        });

				// MULI
				/*IMAP.put(0x5,  (arg, level) -> {
					if(level!=0) {
		                throw new IllegalArgumentException("Illegal indirection level in MULI instruction");
		            }else{
					cpu.setAccum(cpu.getAccum() * arg);
					cpu.incrPC();
		            }
				});*/


				//DIV
				IMAP.put(0x6,(arg, level) -> {
		            if(level < 0 || level > 2) {
		                throw new IllegalArgumentException("Illegal indirection level in DIV instruction");
		            }
		            if (level > 0) {
		            	IMAP.get(0x6).execute(memory.getData(arg), level-1);
		            } else {
		            	if(arg == 0){
		            		throw new DivideByZeroException("Division by Zero");
		            	}else{
		            		cpu.setAccum(cpu.getAccum() / arg);
							cpu.incrPC();
		            	}
		            }
		        });

				// DIVI
				/*IMAP.put(0x6,  (arg, level) -> {

					if(level !=0) {
		                throw new IllegalArgumentException("Illegal indirection level in DIVI instruction");
		            }else{
					if (arg == 0)
						throw new DivideByZeroException("You cannot divide by zero.");
					cpu.setAccum(cpu.getAccum() / arg);
					cpu.incrPC();
		            }
				});*/


		//NOP
		IMAP.put(0x0,(arg, level) -> {
            if(level != 0){
                throw new IllegalArgumentException("Illegal indirection level in NOP instruction");
            }
            cpu.incrPC();
        });


				//LOD
				IMAP.put(0x1,(arg, level) -> {
		            if(level < 0 || level > 2) {
		                throw new IllegalArgumentException("Illegal indirection level in LOD instruction");
		            }
		            if (level > 0) {
		            	IMAP.get(0x1).execute(memory.getData(arg), level-1);
		            } else {
		            	cpu.setAccum(arg);
						cpu.incrPC();
		            }
		        });

		// LODI
		/*IMAP.put(0x1, (arg, level)-> {
			if(level !=0 ) {
                throw new IllegalArgumentException("Illegal indirection level in LODI instruction");
            }else{
			cpu.setAccum(arg);
			cpu.incrPC();
            }
		});*/


				//STO
				IMAP.put(0x2,(arg, level) -> {
		            if(level < 1 || level > 2) {
		                throw new IllegalArgumentException("Illegal indirection level in STO instruction");
		            }
		            if (level > 1) {
		            	IMAP.get(0x2).execute(memory.getData(arg), level-1);
		            } else {
		            	memory.setData(arg + cpu.getMemBase(), cpu.getAccum());
						cpu.incrPC();
		            }
		        });


				//AND
				IMAP.put(0x7,(arg, level) -> {
		            if(level < 0 || level > 1) {
		                throw new IllegalArgumentException("Illegal indirection level in AND instruction");
		            }
		            if (level > 0) {
		            	IMAP.get(0x7).execute(memory.getData(arg), level-1);
		            } else {
		                if((cpu.getAccum() != 0) && (arg != 0)){
		                	cpu.setAccum(1);
		                }else{
		                	cpu.setAccum(0);
		                }
		                cpu.incrPC();
		            }
		        });

				// ANDI
				IMAP.put(0x7,  (arg, level) -> {
					if(level !=0) {
		                throw new IllegalArgumentException("Illegal indirection level in ANDI instruction");
		            }else{
					if (cpu.getAccum() != 0 && arg != 0) {
						cpu.setAccum(1);
					} else {
						cpu.setAccum(0);
					}
					cpu.incrPC();
		            }
				});

				//NOT
				IMAP.put(0x8,(arg, level) -> {
		            if(level != 0) {
		                throw new IllegalArgumentException("Illegal indirection level in NOT instruction");
		            }
		            if(cpu.getAccum() == 0){
		            	cpu.setAccum(1);
		            }else{
		            	cpu.setAccum(0);
		            }
		            cpu.incrPC();
		        });


				//CMPL
				IMAP.put(0x9,(arg, level) -> {
		            if(level != 1) {
		                throw new IllegalArgumentException("Illegal indirection level in CMPL instruction");
		            }
		            else{
		                if(memory.getData(arg) < 0){
		                	cpu.setAccum(1);
		                }else{
		                	cpu.setAccum(0);
		                }
		                cpu.incrPC();
		            }
		        });


				//CMPZ
				IMAP.put(0xA,(arg, level) -> {
		            if(level != 1) {
		                throw new IllegalArgumentException("Illegal indirection level in CMPZ instruction");
		            }
		            else{
		                if(memory.getData(arg) == 0){
		                	cpu.setAccum(1);
		                }else{
		                	cpu.setAccum(0);
		                }
		                cpu.incrPC();
		            }
		        });


				//JUMP
				IMAP.put(0xB,(arg, level) -> {
		            if(level < 0 || level > 3) {
		                throw new IllegalArgumentException("Illegal indirection level in JUMP instruction");
		            }
		            else if(level == 3)
		            {
						int arg1 = memory.getData(arg);
						cpu.setpCounter(arg1 + currentJob.getStartcodeIndex());
					}else
		            if (level > 0) {
		            	IMAP.get(0xB).execute(memory.getData(arg), level-1);
		            } else{
		                cpu.setpCounter(cpu.getpCounter() + arg);
		            }
		        });

				//JUMPI
				/*IMAP.put(0xB, (arg, level)-> {
					if(level !=0 ) {
		                throw new IllegalArgumentException("Illegal indirection level in JUMPI instruction");
		            }else{
					cpu.setpCounter(cpu.getpCounter() + arg);
		            }
				});*/

				//JUMPA
			/*	IMAP.put(0xB,(arg, level) -> {
		            if(level < 0 || level > 1) {
		                throw new IllegalArgumentException("Illegal indirection level in JUMPA instruction");
		            }
		            if (level > 0) {
		            	IMAP.get(0xB).execute(memory.getData(arg), level-1);
		            } else {
		                cpu.setpCounter(cpu.getpCounter() + arg);
		            }
		        });*/


				//JMPZ
				IMAP.put(0xC,(arg, level) -> {
		            if(level < 0 || level > 1) {
		                throw new IllegalArgumentException("Illegal indirection level in JMPZ instruction");
		            }
		            if (level > 0) {
		            	IMAP.get(0xC).execute(memory.getData(arg), level-1);
		            } else {
		                if(cpu.getAccum() == 0){
		                	//cpu.setpCounter(cpu.getpCounter() + arg);
							int arg1 = memory.getData(arg);
		                	cpu.setpCounter(arg1 + currentJob.getStartcodeIndex());
		                }else{
		                	cpu.incrPC();
		                }
		            }
		        });


				//JMPZI
				IMAP.put(0xC,  (arg, level) -> {
					if(level !=0 ) {
		                throw new IllegalArgumentException("Illegal indirection level in JMPZI instruction");
		            }else{
					if (cpu.getAccum() == 0) {
						cpu.setpCounter(cpu.getpCounter() + arg);
					} else {
						cpu.incrPC();
					}
		            }
				});

				//JMPZA
				IMAP.put(0xC,(arg, level) -> {
		            if(level < 0 || level > 1) {
		                throw new IllegalArgumentException("Illegal indirection level in JMPZA instruction");
		            }
		            if (level > 0) {
		            	IMAP.get(0xC).execute(memory.getData(arg), level-1);
		            } else {
		                if(cpu.getAccum() == 0){
		                	cpu.setpCounter(cpu.getpCounter() + arg);
		                }else{
		                	cpu.incrPC();
		                }
		            }
		        });

				//HALT
				IMAP.put(0xF,(arg, level) -> {
					callback.halt();
		        });

				callback = h;

				jobs[0] = new Job();
				jobs[1] = new Job();
				jobs[2] = new Job();
				jobs[3] = new Job();

				currentJob = jobs[0];

				for(int i=0; i<jobs.length; i++){
					jobs[i].setId(i);
					jobs[i].setStartcodeIndex(i*Code.CODE_MAX/4);
					jobs[i].setStartmemoryIndex(i*Memory.DATA_SIZE/4);
					jobs[i].getCurrentState().enter();
				}

	}

	public int getData(int i) {
		return memory.getData(i);
	}

	public void setData(int index, int value) {
		memory.setData(index, value);
	}

	public int[] getData() {
		return memory.getData();
	}

	public Instruction get(Integer key) {
		return IMAP.get(key);
	}

	public int getpCounter() {
		return cpu.getpCounter();
	}

	public int getAccum() {
		return cpu.getAccum();
	}

	public int getMemBase() {
		return cpu.getMemBase();
	}

	public void setpCounter(int instructionPointer) {
		cpu.setpCounter(instructionPointer);
	}

	public void setAccum(int accumulator) {
		cpu.setAccum(accumulator);
	}

	public void setMemBase(int memoryBase) {
		cpu.setMemBase(memoryBase);
	}

	public Code getCode() {
		return code;
	}

	public void setCode(int index, int op, int indirLvl, int arg)  {
		code.setCode(index, op,indirLvl, arg);
	}

	public Job getCurrentJob() {
		return currentJob;
	}

	public int getChangedIndex() {
		return memory.getChangedIndex();
	}

	public States getCurrentState() {
		return currentJob.getCurrentState();
	}

	public void setCurrentState(States currentState) {
		currentJob.setCurrentState(currentState);
	}

	public void changeToJob(int i){
		if(i<0 || i>3) {
			throw new IllegalArgumentException("illegal argument for changing jobs");
		}
		if(i!=currentJob.getId()){
			currentJob.setCurrentAcc(cpu.getAccum());
			currentJob.setCurrentPC(cpu.getpCounter());
			currentJob = jobs[i];
			cpu.setAccum(currentJob.getCurrentPC());
			cpu.setpCounter(currentJob.getCurrentAcc());
			cpu.setMemBase(currentJob.getStartmemoryIndex());
		}
	}

	public void clearJob(){
		memory.clear(currentJob.getStartmemoryIndex(),
				currentJob.getStartmemoryIndex()+Memory.DATA_SIZE/4);
		code.clear(currentJob.getStartcodeIndex(),
				currentJob.getStartcodeIndex()+currentJob.getCodeSize());
		cpu.setAccum(0);
		cpu.setpCounter(currentJob.getStartcodeIndex());
		currentJob.reset();
	}

	public void step(){
		try{
			int pc = cpu.getpCounter();
			if(pc<currentJob.getStartcodeIndex() ||
					pc>=currentJob.getStartcodeIndex()+currentJob.getCodeSize()){
				throw new CodeAccessException("Program Counter is out of bounds");
			}
			int opcode = code.getOp(pc);
			int arg = code.getArg(pc);
			int indirLvl = code.getIndirLvl(pc);
			get(opcode).execute(arg, indirLvl);
		} catch(Exception e){
			callback.halt();
			throw e;
		}
	}

}