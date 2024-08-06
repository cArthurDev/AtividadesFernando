// Não especificou se deveria utilizar recursão ou não
// 4) Um problema típico em ciência da computação consiste em converter um número da sua forma
//    decimal para a forma binária.
public class DecimalBinario {
    public int decimalParaBinario(int decimal) {
        return Integer.parseInt(Integer.toBinaryString(decimal));
    }
}
