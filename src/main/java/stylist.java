// import java.util.List;
// import org.sql2o.*;
// import java.util.ArrayList;
// import java.util.List;

// public class Stylist {
//   private int id;
//   private String firstname;
//   private String lastname;

//   public Stylist(String firstname) {
//     this.firstname = firstname;
//     completed = false;
//     createdAt = LocalDateTime.now();
    
//     public String getFirstname() {
//     return firstname;
// }

// public String getlastname() {
//     return lastname;
// }

// public int getId() {
//     return id;
// }
// }

// public static List<Stylist> all() {
//   String sql = "SELECT id, firstname FROM stylist";
//   try(Connection con = DB.sql2o.open()) {
//     return con.createQuery(sql).executeAndFetch(Task.class);
//   }
// }