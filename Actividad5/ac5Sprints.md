# Git, Scrum y Sprints

## Fase 1: Planificación del sprint (sprint planning)

### Ejercicio 1: Crear ramas de funcionalidades (feature branches)

En esta fase del sprint, los equipos Scrum deciden qué historias de usuario van a trabajar. Cada historia de usuario puede representarse como una rama de funcionalidad.

**Objetivo:** Crear ramas para cada historia de usuario y asegurar que el trabajo se mantenga aislado.

**Instrucciones:**
1. Crea un repositorio en Git.
2. Crea una rama main donde estará el código base.
3. Crea una rama por cada historia de usuario asignada al sprint, partiendo de la rama main.

**Comandos:**

Creamos nuestro directorio `scrum-project` , dentro de este creamos un `README.md` , lo modificamos y guardamos los cambios.

```shell
mkdir scrum-project
cd scrum-project
echo "# Proyecto Scrum" > README.md
git add README.md
git commit -m "Commit inicial en main"
```

![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/initialScrum.png)

Creamos ramas de historia de usuario

```shell
git checkout -b feature-user-story-1
git checkout -b feature-user-story-2
```

![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/branchFeatures.png)


**Pregunta:** ¿Por qué es importante trabajar en ramas de funcionalidades separadas durante un sprint?

- Por que permite el aislamiento de funcionalidades , es decir cada funcionalidad o historia de usuario se desarrolla en su propia rama.Esto asegura que al hacer cualquier cambio en una funcionalidad no afecte a la otra.

- También facilita la integración continua (CI/CD) , al trabajar en rama separadas se puede integrar y desplegar funcionalidades de manera independiente.


## Fase 2: Desarrollo del sprint (sprint execution)

### Ejercicio 2: Integración continua con git rebase

**Objetivo:** Mantener el código de la rama de funcionalidad actualizado con los últimos cambios de main durante el sprint.

**Instrucciones:**
1. Haz algunos commits en main.

2. Realiza un rebase de la rama feature-user-story-1 para actualizar su base con los últimos cambios de main.

**Comandos:**

Simulamos cambios en la rama `main`

```shell
git checkout main
echo "Actualización en main" > updates.md
git add updates.md
git commit -m "Actualizar main con nuevas funcionalidades"
```

![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/mainUpdate.png)

Rebase de la rama `feature-user-story-1` sobre `main`

```shell
git checkout feature-user-story-1
git rebase main
```

![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/rebaseMain.png)

**Pregunta:** ¿Qué ventajas proporciona el rebase durante el desarrollo de un sprint en términos de
integración continua?

- **Historial de commits más limpio y lineal**

    El rebase permite mantener un historial de commits limpio y ordenado, lo que facilita el seguimiento del desarrollo de las funcionalidades. Esto es especialmente útil en CI.

- **Facilita la detección de errores**
    
    Con un historial lineal, es más fácil usar herramientas de CI para realizar revisiones de código y ejecutar pruebas automatizadas. 

- **Mejor integración con la rama principal (main)**

    Al hacer rebase de la rama de funcionalidad sobre la rama principal (main), actualizamos nuestro trabajo con los últimos cambios del proyecto antes de fusionarlo. Esto reduce el riesgo de conflictos cuando finalmente haces el merge.

## Fase 3: Revisión del sprint (sprint review)

### Ejercicio 3: Integración selectiva con git cherry-pick

En esta fase, es posible que algunas funcionalidades estén listas para ser mostradas a los stakeholders,pero otras aún no están completamente implementadas. Usar git cherry-pick puede permitirte seleccionar commits específicos para mostrar las funcionalidades listas, sin hacer merge de ramas incompletas.

**Objetivo:** Mover commits seleccionados de una rama de funcionalidad (feature-user-story-2) a main sin integrar todos los cambios.

**Instrucciones:**

1. Realiza algunos commits en feature-user-story-2.

2. Haz cherry-pick de los commits que estén listos para mostrarse a los stakeholders durante la revisión del sprint.

**Comandos**

Nos movemos a la rama  `feature-user-story-2` , en ella creamos y modificamos los archivos  `feature2.md` y  c , finalmente guradamos los cambios.

```shell
git checkout feature-user-story-2
echo "Funcionalidad lista" > feature2.md
git add feature2.md
git commit -m "Funcionalidad lista para revisión"
echo "Funcionalidad en progreso" > progress.md
git add progress.md
git commit -m "Funcionalidad aún en progreso"
```

![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/feature2Cherry.png)


Seleccionamos el commit que este listo para traerlo a nuestra rama `main`.

```shell
git checkout main
git cherry-pick <hash_del_commit_de_feature-lista>
```

![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/cherryFeatur2.png)


**Pregunta:** ¿Cómo ayuda git cherry-pick a mostrar avances de forma selectiva en un sprint review?

- **Mostrar avances específicos:** En ocasiones, no todo el trabajo de una rama está listo para ser revisado o presentado durante la sprint review. Con `git cherry-pick`, puedo seleccionar solo los commits que representan los avances completados y estables, aplicándolos en una rama destinada a la demostración.

- **Evitar la inclusión de código no revisado o experimental:** Durante el desarrollo de un sprint, es posible que algunas funcionalidades en una rama incluyan código en estado experimental o sin revisar. Con `git cherry-pick`, puedo evitar llevar estos cambios incompletos al entorno de revisión y asegurarme de que solo los commits relevantes y finalizados se presenten.

