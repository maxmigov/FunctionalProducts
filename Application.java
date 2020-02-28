import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Application {

    @FunctionalInterface
    interface VATFunction {
        Product calculate(Product product);

    }

    @FunctionalInterface
    interface IsHealthPredicate {
        boolean test(Product product);
    }

    @FunctionalInterface
    interface IsSHPredicate {
        boolean test(Product product);
    }

    @FunctionalInterface
    interface ConsolePrintConsumer {
        void consume(Product product);
    }

    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        Product item1 = new Product("Health", "Xiaomi Mi Band 4",  45.00f, 4500);
        Product item2 = new Product("Shoes", "Adidas Shoes",  49.90f, 100);
        Product item3 = new Product("Underwear", "Tezenis Briefs",  7.90f, 2500);
        Product item4 = new Product("Second Hand", "H&M Trousers",  25.90f, 300);
        Product item5 = new Product("Shoes", "Skechers Shoes",  40.90f, 150);

        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);

       /* IsHealthPredicate p1 = product -> "Health".equals(product.getCategory());
        IsSHPredicate p2 = product -> "Second Hand".equals(product.getCategory());


        VATFunction function = new VATFunction -> {
            float tax = (tax * 118) / 100;
            return tax;
        }

        */
        Stream<Object> object = list.stream()
                .filter( (name) -> !name.getCategory().equals("Second Hand"))
                .filter( (name) -> !name.getCategory().equals("Health"))
                .map((name) -> name.getPrice())


    }

}
