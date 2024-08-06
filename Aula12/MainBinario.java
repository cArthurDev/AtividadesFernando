public class MainBinario {
    public static void main(String[] args) {
        DecimalBinario decimalBinario = new DecimalBinario();
        System.out.println(decimalBinario.decimalParaBinario(73));
        System.out.println(decimalBinario.decimalParaBinario(255));
        System.out.println(decimalBinario.decimalParaBinario(1023));
        System.out.println(decimalBinario.decimalParaBinario(591));
        System.out.println(decimalBinario.decimalParaBinario(1));
        System.out.println(decimalBinario.decimalParaBinario(0));
    }
}