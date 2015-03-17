package nl.vinyamar.algorithms;

public class Bits {

    public static void main(String[] args) {
        // bitcount
        long count1 = Integer.toBinaryString(2000000000).chars().filter(s -> s == 49).count();
        int count2 = Integer.bitCount(11);
        System.out.println(count1 + "," + count2);

        // reverse bits
        String bitString = String.format("%32s",Integer.toBinaryString(43261596)).replace(" ","0");
        String reversedBitSting = new StringBuilder(bitString).reverse().toString();
        int i = Integer.parseInt(new StringBuilder(String.format("%32s",Integer.toBinaryString(43261596)).replace(" ","0")).reverse().toString(), 2);
        System.out.println(bitString + " " + reversedBitSting + " " + i);
    }
}
