# Amazon Gateway y Lambda

## 1. Usando Amazon Gateway y lambda crear un servicio que reciba un parámetro numérico y retorne el cuadrado del número.

1.1 En Amazon Gateway verificamos la API creada en nuestro caso llamada "mathServices"

![Captura1](https://user-images.githubusercontent.com/48154086/77790686-41ee4a00-7033-11ea-9fc3-c7a0ab2b0a26.PNG)

1.2 Damos click en la opción implementar API como se muestra a continuación:

![Captura2](https://user-images.githubusercontent.com/48154086/77790690-4450a400-7033-11ea-82e3-70a8a286f80c.PNG)

1.3 En la etapa de Implementación colocamos la opción Beta y continuamos con el despliegue de la api

![Captura3](https://user-images.githubusercontent.com/48154086/77790693-44e93a80-7033-11ea-84e3-85a8957731e6.PNG)

1.4 A continuación se muestra el enlace en el cual estará disponible nuestra API. 

![Captura4](https://user-images.githubusercontent.com/48154086/77790695-4581d100-7033-11ea-8284-6ab5274b734d.PNG)

1.5 Volvemos a la consola de administración de AWS y buscamos el servicio Lambda. 

![Captura5](https://user-images.githubusercontent.com/48154086/77790698-46b2fe00-7033-11ea-966a-cee339061ea1.PNG)

1.6 En el servicio Lambda nos dirigimos a funciones y aquí tenemos la función llamada "square".

![Captura6](https://user-images.githubusercontent.com/48154086/77790699-474b9480-7033-11ea-82d1-3a5636fbdbf6.PNG)

1.7 Entramos a la función square

![Captura7](https://user-images.githubusercontent.com/48154086/77790702-49155800-7033-11ea-8532-2ab3cb4622c3.PNG)

1.8 Entramos a la url anteriormente proporcionada y para verificar su correcto funcionamiento agregamos a la url lo siguiente ?value=25, en este caso 25 será el número del que queremos determinar el cuadrado.  

![Captura8](https://user-images.githubusercontent.com/48154086/77790704-4a468500-7033-11ea-84e4-729c2f27af15.PNG)

## 2. Crear una máquina virtual Linux en AWS

2.1 Entramos al servicio de EC2 para verificar nuestra instancia.

![Captura9](https://user-images.githubusercontent.com/48154086/77794253-8da3f200-7039-11ea-8df6-e2e00e2118c2.PNG)

2.2 Realizamos la conexión a nuestra instancia.

![Captura11](https://user-images.githubusercontent.com/48154086/77794254-8e3c8880-7039-11ea-800b-50ae1566cf28.PNG)

2.3 Utilizando Git Bash nos conectamos a la máquina creada en EC2.

![Captura12](https://user-images.githubusercontent.com/48154086/77805569-365d4c00-7050-11ea-8f45-667820544125.PNG)

## 3. Crear una aplicación WEB, usando Spark, Que tenga un formulario que le pida al usuario un número y le regrese el cuadrado del mismo. Esta se debe desplegar en AWS. OJO: La aplicación Web debe usar el servicio de de Amazon GateWay para calcular el valor. Configure la aplicación dentro de un grupo de autoescalabilidad.

Creamos una aplicación web usando Spark la cual le solicita al usuario un numero para calcular el cuadrado y luego utilizamos la conexión al API creado en AWS. 

``` java
    
     */
    public class MathServices {
      private static URL url;

      public static void main(String[] args) {
          port(getPort());
          get("/inputdata", (req, res) -> inputDataPage(req, res));
          get("/results", (req, res) -> {
              res.type("application/json");
              return resultDataPage(req,res);
          });
      }

      public static Integer square(Integer i) {
          return i * i;
      }


      private static String resultDataPage(Request req, Response res) {
        int num = Integer.parseInt(req.queryParams("numero"));
        String text = "";
        try {
            url = new URL("https://svz7imsuh3.execute-api.us-east-1.amazonaws.com/Beta" + "?value=" + num);
            String temp;
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            while ((temp = reader.readLine()) != null) {
                text = text + temp;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MathServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MathServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return text;
    }



      /**
       * Este metodo recibe los datos que el usuario desea agregar a la Linked
       * List
       *
       * @param req
       * @param res
       * @return pageC
       */
      private static String inputDataPage(Request req, Response res) {
          String pageC
                  = "<!DOCTYPE html>"
                  + "<html>"
                  + "<body>"
                  + "<h2>Bandeja de entrada de los numeros:</h2>"
                  + "<h2>Introduzca el numero para calcular el cuadrado</h2>"
                  + "<form action='/resultados\'>"
                  + "<input type=\"text\" name='data'>"
                  + "<input type=\"submit\" value=\"Continue\">"
                  + "</form>"
                  + "</body>"
                  + "</html>";
          return pageC;
      }

      static int getPort() {
          if (System.getenv("PORT") != null) {
              return Integer.parseInt(System.getenv("PORT"));
          }
          return 4567;
    }
    
```



