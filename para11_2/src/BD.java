import java.sql.*;
import java.util.List;
import java.util.Random;

public class BD {
    public static String url ="jdbc:mysql://localhost/groups";
    public static String user = "root";
    public static String password ="";
    // открыть соединение
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    //закрыть соединение
    public void closeConnection(Connection connection){
        if (connection!=null)
        {
            try
            {
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void addStudent(String student_surname, String student_name, String student_lastname, String student_group, int student_variant){
        Connection connection = null;
        try {
            connection = openConnection();//INSERT INTO `students` (`id_student`, `student_surname`, `student_name`, `student_lastname`, `student_group`, `student_variant`) VALUES (NULL, 'Власов', 'Радий', 'Андреевич', 'ИС-22', '1');
            String query = "INSERT INTO `students` (`student_surname`, `student_name`, `student_lastname`, `student_group`, `student_variant`) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,student_surname);
            statement.setString(2,student_name);
            statement.setString(3,student_lastname);
            statement.setString(4,student_group);
            statement.setInt(5,student_variant);
            int rowsTrue=statement.executeUpdate();
            if(rowsTrue>0) {System.out.println("Добавлен");}
            else {System.out.println("Не добавлен");}
            closeConnection(connection);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
    public void variantStudents(){
        Connection connection = null;
        Random random = new Random();
        try {
            connection = openConnection();
            int[] arr=new int[35];
            int ar=1;
            int one = 0,two=0,three=0,four=0,five=0,six=0,seven=0,eight=0,nine=0;
            for (int i=0;i<arr.length;i++) {
                arr[i] = random.nextInt(10);
                if (arr[i]==0){arr[i]=10;}
                if (arr[i]==1){
                    one++;
                    if (one>4){arr[i]=2;}
                }
                if (arr[i]==2){
                    two++;
                    if (two>4){arr[i]=3;}
                }
                if (arr[i]==3){
                    three++;
                    if (three>4){arr[i]=4;}
                }
                if (arr[i]==4){
                    four++;
                    if (four>4){arr[i]=5;}
                }
                if (arr[i]==5){
                    five++;
                    if (five>4){arr[i]=6;}
                }
                if (arr[i]==6){
                    six++;
                    if (six>4){arr[i]=7;}
                }
                if (arr[i]==7){
                    seven++;
                    if (seven>4){arr[i]=8;}
                }
                if (arr[i]==8){
                    eight++;
                    if (eight>4){arr[i]=9;}
                }
                if (arr[i]==9){
                    nine++;
                    if (nine>4){arr[i]=10;}
                }
                String query = "UPDATE `students` SET `student_variant` = ? WHERE `students`.`id_student` = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1,arr[i]);
                statement.setInt(2,ar);
                int rowsTrue = statement.executeUpdate();
                if (rowsTrue > 0) {
                    System.out.println("Добавлен");
                } else {
                    System.out.println("Не добавлен");
                }
                ar++;
            }
            closeConnection(connection);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
    public void sortStudents(){
        Connection connection = null;
        try {
            connection = openConnection();
            String query = "SELECT student_surname,student_name,student_lastname FROM `students` ORDER BY `students`.`student_surname` ASC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String surnam = resultSet.getString("student_surname");
                String nam = resultSet.getString("student_name");
                String group_name = resultSet.getString("student_lastname");
                System.out.println(surnam + " "+nam+" "+group_name);
            }
            closeConnection(connection);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
    public void studentsByVariants(){
        Connection connection = null;
        try {
            connection = openConnection();//SELECT * FROM `students` ORDER BY `students`.`student_variant` ASC
            String query = "SELECT student_surname,student_name,student_lastname,student_variant FROM `students` ORDER BY `students`.`student_variant` ASC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String surnam = resultSet.getString("student_surname");
                String nam = resultSet.getString("student_name");
                String group_name = resultSet.getString("student_lastname");
                System.out.println(surnam + " "+nam+" "+group_name);
            }
            closeConnection(connection);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
    public void variantByStudent(String student_surname){
        Connection connection = null;
        try {
            connection = openConnection();//SELECT * FROM `students` ORDER BY `students`.`student_variant` ASC
            String query = "SELECT student_surname,student_variant FROM `students` WHERE student_surname=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,student_surname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String surnam = resultSet.getString("student_surname");
                int var = resultSet.getInt("student_variant");
                System.out.println(surnam + " "+var);
            }
            closeConnection(connection);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
    public void listOfStudentsByVariant(int variant){
        Connection connection = null;
        try {
            connection = openConnection();//SELECT * FROM `students` ORDER BY `students`.`student_variant` ASC
            String query = "SELECT student_surname,student_name,student_lastname,student_variant FROM `students` WHERE student_variant=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,variant);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String surnam = resultSet.getString("student_surname");
                String nam = resultSet.getString("student_name");
                String group_name = resultSet.getString("student_lastname");
                int var = resultSet.getInt("student_variant");
                System.out.println(surnam +  " "+nam+" "+group_name+" "+var);
            }
            closeConnection(connection);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
    public void numberOfStudentsByVariants(){
        Connection connection = null;
        try {
            connection = openConnection();//SELECT * FROM `students` ORDER BY `students`.`student_variant` ASC
            String query = "SELECT student_variant,COUNT(student_variant) AS student_count FROM `students` GROUP BY student_variant ORDER BY `students`.`student_variant` ASC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String surnam = resultSet.getString("student_variant");
                String nam = resultSet.getString("student_count");
                System.out.println(surnam +  " "+nam);
            }
            closeConnection(connection);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
    public void selectOneColum(String columName, String tableName, List<Integer> arr)
    {
        arr.clear();
        Connection connection = null;
        try {
            connection = openConnection();
            String query = "SELECT `"+columName+"` FROM `"+tableName+"`;";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                int a = resultSet.getInt(columName);
                arr.add(a);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
    public void addVariant()
    {
        RanVar ranVar = new RanVar();
        selectOneColum("id_student", "students", ranVar.idArray);
        ranVar.randVar();
        Connection connection = null;
        try {
            connection = openConnection();
            String query = "SELECT COUNT(*) FROM `variants`";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            {
                if (resultSet.getInt(1)!=0)
                {//Если есть записи в таблице, то удалить все
                    query = "DELETE FROM `variants`";
                    statement.executeUpdate(query);
                }
                for (int i=0; i<ranVar.idArray.size();i++)
                {
                    query = "INSERT INTO `variants` (`id_variant`, `student_id`, `variant`) " +
                            "VALUES (NULL, "+ranVar.idArray.get(i)+" ,"+ranVar.arr[i]+");";
                    statement = connection.prepareStatement(query);
                    statement.executeUpdate();
                }
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }

    }
    public void variantOfStudent(String student_surname){
        Connection connection = null;
        try {
            connection = openConnection();//SELECT * FROM `students` ORDER BY `students`.`student_variant` ASC
            String query = "SELECT student_surname,student_name,student_lastname,variant FROM `students`,`variants` WHERE student_surname=? AND id_student=student_id";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,student_surname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String surnam = resultSet.getString("student_surname");
                String nam = resultSet.getString("student_name");
                String group_name = resultSet.getString("student_lastname");
                int var = resultSet.getInt("variant");
                System.out.println(surnam +  " "+nam+" "+group_name+" "+var);
            }
            closeConnection(connection);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            closeConnection(connection);
        }
    }
}
