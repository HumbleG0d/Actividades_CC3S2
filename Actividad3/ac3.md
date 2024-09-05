# Preguntas
1. **¿Cómo te ha ayudado Git a mantener un historial claro y organizado de tus cambios?**

    En mis proyectos, Git me ha ayudado significativamente a mantener un historial claro y organizado de mis cambios de varias maneras:

    - **Commit Detallados**: Cada vez que realizo un cambio en mi código, hago un commit en Git con un mensaje descriptivo que explica exactamente qué se ha cambiado y por qué. Esto me permite, más adelante, entender el contexto detrás de cada modificación y recordar la razón de ciertos cambios, especialmente en proyectos complejos.

    - **Ramas (Branches) para Nuevas Funcionalidades**: Utilizo ramas para trabajar en nuevas funcionalidades o para realizar experimentos sin afectar la rama principal (main). Esto me permite mantener la rama principal limpia y estable mientras desarrollo nuevas características o pruebo ideas. 

    - **Reversión de Cambios**: Ha habido ocasiones en las que he introducido un cambio que no funcionó como esperaba o que causó problemas en otras partes del proyecto. Con Git, he podido revertir fácilmente esos cambios y restaurar el estado anterior del proyecto, lo cual es invaluable para mantener la estabilidad del código.

    - **Comparación de Versiones (Diffs)**: Git me permite comparar diferentes versiones de mi código para ver exactamente qué ha cambiado entre ellas. Esto es especialmente útil cuando trato de entender cómo un cambio específico pudo haber introducido un error o un problema en mi proyecto.

    - **Colaboración Efectiva**: Al trabajar en equipo, Git ha sido esencial para coordinar los cambios. Todos los miembros del equipo pueden hacer sus commits y luego fusionar sus cambios en una rama común. Esto asegura que todos los cambios estén documentados y que se pueda rastrear quién hizo qué, facilitando la colaboración y la revisión de código.

    - **Etiquetado de Versiones Importantes**: En algunos proyectos, he utilizado etiquetas (tags) para marcar versiones importantes del software, como lanzamientos o versiones beta. Esto me ayuda a tener un punto de referencia claro en el historial del proyecto y facilita la navegación y revisión de cambios importantes.

    - **Respaldos y Acceso Remoto**: Utilizando servicios como GitHub, puedo mantener una copia remota de todos mis proyectos. Esto no solo actúa como un respaldo en caso de que algo le suceda a mi máquina local, sino que también me permite acceder a mi código desde cualquier lugar y colaborar con otros desarrolladores fácilmente.


2. **¿Qué beneficios ves en el uso de branches para desarrollar nuevas características o corregir
errores?**

    El uso de ramas (branches) en Git para desarrollar nuevas características o corregir errores ofrece varios beneficios importantes:

    - **Aislamiento de Cambios**: Cada rama permite trabajar de manera aislada en una nueva característica o en la corrección de un error sin afectar el código base principal o la rama `main`. Esto asegura que el código en producción se mantenga estable y sin interrupciones mientras se desarrollan y prueban nuevos cambios.

    - **Desarrollo Paralelo**: Múltiples desarrolladores pueden trabajar simultáneamente en diferentes ramas. Esto facilita la colaboración y permite que el equipo de desarrollo avance en varias características o correcciones al mismo tiempo sin interferencias, mejorando así la eficiencia y la productividad.

    - **Control de Calidad**: Al desarrollar en una rama separada, se pueden realizar pruebas exhaustivas y revisiones de código antes de fusionar los cambios con la rama principal. Esto reduce la probabilidad de introducir errores o problemas en el código base estable.

    - **Facilidad para Descartar Cambios**: Si una nueva característica o corrección no funciona como se esperaba o introduce problemas, se puede descartar la rama correspondiente sin afectar el código principal. Esto proporciona una gran flexibilidad y reduce el riesgo de comprometer la estabilidad del proyecto.


    - **Despliegues Independientes**: En proyectos que requieren despliegues frecuentes, las ramas permiten preparar y probar lanzamientos independientes. Una vez que una característica está lista y aprobada, puede ser fusionada y desplegada de manera independiente, sin esperar a que otras características estén listas.


# Ejercicios
## Ejercicio 1: Manejo avanzado de branches y resolución de conflictos

Objetivo: Practicar la creación, fusión y eliminación de ramas, así como la resolución de conflictos
que puedan surgir durante la fusión.

### Instrucciones:

