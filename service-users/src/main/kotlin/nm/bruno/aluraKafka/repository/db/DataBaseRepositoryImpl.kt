package nm.bruno.aluraKafka.repository.db

import nm.bruno.aluraKafka.domain.User
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DataBaseRepositoryImpl : DataBaseRepository {

    private val connection: Connection by lazy {
        DriverManager.getConnection(DATABASE_URL)
    }

    init {
        connection.createStatement().execute(CREATE_USER_TABLE_SQL)
    }

    override fun isNewUser(email: String): Boolean {
        return getUser(email) == null
    }

    override fun getUser(email: String): User? {
        val select = connection.prepareStatement(SELECT_USER_SQL)

        select.setString(1, email)
        val results = select.executeQuery()
        return try {
            results.unwrap(User::class.java)
        } catch (ex: SQLException) {
            ex.printStackTrace()
            null
        }
    }

    override fun insertNewUser(email: String): User {
        val insert = connection.prepareStatement(INSERT_USER_SQL)

        insert.setString(1, email)
        insert.setString(2, email)
        val resultSet = insert.executeQuery()
        return resultSet.unwrap(User::class.java)
    }

    companion object {
        private const val DATABASE_URL = "jdbc:sqlite:users_database.db"
        private const val CREATE_USER_TABLE_SQL = "CREATE TABLE IF NOT EXISTS Users (" +
                "uuid varchar(200) primary key," +
                "email varchar(200));"
        private const val INSERT_USER_SQL = "INSERT INTO Users (uuid, email)" +
                "values (?, ?)"
        private const val SELECT_USER_SQL = "SELECT uuid from Users" +
                "where email = ? limit 1"
    }

}