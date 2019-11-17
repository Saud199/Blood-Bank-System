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
public class customListObject {
    
    String id,name,bloodgroup,contactNo,location,urgency,date;
    
    String empty;

    public customListObject(String empty) {
        this.empty = empty;
    }

    public customListObject(String id, String name, String bloodgroup, String contactNo, String location, String urgency, String date) {
        this.id = id;
        this.name = name;
        this.bloodgroup = bloodgroup;
        this.contactNo = contactNo;
        this.location = location;
        this.urgency = urgency;
        this.date = date;
    }

    
}