1. **Crear una nueva rama para una característica:**

    - Crea una nueva rama llamada feature/advanced-feature desde la rama main:

        ```shell
            git branch feature/advanced-feature
            git checkout feature/advanced-feature       
        ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/branch_feature.png)


2. **Modificar archivos en la nueva rama:**

- Edita el archivo main.py para incluir una función adicional:

    El código agregado nos permite imprimer el mensaje `Hello from advanced feature` mediante la funcion **greet**

 ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/modifMain.png)

- Añadimos y confirmamos estos cambios en la rama feature/advanced-feature:

    ```shell
        git add main.py
        git commit -m "Add greet function in advanced feature"     
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/comitFeature.png)

3. **Simular un desarrollo paralelo en la rama main:**

    - Cambia de nuevo a la rama main:

        ```shell
            git checkout main  
        ```
    - Añade y confirma estos cambios en la rama main:

        ```shell
            git add main.py
            git commit -m "Update main.py message in main branch"
        ```
    
    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/commitMain.png)

4. **Intentamos fusionar la rama feature/advanced-feature en main:**

    - Fusiona la rama feature/advanced-feature en main:
        ```shell
            git merge feature/advanced-feature
        ```
    Observamos que surgio un conflicto al momento de hacer un merge.

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/commitMain.png)

    Observamos que los prints creadas en el archivo python en las diferentes ramas se unen. 

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/mergeMain.png)

5. **Resolver el conflicto de fusión:**

    - Git generará un conflicto en main.py. Abre el archivo y resuelve el conflicto manualmente,
    eligiendo cómo combinar las dos versiones.

    - Después de resolver el conflicto, añade el archivo resuelto y completa la fusión:

        ```shell
            git add main.py
            git commit -m "Resolve merge conflict between main and feature/advanced-feature"
        ```
    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/solvedConflict.png)

6. **Eliminar la rama fusionada:**
    - Una vez que hayas fusionado con éxito y resuelto los conflictos, elimina la rama
    feature/advanced-feature:

    ```shell
        git branch -d feature/advanced-feature
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/deleteBranchFea.png)


## Ejercicio 2: Exploración y manipulación del historial de commits

### Instrucciones:

1. **Ver el historial detallado de commits:**

    - Usa el comando git log para explorar el historial de commits, pero esta vez con más detalle:

    ```shell
        git log -p
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitLog.png)

2. **Filtrar commits por autor:**
    - Usa el siguiente comando para mostrar solo los commits realizados por un autor específico:

     ```shell
        git log --author="HumbleG0d"
    ```
    Observamos que el comando nos muestra los commits del autor `HumbleG0d`

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitLogUser.png)


3. **Revertir un commit:**

    - Imagina que el commit más reciente en `main.py` no debería haberse hecho. Usa git revert para revertir ese commit:

    ```shell
        git revert -m 1 9416e4df7a4b0edb4e16bb8744cd859a6d4c218e
    ```

    Este comando de git nos permite revertir el commit de una rama manteniendo la historia de la primera rama padre del merge.

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitRevert.png)


4. **Visualización gráfica del historial:**

    - Usa el siguiente comando para ver una representación gráfica del historial de commits:

    ```shell
        git log --graph --oneline --all
    ```
    
    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitLogGraph.png)

## Ejercicio 3: Creación y gestión de branches desde commits específicos

## Instrucciones:

1. **Crear una nueva rama desde un commit específico:**

    - Usa el historial de commits (git log --oneline) para identificar un commit antiguo desde el cual crear una nueva rama:

        Escojemos el commit con el código `cfbfe0c`, apartir de este commit crearemos una nueva rama.

        ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitLogOneline.png)

    - Crea una nueva rama bugfix/rollback-feature desde ese commit:

        ```shell
        git branch bugfix/rollback-feature cfbfe0c
        git checkout bugfix/rollback-feature
        ```

        ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitCheckout.png)

2. **Modificar y confirmar cambios en la nueva rama:**
    
    - Realiza algunas modificaciones en main.py que simulen una corrección de errores:

        ```python
        print('Hello World')    
        def greet():
        print('Fixed bug in feature')
        greet()
        ```
    - Añade y confirma los cambios en la nueva rama:

         ```shell
        git add main.py
        git commit -m "Fix bug in rollback feature"
        ```
    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/FixBug.png)

    
3. **Fusionar los cambios en la rama principal:**

    - Cambia de nuevo a la rama main y fusiona la rama bugfix/rollback-feature:

        ```shell
        git checkout main
        git merge bugfix/rollback-feature
        ```
    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/merge.png)


4. **Explorar el historial después de la fusión:**

    - Usa git log y git log --graph para ver cómo se ha integrado el commit en el historial:

        ```shell
        git log --graph --oneline
        ```
    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitGrapOneline.png)


