import controler.ContactController;
import repository.ContactRepository;
import service.ContactService;
import view.ContactMenu;

public class Main {
    public static void main(String[] args) {

        // Instanciando as dependências
        ContactRepository repository = new ContactRepository();
        ContactService service = new ContactService(repository);
        ContactMenu menu = new ContactMenu();

        // Iniciando o controlador
        ContactController controller = new ContactController(service, menu);
        controller.iniciar();
    }
}