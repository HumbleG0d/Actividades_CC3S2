## Creancion del entor CI / CD
### Configuracion del entorno CI
1. **Iniciamos el proyecto Node.js**

    Creamos nuestra carpeta `devops_practice` , dentro de ella ejecutamos el comando

    ```shell
    npm init -y
    ```
    para iniciar nuestro proyecto.

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/init.png)

2. **Instalación de las dependencias necesarias**

    Instalamos el framework `Express` de Node y tambien `Jest` para las pruebas.

    ```shell
     npm install express jest 
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/express.png)

    Tambien instalamos la biblioteca `supertest` para las pruebas automatizadas ya que usamos Express.

    ```shell
        npm install supertest --save-dev
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/supertest.png)

3. **Creamos la estructura de nuestro proyecto**

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/estructura.png)

4. **Implementación la API REST**

    Creamos una aplicación web basica `app.js`. Esta aplicación muestra el texto `Hello World` al recibir una solicitud  **GET**.

    ```js
    const express = require('express');
    const app = express();

    app.get('/', (req, res) => {
        res.send('Hello World');
    });

    module.exports = app; 
    ```
    Inciamos un servidor `server.js` para nuestra aplicación. En este servidor definimos el puerto 3000 para que la aplicación escuche. Mostramos un mensaje para confirmar que el servidor está funcionando y en que puerto está escuchando.

    ```js
        const app = require('./app');

        const port = process.env.PORT || 3000;
        app.listen(port, () => {
            console.log(`Server running on port ${port}`);
        });
    ```

5. **Escribimos un test basico para nuestra aplicación**

    Empezamos configurar el servidor de las pruebas , esto se hace con la funcion `beforeAll`. Dentro de esta función iniciamos el servidor con `app.listen` y  con `server.address().port` obtenemos el puerto en el que el servidor esta escuchando. Todo lo que esta dentro de `beforeAll` se ejecuta antes de las pruebas.

    Finalizamos el servidor con `server.close` esto va dentro de la funcion `afterAll`. Esta se ejecuta despues de las pruebas.

    Definimo y ejecutamos la prueba con la función `describe`. En este test verificamos que la aplicación Express responda correctamente a un solicitud **GET** a la ruta raiz `('/')`. La prueba comprueba que el servidor responda con un código de estado `200` y el texto `'Hello World'`. 

    ```js
    const request = require('supertest');
    const app = require('../src/app'); 

    let server;

    beforeAll((done) => {
        server = app.listen(() => {
            console.log(`Server is running on port ${server.address().port}`);
            done();
        });
    });

    afterAll((done) => {
        server.close(done);
    });

    describe('GET /', () => {
        it('Should return Hello, World!', async () => {
            const res = await request(app).get('/');
            expect(res.statusCode).toEqual(200);
            expect(res.text).toBe('Hello World');
        });
    }); 
        ```

6. **Modificamos el archivo package.json**

    Cambiamos el valor de `"test": "jest"` , además agregamos `"devDependencies"` dentro de esta colocamos la version de `"supertest"`.

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/package.png)

