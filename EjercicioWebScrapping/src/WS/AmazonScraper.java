package WS;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AmazonScraper {
    public static void main(String[] args) {
        // URL de la página de búsqueda de Amazon
        String url = "https://www.amazon.com/s?k=juegos";

        try {
            // Conexión y obtención del documento HTML
            Document document = Jsoup.connect(url).get();

            // Seleccionar todos los elementos de productos en la página
            Elements productElements = document.select(".s-result-item");

            // Crear un nuevo archivo CSV para guardar los resultados
            BufferedWriter writer = new BufferedWriter(new FileWriter("productos_amazon.csv"));

            // Escribir la línea de encabezado en el archivo CSV
            writer.write("Título, Precio (€)\n");

            // Recorrer los elementos de productos y extraer el título y el precio
            for (Element productElement : productElements) {
                // Obtener el título del producto
                Element titleElement = productElement.select("span.a-text-normal").first();
                String title = titleElement != null ? titleElement.text() : "N/A";

                // Obtener el precio del producto
                Element priceElement = productElement.select("span.a-offscreen").first();
                String price = priceElement != null ? convertPriceToEUR(priceElement.text()) : "N/A";

                // Escribir los datos en el archivo CSV
                writer.write(title + ", " + price + "\n");
            }

            // Cerrar el archivo CSV
            writer.close();

            System.out.println("Los datos se han guardado exitosamente en el archivo 'productos_amazon.csv'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertPriceToEUR(String price) {
        // Obtener el valor numérico del precio
        double amount = Double.parseDouble(price.replace("$", "").trim());

        // Convertir el precio de dólares a euros
        double convertedAmount = amount * 0.85; // Tasa de conversión USD a EUR

        // Formatear el precio y agregar el símbolo de euros
        return String.format("%.2f€", convertedAmount);
    }
}

