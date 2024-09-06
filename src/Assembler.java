

import java.util.Scanner;

public class Assembler {
    
    private static final boolean TEST_MODE = false;
    
    public static void main(String[] args) {
        int count = 0;

        if (TEST_MODE) {
            testCases();
        } else {

            System.out.println("Assembler - Paul Olson\n");

            /*  Enter assembly code here */

            Scanner input = new Scanner(System.in);

            System.out.println("Enter assembly code to translate to machine code: ");
            System.out.println("Enter 'HALT' to quit.");

            String line;
            do {
                System.out.print("> ");
            line = input.nextLine().trim();

            if (!line.equalsIgnoreCase("HALT")) {
                
                String[] token = line.split(" ");
                
                String opcode = token[0].toUpperCase();
                int machineCode = 0;

                switch (opcode) {
                    case "ADD":
                        machineCode = ADD(token[1], token[2], token[3]);
                        break;
                    case "AND":
                        machineCode = AND(token[1], token[2], token[3]);
                        break;
                    case "SLL":
                        machineCode = SLL(token[1], token[2], token[3]);
                        break;
                    case "SRL":
                        machineCode = SRL(token[1], token[2], token[3]);
                        break;
                    case "ADDI":
                        machineCode = ADDI(token[1], token[2], token[3]);
                        break;
                    case "ANDI":
                        machineCode = ANDI(token[1], token[2], token[3]);
                        break;
                    case "BEQ":
                        machineCode = BEQ(token[1], token[2], token[3]);
                        break;
                    case "LW":
                        machineCode = LW(token[1], token[2], token[3]);
                        break;
                    case "SW":
                        machineCode = SW(token[1], token[2], token[3]);
                        break;
                    default:
                        System.out.println("Invalid opcode: " + opcode);
                        continue;
                }

                String hexCode = Integer.toHexString(machineCode).toUpperCase();
                
                System.out.println("Machine code (decimal): " + machineCode);
                System.out.println("Machine code (hex): 0x" + String.format("%8s", hexCode).replace(' ', '0'));
                System.out.println("Binary code: " + String.format("%32s", Integer.toBinaryString(machineCode)).replace(" ", "0"));

                count++;
            }
         } while (!line.equalsIgnoreCase("HALT"));



            System.out.println("\n*** Assembly complete. Program required " + count + " words of memory.");
            input.close();
        }
    }

    private static int makeR(byte opcode, byte rs, byte rt, byte rd, byte shamt, byte funct) {
        int returnValue = 0;
        
        returnValue |= (opcode) << 26;
        returnValue |= (rs) << 21;
        returnValue |= (rt) << 16;
        returnValue |= (rd) << 11;
        returnValue |= (shamt) << 6;
        returnValue |= (funct) << 0;

        return returnValue;
    }

    private static int makeI(byte opcode, byte rs, byte rt, short immed) {
        int returnValue = 0;
        
        returnValue |= (opcode) << 26;
        returnValue |= (rs) << 21;
        returnValue |= (rt) << 16;
        returnValue |= (immed & 65535) << 0;

        return returnValue;
    }

    private static byte regToByte(String r) {
        byte returnValue = 0;

        switch (r.toUpperCase()) {
            case "$ZERO":
                returnValue = 0;
                break;
            case "$AT":
                returnValue = 1;
                break;
            case "$V0":
                returnValue = 2;
                break;
            case "$V1":
                returnValue = 3;
                break;
            case "$A0":
                returnValue = 4;
                break;
            case "$A1":
                returnValue = 5;
                break;
            case "$A2":
                returnValue = 6;
                break;
            case "$A3":
                returnValue = 7;
                break;
            case "$T0":
                returnValue = 8;
                break;
            case "$T1":
                returnValue = 9;
                break;
            case "$T2":
                returnValue = 10;
                break;
            case "$T3":
                returnValue = 11;
                break;
            case "$T4":
                returnValue = 12;
                break;
            case "$T5":
                returnValue = 13;
                break;
            case "$T6":
                returnValue = 14;
                break;
            case "$T7":
                returnValue = 15;
                break;
            case "$T8":
                returnValue = 24;
                break;
            case "$T9":
                returnValue = 25;
                break;
            case "$S0":
                returnValue = 16;
                break;
            case "$S1":
                returnValue = 17;
                break;
            case "$S2":
                returnValue = 18;
                break;
            case "$S3":
                returnValue = 19;
                break;
            case "$S4":
                returnValue = 20;
                break;
            case "$S5":
                returnValue = 21;
                break;
            case "$S6":
                returnValue = 22;
                break;
            case "$S7":
                returnValue = 23;
                break;
            default:
        }

        return returnValue;
    }
    
    /*  R-Type Instructions */

    private static int ADD(String rd, String rs, String rt) {
        byte rdReg = regToByte(rd);
        byte rsReg = regToByte(rs);
        byte rtReg = regToByte(rt);
        
       return makeR((byte) 0,(byte) rsReg,(byte) rtReg,(byte) rdReg,(byte) 0,(byte) 32);
    }

    private static int AND(String rd, String rs, String rt) {
        byte rdReg = regToByte(rd);
        byte rsReg = regToByte(rs);
        byte rtReg = regToByte(rt);

        return makeR((byte) 0,(byte) rsReg,(byte) rtReg,(byte) rdReg,(byte) 0,(byte) 36);
    }

