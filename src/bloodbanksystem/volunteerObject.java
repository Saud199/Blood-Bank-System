/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbanksystem;

/**
 *
 * @author ABC
 */
public class volunteerObject {
    
    String name,bloodGroup,contactNo,time;
    
    String empty;

    public volunteerObject(String empty) {
        this.empty = empty;
    }

    public volunteerObject(String name, String bloodGroup, String contactNo, String time) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.contactNo = contactNo;
        this.time = time;
    }
    
}
