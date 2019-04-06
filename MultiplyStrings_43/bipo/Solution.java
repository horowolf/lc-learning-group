package MultiplyStrings_43.bipo;

class Solution {


    //110 110
    //int 2^32 . double 2^64
    //110 = 10^110
    //123 * 456 = 6, 999 * 999 < 1000* 1000 <10^6
    // 220
    //2^10 = 1024 1000 10 ^3

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] product = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';

                int left = i + j;
                int right = i + j + 1;

                int temp = a * b;
                int sum = temp + product[right];


                product[left] += sum / 10;
                product[right] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : product) {
            if (!(sb.length() == 0 && n == 0))
                sb.append(n);
        }

        return sb.toString();
    }


}