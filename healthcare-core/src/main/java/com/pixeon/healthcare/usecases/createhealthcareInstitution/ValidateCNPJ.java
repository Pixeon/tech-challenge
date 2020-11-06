package com.pixeon.healthcare.usecases.createhealthcareInstitution;

public class ValidateCNPJ {

    public static boolean isCNPJ(String cnpj) {
        if (!cnpj.substring(0, 1).equals("")) {
            try {
                cnpj = removeCharacters(cnpj);
                int sum = 0;
                int digit;
                String cnpj_calc = cnpj.substring(0, 12);

                if (cnpj.length() != 14) {
                    return false;
                }
                char[] chr_cnpj = cnpj.toCharArray();

                for (int i = 0; i < 4; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        sum += (chr_cnpj[i] - 48) * (6 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                        sum += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                    }
                }
                digit = 11 - (sum % 11);
                cnpj_calc += (digit == 10 || digit == 11) ? "0" : Integer.toString(
                        digit);

                sum = 0;
                for (int i = 0; i < 5; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        sum += (chr_cnpj[i] - 48) * (7 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                        sum += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                    }
                }
                digit = 11 - (sum % 11);
                cnpj_calc += (digit == 10 || digit == 11) ? "0" : Integer.toString(
                        digit);
                return cnpj.equals(cnpj_calc);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    private static String removeCharacters(String cnpj) {
        cnpj = cnpj.replace('.', ' ');
        cnpj = cnpj.replace('/', ' ');
        cnpj = cnpj.replace('-', ' ');
        cnpj = cnpj.replaceAll(" ", "");
        return cnpj;
    }

}
