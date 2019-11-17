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
public class myRequestObjects {
    
    String rid,rname,rContactno,rLocation,rDate,rUrgency,rbloodgroup;
    
    String empty;

    public myRequestObjects(String empty) {
        this.empty = empty;
    }
    
    public myRequestObjects(String rid, String rname, String rbloodgroup, String rContactno, String rLocation, String rDate, String rUrgency) {
        this.rid = rid;
        this.rname = rname;
        this.rContactno = rContactno;
        this.rLocation = rLocation;
        this.rDate = rDate;
        this.rUrgency = rUrgency;
        this.rbloodgroup=rbloodgroup;
    }
    
    
}