    private static int SLL(String rd, String rt, String shamt) {
        byte rdReg = regToByte(rd);
        byte rtReg = regToByte(rt);
        byte shamtReg = Byte.parseByte(shamt);

        return makeR((byte) 0,(byte) 0,(byte) rtReg,(byte) rdReg,(byte) shamtReg,(byte) 0);
    }

    private static int SRL(String rd, String rt, String shamt) {
        byte rdReg = regToByte(rd);
        byte rtReg = regToByte(rt);
        byte shamtReg = Byte.parseByte(shamt);

        return makeR((byte) 0,(byte) 0,(byte) rtReg,(byte) rdReg,(byte) shamtReg,(byte) 2);
    }

    /* I-Type Instructions */

    private static int ADDI(String rt, String rs, String immed) {
        byte rsReg = regToByte(rs);
        byte rtReg = regToByte(rt);
        short immedVal = Short.parseShort(immed);

        return makeI((byte) 8,(byte) rsReg,(byte) rtReg, immedVal);
    }
    
    private static int ANDI(String rt, String rs, String immed) {
        byte rtReg = regToByte(rt);
        byte rsReg = regToByte(rs);
        short immedVal = Short.parseShort(immed);

        return makeI((byte) 12,(byte) rsReg,(byte) rtReg, immedVal);
    }

    private static int BEQ(String rs, String rt, String branchAddr) {
        byte rsReg = regToByte(rs);
        byte rtReg = regToByte(rt);
        short branchAddrVal = Short.parseShort(branchAddr);

        return makeI((byte) 4,(byte) rsReg,(byte) rtReg, branchAddrVal);
    }

    private static int LW(String rt, String immed, String rs) {
        byte rtReg = regToByte(rt);
        short immedVal = Short.parseShort(immed);
        byte rsReg = regToByte(rs);
        

        return makeI((byte) 35,(byte) rsReg,(byte) rtReg, immedVal);
    }

    private static int SW(String rt, String immed, String rs) {
        byte rtReg = regToByte(rt);
        short immedVal = Short.parseShort(immed);
        byte rsReg = regToByte(rs);
        

        return makeI((byte) 43,(byte) rsReg,(byte) rtReg, immedVal);
    }



    /*************************************************************
	 *
	 *   Test Code below
	 *   Do NOT modify
	 * 
	 ************************************************************/
	
	private static void testCases() {
		if (test_regToByte())
			System.out.println("RegToByte working well\n");
		else
			System.out.println("RegToByte failed\n");

		if (test_makeR())
			System.out.println("makeR working well\n");
		else
			System.out.println("makeR failed\n");

		if (test_makeI())
			System.out.println("makeI working well\n");
		else
			System.out.println("makeI failed\n");
	}

	private static boolean test_regToByte() {
		boolean passedTest = true;
		String[] regs = { "$ZERO", "$AT", "$V0", "$V1", "$A0", "$A1", "$A2", "$A3", "$T0", "$T1", "$T2", "$T3", "$T4",
				"$T5", "$T6", "$T7", "$S0", "$S1", "$S2", "$S3", "$S4", "$S5", "$S6", "$S7", "$T8", "$T9" };

		for (int i = 0; i < regs.length; i++) {
			passedTest &= testReg(regs[i], i);
		}

		return passedTest;
	};

	private static boolean testReg(String regName, int expValue) {
		if (regToByte(regName) != expValue) System.out.printf("Fail: regToByte(\"%s\") = %d, should be %d\n", regName, regToByte(regName), expValue);
		return regToByte(regName) == expValue;
	}

	private static boolean test_makeR() {
		boolean passedTest = true;
		
		int i = makeR((byte) 1, (byte) 1,(byte) 1,(byte) 1,(byte) 1,(byte) 1);
		if (i != 0b00000100001000010000100001000001) {
			System.out.println("Test: makeR(1,1,1,1,1,1) = " + Integer.toBinaryString(i) + " failed");
			passedTest = false;
		}

		i = makeR((byte) 63, (byte) 0,(byte) 31,(byte) 0,(byte) 31,(byte) 0);
		if (i != 0b11111100000111110000011111000000) {
			System.out.println("Test: makeR(63,0,31,0,31,0) = " + Integer.toBinaryString(i) + " failed");
			passedTest = false;
		}

		return passedTest;
	};

	private static boolean test_makeI() {
		boolean passedTest = true;
		
		int i = makeI((byte) 1, (byte) 1,(byte) 1,(short) 1);
		if (i != 0b00000100001000010000000000000001) {
			System.out.println("Test: makeI(1,1,1,1) = " + Integer.toBinaryString(i) + " failed");
			passedTest = false;
		}

		i = makeI((byte) 63, (byte) 0,(byte) 31,(short) 0);
		if (i != 0b11111100000111110000000000000000) {
			System.out.println("Test: makeI(63,0,31,0) = " + Integer.toBinaryString(i) + " failed");
			passedTest = false;
		}

		i = makeI((byte) 63, (byte) 0,(byte) 31,(short) -1);
		if (i != 0b11111100000111111111111111111111) {
			System.out.println("Test: makeI(63,0,31,-1) = " + Integer.toBinaryString(i) + " failed");
			passedTest = false;
		}

		return passedTest;
	};

    
}