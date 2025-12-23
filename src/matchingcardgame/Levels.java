/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardgame;

/**
 *
 * @author RNA
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Levels {
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/matchingcardgame?serverTimezone=UTC",
            "root",
            "#"
        );
    }

    private static Level createLevel(int levelNumber) {

        try (Connection con = getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "SELECT totalTime, totalCards FROM levels WHERE levelNumber = ?"
            );
            ps.setInt(1, levelNumber);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int totalSeconds = rs.getInt("totalTime");
                int totalCards = rs.getInt("totalCards");

                return new Level(levelNumber, totalSeconds, totalCards);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // =========================
    // نفس الميثودات القديمة (بدون كسر UI)
    // =========================
    public static Level createLevel1() { return createLevel(1); }
    public static Level createLevel2() { return createLevel(2); }
    public static Level createLevel3() { return createLevel(3); }
    public static Level createLevel4() { return createLevel(4); }
    public static Level createLevel5() { return createLevel(5); }
    public static Level createLevel6() { return createLevel(6); }
    public static Level createLevel7() { return createLevel(7); }
    public static Level createLevel8() { return createLevel(8); }
    public static Level createLevel9() { return createLevel(9); }
    public static Level createLevel10() { return createLevel(10); }
    public static Level createLevel11() { return createLevel(11); }
    public static Level createLevel12() { return createLevel(12); }
    public static Level createLevel13() { return createLevel(13); }
    public static Level createLevel14() { return createLevel(14); }
    public static Level createLevel15() { return createLevel(15); }
}