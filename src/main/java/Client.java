import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private String firstname;
  private String lastname;
  private String style;
  private int stylistId;

  public Client(String firstname, String lastname, String style, int stylistId) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.style = style;
    this.stylistId = stylistId;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getStyle() {
    return style;
  }

  public int getStylistId() {
    return stylistId;
  }

  public int getId() {
    return id;
  }

  public static List<Client> all() {
    String sql = "SELECT id, firstname, lastname, stylistId FROM clients";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  @Override
  public boolean equals(Object otherClient){
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getFirstname().equals(newClient.getFirstname()) &&
             this.getLastname().equals(newClient.getLastname()) &&
             this.getStyle().equals(newClient.getStyle()) &&
             this.getId() == newClient.getId() &&
             this.getStylistId() == newClient.getStylistId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients(firstname, lastname, style, stylistId) VALUES (:firstname, :lastname, :style, :stylistId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("firstname", this.firstname)
        .addParameter("lastname", this.lastname)
        .addParameter("style", this.style)
        .addParameter("stylistId", this.stylistId)
        .executeUpdate()
        .getKey();
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where id=:id";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }
}
