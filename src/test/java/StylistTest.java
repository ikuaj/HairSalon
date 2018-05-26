import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class StylistTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5400/hair_salon_test", "postgres", "braeburn");
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteClientsQuery = "DELETE FROM clients *;";
      String deleteStylistsQuery = "DELETE FROM stylists *;";
      con.createQuery(deleteClientsQuery).executeUpdate();
      con.createQuery(deleteStylistsQuery).executeUpdate();
    }
  }

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("joel");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_stylistInstantiatesWithName_Home() {
    Stylist testStylist = new Stylist("Home");
    assertEquals("Home", testStylist.getName());
  }

 @Test
 public void all_returnsAllInstancesOfStylist_true() {
   Stylist firstStylist = new Stylist("Home");
   firstStylist.save();
   Stylist secondStylist = new Stylist("Work");
   secondStylist.save();
   assertEquals(true, Stylist.all().get(0).equals(firstStylist));
   assertEquals(true, Stylist.all().get(1).equals(secondStylist));
 }

 @Test
 public void getId_stylistInstantiateWithAnId_1() {
   Stylist testStylist = new Stylist("Home");
   testStylist.save();
   assertTrue(testStylist.getId() > 0);
 }

 @Test
 public void find_returnsstylistWithSameId_secondStylist() {
   Stylist firstStylist = new Stylist("Angela");
   firstStylist.save();
   Stylist secondStylist = new Stylist("Vanessa");
   secondStylist.save();
   assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
 }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist firstStylist = new Stylist("Household chores");
    Stylist secondStylist = new Stylist("Household chores");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist myStylist = new Stylist("Household chores");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist myStylist = new Stylist("Household chores");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(myStylist.getId(), savedStylist.getId());
  }

  // @Test
  // public void getClients_retrievesALlClientsFromDatabase_clientsList() {
  //   Stylist myStylist = new Stylist("Household chores");
  //   myStylist.save();
  //   Client firstClien = new Client("Mow the lawn", myStylist.getId());
  //   firstClient.save();
  //   Client secondClient = new Client("Do the dishes", myStylist.getId());
  //   secondClient.save();
  //   Client[] clients = new Client[] { firstClient, secondClient };
  //   assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
  // }

}
