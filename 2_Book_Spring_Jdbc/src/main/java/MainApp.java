import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ajinkya.book.config.AppConfig;
import com.ajinkya.book.dao.BookDAO;
import com.ajinkya.book.dao.impl.BookDAOImpl;
import com.ajinkya.book.model.Book;


public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        BookDAO dao=context.getBean(BookDAOImpl.class);
        
        // Insert a new employee
        Book b = new Book();
        b.setId(1);
        b.setName("C Language");
        b.setPrice(32.23);
        
        dao.insertBook(b);

        
        context.close();
    }
}
