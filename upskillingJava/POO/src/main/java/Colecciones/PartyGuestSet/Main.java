package Colecciones.PartyGuestSet;

/*

### En el método `main`, crea una instancia de `PartyGuestList` y realiza las siguientes operaciones:

• Agrega invitados utilizando el método `addGuest()`.

• Verifica si un invitado específico está en la lista utilizando el método `isGuestInList()`.

• Elimina un invitado utilizando el método `removeGuest()`.

• Muestra el número total de invitados utilizando el método `getTotalGuests()`.

• Utiliza el método `isEmpty()` para verificar si la lista de invitados está vacía.
* */

public class Main {

    public static void main(String[] args) {

        PartyGuestList partyGuestList = new PartyGuestList();

        // Agregar invitados
        partyGuestList.addGuest("Alice");
        partyGuestList.addGuest("Bob");
        partyGuestList.addGuest("Charlie");
        partyGuestList.addGuest("Alice"); // Intento de agregar un invitado duplicado
        partyGuestList.addGuest("David");
        partyGuestList.addGuest("Eve");


        partyGuestList.printGuestList();

        // Verificar si un invitado específico está en la lista
        String guestToCheck = "Bob";
        if (partyGuestList.isGuestInList(guestToCheck)) {
            System.out.println(guestToCheck + " está en la lista de invitados.");
        } else {
            System.out.println(guestToCheck + " no está en la lista de invitados.");
        }

        // Eliminar un invitado aca no hay indice
        partyGuestList.removeGuest("Bob");

        // Mostrar el número total de invitados
        System.out.println("Número total de invitados: " + partyGuestList.getTotalGuests());

        // Verificar si la lista de invitados está vacía
        if (partyGuestList.getTotalGuests() == 0) {
            System.out.println("La lista de invitados está vacía.");
        } else {
            System.out.println("La lista de invitados no está vacía.");
        }

    }
}
