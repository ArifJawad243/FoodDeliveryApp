package user;
import java.lang.*;
import java.io.*;
import javax.swing.*;

public class User {
    private String username;
    private String password;
    private String email;
    private String phone;
    
    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    public String getPhone() {
        return phone;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void saveUser() throws IOException
    {
    	File UserLog = new File("users.txt");
    	try(FileWriter fw = new FileWriter(UserLog, true);)
    	{
			fw.write(username + "," + password + "," + email + "," + phone + "\n");
			fw.close();
		}
    }

    public static User verifyUser(String username, String password) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) 
        {
			String line;
			while ((line = reader.readLine()) != null) 
			{
			    String[] a = line.split(",");
			    if (a[0].equals(username) && a[1].equals(password)) 
			    {
			        return new User(a[0], a[1], a[2], a[3]);
			    }
			}
		}
    return null;
    }
    
    public void deleteUser() throws IOException
    {
    	File UserLog = new File("users.txt");
        File tempFile = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter(tempFile)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] a = line.split(",");
                if (!a[0].equals(this.username))
                {
                    writer.println(line);
                }
            }
        }

        UserLog.delete();
        tempFile.renameTo(UserLog);
    }
}