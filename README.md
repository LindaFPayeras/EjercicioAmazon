# EjercicioAmazon
Este proyecto es una aplicación de scraping en Java que utiliza la biblioteca Jsoup para extraer información de la primera página de resultados de búsqueda de Amazon. La aplicación realiza una búsqueda de productos relacionados con "juegos" y guarda los resultados en un archivo CSV, que incluye el título del producto y su precio en euros.

## Requisitos
Java 8 o superior
Biblioteca Jsoup (https://jsoup.org/)
## Uso
Asegúrate de tener Java instalado en tu sistema.
Descarga la biblioteca Jsoup desde el sitio web oficial e inclúyela en tu proyecto.
Clona este repositorio o descarga el archivo del código fuente.
Abre el proyecto en tu entorno de desarrollo Java preferido.
Modifica la URL de búsqueda si deseas buscar términos diferentes. Puedes cambiarla en la variable url en el archivo AmazonScraper.java.
Ejecuta la clase AmazonScraper para iniciar el proceso de scraping.
Una vez completado, los datos se guardarán en un archivo llamado productos_amazon.csv en el directorio raíz del proyecto. (Se recomienda abrirlo con el editor de texto)
El archivo CSV generado contendrá dos columnas: "Título" y "Precio (€)". Cada línea representa un producto de Amazon encontrado en la página de resultados de búsqueda.
## Licencia
Este proyecto se distribuye bajo la licencia MIT. Consulta el archivo LICENSE para obtener más información.
