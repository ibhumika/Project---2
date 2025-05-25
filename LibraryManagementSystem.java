import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class Book {
    String name;
    int number;

    public Book(String name, int number) {
        this.name = name;
        this.number = number;
    }
}

class BookHolder {
    String name;
    int rollNo;
    String className;
    String phoneNumber;

    public BookHolder(String name, int rollNo, String className, String phoneNumber) {
        this.name = name;
        this.rollNo = rollNo;
        this.className = className;
        this.phoneNumber = phoneNumber;
    }
}

public class LibraryManagementSystem extends JFrame implements ActionListener {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<BookHolder> holders = new ArrayList<>();

    JLabel bookNameLabel, bookNumberLabel, holderNameLabel, rollNoLabel, classLabel, phoneNumberLabel;
    JTextField bookNameField, bookNumberField, holderNameField, rollNoField, classField, phoneNumberField;
    JButton addButton, displayButton;
    JTextArea displayArea;

    public LibraryManagementSystem() {
        setTitle("Library Management System");
        setSize(400, 400);
        setLayout(new FlowLayout());

        bookNameLabel = new JLabel("Book Name:");
        bookNameField = new JTextField(15);
        bookNumberLabel = new JLabel("Book Number:");
        bookNumberField = new JTextField(5);

        holderNameLabel = new JLabel("Holder Name:");
        holderNameField = new JTextField(15);
        rollNoLabel = new JLabel("Roll No:");
        rollNoField = new JTextField(5);
        classLabel = new JLabel("Class:");
        classField = new JTextField(10);
        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField(10);

        addButton = new JButton("Add");
        displayButton = new JButton("Display");
        displayArea = new JTextArea(15, 30);

        addButton.addActionListener(this);
        displayButton.addActionListener(this);

        add(bookNameLabel);
        add(bookNameField);
        add(bookNumberLabel);
        add(bookNumberField);
        add(holderNameLabel);
        add(holderNameField);
        add(rollNoLabel);
        add(rollNoField);
        add(classLabel);
        add(classField);
        add(phoneNumberLabel);
        add(phoneNumberField);
        add(addButton);
        add(displayButton);
        add(displayArea);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String bookName = bookNameField.getText();
            int bookNumber = Integer.parseInt(bookNumberField.getText());
            String holderName = holderNameField.getText();
            int rollNo = Integer.parseInt(rollNoField.getText());
            String className = classField.getText();
            String phoneNumber = phoneNumberField.getText();

            Book book = new Book(bookName, bookNumber);
            books.add(book);

            BookHolder holder = new BookHolder(holderName, rollNo, className, phoneNumber);
            holders.add(holder);

            JOptionPane.showMessageDialog(this, "Book added successfully!");
        } else if (e.getSource() == displayButton) {
            displayArea.setText("");
            for (int i = 0; i < books.size(); i++) {
                displayArea.append("Book Name: " + books.get(i).name + "\n");
                displayArea.append("Book Number: " + books.get(i).number + "\n");
                displayArea.append("Holder Name: " + holders.get(i).name + "\n");
                displayArea.append("Roll No: " + holders.get(i).rollNo + "\n");
                displayArea.append("Class: " + holders.get(i).className + "\n");
                displayArea.append("Phone Number: " + holders.get(i).phoneNumber + "\n\n");
            }
        }
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
}
