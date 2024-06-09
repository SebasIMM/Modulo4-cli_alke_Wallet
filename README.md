
# Proyecto de Gestión de Cuentas y Transferencias

Este proyecto es una aplicación de consola Java diseñada para gestionar cuentas de usuario, realizar cambio de moneda y gestiones financieras.

#### Mapa del Proyecto

	
	main
	│
	└───org.example
	|	  |   Main.java
	|    |
	|    └───example
	|    │
	|    ├───model
	|    │       Account.java
	|    │
	|    ├───repository
	|    │       AccountRepository.java
	|    │
	|    ├───repository
	|    │   └───impl
	|    │           AccountRepositoryImpl.java
	|    │
	|    ├───service
	|    │       TransferService.java
	|    │
	|    └───cli
	|            ConsoleController.java
	|
	└───test
	   │
	   └───repository
		     └───AccountRepositoryImplTest.java


## Estructura del Proyecto

El proyecto se organiza en los siguientes paquetes y clases principales:

- **model**: Contiene las clases que representan los objetos del dominio del negocio.
    
    - `Account`: Representa una cuenta de usuario.
    - `Currency`: Representa una moneda
    - `Transaction`: Representa una transacción financiera
    
- **repository**: Define las interfaces para acceder y manipular los datos del sistema (CRUD).
    
    - `AccountRepository`: Define los métodos para operar con cuentas de usuario.
    - `CurrencyRepository`: Define métodos similares para operar con monedas.
    - `TransactionRepository`: Define métodos para operar con transacciones. Omitiendo metodos modificar y eliminar.
- **repository.impl**: Contiene las implementaciones concretas de las interfaces de repositorio usando lista en memoria.
    
    - `AccountRepositoryImpl`: Implementa la lógica para operar con cuentas de usuario.
    - `CurrencyRepositoryImpl`: Implementa la lógica para operar con monedas.
    - `TransactionRepositoryImpl`: Implementa la lógica para operar con transacciones.
- **service**: Contiene la lógica de negocio relacionada con la transferencia de fondos.
    - `TransferService`: Proporciona métodos para realizar conversiones de moneda.
- **cli**: Contiene las clases relacionadas con la interfaz de usuario de la consola.
    - `ConsoleController`: Controla el flujo de la aplicación de consola, mostrando menús y opciones al usuario.
    - Otras clases como `CurrencyToday`,`Transference`, `History` y `UserData` se encargan de manejar la lógica de las opciones del menú.
- **util**: Contiene utilidades para leer y escribir datos desde y hacia archivos CSV.
        

## Instrucciones de Uso

Para ejecutar la aplicación, sigue estos pasos:

1. Clona el repositorio desde [github](https://github.com/SebasIMM/Modulo4-cli_alke_Wallet.git)
2. Abre el proyecto en tu IDE de preferencia.
3. Ejecuta la clase `Main.java` para iniciar la aplicación.
4. ingresa el usuario y contraseña solicitado.

~~~ 
user: sebas
pass: 1234
~~~
