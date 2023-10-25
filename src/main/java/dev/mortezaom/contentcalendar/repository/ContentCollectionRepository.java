//package dev.mortezaom.contentcalendar.repository;
//
//import dev.mortezaom.contentcalendar.model.Content;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class ContentCollectionRepository {
//
//    private final List<Content> contents = new ArrayList<>();
//
//    public ContentCollectionRepository() {
//    }
//
//    public List<Content> findAll() {
//        return contents;
//    }
//
//    public Optional<Content> findById(Integer id) {
//        return contents.stream().filter(c -> c.id().equals(id)).findFirst();
//    }
//
//    public void updateById(Integer id, Content body) {
//        contents.removeIf(c -> c.id().equals(id));
//        contents.add(body);
//    }
//
//    public void save(Content body) {
//        contents.add(body);
//    }
//
//    public void deleteById(Integer id) {
//        contents.removeIf(c -> c.id().equals(id));
//    }
//
//    public boolean existById(Integer id) {
//        return contents.stream().anyMatch(c -> c.id().equals(id));
//    }
//}
