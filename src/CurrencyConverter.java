
import java.util.*;
import java.io.*;
public class CurrencyConverter{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to Currency Convertor");
        System.out.println("Available Currencies: USD, EUR, GBP");
        System.out.println("Enter the amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        
        System.out.println("Enter the base currency(e.g.; USD, EUR, GBP) : ");
        String baseCurrency = sc.nextLine().toUpperCase();
        
        System.out.println("Enter the target currency(e.g.; USD, EUR, GBP) : ");
        String targetCurrency = sc.nextLine().toUpperCase();
        
        double result = convertCurrency(amount, baseCurrency, targetCurrency);
        
        if(result == -1){
            System.out.println("Invalid currencies entered. Conversion failed.");
        }else{
            System.out.println(amount + " " + baseCurrency + " = " + result + " " + targetCurrency);
        }
        sc.close();
    }
    public static double convertCurrency(double amount, String fromCurrency, String toCurrency){
        double usdToEurRate=0.85;
        double usdToGbpRate=0.75;
        
        double eurToUsdRate = 1.18;
        double eurToGbpRate = 0.88;

        double gbpToUsdRate = 1.33;
        double gbpToEurRate = 1.14;
        
        switch(fromCurrency){
            case "USD":
                switch(toCurrency){
                    case "EUR":
                        return amount*usdToEurRate;
                    case "GBP":
                        return amount*usdToGbpRate;
                    default:
                        return -1;
                }
            case "EUR":
                switch (toCurrency) {
                    case "USD":
                        return amount * eurToUsdRate;
                    case "GBP":
                        return amount * eurToGbpRate;
                    default:
                        return -1;
                }
            case "GBP":
                switch (toCurrency) {
                    case "USD":
                        return amount * gbpToUsdRate;
                    case "EUR":
                        return amount * gbpToEurRate;
                    default:
                        return -1;
                }
            default:
                return -1;
        }
}
}