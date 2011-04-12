package Core.Algorithms;

import java.io.Serializable;

public enum QuantumInstructionEnum implements Serializable {
	// Gate instructions
	Create_H, // 0
	Create_X, // 1
	Create_Y, // 2
	Create_Z, // 3
	Create_P, // 4
	Create_SWAP, // 5
	Create_V, // 6
	Create_W, // 7
	Create_RX, // 8
	Create_RY, // 9
	Create_RZ, // 10
	// Control instructions
	Iterate, // 11
	RevIterate, // 12
	Body, // 13
	// Root,
	Create_CH, // 14
	Create_CX, // 15
	Create_CCX, // 15
	Create_CY, // 16
	Create_CZ, // 17
	Create_CP, // 18
	Create_CRX, // 19
	Create_CW, // 20
	Create_CV, // 21
	Create_CRZ, // 22
	Create_CRY, // 23
	Create_Zero, // 24
	// Custom Gates
	Create_Custom1, // 25
	Create_Custom2, // 26
	Create_Custom3, // 27
	Create_CCustom1, // 28
	Create_CCustom2, // 29
	Create_CCustom3;// 30
	public static QuantumInstructionEnum[] getControl() {
		QuantumInstructionEnum[] stand = new QuantumInstructionEnum[11];
		int i = 0;
		stand[i++] = Create_CH;
		stand[i++] = Create_CX;
		stand[i++] = Create_CCX;
		stand[i++] = Create_CY;
		stand[i++] = Create_CZ;
		stand[i++] = Create_CP;
		stand[i++] = Create_CRX;
		stand[i++] = Create_CRY;
		stand[i++] = Create_CRZ;
		stand[i++] = Create_CW;
		stand[i++] = Create_CV;
		return stand;
	}

	public static QuantumInstructionEnum[] getCustom() {
		QuantumInstructionEnum[] cust = new QuantumInstructionEnum[6];
		cust[0] = Create_Custom1;
		cust[1] = Create_CCustom1;
		cust[2] = Create_Custom2;
		cust[3] = Create_CCustom2;
		cust[4] = Create_Custom3;
		cust[5] = Create_CCustom3;

		return cust;
	}

	public static QuantumInstructionEnum[] getFlowControl() {
		QuantumInstructionEnum[] stand = new QuantumInstructionEnum[3];
		int i = 0;
		stand[i++] = Iterate;
		stand[i++] = RevIterate;
		stand[i++] = Body;
		return stand;
	}

	public static QuantumInstructionEnum[] getStandard() {
		QuantumInstructionEnum[] stand = new QuantumInstructionEnum[12];
		int i = 0;
		stand[i++] = Create_H;
		stand[i++] = Create_X;
		stand[i++] = Create_Y;
		stand[i++] = Create_Z;
		stand[i++] = Create_P;
		stand[i++] = Create_V;
		stand[i++] = Create_W;
		stand[i++] = Create_RX;
		stand[i++] = Create_RY;
		stand[i++] = Create_RZ;
		stand[i++] = Create_SWAP;
		stand[i++] = Create_Zero;

		return stand;
	}

	public static boolean hasPhase(QuantumInstructionEnum i) {
		switch (i) {
			case Create_P:
			case Create_RX:
			case Create_RY:
			case Create_RZ:
			case Create_CP:
			case Create_CRX:
			case Create_CCX:
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
			case Create_CCX:
			case Create_CY:
			case Create_CZ:
			case Create_SWAP:
			case Create_CCustom1:
			case Create_CCustom2:
			case Create_CCustom3:
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