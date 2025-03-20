/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.templatemethod;

import java.util.Scanner;

/**
 *
 * @author igorp
 */
public class TemplateMethod {

    public static void main(String[] args) {
        Network network = null;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Input user name: ");
        String userName = scan.nextLine();
        
        System.out.println("Input password: ");
        String password = scan.nextLine();
        
        System.out.println("Input message: ");
        String message = scan.nextLine();
        
        System.out.println("""         
            Choose social network for posting message
            1 - Facebook
            2 - Twitter
        """);
        
        int choice = Integer.parseInt(scan.next());
        
        if(choice == 1){
            network = new Facebook(userName, password);
        } else if(choice == 2){
            network = new Twitter(userName, password);
        }
        network.post(message);
    }
}
