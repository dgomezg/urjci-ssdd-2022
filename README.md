# URJCI - Sistemas Distribuidos - Curso 21/22

Repositorio de ejemplos, ejercicios y soluciones para el curso de
Sistemas Distribuidos de 3er curso de Grado de Ingeniería de Software en la
URJCI.

## Cómo utilizar este repositorio

Este repositorio tiene una rama principal donde podrán encontrarse todo el código
de ejemplos, ejercicios y soluciones de forma unificada. Los ejercicios y soluciones se
irán publicando en este repositorio de forma progresiva a medida que el curso avance.

Se recomienda probar a realizar los ejercicios antes de comprobar la solución.

De forma alternativa, para cada ejercicio, existe una rama en la que se
podrán encontrar commits por cada paso dado para realizar cada ejercicio.

---
> NOTA: Al funsionar las ramas de cada ejercicio en la rama principal (`main`) no se conserva el detalle de todos los
> pasos/`commits` (la rama se fusiona con `git merge <nombre_rama> --squash`), pero en cada rama se conserva el detalle
> de cada uno de esos pasos.
---

Si se desea seguir un ejercicio concreto, solo es necesario obtener el código de una rama.
Para ello, se puede utilizar el siguiente comando

```shell
$ git checkout <nombre_rama> 
```

sustituyendo `<nombre_rama>` por el nombre de la rama dónde se encuentra el ejercicio.

---
> NOTA: Para saber qué rama corresponde con cada ejercicio se puede consultar
> la sección
> [Indice de ramas y correspondencia con ejercicios](#indice-de-ramas-y-correspondencia-con-ejercicios)
---

Se puede comprobar la rama en la que está con el comando
```shell
$ git branch
* main
  samples
  ej1
```
(la rama en la que se está aparecerá marcada con un asterisco)

Una vez en la rama, podemos ver los distintos pasos (los distintos `commits`) con el comando
```shell
$ git log --oneline
878ada7 (HEAD -> sockets-ej3) Ex3. Step 2.2: More concise thread start
85e09b7 Ex3 Step 2. serviceSocket handled entirely at processRequest
4ec71a5 Ex3. Step 1.4: Using a lambda instead of a Runnable
912244b Ex3. Step1.3: Better reuse in trw-with-resources since java9
7a96efa Ex3 Step1.2: try-with-resources can reuse an already defined resource
7b6b1dd Ex3. Step1.1: Socket should be closed by the thread, not externally
fec2b05 Ex3. Step 1: Request processing is done in a thread
8210913 Ex 3. Step 0. Initial commit. ConcurrentEchoServer with TODO
249a3b1 (origin/main, main) Initial commit
```
(si se desea más detalle de los distintos pasos y ver el comentario completo del `commit`, se puede omitir el parametro
`--oneline` del comando anterior)

La primera columna indica el SHA (su parte inicial) del commit, este identificador puede utilizarse para obtener el
código corresponidente a cada uno de esos pasos. Por ejemplo, si queremos partir del estado inicial solo tendremos que
ejecutar el comando:

```shell
$ git checkout <SHA_commit>
```

Por ejemplo, en el caso anterior, si queremos situarnos en el Paso 0 (commit `8210913` , bastará con que ejecutemos
```shell
$ git checkout 8210913
```
A partir de ese momento, en nuestro IDE tendremos el código correspondiente a ese paso. Si vamos haciendo `checkout` de
los siguientes pasos, podremos ir siguiendo la solución paso a paso.

Si en un determinado paso (`commit`) queremos utilizarlo como base para realizar el ejercicio, bastará con que indiquemos
que queremos crear una nueva rama a partir de ese punto. Para ello bastará con que utilicemos el comando

```shell
$ git switch -c <nombre-rama-nueva>
```

A partir de ese momento, habremos creado una nueva rama partiendo del `commit` en que nos encontrasemos.

## Indice de ramas y correspondencia con ejercicios.

| rama | ejercicio / ejemplo |
| ---- | ------------------- |
| `main` | Rama principal donde se encuentran todos los ejemplos y ejercicios resueltos 
| `socket-samples` | Rama con ejemplos de creación de Socket Servidor y socket cliente |
| `sockets-ej1` | Ejercicio de creación de un cliente de Echo que envia a un servidor lo recibido por la entrada estándar y espera la respuesta del servidor |
