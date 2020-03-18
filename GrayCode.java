public class GrayCode {
  public static void main(String[] args) {
    GrayCode gc = new GrayCode();

    // Print out the gray code for 4 bits
    int bits = 4;
    for (String line : gc.getGrayCode(bits)) {
      System.out.println(line);
    }
  }

  // Returns an array, each element is a line of the gray code
  private String[] getGrayCode(int bits) {
    // Base case, the 0 gray code is empty
    if (bits == 0) {
      return new String[]{""};
    }

    // Get the gray code for a bit value of one less
    String[] previousGrayCode = getGrayCode(bits - 1);

    // Create a new array of size 2 ^ n elements (for n bits)
    String[] grayCode = new String[(int)Math.pow(2, bits)];

    // Loop through all the previous gray code lines
    // Append a 1/0 at the correct place in the current gray code
    for (int i = 0; i < previousGrayCode.length; i++) {
      grayCode[i] = "0" + previousGrayCode[i];
      grayCode[grayCode.length - i - 1] = "1" + previousGrayCode[i];
    }

    return grayCode;
  }
}