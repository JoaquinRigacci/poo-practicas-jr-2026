package ar.edu.unlu.poo.practica07.ejercicio01;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" PRUEBA: FORMAS GEOMÉTRICAS, DIBUJABLES Y LIENZO (POO)");
        System.out.println("==========================================================\n");

        // 1. Instanciamos el contenedor polimórfico (Lienzo)
        Lienzo lienzo = new Lienzo();

        // 2. Creamos formas geométricas (heredan de Forma e implementan Dibujable)
        Circulo circuloRojo = new Circulo("Rojo", 5.0);
        Circulo circuloAzul = new Circulo("Azul", 2.5);
        Rectangulo rectanguloVerde = new Rectangulo("Verde", 4.0, 6.0);

        // 3. Creamos un elemento de texto (NO es Forma, pero implementa Dibujable)
        Texto cartelBienvenida = new Texto("¡Bienvenidos a Programación Orientada a Objetos!", 14);
        Texto pieDePagina = new Texto("UNLu - Laboratorio de Informática", 10);

        // 4. Mostramos el cálculo específico de área para las formas geométricas
        System.out.println("--- 1. CÁLCULO DE ÁREAS (JERARQUÍA FORMA) ---");
        System.out.printf("Área del Círculo Rojo (radio 5.0): %.2f%n", circuloRojo.calcularArea());
        System.out.printf("Área del Círculo Azul (radio 2.5): %.2f%n", circuloAzul.calcularArea());
        System.out.printf("Área del Rectángulo Verde (4x6): %.2f%n", rectanguloVerde.calcularArea());
        System.out.println();

        // 5. Agregamos todos los elementos al lienzo
        // Gracias al polimorfismo, el lienzo recibe objetos de distintas clases
        // siempre y cuando cumplan con el contrato de la interfaz Dibujable.
        lienzo.agregarElemento(circuloRojo);
        lienzo.agregarElemento(rectanguloVerde);
        lienzo.agregarElemento(cartelBienvenida);
        lienzo.agregarElemento(circuloAzul);
        lienzo.agregarElemento(pieDePagina);

        // 6. Renderizamos el lienzo completo
        System.out.println("--- 2. RENDERIZADO DEL LIENZO (POLIMORFISMO CON DIBUJABLE) ---");
        lienzo.renderizarTodo();

        System.out.println("\n==========================================================");
        System.out.println(" RENDERIZADO FINALIZADO CON ÉXITO");
        System.out.println("==========================================================");
    }
}
