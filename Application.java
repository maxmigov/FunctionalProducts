import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Application {

    @FunctionalInterface
    interface VATFunction extends Function<Product, Product> {
        Product apply(Product product);
    }

    @FunctionalInterface
    interface IsHealthPredicate extends Predicate<Product> {
        boolean test(Product product);
    }

    @FunctionalInterface
    interface IsSHPredicate extends Predicate<Product> {
        boolean test(Product product);
    }

    @FunctionalInterface
    interface ConsolePrintConsumer extends Consumer<Product> {
        void accept(Product product);
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

        IsHealthPredicate p1 = product -> !product.getCategory().equals("Second Hand");
        IsSHPredicate p2 = product -> !product.getCategory().equals("Health");

        VATFunction v1 = product -> {
            product.setPrice(product.getPrice() + product.getPrice() * 0.18f % 100);
            return product;
        };

        ConsolePrintConsumer c1 = product -> System.out.println(product);

        list.stream()
                .filter(p1)
                .filter(p2)
                .map(v1)
                .forEach(c1);
    }
}