## Fase 4: Retrospectiva del sprint (sprint retrospective)

### Ejercicio 4: Revisión de conflictos y resolución
Durante un sprint, pueden surgir conflictos al intentar integrar diferentes ramas de funcionalidades. Es importante aprender cómo resolver estos conflictos y discutirlos en la retrospectiva.

**Objetivo:** Identificar y resolver conflictos de fusión con git merge al intentar integrar varias ramas de funcionalidades al final del sprint.

**Instrucciones:**

1. Realiza cambios en feature-user-story-1 y feature-user-story-2 que resulten en conflictos.

2. Intenta hacer merge de ambas ramas con main y resuelve los conflictos.

**Comandos:**

Nos movemos a la rama `feature-user-story-1` , creamos y modificamos el archivo `conflicted-file.md` finalmente guardamos los cambios.

```shell
git checkout feature-user-story-1
echo "Cambio en la misma línea" > conflicted-file.md
git add conflicted-file.md
git commit -m "Cambio en feature 1"
```

![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/checkoutF1.png)

Nos movemos a la rama `feature-user-story-2` , creamos y modificamos el archivo `conflicted-file.md` finalmente guardamos los cambios.

```shell
git checkout feature-user-story-2
echo "Cambio diferente en la misma línea" > conflicted-file.md
git add conflicted-file.md
git commit -m "Cambio en feature 2"
```

![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/checkoutF2.png)


Mergeamos las ramas `feature-user-story-1` , `feature-user-story-2` 

```shell
git checkout main
git merge feature-user-story-1
git merge feature-user-story-2
```

![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/merge2.png)

**Pregunta :** ¿Cómo manejas los conflictos de fusión al final de un sprint? ¿Cómo puede el equipo mejorar la comunicación para evitar conflictos grandes?

-   Cuando se presenta un conflicto de fusión, Git te notifica que hay líneas de código en conflicto entre las ramas que estás intentando combinar.

    1. Iniciar el merge: Si hay conflictos durante la fusión.

    2. Identificar los archivos en conflicto: Git nos informará qué archivos tienen conflictos.

    3. Editar los archivos en conflicto.

    4. Marcar el conflicto como resuelto: Una vez que hayamos resuelto el conflicto, añadimos el archivo al staging area.

    5. Completar la fusión: Finalmente, completamos la fusión haciendo un commit.

- Estrategias para evitar grandes conflictos:

    1. **Integraciones frecuentes:** Fomenta la integración continua (CI), donde cada desarrollador sincroniza su rama con main o develop con frecuencia. 

    2. **Rebases frecuentes:** Antes de hacer un merge al final de un sprint, pedir a los miembros del equipo que hagan un rebase de sus ramas sobre main o develop.


    3. **Comunicación constante:** Fomenta la comunicación sobre qué partes del código están tocando con los miembros del equipo. 


## Fase de desarrollo: automatización de integración continua (CI) con git rebase

### Ejercicio 5: Automatización de rebase con hooks de Git

En un entorno CI, es común automatizar ciertas operaciones de Git para asegurar que el código se
mantenga limpio antes de que pase a la siguiente fase del pipeline. Usa los hooks de Git para
automatizar el rebase cada vez que se haga un push a una rama de funcionalidad.

**Objetivo:** Implementar un hook que haga automáticamente un rebase de main antes de hacer push en una rama de funcionalidad, asegurando que el historial se mantenga limpio.

**Instrucciones:**
1. Configura un hook pre-push que haga un rebase automático de la rama main sobre la rama de
funcionalidad antes de que el push sea exitoso.

2. Prueba el hook haciendo push de algunos cambios en la rama feature-user-story-1.

**Comandos:**

Dentro del proyecto, creamos un hook pre-push

```shell
nano .git/hooks/pre-push
```
Agrega el siguiente script para automatizar el rebase

```shell
#!/bin/bash
git fetch origin main
git rebase origin/main
```

![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/prePush.png)

![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/prePushFile.png)


Simulación de cambios y haz push

```shell
chmod +x .git/hooks/pre-push
git checkout feature-user-story-1
echo "Cambios importantes" > feature1.md
git add feature1.md
git commit -m "Cambios importantes en feature 1"
git push origin feature-user-story-1
```

![](https://github.com/HumbleG0d/Actividades_CC3S2/blob/main/Actividad2/assets/pushFail.png)


**Pregunta:** Qué ventajas y desventajas observas al automatizar el rebase en un entorno de CI/CD?.

- **Historial más limpio y lineal:**

    Un rebase automatizado mantiene el historial del proyecto más limpio, ya que los commits de las ramas se reordenan sobre la rama principal, eliminando la "mezcla" de commits intercalados que sucede con los merges tradicionales.

-   **Facilita la integración continua:**

    En un entorno de CI/CD, donde las actualizaciones constantes y la colaboración entre varios desarrolladores son comunes, un rebase automatizado asegura que cada nueva funcionalidad se integre de forma fluida y sin conflictos con el código en la rama principal.

-   **Reducción de conflictos futuros:**

    Al hacer rebase regularmente en lugar de merge, es menos probable que los conflictos se acumulen y se conviertan en un problema mayor. Un conflicto pequeño se puede manejar rápidamente, manteniendo el flujo de trabajo fluido y eficiente.