package Colecciones.PartyGuestSet;


import java.util.HashSet;
import java.util.Set;

/**
 * @author: Ariel Zarate
 * @version: 1.0
 * @since: 2026-02-22
 * 1. Crea una clase principal llamada PartyGuestList.
 *
 * 2. Declara una variable de instancia de tipo Set<String> para almacenar los invitados.
 *
 * 3. Inicializa el conjunto de invitados como una instancia de HashSet.
 *
 * 4. Crea un método llamado `addGuest` que tome como parámetro un invitado (de tipo String) y lo agregue al conjunto de invitados utilizando el método `add()`.
 *
 * 5. Crea un método llamado `removeGuest` que tome como parámetro un invitado y lo elimine del conjunto utilizando el método `remove()`.
 *
 * 6. Crea un método llamado `isGuestInList` que tome como parámetro un invitado y verifique si está presente en el conjunto utilizando el método `contains()`.
 *
 * 7. Crea un método llamado `getTotalGuests` que devuelva el número total de invitados utilizando el método `size()`.
 * */


public class PartyGuestList {

    private Set<String> guestList=null;

    //3
    public PartyGuestList() {
        this.guestList = new HashSet<>();
    }

    //4
    public void addGuest(String guest) {
        guestList.add(guest);
    }

    //5
    public void removeGuest(String guest) {
        guestList.remove(guest);
        System.out.println("Invitado " + guest + " eliminado de la lista.");
    }

    //6
    public boolean isGuestInList(String guest) {
        return guestList.contains(guest);
    }

    //7 return total guests
    public int getTotalGuests() {
        return guestList.size();
    }

    public void printGuestList() {
        System.out.println("Lista de invitados:");
        for (String guest : guestList) {
            System.out.println(guest);
        }
    }

}
