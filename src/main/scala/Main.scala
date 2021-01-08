import java.sql._
object Main extends App {

    var conn: Connection = null 

    try {
        val connectionString = "jdbc:hive2://localhost:10000/default"
        Class.forName("org.apache.hive.jdbc.HiveDriver")
        conn = DriverManager.getConnection(connectionString, "","");

        val statement = conn.createStatement();
        var resultSet = statement.executeQuery("select * from pokes")

        while(resultSet.next()){
            val foo = resultSet.getString("foo")
            val bar = resultSet.getString("bar")
            println(foo + " " + bar)
        }
    }catch {
        case e: Exception => e.printStackTrace()
    }
    conn.close 
}