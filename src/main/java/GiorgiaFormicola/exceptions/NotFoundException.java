package GiorgiaFormicola.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super("Event with id '" + id + "' not found!");
    }
}