5. **Eliminar la rama bugfix/rollback-feature:**
    - Una vez fusionados los cambios, elimina la rama bugfix/rollback-feature:

    ```shell
    git branch -d bugfix/rollback-feature
    ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitBugFixD.png)


## Ejercicio 4: : Manipulación y restauración de commits con git reset y git restore

## Instrucciones:

1. **Hacer cambios en el archivo main.py:**

    - Edita el archivo main.py para introducir un nuevo cambio:


        ```shell
        git add main.py
        git commit -m "Introduce a change to be reset"
        ```

2. **Usar git reset para deshacer el commit:**
    - Deshaz el commit utilizando git reset para volver al estado anterior:

        ```shell
        git reset --hard HEAD~1
        ```
    - Verifica que el commit ha sido eliminado del historial y que el archivo ha vuelto a su estado anterior

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/head.png)

3. **Usar git restore para deshacer cambios no confirmados:**

    - Realiza un cambio en README.md y no lo confirmes:

        ```shell
         echo "Another line in README" >> README.md
         git status
        ```
    - Usa git restore para deshacer este cambio no confirmado:

        ```shell
        git restore README.md
        ```
    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitRestore.png)
    
    - Verifica que el cambio no confirmado ha sido revertido.Observamos que al aplicar el anterior comando , git deja de seguir el archivo `README.md`

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitRestore2.png)

## Ejercicio 5: Trabajo colaborativo y manejo de Pull Requests

## Instrucciones:

1. **Crear un nuevo repositorio remoto:**

    - Usa GitHub o GitLab para crear un nuevo repositorio remoto y clónalo localmente:

        ```shell
        git clone git@github.com:HumbleG0d/pr_repository.git
        ```
    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitClone.png)

2. **Crear una nueva rama para desarrollo de una característica:**

    - En tu repositorio local, crea una nueva rama feature/team-feature:

        ```shell
        git branch feature/team-feature
        git checkout feature/team-feature
        ```
    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitFeature.png)
    
    
3. **Realizar cambios y enviar la rama al repositorio remoto:**

    - Realiza cambios en los archivos del proyecto y confírmalos:

        ```shell
        echo "print('Collaboration is key!')" > collaboration.py
        git add .
        git commit -m "Add collaboration script"
        ```

        ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitCollaboration.png)

4. **Abrir un Pull Request:**

    - Abre un Pull Request (PR) en la plataforma remota (GitHub/GitLab) para fusionar feature/teamfeature con la rama main.

    
    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitPr.png)


    - Añade una descripción detallada del PR, explicando los cambios realizados y su propósito.

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitPr2.png)

5. **Revisar y Fusionar el Pull Request:**

    - Simula la revisión de código, comenta en el PR y realiza cualquier cambio necesario basado en la retroalimentación.

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/commentPr.png)

    - Una vez aprobado, fusiona el PR en la rama main.

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/mergetPr.png)
    

6. **Eliminar la rama remota y local:**

    - Después de la fusión, elimina la rama tanto local como remotamente:


        ```shell
        git branch -d feature/team-feature
        git push origin --delete feature/team-feature
        ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitFeatureD.png)
    

# Ejercicio 6: Cherry-Picking y Git Stash
## Instrucciones:

1. **Hacer cambios en main.py y confirmarlos:**

    - Realiza y confirma varios cambios en main.py en la rama main:

        ```shell
        echo "print('Cherry pick this!')" >> main.py
        git add main.py
        git commit -m "Add cherry-pick example"
        ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitCherry.png)

2. **Crear una nueva rama y aplicar el commit específico:**

    - Crea una nueva rama feature/cherry-pick y aplícale el commit específico:

        ```shell
        git branch feature/cherry-pick
        git checkout feature/cherry-pick
        git cherry-pick <commit-hash>
        ```
    
3. **Guardar temporalmente cambios no confirmados:**

    - Realiza algunos cambios en main.py pero no los confirmes:

        ```shell
        echo "print('This change is stashed')" >> main.py
        git status
        ```
    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitCherryS.png)
    
    - Guarda temporalmente estos cambios utilizando git stash:

        ```shell
        git stash
        ```
    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitSatsh.png)
    

4. **Aplicar los cambios guardados:**

    - Realiza otros cambios y confírmalos si es necesario.

    - Luego, recupera los cambios guardados anteriormente:

        ```shell
        git stash pop
        ```

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitSatshPop.png)

5. **Revisar el historial y confirmar la correcta aplicación de los cambios:**

    - Usa git log para revisar el historial de commits y verificar que todos los cambios se han aplicado correctamente.

    ![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad3/assets/gitLog2.png)

