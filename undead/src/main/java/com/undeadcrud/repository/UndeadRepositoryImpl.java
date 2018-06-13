package com.undeadcrud.repository;

import com.undeadcrud.domain.Undead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UndeadRepositoryImpl implements UndeadRepository {

        private Connection connection;
        private PreparedStatement addUndeadStmt;
        private PreparedStatement getAllStmt;
        private PreparedStatement getByIdStmt;
        private PreparedStatement deleteTableStmt;
        private PreparedStatement updateStmt;
        private PreparedStatement deleteByIdStmt;
        

        public UndeadRepositoryImpl(Connection connection) throws SQLException {
            this.connection = connection;
            if (!isDatabaseReady()) {
                createTables();
            }
            setConnection(connection);
        }

        public Connection getConnection() {
            return connection;
        }

        public void setConnection(Connection connection) throws SQLException {
            this.connection = connection;
            addUndeadStmt = connection.prepareStatement("INSERT INTO Undead (nazwa, typ, tier, lokacja, zdolnoscSpecjalna) VALUES (?, ?, ?, ?, ?)");
            getAllStmt = connection.prepareStatement("SELECT * FROM Undead");
            getByIdStmt = connection.prepareStatement("SELECT * FROM Undead WHERE id = ?");
            deleteTableStmt = connection.prepareStatement("DROP TABLE Undead");
            updateStmt = connection.prepareStatement("UPDATE Undead SET name = ? WHERE id = ?");
            deleteByIdStmt = connection.prepareStatement("DELETE FROM Undead WHERE id = ?");
        }

        public void createTables() throws SQLException {
            connection.createStatement().executeUpdate(
                    "CREATE TABLE " + "Undead(id int GENERATED BY DEFAULT AS IDENTITY, " +
                            "nazwa varchar(40), " + "typ varchar(40), " + "tier int, lokacja varchar(40), " + "zdolnoscSpecjalna varchar(40))");
        }

        public boolean isDatabaseReady() {
            try {
                ResultSet results = connection.getMetaData().getTables(null, null, null, null);
                boolean tableExists = false;
                while (results.next()) {
                    if ("Undead".equalsIgnoreCase(results.getString("TABLE_NAME"))) {
                        tableExists = true;
                        break;
                    }
                }
                return tableExists;
            } catch (SQLException e) {
                return false;
            }
        }

        @Override
        public List<Undead> getAll() {
            List<Undead> undeads = new LinkedList<>();
            try {
                ResultSet results = getAllStmt.executeQuery();

                while (results.next()) {
                    Undead u = new Undead("Szkielet Wojownik","Szkielet", 5,"Cmentarz", "Demoralizacja");
                    u.setId(results.getInt("id"));
                    u.setTyp(results.getString("name"));
                    undeads.add(u);
                }

            } catch (SQLException e) {
                throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
            }
            return undeads;
        }

        @Override
        public Undead getById(int id) throws SQLException {
            getByIdStmt.setInt(1, id);
            ResultSet results = getByIdStmt.executeQuery();
            if (results.next()) {
                Undead undead = new Undead("Szkielet Wojownik","Szkielet", 5,"Cmentarz", "Demoralizacja");
                undead.setId(results.getInt("id"));
                undead.setTyp(results.getString("typ"));
                return undead;
            } else {
                return null;
            }
        }

        @Override
        public void addUndead(Undead undead) {
            try {
                addUndeadStmt.setString(1, undead.getNazwa());
                addUndeadStmt.setString(2, undead.getTyp());
                addUndeadStmt.setInt(3, undead.getTier());
                addUndeadStmt.setString(4, undead.getLokacja());
                addUndeadStmt.setString(5, undead.getZdolnoscSpecjalna());

                addUndeadStmt.executeUpdate();
            } catch (SQLException e) {
                throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
            }
        }

        @Override
        public void deleteUndead(Undead undead) throws SQLException {

            deleteByIdStmt.setInt(1, undead.getId());
            deleteByIdStmt.executeUpdate();

        }

        @Override
        public void updateUndead(int id, Undead newUndead) throws SQLException {
            updateStmt.setInt(2, id);
            updateStmt.setString(1, newUndead.getTyp());
            updateStmt.executeUpdate();
        }

        /*
        @Override
        public void dropDatatable() throws SQLException {
            deleteTableStmt.executeUpdate();
        }
        */

    }
    