7. **Ejecucion del test y el servidor**

    Observamos que las prueba pasa. Tambien podemos ejecutar la prueba usando el siguiente comando
    ```shell
        npx jest
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/test.png)

    Iniciamos nuestro servidor 

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/nodeServer.png)

    Si todo salio bien , podremos visualizar nuestro mensaje en nuetro browser.

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/localhost.png)

### Pipeline CI/CD

1. **Creamos la estructura para GitHub Actions**

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/githubAc.png)

2. **Definimos el flujo de trabajo**

    Nombramos a nuestro archivo de configuracion `CI Pipeline` con la variable **name**.
    Definimos los eventos que activaran la ejecución del flujo de trabajo con la variable **on**.El flujo de trabajo se ejecutará en 2 eventos: cuando haya `push` o `pull_request` en la rama `main`

    Con la variable **jobs** definimos los trabajos que se ejecutaran como parte del flujo de trabajo.

    Bajo **jobs** definimos nuestro trabajo **build** , en este tenemos la variable **runs-on** que denife el tipo de máquina o ambiente en el cual se ejecutará el trabajo. En este caso usaremos `ubuntu-latest` que es una maquina virtual que utiliza la ultima version de Ubuntu disponible en GitHub Actions.

    Con la variable  **steps** denifinmos los pasos específicos que se ejecutarán en el trabajo `build`.


    1. Como primer paso tenemos a la clonación del código en la máquina virtual. Para ello hacemos uso de la variable **uses**  con el valor `actions/checkout@v4`

    2. Como segundo paso tenemos a la instalación del node. Pata ello hacemos uso de la variable **uses** con el valor `actions/setup-node@v4`
    y le especificamos la versión con la variable **node-version**

    3. Como tercer paso tenemos a la instalación de las dependencias. Para ellos hacemos uso de la variable **run** (esta variable ejecuta un comando en la shell de la maquina virtual) , con el valor `npm run ci` comando que instala las dependecias del proyecto.
    Especificamos el directorio de trabajo desde el cual se ejecuta el comando con la varible **working-directory**

    4. Como cuarto paso tenemos la ejecución de los tests. Para ello hacemos uso de la variable **run** con el valor `npx jest --verbose` , igual que en el paso anterior indicamos el directorio de trabajo donde están los archivos de prueba y las configuraciones necesarias para Jest.

    ```yml 
        name: CI Pipeline

    on:
    push:
        branches:
        - main
    pull_request:
        branches:
        - main

    jobs:
    build:
        runs-on: ubuntu-latest

        steps:
        - name: 'Checkout'
        uses: actions/checkout@v4
        - name: 'Setup node'
        uses: actions/setup-node@v4
        with:
            node-version: 20.11.1
        - name: 'Install dependencies'
        run: npm ci
        working-directory: ./Actividad1/devops-practice/
        - name: 'Run test'
        run:  npx jest --verbose
        working-directory: ./Actividad1/devops-practice/
    ```


    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/build.png)

### Configuracion del entorno CD

1. **Crea un archivo Docker para contenerizar la aplicación**
    
    Creamos un Dockerfile para crear una imagen de Docker para nuestra aplicación.

    - Utilizamos la imagen ofcial de Node.js version 20 con la instrucción `Fron node:20`.
    - Establcemos un directorio de trabajo en  `app` con la instrucción  `WORKDIR /app`.
    - Copiamos los archivos de dependencias con la instrcción  `COPY` y luego instalamos las dependecias necesarias con la instrucción  `RUN`.
    - Exponemos el puerto 3000 para la aplicación con la instrucción  `EXPOSE`
    - Finalmente ejecutamos el servidor de la aplicación con  `node src/server.js` cuando se inicial el contenedor.

    ```yml
        FROM node:20

        WORKDIR /app

        COPY package*.json ./

        RUN npm install

        COPY . .

        EXPOSE 3000

        CMD ["node", "src/server.js"]
    ```
2. **Construimos la imagen de Docker**

    Para ello hacemos uso del siguiente comando.
    ```shell
        docker build -t devops_practice .
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/dockerBuild.png)


3. **Corremos el contenedor localmente**

    Para ello hacemos uso del siguiente comando.
 
    ```shell
         docker run -p 3000:3000 devops_practice
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/dockerRun.png)


### Automatización del despliegue con GitHub Actions:
1. **Actualizamos el archivo `ci.yml`**

    Agregamos la construcción y despliegue de la imagen docker
    
    ```yml
        - name: 'Buil Docker image'
        run: docker build -t devops_practice .
        - name: 'Run Docker container'
        run: docker run -d -p 3000:3000 devops_practice
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/GitHubDoc.png)

2. **Verificamos que la aplicación se haya desplegado correctamente de manera local usando Docker**

    Para ello accedemos a `http://localhost:3000` en nuestro browser.

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/localhost.png)

### Automatización
1. **Automatizamos la configuración y gestión del entorno local usando Docker Compose**

    Para ello creamos una archivo `docker-compose.yml`. 
    - En este archivo definimos la version de Docker Compose con la clave `version` 
    - Construimos la imagen usando el Dockerfile en el directorio actual con la clave `build: .`
    - Mapeamos el puerto 3000 del host al puerto 3000 del contenedor
    - Definimos la variable de entorno para el contenedor con la clave `environments`

    ```yml
        version: '3.8'
        services:
            app:
            build: .
            posrts:
            - "3000:3000"
            environment:
            - NODE_ENV=production
    ```
2. **Corremos la aplicacion usando Docker Compose**

    Para ello ejecutamos el siguiente comando:
    ```shell
    docker-compose up --build -d
    ```

    Observamos se crearon correctamente las imágenes necesarias y se levanto correctamente el contenedor definido en nuestro archivo  `docker-compose.yml`

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad1/assets/DockerCompose.png)