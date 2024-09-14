# Preguntass de discusión:

1. **¿Por qué se considera que rebase es más útil para mantener un historial de proyecto lineal en comparación con merge?**

    El rebase se considera más útil para mantener un historial de proyecto lineal en comparación con el merge porque reescribe el historial de los commits, colocando los cambios de una rama al final de la otra, sin crear un commit de fusión (merge commit). Esto da como resultado un historial más limpio, donde todos los commits parecen haber sido aplicados secuencialmente sin bifurcaciones o ramas extra.

2. **¿Qué problemas potenciales podrían surgir si haces rebase en una rama compartida con otros miembros del equipo?**

    * El principal riesgo de hacer un rebase en una rama compartida es que el rebase reescribe el historial de commits, cambiando los identificadores (hashes) de los commits. Esto crea una nueva versión de los commits que ya existían, lo que puede causar desincronización entre los colaboradores que ya han basado su trabajo en el historial original.

    * Después de hacer un rebase, si intentas hacer un git push, Git te dirá que no puede hacerlo porque tu historial ya no coincide con el del servidor remoto. Necesitarás hacer un git push --force para sobrescribir el historial en el repositorio remoto.

3. **¿En qué se diferencia cherry-pick de merge, y en qué situaciones preferirías uno sobre el otro?**
    * git merge cuando quiero combinar el trabajo completo de una rama en otra, preservando todo el historial de commits.

    * git cherry-pick cuando necesite aplicar solo ciertos commits específicos de una rama, sin mezclar el resto de los cambios.

4. **¿Por qué es importante evitar hacer rebase en ramas públicas?**
        
    Es importante evitar hacer rebase en ramas públicas porque el rebase reescribe el historial de commits, lo que puede generar problemas graves de sincronización y colaboración cuando otros desarrolladores ya han basado su trabajo en esa rama.

# Ejercicios teóricos

1. **Diferencias entre git merge y git rebase**

    **Pregunta**: Explica la diferencia entre git merge y git rebase y describe en qué escenarios sería más adecuado utilizar cada uno en un equipo de desarrollo ágil que sigue las prácticas de Scrum.


    Uso de git merge:

    * **Cuando:** Integras ramas de características, correcciones o cualquier otro tipo de desarrollo en ramas principales (main o develop).
    * **Por qué:** Mantiene el historial completo y muestra claramente cómo los cambios se han integrado. Es adecuado para ramas públicas y compartidas, ya que no reescribe el historial.

    Uso de git rebase:

    * **Cuando:** Trabajas en ramas locales y deseas mantener un historial lineal y limpio antes de hacer un merge final a una rama principal.

    * **Por qué:** Limpia el historial de commits y facilita la comprensión de la línea de tiempo del desarrollo. Es útil para preparar ramas para integración, pero debe evitarse en ramas compartidas para prevenir problemas de sincronización.

2. **Relación entre git rebase y DevOps**

    **Pregunta:** ¿Cómo crees que el uso de git rebase ayuda a mejorar las prácticas de DevOps, especialmente en la implementación continua (CI/CD)? Discute los beneficios de mantener un historial lineal en el contexto de una entrega continua de código y la automatización de pipelines.

    * En Ramas Locales: Usa git rebase en ramas locales o de características para mantener un historial limpio antes de integrar cambios en la rama principal. Esto es útil para preparar ramas para integración final sin crear un historial de commits de fusión complejo.

    * Antes de la Integración Final: Realiza un rebase antes de fusionar una rama de características en la rama principal para asegurarte de que tu historial de cambios sea lineal y esté actualizado con los últimos cambios en la rama principal.


    * En Combinación con CI/CD: Usa rebase junto con las prácticas de CI/CD para asegurar que tus cambios se integren sin problemas y se prueben en un contexto de código actualizado. Esto ayuda a mantener la coherencia y la calidad en el proceso de entrega continua.

3. **Impacto del git cherry-pick en un equipo Scrum**
**Pregunta:** Un equipo Scrum ha finalizado un sprint, pero durante la integración final a la rama principal (main) descubren que solo algunos commits específicos de la rama de una funcionalidad deben aplicarse a producción. ¿Cómo podría ayudar git cherry-pick en este caso? Explica los beneficios y posibles
complicaciones.

    * git cherry-pick permite tomar commits específicos de una rama y aplicarlos directamente en otra rama (en este caso, la rama main). A diferencia de un merge o rebase, donde toda una rama o un conjunto de commits son aplicados de una vez, con cherry-pick se seleccionan individualmente los commits que se quieren integrar.
    En este caso, si el equipo decide que solo algunos commits son estables y listos para producción, pueden usar git cherry-pick para aplicar solo esos cambios sin tener que fusionar la rama completa, lo que podría incluir cambios no deseados o inestables

# Ejercicios prácticos

