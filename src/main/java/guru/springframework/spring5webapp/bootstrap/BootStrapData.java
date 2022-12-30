package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author xavier = new Author("Xavier", "Dan");
        Book monBeauSapin = new Book("Mon Beau Sapin, Roi des forêts","284658274837535636436");
        xavier.getBooks().add(monBeauSapin);
        monBeauSapin.getAuthors().add(xavier);

        authorRepository.save(xavier);
        bookRepository.save(monBeauSapin);

        Author john = new Author("John", "Doe");
        Book mesRecettes = new Book("Mes belles recettes","646274834746365252535");
        john.getBooks().add(mesRecettes);
        mesRecettes.getAuthors().add(john);

        authorRepository.save(john);
        bookRepository.save(mesRecettes);

        System.out.println("Started in Bootstrap");
        System.out.println("Nombre de livres présents : " + bookRepository.count());
    }
}
