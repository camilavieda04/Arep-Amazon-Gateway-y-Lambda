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