1. **Simulación de un flujo de trabajo Scrum con git rebase y git merge**

    ##### Contexto:
    
    • Tienes una rama main y una rama feature en la que trabajas. Durante el desarrollo del sprint, se
    han realizado commits tanto en main como en feature.
    
    • Tu objetivo es integrar los cambios de la rama feature en main manteniendo un historial limpio.
    
    ##### Instrucciones:

    1. Crea un repositorio y haz algunos commits en la rama main.

    2. Crea una rama feature, agrega nuevos commits, y luego realiza algunos commits adicionales en main.
    
    3. Realiza un rebase de feature sobre main.

    4. Finalmente, realiza una fusión fast-forward de feature con main.

    ##### Preguntas:

    • ¿Qué sucede con el historial de commits después del rebase?

    
    • ¿En qué situación aplicarías una fusión fast-forward en un proyecto ágil?

    ##### Comandos:

    Creamos el directorio `scrum-workflow`

    ```shell
    mkdir scrum-workflow
    cd scrum-workflow
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/mkdir.png)

    Creamos el archivo `mainfile.md` , lo modificamos , agregamos los cambios al área de preparación y finalmente guardamos los cambios

    ```shell
    echo "Commit inicial en main" > mainfile.md
    git add mainfile.md
    git commit -m "Commit inicial en main"
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/inicialCommit.png)


    Creamos la rama `feature` y nos movemos a ella . En ensa rama creamos el archivo `featurefil.md` , modificamos este archivo , luego agreamos los cambios al área de preparación y finalmente  guardamos los cambios.

     ```shell
    git checkout -b feature
    echo "Nueva característica en feature" > featurefile.md
    git add featurefile.md
    git commit -m "Commit en feature"
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/commitFeature.png)


    Regresamos a la rama `main`. Actualizamos el archivo `mainfile.md`.

    ```shell
    git checkout main
    echo "Actualización en main" >> mainfile.md
    git add mainfile.md
    git commit -m "Actualización en main"
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/updateMain.png)


    Regresamos a la rama `feature` , hacemos un **rebase** , regresamos a la rama `main` y finalmente para mantener el historial lineal hacemos uso del comando `git merge feature --ff-only`.

    ```shell
    git checkout feature
    git rebase main
    git checkout main
    git merge feature --ff-only
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/rebase.png)


2. **Cherry-pick para integración selectiva en un pipeline CI/CD**

    ##### Contexto:
    • Durante el desarrollo de una funcionalidad, te das cuenta de que solo ciertos cambios deben ser integrados en la rama de producción, ya que el resto aún está en desarrollo. Para evitar fusionar toda la rama, decides hacer cherry-pick de los commits que ya están listos para producción.

    ##### Instrucciones:

    1. Crea un repositorio con una rama main y una rama feature.
    2. Haz varios commits en la rama feature, pero solo selecciona uno o dos commits específicos que
    consideres listos para producción.
    3. Realiza un cherry-pick de esos commits desde feature a main.
    4. Verifica que los commits cherry-picked aparezcan en main.

    ##### Preguntas:
    • ¿Cómo utilizarías cherry-pick en un pipeline de CI/CD para mover solo ciertos cambios listos a
    producción?
    • ¿Qué ventajas ofrece cherry-pick en un flujo de trabajo de DevOps?

    ##### Comandos:

    Creamos el directorio `cu-cd-workflow` , dentro de este creamos el archivo `main.md` , modificamos este archivo , luego agreamos los cambios al área de preparación y finalmente  guardamos los cambios.


    ```shell
    mkdir ci-cd-workflow
    cd ci-cd-workflow
    echo "Commit inicial en main" > main.md
    git add main.md
    git commit -m "Commit inicial en main"
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/conMainCID.png)


    Creamos y nos movemos a la rama `feature` , dentro de esta creamos el archivo `feature1.md` modificamos este archivo , luego agreamos los cambios al área de preparación y finalmente  guardamos los cambios.

     ```shell
    git checkout -b feature
    echo "Primera característica" > feature1.md
    git add feature1.md
    git commit -m "Agregar primera característica"
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/feature1Com.png)


    Creamos otro archivo `feature2.md` modificamos este archivo , luego agreamos los cambios al área de preparación y finalmente  guardamos los cambios.

     ```shell
    echo "Segunda característica" > feature2.md
    git add feature2.md
    git commit -m "Agregar segunda característica"
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/feature2Com.png)


    Nos movemos a la rama `main` y hacemos `cherry-pick` de los commits realizados en la rama `feature`.Con este comando lo que hacemos es traer los commits de la rama `feature` a nuestra rama `main`.

    ```shell
    git checkout main
    git cherry-pick <hash_del_commit1>
    git cherry-pick <hash_del_commit2>
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/cherryPick.png)

    [Git, Scrum y Sprints](ac5Sprints.md)