package Core.Algorithms;

public enum QuantumInstructionEnum {
	// Gate instructions
	Create_H,
	Create_X,
	Create_Y,
	Create_Z,
	Create_P,
	Create_SWAP,
	Create_V,
	Create_W,
	Create_RX,
	Create_RY,
	Create_RZ,
	// Control instructions
	Iterate,
	Body,
	// Root,
	Create_CH,
	Create_CX,
	Create_CY,
	Create_CZ,
	Create_CP,
	Create_CRX,
	Create_CW,
	Create_CV,
	Create_CRZ,
	Create_CRY,
	Create_Zero;
	public static boolean hasPhase(QuantumInstructionEnum i) {
		switch (i) {
			case Create_P:
			case Create_RX:
			case Create_RY:
			case Create_RZ:
			case Create_CP:
			case Create_CRX:
			case Create_CRY:
			case Create_CRZ:
				return true;
			default:
				return false;
		}

	}

	public static boolean hasSecondQubit(QuantumInstructionEnum i) {
		switch (i) {
			case Create_CH:
			case Create_CP:
			case Create_CRX:
			case Create_CRY:
			case Create_CRZ:
			case Create_CV:
			case Create_CW:
			case Create_CX:
			case Create_CY:
			case Create_CZ:
			case Create_SWAP:
				return true;
			default:
				return false;
		}

	}

	// public static boolean isControl(QuantumInstructionEnum i) {
	// switch (i) {
	// case Iterate:
	// case Body:
	// case Root:
	// return true;
	// default:
	// return false;
	// }
	//
	// }
}