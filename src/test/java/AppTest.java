// import org.sql2o.*;
// import org.junit.*;
// import static org.junit.Assert.*;

// public class clientTest {

//   @Before
//   public void setUp() {
//     DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5400/stylist_test", null, null);
//   }

//   @After
//   public void tearDown() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "DELETE FROM stylist *;";
//       con.createQuery(sql).executeUpdate();
//     }
//   }

//   @Test
//   public void save_returnsTrueIfFirstnameAretheSame() {
//   Stylist myStylist = new Stylist("vanessa");
//   myStylist.save();
//   assertTrue(Stylist.all().get(0).equals(myStylist));
//   }
// }