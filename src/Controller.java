
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.Statement;


public class Controller extends JFrame implements Serializable {

    private int customerId;

    private JButton Db_connect;
    private JButton addNewCar;
    private JButton addNewCustomer;
    private JButton findCar;
    private JButton DisplayAvailableCars;
    private JButton DisplayAllCars;
    private JButton GetRentDetails;
    private JButton ShowInfo;
    private JButton findCustom;
    private JTextField Carname;
    private JTextField CarId;
    private JTextField brand;
    private JTextField plateNum;
    private JTextField rentPriceDay;
    private JTextField color;
    private JTextField CusName;
    private JTextField LicanceNum;
    private JTextField Age;
    private JTextArea textArea;



    // Controller's constructor
    public Controller() {

        Db_connect = new JButton("DbConnection");
        addNewCar = new JButton("addNewCar");
        addNewCustomer = new JButton("addNewCustomer");
        findCar = new JButton("findCar");
        DisplayAvailableCars = new JButton("DisplayAvailableCars");
        DisplayAllCars = new JButton("DisplayAllCars");
        GetRentDetails = new JButton("GetRentDetails");
        CarId = new JTextField("CarID");
        Carname = new JTextField("Carname");
        brand = new JTextField("brand");
        plateNum = new JTextField("plateNum");
        rentPriceDay = new JTextField("rentPrice");
        color = new JTextField("color");
        CusName = new JTextField("CusName");
        LicanceNum = new JTextField("LicanceNum");
        Age = new JTextField("age");
        textArea = new JTextArea();
        ShowInfo = new JButton("ShowInfo");
        findCustom = new JButton("Find Custom");



        customerId = 1;


        Container sceneContainer = getContentPane();
        sceneContainer.setLayout(new FlowLayout());

        sceneContainer.add(Db_connect);
        sceneContainer.add(addNewCar);
        sceneContainer.add(addNewCustomer);
        sceneContainer.add(findCar);
        sceneContainer.add(findCustom);
        sceneContainer.add(DisplayAvailableCars);
        sceneContainer.add(DisplayAllCars);
        sceneContainer.add(Carname);
        sceneContainer.add(CarId);
        sceneContainer.add(brand);
        sceneContainer.add(plateNum);
        sceneContainer.add(rentPriceDay);
        sceneContainer.add(color);
        sceneContainer.add(CusName);
        sceneContainer.add(LicanceNum);
        sceneContainer.add(Age);
        sceneContainer.add(ShowInfo);
        sceneContainer.add(textArea);

        JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sceneContainer.add(scroll);

        setTitle("CarRental ");
        setSize(800, 400);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Db_connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ConnectionClass db = new ConnectionClass();
                db.connectToDb("Bil387final","postgres","1234");

            }
        });

        addNewCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectionClass db2 = new ConnectionClass();
                Connection conn = db2.connectToDb("bil387","postgres","1234");

                try {
                    insert_Car(conn, "CarInfo", Carname.getText() ,Integer.parseInt(CarId.getText()),brand.getText(),plateNum.getText(),Integer.parseInt(rentPriceDay.getText()), color.getText());
                }
                catch(NumberFormatException num){
                    System.out.println(num);
                }



            }
        });

        addNewCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        ShowInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        findCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        findCustom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
    public void insert_Car(Connection conn, String table_Name,String name,int carId, String brand, String numberPlate,int rentPriceDay, String Color) {

        Statement statement;
        try {
            String query = String.format("insert into %s(name,carId,brand,numberPlate,rentPriceDay,Color) values('%s' , '%d', '%s' , '%s' ,'%d' ,'%s');", table_Name, name, carId, brand,numberPlate, rentPriceDay, Color);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");

        } catch (Exception e) {
            System.out.println(e);
        }

    }



}